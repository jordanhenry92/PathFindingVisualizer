
public class Node {

    private String val;
    private int r;
    private int c;

    public Node(String val, int r, int c) {
        this.val = val;
        this.r = r;
        this.c = c;
    }

    public String getVal() {
        return val;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public void setVal(String val) {
        this.val = val;
    }

}

