package com.nebulabuilds.nebui.layout;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NebPosition {

    private NebAlign origin;
    private double x, y;

    public NebPosition(NebAlign origin, double x, double y) {
        this.origin = origin;
        this.x = x;
        this.y = y;
    }

    public float getXOnScreen(float screenWidth) {



        double calculated = (((screenWidth * origin.getX()) + x) ) ;

        return (float) calculated;
    }

    public float getYOnScreen(float screenHeight) {

        double calculated = (((screenHeight * origin.getY()) + y));

        return (float) calculated;
    }
}
