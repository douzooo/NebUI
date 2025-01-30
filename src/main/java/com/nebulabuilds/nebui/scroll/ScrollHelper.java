package com.nebulabuilds.nebui.scroll;

import com.nebulabuilds.nebui.NebUI;
import lombok.Getter;
import lombok.Setter;

public class ScrollHelper {
    private float step = 0, real = 0, scroll = 0, maxScroll = 0, speed = 300F;
    private boolean flag = true;
    @Setter
    private boolean inverted = false;

    /**
     Returns the smoothed scroll value, only call this once after you set all the setters
     */

    @Getter
    int wheel = 0;

    public void setWheel(int wheel) {
        if(inverted){
            this.wheel = -wheel;
        }else{
            this.wheel = wheel;
        }
    }

    public float getScroll() {
           float delta = 1f / NebUI.getInstance().minecraftBridge.fps();
           if (flag)
               real += wheel / 120f * step;
           float divider = delta * 2 * Math.min(speed, maxScroll); // Adjust this if needed
           if (scroll > real) {
               scroll -= ((scroll - real) / 50) * divider;
           }
           if (scroll < real) {
               scroll += ((real - scroll) / 50) * divider;
           }

           real = clamp_float(real, 0, maxScroll);
           real = ((int) (real * 100)) / 100f;


           System.out.println("DEBUG: " + scroll + "  /  " +  wheel + " / " + NebUI.getInstance().minecraftBridge.fps());

           return scroll;



    }

    public float clamp_float(float value, float min, float max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    /**
     How much to increment each scroll
     */
    public void setStep(float step) {
        this.step = step;
    }

    /**
     Maximum scroll, for example height of your scrollable panel
     */
    public void setMaxScroll(float maxScroll) {
        this.maxScroll = maxScroll;
    }

    /**
     Speed of the scrolling
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     Scrolling will only happen when this flag is true (by default it's always true)
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ScrollHelper{" +
                "step=" + step +
                ", real=" + real +
                ", scroll=" + scroll +
                ", maxScroll=" + maxScroll +
                ", speed=" + speed +
                ", flag=" + flag +
                '}';
    }
}
