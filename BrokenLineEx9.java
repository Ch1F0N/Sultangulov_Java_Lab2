import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLineEx9 {
    private List<Point> points;

    public BrokenLineEx9() {
        this.points = new ArrayList<>();
    }

    public BrokenLineEx9(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
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
            if (i < points.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
