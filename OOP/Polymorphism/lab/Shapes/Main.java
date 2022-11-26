package Polymorphism.lab.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Rectangle(4.0,7.0);

        shape.calculateArea();
        shape.calculatePerimeter();
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());

        Shape circle = new Circle(14.0);
        circle.calculatePerimeter();
        circle.calculateArea();
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
