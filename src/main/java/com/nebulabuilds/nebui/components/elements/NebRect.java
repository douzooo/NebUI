package com.nebulabuilds.nebui.components.elements;

import com.nebulabuilds.nebui.NebUI;
import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.layout.NebPosition;
import com.nebulabuilds.nebui.utils.NebRadius;

import java.awt.*;
import java.util.ArrayList;

public class NebRect extends NebNode
{


    public NebRect(NebPosition position, Color fillColor, Color outlineColor, boolean fill, boolean outline,
    boolean rounded, boolean hover, boolean clickable, double width, double height,
    ArrayList<NebNode> children, NebRadius radius) {
    super(position, fillColor, outlineColor, fill, outline, hover, clickable, rounded, width, height, children, radius);
}

    @Override
    public void handleFill(float x, float y, float width, float height) {
        if (rounded) {
            NebUI.getInstance().getRenderer().drawRoundedRect(x, y, width, height, radius, fillColor);
        } else {
            NebUI.getInstance().getRenderer().drawRect(x, y, width, height, fillColor);
        }
    }

    @Override
    public void handleOutline(float x, float y, float width, float height) {
        if (outline) {
            // Implement outline drawing logic if necessary
//            NebUI.getInstance().getRenderer().draw(x, y, width, height, outlineColor);
        }
    }

}
