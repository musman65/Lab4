//https://github.com/musman65/Lab4

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 6298674
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Travel Expenses");
        GridPane gp = new GridPane();
        Label title = new Label("Declare all expenses, leave empty if 0");
        
        Label days = new Label("Number of days on the trip:");
        Label airefare = new Label("Airfare:");
        Label car = new Label("Amount for car rental fees:");
        Label milesDriven = new Label("Miles driven, if a private vehicle was used:");
        Label parkingFees = new Label("Parking fees:");
        Label taxiCharges = new Label("Taxi charges:");
        Label conOrSem = new Label("Conference or seminar registration fees:");
        Label lod = new Label("Lodging charges per night:");
        
        TextField daysT = new TextField();
        TextField airT = new TextField();
        TextField carT = new TextField();
        TextField milesT = new TextField();
        TextField parkT = new TextField();
        TextField taxiT = new TextField();
        TextField conT = new TextField();
        TextField lodT = new TextField();
        TextField[] texts = {daysT, airT, carT, milesT, parkT, taxiT, conT, lodT};
        
        Button enter = new Button("Enter");
        Button clear = new Button("Clear");
        enter.setDisable(true);
        
        for (int i = 0; i < texts.length; i++) {
            texts[i].setOnKeyPressed(event ->{
               if (!(daysT.getText().equals("")) && !(airT.getText().equals("")) && !(carT.getText().equals("")) && !(milesT.getText().equals(""))) {
                    if (!(parkT.getText().equals("")) && !(taxiT.getText().equals("")) && !(conT.getText().equals("")) && !(lodT.getText().equals(""))) {
                        enter.setDisable(false);
                    }
                } 
            });
        }
        
        clear.setOnMouseClicked(event -> {
            for (int i = 0; i < texts.length; i++) {
                texts[i].clear();
            }
            enter.setDisable(true);
        });
        
        enter.setOnMouseClicked(event ->{
            
        });
        
        gp.add(title,       0, 0);
        gp.add(days,        0, 1);
        gp.add(airefare,    0, 2);
        gp.add(car,         0, 3);
        gp.add(milesDriven, 0, 4);
        gp.add(parkingFees, 0, 5);
        gp.add(taxiCharges, 0, 6);
        gp.add(conOrSem,    0, 7);
        gp.add(lod,         0, 8);
        
        gp.add(daysT,       1, 1);
        gp.add(airT,        1, 2);
        gp.add(carT,        1, 3);
        gp.add(milesT,      1, 4);
        gp.add(parkT,       1, 5);
        gp.add(taxiT,       1, 6);
        gp.add(conT,        1, 7);
        gp.add(lodT,        1, 8);
        
        gp.setVgap(10);
        gp.setHgap(50);
        gp.setPadding(new Insets(10));
        
        HBox hb = new HBox(10, enter, clear);
        hb.setPadding(new Insets(10));
        
        HBox hb2 = new HBox(title);
        hb2.setPadding(new Insets(10));
        
        VBox vb = new VBox(10, hb2, gp, hb);
        
        Scene sc = new Scene(vb, 800, 500);
        stage.setScene(sc);
        stage.show();
    }
    
}
