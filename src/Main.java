import javafx.application.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;



public class Main extends Application{
    Label username;
    Label password;
    Label role, lbllanguage ,lblbirth;
    TextField txtuser;
    TextField txtpass;
    ComboBox<String> language;
    CheckBox[] checkBoxes;
    Button btn1, btn2;
    DatePicker datePicker;

    RadioButton radio1, radio2;
    ToggleGroup toggleGroup;

    @Override
    public void start(Stage stage){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);

        username = new Label("Username: ");
        txtuser = new TextField("Type your username");
        txtuser.setPrefWidth(300);
        grid.add(username,0,0);
        GridPane.setHalignment(username, HPos.RIGHT);
        GridPane.setValignment(username,VPos.CENTER);

        grid.add(txtuser,1,0);
        GridPane.setHalignment(txtuser, HPos.LEFT);
        GridPane.setValignment(username,VPos.CENTER);

        password = new Label("Password: ");
        txtpass = new PasswordField();
        txtpass.setPromptText("Enter your password");
        txtpass.setPrefWidth(300);
        grid.add(password,0,1);
        GridPane.setHalignment(password, HPos.RIGHT);
        GridPane.setValignment(password,VPos.CENTER);

        grid.add(txtpass,1,1);
        GridPane.setHalignment(txtpass, HPos.LEFT);
        GridPane.setValignment(txtpass,VPos.CENTER);

        lblbirth = new Label("Your birthdate:");
        datePicker = new DatePicker();
        datePicker.setPrefWidth(300);
        grid.add(lblbirth,0,2);
        grid.add(datePicker,1,2);

        lbllanguage = new Label("Choose language");
        language = new ComboBox<>();
        language.getItems().addAll("Python", "Java", "SQL");
        language.setPrefWidth(300);
        language.setPromptText("Click to choose");
        grid.add(lbllanguage,0,3);
        GridPane.setHalignment(lbllanguage, HPos.RIGHT);
        GridPane.setValignment(lbllanguage, VPos.CENTER);

        grid.add(language,1,3);
        GridPane.setHalignment(language, HPos.LEFT);
        GridPane.setValignment(language, VPos.CENTER);

        checkBoxes = new CheckBox[2];

        for (int i=0; i< checkBoxes.length; i++)
            checkBoxes[i] = new CheckBox();

        checkBoxes[0].setText("Join Mailing List");
        checkBoxes[0].setSelected(true);
        checkBoxes[1].setText("Accept Terms");
        checkBoxes[1].setSelected(false);
        checkBoxes[1].setAllowIndeterminate(true);

        checkBoxes[0].setOnAction(e->{System.out.println(checkBoxes[0].isSelected());});
        checkBoxes[1].setOnAction(e->{ System.out.println(checkBoxes[1].isSelected()+ ", "+ checkBoxes[1].isIndeterminate());});

        grid.add(checkBoxes[0],1,4);
        GridPane.setHalignment(checkBoxes[0],HPos.LEFT);
        GridPane.setValignment(checkBoxes[0],VPos.CENTER);

        grid.add(checkBoxes[1],1,5);
        GridPane.setHalignment(checkBoxes[1],HPos.LEFT);
        GridPane.setValignment(checkBoxes[1],VPos.CENTER);

        btn1 = new Button("Submit");
        btn2 = new Button("Exit");
        btn1.setOnAction(e->{
            System.out.println("Username: "+txtuser.getText());
            System.out.println("Password:"+ txtpass.getText());
            if(radio1.isSelected())
                System.out.println("The gender is: male");
            else
                System.out.println("The gender is: female");
            System.out.println("The preferred language to learn is "+language.getValue());
            System.out.println("The date of birth is: "+ datePicker.getValue());
        });
        btn2.setOnAction(e->{Platform.exit();});
        HBox pane = new HBox();
        pane.getChildren().addAll(btn1,btn2);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
        grid.add(pane,0,6);
        GridPane.setColumnSpan(pane, 2);
        GridPane.setHalignment(pane, HPos.CENTER);
        GridPane.setValignment(pane, VPos.CENTER);

        radio1 = new RadioButton("Male");
        radio2 = new RadioButton("Female");
        toggleGroup = new ToggleGroup();
        radio1.setToggleGroup(toggleGroup);
        radio2.setToggleGroup(toggleGroup);
        /*radio1.setOnAction(e->{System.out.println("The gender is: "+ radio1.getText());});
        radio2.setOnAction(e->{System.out.println("The gender is: "+ radio2.getText());});*/
        grid.add(radio1,1,4);
        grid.add(radio2,1,5);
        GridPane.setHalignment(radio1, HPos.CENTER);
        GridPane.setValignment(radio1,VPos.CENTER);
        GridPane.setHalignment(radio2, HPos.CENTER);
        GridPane.setValignment(radio2,VPos.CENTER);


        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.setHeight(250);
        stage.setWidth(450);
        stage.setTitle("CHECK BOXES");

        stage.show();

    }



    public static void main(String[] args){
        launch(args);
    }
}
