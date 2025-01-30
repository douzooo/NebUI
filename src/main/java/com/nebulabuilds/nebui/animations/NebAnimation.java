package com.nebulabuilds.nebui.animations;

import lombok.Getter;

import java.util.function.Consumer;
import java.util.function.Function;

public class NebAnimation {

    private float duration,elapsed;
    private Consumer<Float> callbackUpdate;
    private Function<Float, Float> easingFunction;
    @Getter
    private boolean running;

    public NebAnimation(float duration, Consumer<Float> callbackUpdate, Function<Float, Float> easingFunction) {
        this.duration       = duration;
        this.elapsed        = 0;
        this.callbackUpdate = callbackUpdate;
        this.easingFunction = easingFunction;
        this.running        = false;
    }

    public void start(){
        this.running = true;
    }

    public void stop(){
        this.running = false;
    }

    public void tick(float deltaTime){
        if(!running) return;
        elapsed += deltaTime; //Thx Copilot
        if(elapsed > duration){
            elapsed = duration;
            running = false;
        }
        float progress = easingFunction.apply(elapsed / duration);
        callbackUpdate.accept(progress);
    }

}
