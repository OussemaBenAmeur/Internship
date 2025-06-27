interface Drawable {
    default void draw() {
        System.out.println("Draw");
    }
}
interface Transformable {
    default void transform(double x, double y) {
        System.out.println("Transform by "+x+" and "+y);
    }
}

abstract class Shape implements Drawable, Transformable {
    abstract double getArea();

}

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    double getArea() {
        return height * width;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle of width " + width + " and height " + height);
    }
    @Override
    public void transform(double x, double y) {
        System.out.println("Transforming Rectangle of width " + width + " and height " + height + " to " + x + "," + y);
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    double getArea() {
        return 0.5*base * height;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Triangle of base " + base + " and height " + height);
    }
    @Override
    public void transform( double x, double y) {
        System.out.println("Transforming Triangle of base " + base + " and height " + height + " to " + x + "," + y);
    }

}

class Circle extends Shape {
    double radius;
    double nothing=0;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius " + radius);
    }
    @Override
    public void transform( double x, double y) {
        System.out.println("Transforming circle with radius " + radius + " to " + x + "," + y );
    }

}


public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(4, 5),
                new Triangle(3, 6),
                new Circle(5)
        };
        Rectangle rect =new Rectangle(4, 5);
        double x=rect.height;

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.getArea());
        }
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                shape.draw();
                shape.transform(2.5, 0);
                System.out.println("Area: " + shape.getArea());
            }
            else {
                shape.draw();
                shape.transform(2.5, 1.5);
                System.out.println("Area: " + shape.getArea());
            }
        }
    }
}

