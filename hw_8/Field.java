package com.hw.hw_8;

import java.util.Arrays;

public class Field {
    final private int INITIAL_NUMBER_SHAPES = 10;
    private String name;
    private double height;
    private double width;
    private double x0;
    private double y0;
    private Shape[] arrayShape = new Shape[INITIAL_NUMBER_SHAPES];
    private int countShapes;
    private Shape activeShape;
    private int activeShapeIndex;

    public Field(String name){
        this(name, 100d, 100d);
    }

    public Field(String name, double height, double width){
        this.name = name;
        this.height = height;
        this.width = width;
    }

    public Shape activateShape(int index){
        if (index > 0 & index < countShapes){
            activeShape = arrayShape[index];
            activeShapeIndex = index;
            return activeShape;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void addShape(Shape shape){
        if(countShapes + 1 > arrayShape.length) {
            if (countShapes < Integer.MAX_VALUE) {
                if(countShapes + INITIAL_NUMBER_SHAPES <= Integer.MAX_VALUE) {
                    arrayShape = Arrays.copyOf(arrayShape, arrayShape.length + INITIAL_NUMBER_SHAPES);
                } else {
                    arrayShape = Arrays.copyOf(arrayShape, Integer.MAX_VALUE);
                }
            }
        }
        arrayShape[++countShapes] = shape;
    }

    public void delShape(int index){
        if (index > 0 & index < countShapes){
            for(int i = index; i > countShapes; i++){
                arrayShape[i] = arrayShape[i+1];
            }
            arrayShape[--countShapes] = null;
        }
    }

    public void delShape(){
        if(activeShape != null) {
            for (int i = activeShapeIndex; i > countShapes; i++) {
                arrayShape[i] = arrayShape[i + 1];
            }
            arrayShape[--countShapes] = null;
            activeShape = null;
            activeShapeIndex = -1;
        }
    }

    public String getName() {
        return name;
    }

    public void close(){
        arrayShape = new Shape[INITIAL_NUMBER_SHAPES];
    }

    public void resize(double newHeight, double width){
        this.height = height;
        this.width = width;
    }
}
