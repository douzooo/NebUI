package com.nebulabuilds.nebui.components.builders.impl;

import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.components.builders.NebNodeBuilder;
import com.nebulabuilds.nebui.components.elements.NebRect;
import com.nebulabuilds.nebui.layout.NebAlign;
import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.utils.NebRadius;

import java.awt.*;
import java.util.ArrayList;

public class NebRectBuilder implements NebNodeBuilder {

    private NebRadius radius;
    private NebAlign origin = NebAlign.MIDDLE_CENTER;
    private double x=0,y=0;
    private Color fillColor,outlineColor;
    private boolean fill,outline,clickable,hover,rounded;
    private double width,height;
    private ArrayList<NebNode> children = new ArrayList<>();

    @Override
    public NebRectBuilder round(NebRadius radius) {
        this.rounded = true;
        this.radius = radius;
        return this;
    }

    @Override
    public NebRectBuilder round(int radius) {
        this.rounded = true;
        this.radius = NebRadius.of(radius);
        return this;
    }

    @Override
    public NebRectBuilder align(NebAlign origin) {
        this.origin = origin;
        return this;
    }

    @Override
    public NebRectBuilder position(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }


    @Override
    public NebRectBuilder fill(Color c) {
        this.fillColor = c;
        this.fill = true;
        return this;
    }

    @Override
    public NebRectBuilder outline(Color c) {
        this.outlineColor = c;
        this.outline = true;
        return this;
    }

    @Override
    public NebRectBuilder clickable(boolean isClickable) {
        this.clickable = isClickable;
        return this;
    }

    @Override
    public NebRectBuilder size(double width, double height) {
        this.width = width;
        this.height = height;
        return this;
    }

    @Override
    public NebRectBuilder append(NebNode... node) {
        for (NebNode nebNode : node) {
            children.add(nebNode);
        }
        return this;
    }

    public NebRect build() {
        NebPosition position = new NebPosition(origin,x,y);

        return new NebRect(position,fillColor,outlineColor,fill, outline,rounded,hover,clickable,width,height, children, radius);
    }

}
