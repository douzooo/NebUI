package com.nebulabuilds.nebui.components.elements;

import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.utils.NebRadius;

import java.awt.*;
import java.util.ArrayList;

public class NebText extends NebNode {

    float maxWidth, maxHeight;

    public NebText(NebPosition position, Color fillColor, Color outlineColor, boolean fill, boolean outline, boolean hover, boolean clickable, boolean rounded, float width, float height, ArrayList<NebNode> children, NebRadius radius) {
        super(position, fillColor, outlineColor, fill, outline, hover, clickable, rounded, width, height, children, radius);
    }


    @Override
    public void handleFill(float x, float y, float width, float height) {

    }

    @Override
    public void handleOutline(float x, float y, float width, float height) {

    }
}
