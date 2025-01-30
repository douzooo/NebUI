package com.nebulabuilds.nebui;

import com.nebulabuilds.nebui.handler.NebRenderingHandler;
import com.nebulabuilds.nebui.input.NebInputHandler;
import com.nebulabuilds.nebui.minecraft.NebIMinecraftHandling;
import com.nebulabuilds.nebui.renderer.NebIRenderer;
import com.nebulabuilds.nebui.screen.NebScreen;
import com.nebulabuilds.nebui.utils.NebRadius;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class NebUI {

    public static NebUI instance = new NebUI();

    public static NebUI getInstance() {
        return instance;
    }

    @Getter
    public NebScreen activeScreen;
    @Getter @Setter
    public NebIRenderer renderer;
    @Getter
    public NebRenderingHandler handler;
    @Getter @Setter
    public NebIMinecraftHandling minecraftBridge;
    @Getter @Setter
    public NebIController controller;
    @Getter @Setter
    public NebInputHandler inputHandler;


    public NebUI() {
        this.inputHandler = new NebInputHandler() {
            @Override
            public int getWheelD() {
                System.out.println("[NebUI] Please initialize the inputHandler first, use NebUI.getInstance().setInputHandler(<class>)!");
                return 0;
            }
        };
        this.controller = new NebIController() {
            @Override
            public void open(NebScreen screen) {
                setActiveScreen(screen);
            }

            @Override
            public void close() {
                closeScreen();
            }
        };

        this.minecraftBridge = new NebIMinecraftHandling() {


            @Override
            public int fps() {
                System.out.println("[NebUI] Please initialize the minecraftHandler first, use NebUI.getInstance().setMinecraftHandler(<class>)!");
                return 0;
            }
        };

        this.handler = new NebRenderingHandler();
        this.renderer = new NebIRenderer() {
            @Override
            public void start() {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");
            }

            @Override
            public void drawRect(float x, float y, float width, float height, Color c) {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");
            }

            @Override
            public void drawRoundedRect(float x, float y, float width, float height, NebRadius radius, Color color) {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");
            }

            @Override
            public void end() {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");
            }

            @Override
            public void nvgScissor(float x, float y, float width, float height) {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");
            }

            @Override
            public void nvgResetScissor() {

            }

            @Override
            public void nvgIntersectScissor(float x, float y, float width, float height) {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");
            }

            @Override
            public void restore() {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");

            }
            @Override
            public void save() {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");

            }

            @Override
            public float getScaleFactor() {
                System.out.println("[NebUI] Please initialize the renderer first, use NebUI.getInstance().setRenderer(<class>)!");
                return 0;
            }
        };
    }

    public void setActiveScreen(NebScreen activeScreen) {
        activeScreen.build();
        this.activeScreen = activeScreen;
        activeScreen.initCallback.init();

        activeScreen.effectCallback.load(activeScreen.getScreenEffects());

    }

    public void closeScreen(){
        this.activeScreen = null;
    }

    public boolean isScreenOpen(){
        return activeScreen != null;
    }


}
