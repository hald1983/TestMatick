package Test;

import java.awt.Color;
import java.util.Arrays;

public interface Shape {
    void draw();
    int getSpace();
    String getColor();
}

class Square implements Shape {
    int side;
    Color color;

    Square(Color color, int side) {
        this.color = color;
        this.side = side;
    }

    @Override
    public String toString() {
        return "Квадрат: Площадь -" + getSpace() + " кв.ед., Длинна стороны -" +  Arrays.toString(getSide()) + " ед., Цвет (R, G, B) -" + getColor() + ".";
    }

    @Override
    public void draw() {
        new SquareDrawing(color, side, this);
    }

    @Override
    public int getSpace() {
        return side*side;
    }

    @Override
    public String getColor() {
        return "" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() ;
    }

    int[] getSide() {
        int [] arr = {side};
        return arr;
    }
}


class Triangle implements Shape {
    int side1, side2;
    double side3;
    Color color;

    public Triangle(Color color, int side1, int side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.color = color;
    }

    double[] getSide() {
        double [] arr = {side1, side2, side3};
        return arr;
    }

    double getHypotenuse() {
        double hypotenuse = 0;
        for(double i : getSide()){
            if(hypotenuse < i) hypotenuse = i;
        }
        return hypotenuse;
    }

    @Override
    public void draw() {
        new TriangleDrawing(color, side1, side2, this);
    }

    @Override
    public String getColor() {
        return "" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() ;
    }

    public String toString() {
        return "Треугольник: Площадь -" + getSpace() + " кв.ед., Длина сторон -" +  Arrays.toString(getSide()) + " ед., Цвет (R, G, B) -" + getColor() + ", Гипотенуза -" + getHypotenuse()+" ед.";
    }

    @Override
    public int getSpace(){
        int p = (int) (side1+side2+side3)/2;
        int s = (int) Math.sqrt((p*(p-side1)*(p-side2)*(p-side3)));
        return s;

    }

}

class Circle implements Shape {
    int radius;
    Color color;

    public Circle(Color color, int radius) {
        this.radius = radius;
        this.color = color;
    }

    int getRadius() { return radius; }

    @Override
    public void draw() {
        new CircleDrawing(color, radius, this);
    }

    @Override
    public int getSpace() {
        return  ((int) (Math.PI * Math.pow(radius, 2)));
    }

    @Override
    public String getColor() {
        return "" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() ;
    }

    public String toString() {
        return "Круг: Площадь -" + getSpace() + " кв.ед., Радиус -" +  radius + " ед., Цвет (R, G, B) -" + getColor() + ".";
    }
}

class Trapeze implements Shape {
    int base1, base2, h;
    Color color;

    public Trapeze(Color color, int base1, int base2, int h) {
        this.base1 = base1;
        this.base2 = base2;
        this.h = h;
        this.color = color;
    }

    int[] side() {
        int [] arr = {base1, base2, h};
        return arr;
    }

    @Override
    public void draw() {
        new TrapezeDrawing(color, base1, base2, h, this);
    }

    @Override
    public int getSpace() {
        return (base1+base2)/2*h;
    }

    @Override
    public String getColor() {
        return "" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() ;
    }

    public String toString() {
        return "Трапеция: Площадь -" + getSpace() + " кв.ед., Размеры: Основания1, Основания2, Высота -" +  Arrays.toString(side()) + " ед., Цвет (R, G, B) -" + getColor() + ".";
    }
}