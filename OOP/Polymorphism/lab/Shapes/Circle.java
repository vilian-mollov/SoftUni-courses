package Polymorphism.lab.Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        Double perimeter = 2 * Math.PI * radius;
        setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        Double area = Math.PI * radius * radius;
        setArea(area);
    }
}
