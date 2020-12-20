package com.mycompany.part2;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length <= 1 ? 0 : coeffs.length - 1;
    }

    @Override
    public String toString() {
        if (coeffs.length == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (coeffs.length > 1) {
            for (int i = coeffs.length - 1; i > 1; i--) {
                sb.append(coeffs[i]).append("x^").append(i).append("+");
            }
            sb.append(coeffs[1]).append("x").append("+");
        }
        sb.append(coeffs[0]);
        return sb.toString();
    }

    public MyPolynomial add(MyPolynomial right) {
        if (right.coeffs.length == 0) {
            return new MyPolynomial(this.coeffs);
        }
        int minLength = Math.min(this.coeffs.length, right.coeffs.length);
        double[] highDegree;
        double[] lowDegree;
        if (this.coeffs.length >= right.coeffs.length) {
            highDegree = this.coeffs;
            lowDegree = right.coeffs;
        } else {
            highDegree = right.coeffs;
            lowDegree = this.coeffs;
        }
        for (int i = 0; i < minLength; i++) {
            highDegree[i] += lowDegree[i];
        }
        return new MyPolynomial(highDegree);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        if (right.coeffs.length == 0) {
            return new MyPolynomial(this.coeffs);
        }
        int thisLength = this.coeffs.length;
        int rightLength = right.coeffs.length;
        double[] prod = new double[thisLength + rightLength - 1];

        for (int i = 0; i < thisLength + rightLength - 1; i++) {
            prod[i] = 0;
        }
        for (int i = 0; i < thisLength; i++) {
            for (int j = 0; j < rightLength; j++) {
                prod[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }

        return new MyPolynomial(prod);
    }
}