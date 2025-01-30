package com.nebulabuilds.nebui.components.builders.impl;

import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.components.builders.NebNodeBuilder;
import com.nebulabuilds.nebui.components.elements.NebRect;
import com.nebulabuilds.nebui.components.elements.NebScrollbar;
import com.nebulabuilds.nebui.layout.NebAlign;
import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.utils.NebRadius;

import java.awt.*;
import java.util.ArrayList;

public class NebScrollbarBuilder {

    private NebAlign origin = NebAlign.MIDDLE_CENTER;
    private double x=0,y=0;
    private double width,height;
    private ArrayList<NebNode> children = new ArrayList<>();



    public NebScrollbarBuilder position(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }


    public NebScrollbarBuilder size(double width, double height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public NebScrollbar build() {
        NebScrollbar position = new NebScrollbar((float) x, (float) y, (float) width, (float) height);

        return position;
    }

}
