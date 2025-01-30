package com.nebulabuilds.nebui.components.elements;

import com.nebulabuilds.nebui.NebUI;
import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.renderable.Renderable;
import com.nebulabuilds.nebui.utils.NebRadius;
import lombok.Getter;

import java.awt.*;
import java.util.List;

public class NebScrollbar{

    @Getter
    public float x,y,width,height;

    public NebScrollbar(float x,float y,float width,float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(float x, float y, float width, float height, float maxScroll, float currentValue) {
        // Draw the scrollbar container

        float sliderHeight = (height / maxScroll) * height; // Slider height is proportional to the viewable area

        sliderHeight = Math.min(sliderHeight, 50);

        float sliderY = y + (currentValue / maxScroll) * ((height - sliderHeight-10)) + 5;
        NebUI.getInstance().getRenderer().drawRoundedRect(x, sliderY, 2, sliderHeight, NebRadius.of(2), Color.BLACK);
    }



}

