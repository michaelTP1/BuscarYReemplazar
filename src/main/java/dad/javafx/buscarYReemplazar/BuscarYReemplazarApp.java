package dad.javafx.buscarYReemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazarApp extends Application {


	private TextField searchText, replaceText;
	private Button searchButton, replaceButton, replaceAllButton, closeButton, helpButton;
	private CheckBox caseCheck, searchBackCheck, regExpCheck, stickOutCheck;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		

		
		searchText = new TextField();
		replaceText = new TextField();
		
		searchButton = new Button("Buscar");
		searchButton.setMaxWidth(Double.MAX_VALUE);
		searchButton.setDefaultButton(true);
		
		replaceButton = new Button("Reemplazar");
		replaceButton.setMaxWidth(Double.MAX_VALUE);
		replaceAllButton = new Button("Reemplazar todo");
		replaceAllButton.setMaxWidth(Double.MAX_VALUE);
		closeButton = new Button("Cerrar");
		closeButton.setMaxWidth(Double.MAX_VALUE);
		helpButton = new Button("Ayuda");
		helpButton.setMaxWidth(Double.MAX_VALUE);
		
		caseCheck = new CheckBox("Mayúsculas  y minúsculas");
		searchBackCheck = new  CheckBox("Buscar hacia atrás");
		regExpCheck = new CheckBox("Expresión regular");
		stickOutCheck = new CheckBox("Resaltar resultados");
		
		
		GridPane searchGrid = new GridPane();
		searchGrid.addRow(0, new Label("Buscar:"), searchText);
		searchGrid.addRow(1, new Label("Reemplazar con:"), replaceText);
		
		GridPane checkGrid = new GridPane();
		checkGrid.addRow(0, caseCheck, searchBackCheck);
		checkGrid.addRow(1, regExpCheck, stickOutCheck);
		checkGrid.setHgap(5);
		checkGrid.setVgap(5);
		
		searchGrid.setHgap(5);
		searchGrid.setVgap(5);
		
		searchGrid.add(checkGrid, 1, 2);
		
		ColumnConstraints[] cols = {
			
				new ColumnConstraints(),
				new ColumnConstraints()
		};
		
		cols[1].setFillWidth(true);
		cols[1].setHgrow(Priority.ALWAYS);
		searchGrid.getColumnConstraints().addAll(cols);
		
		VBox buttonBox = new VBox(5, searchButton, replaceButton, replaceAllButton, closeButton, helpButton);
		
		BorderPane root = new BorderPane();
		root.setCenter(searchGrid);
		root.setRight(buttonBox);
		root.setPadding(new Insets(5, 5, 5, 5));
		BorderPane.setMargin(searchGrid, new Insets(0,15,0,0));
		BorderPane.setAlignment(buttonBox, Pos.CENTER);
		
		Scene scene = new Scene(root, 500, 180);
		
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}


	public static void main(String[] args) {
		launch(args);

	}

}
