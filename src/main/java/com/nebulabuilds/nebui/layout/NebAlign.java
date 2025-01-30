package com.nebulabuilds.nebui.layout;

import lombok.Getter;

public enum NebAlign {

    TOP_LEFT(0f,0f),
    TOP_CENTER(0.5f,0f),
    TOP_RIGHT(1f,0f),
    BOTTOM_LEFT(0f,1f),
    BOTTOM_CENTER(0.5f,1f),
    BOTTOM_RIGHT(1f,1f),
    MIDDLE_LEFT(0f,0.5f),
    MIDDLE_CENTER(0.5f,0.5f),
    MIDDLE_RIGHT(1f,0.5f),;

    @Getter
    private float x,y;

    NebAlign(float x, float y) {
        this.x = x;
        this.y = y;
    }




}
