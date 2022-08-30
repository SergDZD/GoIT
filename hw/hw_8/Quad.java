package com.hw.hw_8;

public class Quad extends Shape implements Scalable, Movable, Rotatable{
    private Point pointLowLeft;
    private Point pointLowRight;
    private Point pointHighLeft;
    private Point pointHighRight;
    private double lengthSide;
    private double angle;
    private double lengthDiagonal;

    @Override
    String getNameShape() {
        return "Quad";
    }

    @Override
    void delete() {
        pointLowRight = null;
        pointHighRight = null;
        pointLowLeft = null;
        pointHighLeft = null;
    }

    public Quad(Point pointLowLeft, double lengthSide) {
        this.pointLowLeft = pointLowLeft;
        this.lengthSide = lengthSide;
        this.pointLowRight = new Point(pointLowLeft.X() + lengthSide, pointLowLeft.Y());
        this.pointHighLeft = new Point(pointLowLeft.X(), pointLowLeft.Y() + lengthSide);
        this.pointHighRight = new Point(pointLowLeft.X() + lengthSide, pointLowLeft.Y() + lengthSide);
        lengthDiagonal = getLengthDiagonal(lengthSide);
        angle = 0;
    }

    public Quad(Point pointLowLeft, Point pointHighRight) {
        this.pointLowLeft = pointLowLeft;
        this.pointHighRight = pointHighRight;
        pointLowRight = new Point(pointHighRight.X(), pointLowLeft.Y());
        pointHighLeft = new Point(pointLowLeft.X(), pointHighRight.Y());
        lengthSide = Math.abs(pointLowLeft.X() - pointLowRight.X());
        lengthDiagonal = getLengthDiagonal(lengthSide);
        angle = 0;
    }

    @Override
    public void move(Point newBasePoint) {
        double dX = newBasePoint.X() - pointLowLeft.X();
        double dY = newBasePoint.Y() - pointLowLeft.Y();
        pointLowLeft = newBasePoint;
        pointLowRight = new Point(pointLowRight.X() + dX, pointLowRight.Y() + dY);
        pointHighLeft = new Point(pointHighLeft.X() + dX, pointHighLeft.Y() + dY);
        pointHighRight = new Point(pointHighRight.X() + dX, pointHighRight.Y() + dY);
    }

    @Override
    public void rotate(Point point, float angle) {
        double r = Math.sqrt(Math.pow(point.X() - pointLowLeft.X(), 2) + Math.pow(point.Y() - pointLowLeft.Y(), 2));
        this.angle = angle + Math.acos(r);
        pointLowLeft = new Point(Math.acos(this.angle), Math.asin(this.angle));
        setNewPoint(this.angle);
    }

    @Override
    public void scale(float percent) {
        lengthSide *= (percent / 100);
        lengthDiagonal = getLengthDiagonal(lengthSide);
        setNewPoint(angle);
    }

    private double getLengthDiagonal(double lengthSide){
        return lengthDiagonal = Math.sqrt(lengthSide * lengthSide * 2);
    }

    private void setNewPoint(double angle) {
        double dX = Math.cos(Math.toRadians(this.angle)) * lengthSide;
        double dY = Math.sin(Math.toRadians(this.angle)) * lengthSide;
        pointLowRight = new Point(pointLowRight.X() + dX, pointLowRight.Y() + dY);
        dX = Math.cos(Math.toRadians(this.angle + 45)) * lengthSide;
        dY = Math.sin(Math.toRadians(this.angle + 45)) * lengthSide;
        pointHighRight = new Point(pointHighRight.X() + dX, pointHighRight.Y() + dY);
        dX = Math.cos(Math.toRadians(this.angle + 90)) * lengthSide;
        dY = Math.sin(Math.toRadians(this.angle + 90)) * lengthSide;
        pointHighLeft = new Point(pointHighLeft.X() + dX, pointHighLeft.Y() + dY);
    }
}
