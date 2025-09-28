public class BrokenLineEx9 {
    private int x;
    private int y;
    private int x2;
    private int y2;

    public BrokenLineEx9() {
        this.x = 0;
        this.y = 0;
    }

    public BrokenLineEx9(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public BrokenLineEx9(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint() {
        this.x += 2;
        this.y -= 5;
    }

    @Override
    public String toString() {
        if (x2 != 0 && y2 != 0) {
            return String.format("{%1$d;%2$d}, {%3$d;%4$d}", x, y, x2, y2);
        } else {
            return String.format("{%1$d;%2$d}", x, y);
        }
    }
}
