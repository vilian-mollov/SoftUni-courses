package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    Point bottomLeftCorner;
    Point topRightCorner;

    public Rectangle(Point bottomLeftCorner, Point topRightCorner) {
        this.bottomLeftCorner = bottomLeftCorner;
        this.topRightCorner = topRightCorner;
    }

    public boolean contains(Point point) {
        int testX = point.getX();
        int testY = point.getY();

        return testX >= bottomLeftCorner.x && testY >= bottomLeftCorner.y && testX <= topRightCorner.x && testY <= topRightCorner.y;
    }
}
