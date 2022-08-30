package com.hw.hw_8;

public class Circle extends Shape implements Movable, Scalable {

    private double r;
    private Point pointCenter;

    public Circle(Point point, double r){
        pointCenter = point;
        this.r = r;
    }

    public Circle(Point point1, Point point2){
        double dX = (point2.X() - point1.X());
        double dY = (point2.Y() - point1.Y());
        r = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2)) / 2;
        pointCenter = new Point(dX/2, dY/2);
    }

    public void resize(double r) {
        this.r = r;
    }

    @Override
    String getNameShape() {
        return "Circle";
    }

    @Override
    void delete() {
        pointCenter = null;
    }

    @Override
    public void move(Point newPointCenter) {
        pointCenter = newPointCenter;
    }

    @Override
    public void scale(float percent) {
        r *= percent / 100;
    }
}
