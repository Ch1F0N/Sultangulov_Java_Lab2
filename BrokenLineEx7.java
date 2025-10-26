import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLineEx7 {
    private List<Point> points;

    public BrokenLineEx7() {
        this.points = new ArrayList<>();
    }

    public BrokenLineEx7(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public void addPoint(Point point) {
        if (point != null) {
            points.add(point);
        }
    }

    public void addPoints(Point... newPoints) {
        points.addAll(Arrays.asList(newPoints));
    }

    public double getLength() {
        if (points.size() < 2) return 0.0;

        double length = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
    }

    public void move(double dx, double dy) {
        for (Point p : points) {
            p.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        if (points.isEmpty()) {
            return "Линия []";
        }
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
