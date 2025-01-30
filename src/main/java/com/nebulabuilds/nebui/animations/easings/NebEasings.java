package com.nebulabuilds.nebui.animations.easings;


public class NebEasings {


    public static float linear(float x) {
        return x;
    }


    public static float easeInSine(float x) {
        return (float) (1.0 - Math.cos(x * Math.PI / 2.0));
    }


    public static float easeOutSine(float x) {
        return (float) Math.sin(x * Math.PI / 2.0);
    }


    public static float easeInOutSine(float x) {
        return (float) (-(Math.cos(Math.PI * x) - 1.0) / 2.0);
    }


    public static float easeInCubic(float x) {
        return x * x * x;
    }


    public static float easeOutCubic(float x) {
        return (float) (1.0 - Math.pow(1.0 - x, 3.0));
    }


    public static float easeInOutCubic(float x) {
        return (float) (x < 0.5 ? 4.0 * x * x * x : 1.0 - Math.pow(-2.0 * x + 2.0, 3.0) / 2.0);
    }


    public static float easeInQuint(float x) {
        return x * x * x * x * x;
    }


    public static float easeOutQuint(float x) {
        return (float) (1.0 - Math.pow(1.0 - x, 5.0));
    }


    public static float easeInOutQuint(float x) {
        return x < 0.5 ? 16.0f * x * x * x * x * x : 1.0f - (float) Math.pow(-2.0 * x + 2.0, 5.0) / 2.0f;
    }


    public static float easeInQuad(float x) {
        return x * x;
    }


    public static float easeOutQuad(float x) {
        return 1.0f - (1.0f - x) * (1.0f - x);
    }


    public static float easeInOutQuad(float x) {
        return x < 0.5 ? 2.0f * x * x : 1.0f - (float) Math.pow(-2.0 * x + 2.0, 2.0) / 2.0f;
    }


    public static float easeInQuart(float x) {
        return x * x * x * x;
    }


    public static float easeOutQuart(float x) {
        return 1.0f - (float) Math.pow(1.0 - x, 4.0);
    }


    public static float easeInOutQuart(float x) {
        return x < 0.5 ? 8.0f * x * x * x * x : 1.0f - (float) Math.pow(-2.0 * x + 2.0, 4.0) / 2.0f;
    }


    public static float easeInExpo(float x) {
        return x == 0.0f ? 0.0f : (float) Math.pow(2.0, 10.0 * (x - 1.0));
    }


    public static float easeOutExpo(float x) {
        return x == 1.0f ? 1.0f : (float) (-Math.pow(2.0, -10.0 * x) + 1.0);
    }


    public static float easeInOutExpo(float x) {
        if (x == 0.0f) return 0.0f;
        if (x == 1.0f) return 1.0f;
        return x < 0.5f ? (float) (Math.pow(2.0, 20.0 * x - 10.0) / 2.0) : (float) (2.0 - Math.pow(2.0, -20.0 * x + 10.0) / 2.0);
    }


    public static float easeInElastic(float x) {
        return x == 0.0f ? 0.0f : x == 1.0f ? 1.0f : (float) (-Math.pow(2.0, 10.0 * x - 10.0) * Math.sin((x * 10.0 - 10.75) * (2.0 * Math.PI) / 3.0));
    }


    public static float easeOutElastic(float x) {
        return x == 0.0f ? 0.0f : x == 1.0f ? 1.0f : (float) (Math.pow(2.0, -10.0 * x) * Math.sin((x * 10.0 - 0.75) * (2.0 * Math.PI) / 3.0) + 1.0);
    }


    public static float easeInOutElastic(float x) {
        if (x == 0.0f) return 0.0f;
        if (x == 1.0f) return 1.0f;
        return x < 0.5f ?
                (float) (-Math.pow(2.0, 20.0 * x - 10.0) * Math.sin((20.0 * x - 11.125) * (2.0 * Math.PI) / 4.5) / 2.0) :
                (float) (Math.pow(2.0, -20.0 * x + 10.0) * Math.sin((20.0 * x - 11.125) * (2.0 * Math.PI) / 4.5) / 2.0 + 1.0);
    }
}