public class BrokenLine {
    private int x;
    private int y;

    public BrokenLine(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint() {
        this.x += 2;
        this.y -= 5;
    }

    @Override
    public String toString() {
        return String.format("{%1$d;%2$d}", x, y);
    }
}