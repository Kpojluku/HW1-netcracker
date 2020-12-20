package com.mycompany.part2;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius,
                int speed, int direction) throws IllegalArgumentException {
        if(direction > 180 || direction < -180){
            throw new IllegalArgumentException("Введенное значение аргумента \"direction\"" +
                    " не входит в допустимый диапазон (от -180 до 180)");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
        double convertToRadians = direction*Math.PI/180;
        this.xDelta = calculateXDelta(speed, convertToRadians);
        this.yDelta = calculateYDelta(speed, convertToRadians);
    }
    private float calculateXDelta(int speed, double direction){
        return (float) (speed * Math.cos(direction));
    }
    private float calculateYDelta(int speed, double direction){
        return (float) (speed * Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        x += xDelta;
        y += yDelta;
    }
    public void reflectHorizontal(){
        xDelta = -xDelta;
    }
    public void reflectVertical(){
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + x + "," + y +
                "), speed=(" + xDelta + ","
                + yDelta + ")]";
    }
}
