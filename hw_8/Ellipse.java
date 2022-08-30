package com.hw.hw_8;

public class Ellipse extends Shape implements Movable, Scalable, Rotatable {
    private double x;
    private double y;
    private Point centerPoint;
    private double r1;
    private double r2;
    private double angle;


    public Ellipse(Point centerPoint, double r1, double r2) {
        this(centerPoint, r1, r2, 0);
    }

    public Ellipse(Point centerPoint, double r1, double r2, double angle) {
        this.centerPoint = centerPoint;
        this.r1 = r1;
        this.r2 = r2;
        this.angle = angle;
    }

    @Override
    String getNameShape() {
        return "Ellipse";
    }

    @Override
    void delete() {
        centerPoint = null;
    }

    @Override
    public void move(Point newCenterPoint) {
        centerPoint = newCenterPoint;
    }

    @Override
    public void rotate(Point point, float angle) {
        double r = Math.sqrt(Math.pow(point.X() - centerPoint.X(), 2) + Math.pow(point.Y() - centerPoint.Y(), 2));
        this.angle = angle + Math.acos(r);
        double x = Math.acos(this.angle);
        double y = Math.asin(this.angle);
        centerPoint = new Point(x, y);
    }

    @Override
    public void scale(float percent) {
        r1 *= percent / 100;
        r2 *= percent / 100;
    }
}

