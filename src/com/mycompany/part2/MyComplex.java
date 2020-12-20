package com.mycompany.part2;

public class MyComplex {
    double real = 0.0;
    double imag = 0.0;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public MyComplex() {
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + "+" + imag + "i)";
    }

    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return !isReal();
    }

    public boolean equals(double real, double imag) {
        return Double.compare(this.real, real) == 0
                && Double.compare(this.imag, imag) == 0;
    }

    public boolean equals(MyComplex myComplex) {
        if (this == myComplex) return true;
        if (myComplex == null) return false;
        return equals(real, imag);
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        return Math.atan(imag / real);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real,
                this.imag + right.imag);
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.real,
                this.imag - right.imag);
    }

    public MyComplex multiply(MyComplex right) {
        double reTmp = this.real * right.real - this.imag * right.imag;
        double imTmp = this.imag * right.real + this.real * right.imag;
        this.real = reTmp;
        this.imag = imTmp;
        return this;

    }

    public MyComplex divide(MyComplex right) {
        double denominator = right.real * right.real + right.imag * right.imag;
        double reTmp = this.real * right.real + this.imag * right.imag;
        double imTmp = right.real * this.imag - this.real * right.imag;
        this.real = reTmp / denominator;
        this.imag = imTmp / denominator;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }


}
