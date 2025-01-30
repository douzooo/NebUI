package com.nebulabuilds.nebui.screen;

import com.nebulabuilds.nebui.components.NebNode;
import com.nebulabuilds.nebui.effects.NebScreenEffects;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class NebScreen {

    @Getter @Setter
    private NebScreenEffects screenEffects = new NebScreenEffects();

    private final List<NebNode> components = new ArrayList<>();
    public InitCallback initCallback = () -> {};
    public EffectCallback effectCallback = (x) -> {};
    // Add a single component
    public void addNode(NebNode component) {
        components.add(component);
    }

    public boolean hasScreenEffects(){
        return screenEffects != null;
    }


    // Add multiple components
    public void addNode(NebNode... components) {
        this.components.addAll(Arrays.asList(components));
    }

    // Get the list of components
    public List<NebNode> getComponents() {
        return new ArrayList<>(components);  // Return a copy to prevent external modification
    }

    // Initialize with a callback
    public void init(InitCallback initCallback) {
        this.initCallback = initCallback;
    }

    // Initialize with a callback
    public void effect(EffectCallback effectCallback) {
        this.effectCallback = effectCallback;
    }

    // Interface for initialization callback
    public interface InitCallback {
        void init();
    }

    public interface EffectCallback {
        void load(NebScreenEffects effects);
    }

    // Abstract method to build the screen with effects
    public abstract void build();
}
