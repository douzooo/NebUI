package com.nebulabuilds.nebui.utils;

public class NebRadius {

    public  int top_left = 0,top_right = 0,bottom_left = 0 ,bottom_right = 0;

    public NebRadius(int top_left, int top_right, int bottom_left, int bottom_right) {
        this.top_left = top_left;
        this.top_right = top_right;
        this.bottom_left = bottom_left;
        this.bottom_right = bottom_right;
    }

    public NebRadius(int radius) {
        this.top_left = radius;
        this.top_right = radius;
        this.bottom_left = radius;
        this.bottom_right = radius;
    }

    public static NebRadius of(int radius){
        return new NebRadius(radius);
    }

    public static NebRadius of(int top_left, int top_right, int bottom_left, int bottom_right){
        return new NebRadius(top_left,top_right,bottom_left,bottom_right);
    }
}
