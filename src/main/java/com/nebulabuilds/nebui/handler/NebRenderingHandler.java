package com.nebulabuilds.nebui.handler;

import com.nebulabuilds.nebui.NebUI;
import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.components.elements.NebFrame;
import com.nebulabuilds.nebui.effects.NebEffect;
import com.nebulabuilds.nebui.effects.impl.NebEffectIntersectMask;
import com.nebulabuilds.nebui.effects.impl.NebEffectMask;
import com.nebulabuilds.nebui.layout.NebAlign;
import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.scroll.NebScrollType;

import java.util.List;

public class NebRenderingHandler {

    private NebNode currentlyHoveredElement = null;

    float wheel = 0;
    float screenW, screenH;
    float mouseX, mouseY;

    public void drawScreen(float screenWidth, float screenHeight) {
        wheel = NebUI.getInstance().getInputHandler().getWheelD();
        this.screenH = screenHeight;
        this.screenW = screenWidth;

        NebUI.getInstance().getRenderer().start();
        NebUI.getInstance().getActiveScreen().getScreenEffects().render(screenWidth, screenHeight, 0, 0);

        if (NebUI.getInstance().getActiveScreen() != null) {
            NebUI.getInstance().getActiveScreen().getComponents().forEach(component -> {
                renderElement(component, 0, 0, screenWidth, screenHeight);
            });
        }

        NebUI.getInstance().getRenderer().end();
    }

    private void renderElement(NebNode element, float parentX, float parentY, float parentWidth, float parentHeight) {
        float elementX = parentX + element.getPosition().getXOnScreen(parentWidth);
        float elementY = parentY + element.getPosition().getYOnScreen(parentHeight);

        if (element instanceof NebFrame) {

            NebFrame frame = (NebFrame) element;
            if (frame.getScroll() != null) {

                if (frame.getScroll().getType() == NebScrollType.ELEMENT) {
                    switch (frame.getScroll().getDirection()) {
                        case UP:
                            elementY -= frame.getScroll().get();
                            break;
                        case DOWN:
                            elementY += frame.getScroll().get();
                            break;
                        case LEFT:
                            elementX -= frame.getScroll().get();
                            break;
                        case RIGHT:
                            elementX += frame.getScroll().get();
                            break;
                    }
                }

                if (checkHoverComponent(mouseX, mouseY, elementX, elementY, element)) {
                    frame.getScroll().setWheel((int) wheel);
                }
            }

        }

        element.render(elementX, elementY, (float) element.getWidth(), (float) element.getHeight());

        if (element instanceof NebFrame) {
            NebFrame f = (NebFrame) element;
            if (f.getScroll() != null) {
                f.getScroll().getScrollbar().render((float) (elementX + element.getWidth() - 4), elementY, 8, f.getScroll().getScrollbar().getHeight(), 280, f.getScroll().get());
            }
        }

        if(element instanceof NebFrame){
            NebFrame f = (NebFrame) element;
            if(f.getScroll() != null){
                NebEffectIntersectMask m = new NebEffectIntersectMask(elementX,elementY, (float) element.getWidth(), (float)element.getWidth());
                m.render(screenW,screenH,mouseX,mouseY);
            }
        }

        for (NebNode child : element.getChildren()) {

            float x = 0, y = 0;
            if (element instanceof NebFrame) {
                NebFrame frame = (NebFrame) element;
                if (frame.getScroll() != null) {
                    if (frame.getScroll().getType() == NebScrollType.CHILD) {
                        switch (frame.getScroll().getDirection()) {
                            case UP:
                                y -= frame.getScroll().get();
                                break;
                            case DOWN:
                                y += frame.getScroll().get();
                                break;
                            case LEFT:
                                x -= frame.getScroll().get();
                                break;
                            case RIGHT:
                                x += frame.getScroll().get();
                                break;
                        }
                    }

                    if (checkHoverComponent(mouseX, mouseY, elementX, elementY, element)) {
                        frame.getScroll().setWheel((int) wheel);
                    }
                }
            }


            renderElement(child, elementX + x, elementY + y, (float) element.getWidth(), (float) element.getHeight());
        }
    }

    public void oneMouseUpdate(float mouseX, float mouseY, float screenWidth, float screenHeight) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;

        if (NebUI.getInstance().getActiveScreen() != null) {
            List<NebNode> components = NebUI.getInstance().getActiveScreen().getComponents();
            NebNode newHoveredElement = null;

            for (int i = components.size() - 1; i >= 0; i--) {
                NebNode component = components.get(i);
                newHoveredElement = updateElementHoverState(component, mouseX, mouseY, 0, 0, screenWidth, screenHeight, newHoveredElement);
            }

            if (newHoveredElement != currentlyHoveredElement) {
                if (currentlyHoveredElement != null) {
                    currentlyHoveredElement.handleHoverExit();
                    currentlyHoveredElement.setHover(false);
                }
                if (newHoveredElement != null) {
                    newHoveredElement.handleHover();
                    newHoveredElement.setHover(true);
                }
                currentlyHoveredElement = newHoveredElement;
            }
        }
    }

    private NebNode updateElementHoverState(NebNode element, float mouseX, float mouseY, float parentX, float parentY, float parentWidth, float parentHeight, NebNode currentHoveredElement) {
        float elementX = parentX + element.getPosition().getXOnScreen(parentWidth);
        float elementY = parentY + element.getPosition().getYOnScreen(parentHeight);

        element.mouseUpdate(mouseX, mouseY);

        if (checkHoverComponent(mouseX, mouseY, elementX, elementY, element)) {
            currentHoveredElement = element;
        }

        for (int i = element.getChildren().size() - 1; i >= 0; i--) {
            NebNode child = element.getChildren().get(i);
            currentHoveredElement = updateElementHoverState(child, mouseX, mouseY, elementX, elementY, (float) element.getWidth(), (float) element.getHeight(), currentHoveredElement);
        }

        return currentHoveredElement;
    }

    public boolean checkHoverComponent(float mouseX, float mouseY, float elementX, float elementY, NebNode component) {
        for (NebEffect nebEffect : NebUI.getInstance().getActiveScreen().getScreenEffects().getEffects()) {
            if (nebEffect instanceof NebEffectMask) {
                NebEffectMask nebEffectMask = (NebEffectMask) nebEffect;
                if (mouseX >= nebEffectMask.getPosition().getXOnScreen(screenW) && mouseX <= nebEffectMask.getPosition().getXOnScreen(screenW) + nebEffectMask.getWidth() && mouseY >= nebEffectMask.getPosition().getYOnScreen(screenH) && mouseY <= nebEffectMask.getPosition().getYOnScreen(screenH) + nebEffectMask.getHeight()) {
                    if (mouseX >= elementX && mouseY >= elementY && mouseX <= elementX + component.getWidth() && mouseY <= elementY + component.getHeight()) {
                        return true;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        }
        return mouseX >= elementX && mouseY >= elementY && mouseX <= elementX + component.getWidth() && mouseY <= elementY + component.getHeight();
    }

    public void click(int width, int height) {
        
    }
}
