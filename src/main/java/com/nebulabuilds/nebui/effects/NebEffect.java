package com.nebulabuilds.nebui.effects;

import lombok.Getter;

public abstract class NebEffect {

    @Getter
    private String name;

    public NebEffect(String name) {
        this.name = name;
    }

    public abstract void render(float width, float height, float mouseX, float mouseY);
}
