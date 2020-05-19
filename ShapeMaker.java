package Test;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ShapeMaker {
    Shape BuildShape();
}

class CircleBuilder implements ShapeMaker {

    @Override
    public Shape BuildShape() {
        return new Circle(
                new Color(Start.rand.nextInt(256), Start.rand.nextInt(256), Start.rand.nextInt(256)),
                Start.rand.nextInt(80)+5
        );
    }
}

class SquareBuilder implements ShapeMaker {

    @Override
    public Shape BuildShape() {
        return new Square(
                new Color(Start.rand.nextInt(256), Start.rand.nextInt(256), Start.rand.nextInt(256)),
                Start.rand.nextInt(50)+5
        );
    }
}

class TriangleBuilder implements ShapeMaker {

    @Override
    public Shape BuildShape() {
        int side1, side2;
        double side3;
        {
            side1 = Start.rand.nextInt(50)+5;
            side2 = Start.rand.nextInt(50)+5;
            side3 = new BigDecimal(Math.sqrt((side1*side1+side2*side2))).setScale(3, RoundingMode.UP).doubleValue();
        }

        return new Triangle(
                new Color(Start.rand.nextInt(256), Start.rand.nextInt(256), Start.rand.nextInt(256)),
                side1, side2, side3);
    }
}

class TrapezeBuilder implements ShapeMaker {

    @Override
    public Shape BuildShape() {
        int base1 = Start.rand.nextInt(50)+5;
        int base2 = Start.rand.nextInt(50)+5;
        int h = Start.rand.nextInt(50)+5;


        return new Trapeze(
                new Color(Start.rand.nextInt(256), Start.rand.nextInt(256), Start.rand.nextInt(256)),
                base1, base2, h
        );
    }
}