import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class PathFinderView extends Application {

    private int rl = 15;
    private int cl = 15;
    private Button[][] buttons = new Button[rl][cl];
    private Controller controller = new Controller();
    private Grid matrix = new Grid(rl, cl);


    // This method loads whatever you need before the application actually starts
    // Such as pictures, assets, etc...
    @Override
    public void init() throws Exception {
        System.out.println("Before");
    }

    public void setRl(int rl) {
        this.rl = rl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    // Launches the actual application
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Path-finding Visualizer");

        primaryStage.setHeight(750);
        primaryStage.setWidth(950);

        BorderPane border = new BorderPane();

        GridPane grid = new GridPane();
        grid.setPrefSize(700,700);


        // Set constraints for grid button sizes
        for (int row = 0 ; row < rl; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col < cl; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        // Create Radio buttons
        ToggleGroup tg = new ToggleGroup();
        RadioButton wallRb = new RadioButton("Wall");
        RadioButton startRb = new RadioButton("Start");
        RadioButton endRb = new RadioButton("End");
        wallRb.setToggleGroup(tg);
        wallRb.setSelected(true);
        startRb.setToggleGroup(tg);
        endRb.setToggleGroup(tg);

        CheckBox traversalCheck = new CheckBox("Show traversal path");
        traversalCheck.setPadding(new Insets(50, 10, 10, 5));
        traversalCheck.setOnAction(event -> update(buttons, matrix, traversalCheck));

        Button solveButton = new Button("Solve");
        solveButton.setOnAction(event -> {controller.onSolveClick(matrix);
                                        update(buttons, matrix, traversalCheck);});


        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> {controller.onRefreshClick(matrix, rl, cl);
                                            update(buttons, matrix, traversalCheck);});


        // Create grid buttons
        for (int r=0; r<rl; r++) {
            for (int c=0; c<cl; c++) {
                Button button = new Button();
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                button.setStyle("-fx-border-width: 0.3px;");
                button.setPadding(new Insets(0.3));
                buttons[r][c] = button;
                int tempR = r;
                int tempC = c;
                button.setOnAction(event -> {controller.onclick(button, tg, matrix, tempC, tempR);
                                            update(buttons, matrix, traversalCheck);});
                grid.add(button, r, c);
            }
        }

        update(buttons, matrix, traversalCheck);

        VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(10, 60, 20, 20));
        vbox.getChildren().add(wallRb);
        vbox.getChildren().add(startRb);
        vbox.getChildren().add(endRb);
        vbox.getChildren().add(solveButton);
        vbox.getChildren().add(refreshButton);
        vbox.getChildren().add(traversalCheck);

        border.setRight(vbox);

        ScrollPane scrollPane = new ScrollPane(grid);
        border.setCenter(scrollPane);

        primaryStage.setScene(new Scene(border));
        primaryStage.show();
    }

    public void update(Button[][] buttons, Grid grid, CheckBox cb) {
        for (int i=0; i<grid.getRl(); i++) {
            for (int j=0; j<grid.getCl(); j++) {
                switch (grid.getNodes()[i][j].getVal()) {
                    case "1":
                        buttons[j][i].setStyle(null);
                        break;
                    case "X":
                        buttons[j][i].setStyle("-fx-background-color:#43464b; -fx-border-width: 0.3px; -fx-border-color:BLACK");
                        break;
                    case "S":
                        buttons[j][i].setStyle("-fx-background-color:#3CB371; -fx-border-width: 0.3px; -fx-border-color:BLACK");
                        break;
                    case "E":
                        buttons[j][i].setStyle("-fx-background-color:#CD5C5C; -fx-border-width: 0.3px; -fx-border-color:BLACK");
                        break;
                    case "O":
                        buttons[j][i].setStyle("-fx-background-color:#4682B4; -fx-border-width: 0.3px; -fx-border-color:BLACK");
                        break;
                    case "V":
                        if (cb.isSelected()) {
                            buttons[j][i].setStyle("-fx-background-color:#87CEFA; -fx-border-width: 0.3px; -fx-border-color:BLACK");
                            break;
                        }
                }
            }
        }
    }

    // This method runs after the application is stopped
    @Override
    public void stop() throws Exception {
        System.out.println("After");
    }
}

