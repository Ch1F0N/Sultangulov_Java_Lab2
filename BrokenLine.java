public class BrokenLine {
    private Point[] points;

    public BrokenLine(Point... points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void move(double dx, double dy) {
        for (Point p : points) {
            p.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
