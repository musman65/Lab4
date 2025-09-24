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
        Label title = new Label("Declare all expenses, leave empty if 0:");
        
        Label days = new Label("Number of days on the trip:");
        Label airefare = new Label("Airfare:");
        Label car = new Label("Amount for car rental fees:");
        Label milesDriven = new Label("Miles driven, if a private vehicle was used:");
        Label parkingFees = new Label("Parking fees:");
        Label taxiCharges = new Label("Taxi charges:");
        Label conOrSem = new Label("Conference or seminar registration fees:");
        Label lod = new Label("Lodging charges per night:");
        Label error = new Label("");
        
        Label l1 = new Label("");
        Label l2 = new Label("");
        Label l3 = new Label("");
        
        Label[] labels = {l1, l2, l3};
        
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
        
        
        l1.setId("info");
        l2.setId("info");
        l3.setId("info");
        error.setId("error");
        title.setId("title");
        
        for (int i = 0; i < texts.length; i++) {
            texts[i].setOnKeyReleased(event ->{
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
            int sum = 0;
            int reinburse = 0;
            String message = " cannot contain a letter, a space, or any sort of special character!";
            //Input checks
            if (isNotValid(daysT.getText())) {
                error.setText("Days" + message);
                removeAllText(labels);
                return;
            }
            if (isNotValid(airT.getText())) {
                error.setText("Airfare" + message);
                removeAllText(labels);
                return;
            }
            if (isNotValid(carT.getText())) {
                error.setText("Car rental" + message);
                removeAllText(labels);
                return;
            }
            if (isNotValid(milesT.getText())) {
                error.setText("Miles cannot" + message);
                removeAllText(labels);
                return;
            }
            if (isNotValid(parkT.getText())) {
                error.setText("Parking fees" + message);
                removeAllText(labels);
                return;
            }
            if (isNotValid(taxiT.getText())) {
                error.setText("Taxi charges" + message);
                removeAllText(labels);
                return;
            }
            if (isNotValid(conT.getText())) {
                error.setText("Conferenc or seminar fees" + message);
                removeAllText(labels);
                return;
            }
            if (isNotValid(lodT.getText())) {
                error.setText("Lodging charges" + message);
                removeAllText(labels);
                return;
            }
            
            error.setText("");
            
            sum += Integer.parseInt(airT.getText().trim());
            sum += Integer.parseInt(carT.getText().trim());
            sum += Integer.parseInt(parkT.getText().trim());
            sum += Integer.parseInt(taxiT.getText().trim());
            sum += Integer.parseInt(conT.getText().trim());
            sum += Integer.parseInt(lodT.getText().trim());
            sum += Integer.parseInt(milesT.getText().trim()) * 0.27;
            
            
            reinburse += Integer.parseInt(daysT.getText().trim()) * 37;
            reinburse += Integer.parseInt(daysT.getText().trim())* 10;
            reinburse += Integer.parseInt(daysT.getText().trim())* 20;
            reinburse += Integer.parseInt(daysT.getText().trim())* 95;
            reinburse += Integer.parseInt(milesT.getText().trim()) * 0.27;
            l1.setText("Total expenses: $" + sum + " of which $" + Integer.parseInt(milesT.getText().trim()) * 0.27 + " is for the private car.");
            l2.setText("Total expenses allowed: $" + reinburse + " of which $" + Integer.parseInt(milesT.getText().trim()) * 0.27 + " is for the private car.");
            if (sum - reinburse > 0) {
             l3.setText("You must pay the excess which is: $" + (sum - reinburse) + ".");   
            } else {
                l3.setText("You saved: $" + (reinburse - sum)+ ".");
            }
            
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
        gp.add(error,       0, 9);
        gp.add(l1,          0, 10);
        gp.add(l2,          0, 11);
        gp.add(l3,          0, 12);
        
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
        
        HBox hb = new HBox(10, clear, enter);
        hb.setPadding(new Insets(10));
        
        HBox hb2 = new HBox(title);
        hb2.setPadding(new Insets(10));
        
        VBox vb = new VBox(10, hb2, gp, hb);
        
        Scene sc = new Scene(vb, 800, 600);
        sc.getStylesheets().add("styles.css");
        stage.setScene(sc);
        stage.show();
    }
    
    public static void removeAllText(Label[] labels) {
        for (Label label : labels) {
            label.setText("");
        }
    }
    
    public static boolean isNotValid(String text) {
        try {
            int num = Integer.parseInt(text);
        } catch(Exception e) {
            return true;
        }
        return Integer.parseInt(text) < 0;

    }
}
