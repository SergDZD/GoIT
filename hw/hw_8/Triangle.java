package com.hw.hw_8;

public class Triangle extends Shape implements Movable, Rotatable, Scalable{

    private Point point1, point2, point3;

    @Override
    String getNameShape() {
        return "Triangle";
    }

    @Override
    void delete() {
        point1 = point2 = point3 = null;
    }

    public Triangle(Point point1, Point point2, Point point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public void move(Point newBasePoint) {
        double dX = newBasePoint.X() - point1.X();
        double dY = newBasePoint.Y() - point1.Y();
        point1 = newBasePoint;
        point2 = new Point(point2.X() + dX, point2.Y() + dY);
        point3 = new Point(point3.X() + dX, point3.Y() + dY);
    }

    @Override
    public void rotate(Point point, float angle) {
        double r1 = Math.sqrt(Math.pow(point.X() - point1.X(), 2) + Math.pow(point.Y() - point1.Y(), 2));
        double r2 = Math.sqrt(Math.pow(point.X() - point2.X(), 2) + Math.pow(point.Y() - point2.Y(), 2));
        double r3 = Math.sqrt(Math.pow(point.X() - point3.X(), 2) + Math.pow(point.Y() - point3.Y(), 2));
        double fullAngle1 = Math.toRadians(angle) + Math.acos(r1);
        double fullAngle2 = Math.toRadians(angle) + Math.acos(r2);
        double fullAngle3 = Math.toRadians(angle) + Math.acos(r3);
        point1 = new Point(Math.cos(fullAngle1), Math.sin(fullAngle1));
        point2 = new Point(Math.cos(fullAngle2), Math.sin(fullAngle2));
        point3 = new Point(Math.cos(fullAngle3), Math.sin(fullAngle3));
    }

    @Override
    public void scale(float percent) {
        double lengthA = Math.sqrt(Math.pow(point2.X() - point1.X(), 2) + Math.pow(point2.Y() - point1.Y(), 2));
        double lengthB = Math.sqrt(Math.pow(point3.X() - point1.X(), 2) + Math.pow(point3.Y() - point1.Y(), 2));
        double lengthC = Math.sqrt(Math.pow(point3.X() - point2.X(), 2) + Math.pow(point3.Y() - point2.Y(), 2));
        double dX = point1.X() - point2.X();
        double tempAngle = Math.acos(dX / lengthA);
        lengthA *= (percent / 100);
        dX = lengthA * Math.cos(tempAngle);
        double dY = lengthA * Math.sin(tempAngle);
        point2 = new Point(point2.X() + dX, point2.Y() + dY);
        dX = point1.X() - point3.X();
        tempAngle = Math.acos(dX / lengthB);
        lengthB *= (percent / 100);
        dX = lengthB * Math.cos(tempAngle);
        dY = lengthB * Math.sin(tempAngle);
        point2 = new Point(point3.X() + dX, point3.Y() + dY);

    }
}
