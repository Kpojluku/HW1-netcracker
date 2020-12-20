package com.mycompany.part1;

public enum TriangleType {
    Equilateral("Equilateral"),
    Isosceles("Isosceles"),
    Scalene("Scalene");

    private String type;

    TriangleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TriangleType{" +
                "type='" + type + '\'' +
                '}';
    }


}
