package com.mycompany.part1.figures;

public class Cylinder extends Circle{

    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, String color, double height){
        super(radius, color);
        this.height = height;
    }

    @Override
    public double getArea(){
        double baseSquare = 2*super.getArea();
        double rectangleSquare = 2*Math.PI*getRadius()*height;

        return baseSquare + rectangleSquare;
    }

    public double calculateVolume(){
        return super.getArea()*height;
    }

}
