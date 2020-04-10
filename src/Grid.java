
public class Grid {

    private int rl = 0;
    private int cl = 0;
    private Node[][] nodes;
    private Node startNode;
    private Node endNode;

    public Grid(int rl, int cl) {
        this.rl = rl;
        this.cl = cl;
        nodes = new Node[rl][cl];
        init_grid(rl, cl);
        this.startNode = new Node("S", 0, 0);
        mark_start(0, 0);
        this.endNode = new Node("E", rl-1, cl-1);
        mark_end(rl-1, cl-1);
    }

    public int getRl() {
        return rl;
    }

    public int getCl() {
        return cl;
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    // Initialize grid of rl x cl
    public void init_grid(int rl, int cl) {
        Node[][] arr = new Node[rl][cl];
        for (int i=0; i<rl; i++) {
            for (int j=0; j<cl; j++) {
                Node node = new Node("1", i, j);
                arr[i][j] = node;
            }
        }
        this.nodes = arr;
    }

    // Adds some simple walls for testing
    public void init_test_grid() {
        init_grid(10,10);
        mark_wall(0,2);
        mark_wall(2,2);
        mark_wall(3,2);
        mark_wall(4,2);
        mark_wall(3,2);
        mark_wall(4,7);
        mark_wall(5,7);
        mark_wall(6,7);
        mark_wall(3,7);

    }

    public void mark_start(int row, int col) {
        this.startNode.setVal("1");
        this.startNode = this.nodes[row][col];
        this.nodes[row][col].setVal("S");
    }

    public void mark_end(int row, int col) {
        this.endNode.setVal("1");
        this.endNode = this.nodes[row][col];
        this.nodes[row][col].setVal("E");
    }

    public void mark_visited(int row, int col) {
        this.nodes[row][col].setVal("V");
    }

    public void mark_wall(int row, int col) {
        this.nodes[row][col].setVal("X");
    }

    public void mark_path(int row, int col) {
        this.nodes[row][col].setVal("O");
    }

    // Prints grid to console
    public void print_grid() {
        for (int i=0; i<nodes.length; i++) {
            for (int j=0; j<nodes[0].length; j++) {
                System.out.print(nodes[i][j].getVal() + "  ");
            }
            System.out.print("\n");
        }
    }

}

