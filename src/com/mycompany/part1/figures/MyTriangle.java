package com.mycompany.part1.figures;

import com.mycompany.part1.MyPoint;
import com.mycompany.part1.TriangleType;

import java.util.Arrays;

public class MyTriangle {
        private MyPoint v1;
        private MyPoint v2;
        private MyPoint v3;

    public MyTriangle(int x1, int y1,
                      int x2, int y2,
                      int x3, int y3 ) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + Arrays.toString(v1.getXY()) +
                ", v2=" + Arrays.toString(v2.getXY()) +
                ", v3=" + Arrays.toString(v3.getXY()) +
                '}';
    }

    public double getPerimeter(){
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType(){

        if(isEquilateral()) {
            return TriangleType.Equilateral.getType();
        }else if (isIsosceles()){
            return TriangleType.Isosceles.getType();
        }else
            return TriangleType.Scalene.getType();

    }
    private boolean isEquilateral(){
        double epsilon = 0.000000001;
        return Math.abs(v1.distance(v2) - v2.distance(v3)) < epsilon  &&
                Math.abs(v2.distance(v3) - v3.distance(v1)) < epsilon  &&
                Math.abs(v3.distance(v1) - v1.distance(v2)) < epsilon ;
    }

    private boolean isIsosceles(){
        double epsilon = 0.000000001;
        return Math.abs(v1.distance(v2) - v2.distance(v3)) < epsilon  ||
                Math.abs(v2.distance(v3) - v3.distance(v1)) < epsilon  ||
                Math.abs(v3.distance(v1) - v1.distance(v2)) < epsilon ;
    }
}
