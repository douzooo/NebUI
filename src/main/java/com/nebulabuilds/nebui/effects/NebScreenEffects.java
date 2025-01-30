package com.nebulabuilds.nebui.effects;

import com.nebulabuilds.nebui.NebUI;
import lombok.Getter;

import java.util.ArrayList;

public class NebScreenEffects {

    @Getter
    public ArrayList<NebEffect> effects = new ArrayList<>();

    public void bind(NebEffect effect) {
        effects.add(effect);
    }

    public boolean hasEffect(NebEffect nebEffect) {
        return effects.contains(nebEffect);
    }

    public void render(float screenWidth, float screenHeight,float mouseX, float mouseY){
        for (NebEffect effect : effects) {
            effect.render(screenWidth, screenHeight, mouseX, mouseY);
        }
    }
}
