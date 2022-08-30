package com.hw.hw_8;

public class Line extends Shape implements Scalable, Movable, Rotatable{
    private Point point1;
    private Point point2;
    private double length;
    private double angle;

    public Line(Point point1, Point point2){
        this.point1 = point1;
        this.point2 = point2;
        length = Math.sqrt(Math.pow(point2.X() - point1.X(), 2d) + Math.pow(point2.Y() - point1.Y(), 2d));
        angle = Math.toDegrees(Math.atan(Math.abs(point2.Y() - point1.Y()) / Math.abs(point2.X() - point1.X())));
    }

    public Line(Point point, double length, float angle){
        point1 = point;
        this.length = length;
        this.angle = angle;
        double y = length * Math.sin(Math.toRadians(angle));
        double x = length * Math.cos(Math.toRadians(angle));
        point2 = new Point(x, y);
    }

    public Line(Point point, double length){
        point1 = point;
        this.length = length;
        this.angle = 0;
        point2 = new Point(point.X() + length, point.Y() + length);
    }

    @Override
    String getNameShape() {
        return "Line";
    }

    @Override
    public void move(Point newBasePoint) {
        double dX = newBasePoint.X() - point1.X();
        double dY = newBasePoint.Y() - point1.Y();
        point1 = newBasePoint;
        point2 = new Point(point2.X() + dX, point2.Y() + dY);
    }

    @Override
    public void rotate(Point point, float angle) {
        double r = Math.sqrt(Math.pow(point.X() - point1.X(), 2) + Math.pow(point.Y() - point1.Y(), 2));
        this.angle = angle + Math.acos(r);
        double x = Math.acos(this.angle);
        double y = Math.asin(this.angle);
        double dX = x - point1.X();
        double dY = y - point1.Y();
        point1 = new Point(x, y);
        point2 = new Point(point2.X() - dX, point2.Y() - dY);
    }

    @Override
    public void scale(float percent) {
        length *= percent / 100;
        double x2 = Math.acos(Math.toRadians(angle));
        double y2 = Math.asin(Math.toRadians(angle));
        point2 = new Point(x2, y2);
    }

    @Override
    void delete() {
        point1 = null;
        point2 = null;
    }
}
