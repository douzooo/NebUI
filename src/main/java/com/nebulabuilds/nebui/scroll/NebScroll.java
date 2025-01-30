package com.nebulabuilds.nebui.scroll;

import com.nebulabuilds.nebui.components.elements.NebScrollbar;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class NebScroll {

    @Getter
    private NebScrollDirection direction;
    @Getter
    private NebScrollType type;
    private boolean invertedMouseWheel = false;
    private ScrollHelper scrollHelper;
    @Getter @Setter
    private NebScrollbar scrollbar;

    public void setWheel(int wheel) {
            scrollHelper.setWheel(wheel);  // Use the wheel value as is
    }



    public NebScroll(NebScrollDirection direction, NebScrollType type,boolean inverted, NebScrollbar scrollbar) {
        this.direction = direction;
        this.type = type;
        this.scrollHelper = new ScrollHelper();
        scrollHelper.setFlag(true);
        scrollHelper.setSpeed(100);
        scrollHelper.setStep(20);
        scrollHelper.setMaxScroll(280);
        scrollHelper.setInverted(inverted);
        this.scrollbar =scrollbar;
    }


    @Override
    public String toString() {
        return "NebScroll{" +
                "direction=" + direction +
                ", type=" + type +
                ", scrollHelper=" + scrollHelper.toString() +
                ", scroll=" + get() +
                '}';
    }

    public float get(){
        return scrollHelper.getScroll();
    }
}
