package Polymorphism.lab.Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(height * 2 + width * 2);
    }

    @Override
    public void calculateArea() {
        setArea(height * width);
    }
}
