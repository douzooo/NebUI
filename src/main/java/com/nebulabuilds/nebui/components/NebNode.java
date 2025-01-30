package com.nebulabuilds.nebui.components;

import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.utils.NebRadius;
import com.nebulabuilds.nebui.utils.NebUtils;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class NebNode {

    @Setter
    public List<NebNode> children = new ArrayList<>();

    @Setter
    public NebPosition position;

    @Setter
    public Color fillColor;

    @Setter
    public Color outlineColor;

    @Setter
    public boolean fill = false;

    @Setter
    public boolean outline = false;

    @Setter
    public boolean hover = false;

    @Setter
    public boolean clickable = false;

    @Setter
    public double width, height;

    @Setter
    public boolean rounded;

    @Setter
    public NebRadius radius;

    @Setter
    public String id;

    @Setter
    public ClickAction clickCallback = new ClickAction() {
        @Override
        public void left() {}
        @Override
        public void click() {}
        @Override
        public void right() {}
        @Override
        public void wheel() {}
    };

    @Setter
    public HoverAction hoverCallback = new HoverAction() {
        @Override
        public void hoverEnter() {}
        @Override
        public void hoverExit() {}
        @Override
        public void hover() {}
    };

    public NebNode(NebPosition position, Color fillColor, Color outlineColor, boolean fill, boolean outline,
                   boolean hover, boolean clickable, boolean rounded, double width, double height,
                   List<NebNode> children, NebRadius radius) {
        this.position = position;
        this.fillColor = fillColor;
        this.outlineColor = outlineColor;
        this.fill = fill;
        this.outline = outline;
        this.hover = hover;
        this.clickable = clickable;
        this.rounded = rounded;
        this.width = width;
        this.height = height;
        this.radius = radius;
        if (children != null) {
            this.children = new ArrayList<>(children);
        }
        this.id = NebUtils.generateId();
    }

    public void render(float x, float y, float width, float height) {
        if (outline) {
            handleOutline(x, y, width, height);
        }
        if (fill) {
            handleFill(x, y, width, height);
        }
        specials(x, y, width, height);
    }

    public void mouseUpdate(float mouseX, float mouseY) {
        // Mouse update logic
    }

    public void handleFill(float x, float y, float width, float height) {
        // Fill handling logic
    }

    public void handleOutline(float x, float y, float width, float height) {
        // Outline handling logic
    }

    public void specials(float x, float y, float width, float height){

    }

    public void handleClick() {
        if (clickable && clickCallback != null) {
            clickCallback.click();
            clickCallback.left();
            clickCallback.right();
            clickCallback.wheel();
        } else {
            System.out.println("[NebUI] This element is not clickable (" + this.getClass().getCanonicalName() + ")");
        }
    }

    public void handleHoverEnter() {
        if (hoverCallback != null) {
            hoverCallback.hoverEnter();
        }
    }

    public void handleHoverExit() {
        if (hoverCallback != null) {
            hoverCallback.hoverExit();
        }
    }

    public void handleHover() {
        if (hoverCallback != null) {
            hoverCallback.hover();
        }
    }

    public abstract static class ClickAction {
        public void left() {}
        public void click() {}
        public void right() {}
        public void wheel() {}
    }

    public abstract static class HoverAction {
        public void hoverEnter() {}
        public void hoverExit() {}
        public void hover() {}
    }
}
