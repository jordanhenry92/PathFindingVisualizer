import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {

    // Runs the BFS algorithm
    public void onOkClick(Grid grid) {
        Algorithms algo = new Algorithms();
        algo.find_path_bfs(grid);
        grid.print_grid();
        System.out.println("");
    }

    // Refreshes the grid to the original state
    public void onRefreshClick(Grid grid, int rl, int cl) {
        grid.init_grid(rl, cl);
        grid.mark_start(0,0);
        grid.mark_end(rl-1, cl-1);
        grid.print_grid();
        System.out.println("");
    }

    // Places a node with the appropriate value depending on the toggle selected
    public void onclick(Button b, ToggleGroup tg, Grid grid, int row, int col) {

        RadioButton selectedRadioButton = (RadioButton)tg.getSelectedToggle();
        String selectedValue = selectedRadioButton.getText();

        switch (selectedValue) {
            case "Wall":
                grid.mark_wall(row, col);
                break;
            case "Start":
                grid.mark_start(row, col);
                break;
            case "End":
                grid.mark_end(row, col);
                break;
        }

//        grid.print_grid();
//        System.out.println("");
    }

}
