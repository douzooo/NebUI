package com.nebulabuilds.nebui.animations;

import java.util.ArrayList;
import java.util.Arrays;

public class NebAnimationManager {

    private ArrayList<NebAnimation> animations = new ArrayList<>();

    public void addAnimation(NebAnimation... animation){
        animations.addAll(Arrays.asList(animation));
    }

    public void update(float deltaTime){
        for(NebAnimation animation : animations){
            animation.tick(deltaTime);
        }
        animations.removeIf(nebAnimation -> !nebAnimation.isRunning());
    }


}
