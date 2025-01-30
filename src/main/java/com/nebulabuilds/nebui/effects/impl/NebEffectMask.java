package com.nebulabuilds.nebui.effects.impl;

import com.nebulabuilds.nebui.NebUI;
import com.nebulabuilds.nebui.effects.NebEffect;
import com.nebulabuilds.nebui.layout.NebPosition;
import lombok.Getter;

public class NebEffectMask extends NebEffect {
    @Getter
    private NebPosition position;
    @Getter
    float x,y,width,height;

    public NebEffectMask(NebPosition nebPosition, float width, float height) {
        super("Mask");
        this.x = x;
        this.y = y;
        this.position = nebPosition;
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(float screenWidth, float screenHeight, float mouseX, float mouseY) {

        NebUI.getInstance().getRenderer().nvgScissor(position.getXOnScreen(screenWidth), position.getYOnScreen(screenHeight), width,height);
    }
}
