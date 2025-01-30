//package com.nebulabuilds.nebui.hover;
//
//import com.nebulabuilds.nebui.NebUI;
//import com.nebulabuilds.nebui.components.NebElement;
//import com.nebulabuilds.nebui.components.elements.NebFrame;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class NebHoverManager {
//
//    public ArrayList<NebElement> elementIndex = new ArrayList<>();
//    public NebElement currentHoveringElement = null;
//
//    public NebHoverManager() {
//    }
//
//    public boolean isHovering(){
//        return currentHoveringElement != null;
//    }
//
//    public void setHovering(NebElement nebElement){
//        this.currentHoveringElement = nebElement;
//    }
//
//    public void setNoneHover(){
//        this.currentHoveringElement = null;
//    }
//
//    public void addElement(NebElement element) {
//        elementIndex.add(element);
//    }
//
//    public void load() {
//        elementIndex.clear();
//        NebUI.getInstance().getActiveScreen().getComponents().forEach(component -> processComponent(component));
//        Collections.reverse(elementIndex);
//        printElementsTree();
//    }
//
//    private void processComponent(Object component) {
//        if (component instanceof NebElement) {
//            elementIndex.add((NebElement) component);
//        }
//
//        if (component instanceof NebFrame) {
//            NebFrame nebFrame = (NebFrame) component;
//            for (NebElement element : nebFrame.getChildren()) {
//                processComponent(element);
//            }
//        }
//    }
//
//    private void printWithIndent(Object obj, int indentLevel) {
//        for (int i = 0; i < indentLevel; i++) {
//            System.out.print("    "); // Print indentation spaces
//        }
//        System.out.println(obj);
//    }
//
//    public void printElementsTree() {
//        NebUI.getInstance().getActiveScreen().getComponents().forEach(component -> printComponentTree(component, 0));
//    }
//
//    private void printComponentTree(Object component, int indentLevel) {
//        printWithIndent(component, indentLevel);
//
//        if (component instanceof NebFrame) {
//            NebFrame nebFrame = (NebFrame) component;
//            for (NebElement element : nebFrame.getChildren()) {
//                printComponentTree(element, indentLevel + 1); // Recursively print the element with increased indent level
//            }
//        }
//    }
//
//    public boolean isElementInFront(NebElement element1, NebElement element2) {
//        int index1 = elementIndex.indexOf(element1);
//        int index2 = elementIndex.indexOf(element2);
//
//        if (index1 == -1 || index2 == -1) {
//            throw new IllegalArgumentException("Both elements must be in the elementIndex.");
//        }
//
//        return index1 > index2;
//    }
//}
