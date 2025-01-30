package com.nebulabuilds.nebui.renderer;

import com.nebulabuilds.nebui.utils.NebRadius;

import java.awt.*;

public interface NebIRenderer {

    void start();
    void drawRect(float x, float y, float width, float height, Color c);
    void drawRoundedRect(float x, float y, float width, float height, NebRadius radius, Color color);
    void end();
    void nvgScissor(float x, float y, float width, float height);
    void nvgResetScissor();
    void nvgIntersectScissor(float x, float y, float width, float height);
    void restore();
    void save();
    float getScaleFactor();

}
