package com.nebulabuilds.nebui.components.elements;

import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.utils.NebRadius;

import java.awt.*;
import java.util.List;

public class NebButton extends NebNode {
    public NebButton(NebPosition position, Color fillColor, Color outlineColor, boolean fill, boolean outline, boolean hover, boolean clickable, boolean rounded, double width, double height, List<NebNode> children, NebRadius radius) {
        super(position, fillColor, outlineColor, fill, outline, hover, clickable, rounded, width, height, children, radius);
    }
}
