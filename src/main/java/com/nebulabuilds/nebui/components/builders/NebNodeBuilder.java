package com.nebulabuilds.nebui.components.builders;

import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.layout.NebAlign;
import com.nebulabuilds.nebui.utils.NebRadius;

import java.awt.*;

public interface NebNodeBuilder {

    NebNodeBuilder round(NebRadius rad);
    NebNodeBuilder round(int rad);

    /**
     * Set the align of the position
     * @param origin
     * @return
     */
    NebNodeBuilder align(NebAlign origin);

    /**
     * Set the position based on the align
     * @param x
     * @param y
     * @return
     */
    NebNodeBuilder position(double x,double y);

    NebNodeBuilder fill(Color c);
    NebNodeBuilder outline(Color c);
    NebNodeBuilder clickable(boolean isClickable);
    NebNodeBuilder size(double width,double height);
    NebNodeBuilder append(NebNode... node);
}
