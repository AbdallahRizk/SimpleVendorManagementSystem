/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendor.management.system;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author abdallahrizk
 */








public class VendorManagementSystem extends Application {
    
    ControlsImplementation controls = new ControlsImplementation();
    DBImplementation db = new DBImplementation();
    
    @Override
    public void start(Stage primaryStage) {
       
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////    
             ////////////////////////////////////////// Main Pane ///////////////////////////////////////    
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////    
          VBox main_pane = new VBox(15);
          main_pane.setPadding(new Insets(10,10,10,10));

          Button addItem_mainPane = new Button("Add Products");
          addItem_mainPane.setPrefWidth(120);
          Button sellItem_mainPane = new Button("Sales");
          sellItem_mainPane.setPrefWidth(120);
          Button addJuice_mainPane = new Button("Add Juice");
          addJuice_mainPane.setPrefWidth(120);
          Button itemList_mainPane = new Button("Items list");
          itemList_mainPane.setPrefWidth(120);
          Button discount_mainPane = new Button("Discount");
          discount_mainPane.setPrefWidth(120);
          Button report_mainPane = new Button("Report");
          report_mainPane.setPrefWidth(120);
          
          main_pane.getChildren().addAll(addItem_mainPane,addJuice_mainPane,sellItem_mainPane,itemList_mainPane,discount_mainPane,report_mainPane);
          main_pane.setAlignment(Pos.CENTER);
          
        Scene scene = new Scene(main_pane);
        
        primaryStage.setHeight(500);
        primaryStage.setWidth(850);
        primaryStage.setTitle("Vendor Managment System");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////    
             ////////////////////////////////////////// Add Item ///////////////////////////////////////    
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
            BorderPane addItemPane = new BorderPane();
            Scene addItemScene = new Scene(addItemPane);
          
            
            
            TextField orderNumber_textField = new TextField(); // the order number unique code to be saved to the database
            orderNumber_textField.setPrefWidth(170);
            TextField quantity_textField = new TextField(); // how many items to be added to the database vendor management system
            quantity_textField.setPrefWidth(170);
            TextField additionQunatity_textField = new TextField(); // Addition quantity gifts from the company
            additionQunatity_textField.setPrefWidth(170);
            
            TextField vendorDescribition_textField = new TextField(); // the vendor describtion from the company
            vendorDescribition_textField.setPrefWidth(170);
            TextField customerDescribition_textField = new TextField(); // describition the willbe be display for customers
            customerDescribition_textField.setPrefWidth(170);
            
            DatePicker expirationDate_dataPicker = new DatePicker(); // the expire date
            expirationDate_dataPicker.setPrefWidth(170);
            DatePicker expireDateWorning_datePicker = new DatePicker(); // worning to notify the admin about near items going to be expire
            expireDateWorning_datePicker.setPrefWidth(170);
            
            TextField quantityWorning_textField = new TextField(); // worning level to notify for the admin to purchase
            quantityWorning_textField.setPrefWidth(170);
            
            TextField orginalPice_textField = new TextField(); // the actual cost from the company
            orginalPice_textField.setPrefWidth(170);
            TextField additionCost = new TextField(); // addition costs delivery and ...etc
            additionCost.setPrefWidth(170);
            TextField tax_textField = new TextField();
            tax_textField.setPromptText("Tax Per Unit");
            tax_textField.setPrefWidth(170);
            TextField azaka_textField = new TextField();
            azaka_textField.setPromptText("Zaka per unit");
            azaka_textField.setPrefWidth(170);
            
            TextField width_textField = new TextField(); // width to size the item
            width_textField.setPrefWidth(84);
            TextField height_textField = new TextField(); // height to size the item
            height_textField.setPrefWidth(84);
            
            HBox sizePane = new HBox(5);
            sizePane.getChildren().addAll(width_textField, height_textField);
            
            TextField shelf_textField = new TextField(); // shelf for the location
            shelf_textField.setPromptText("Shelf");
            TextField block_textField = new TextField(); // block for the location
            block_textField.setPromptText("Block");
            TextField warehouse_textField = new TextField(); // warehouse for the location
            warehouse_textField.setPromptText("Warehouse");
            shelf_textField.setPrefWidth(56);
            block_textField.setPrefWidth(56);
            warehouse_textField.setPrefWidth(56);
            
            HBox locationPane = new HBox(5);
            locationPane.getChildren().addAll(shelf_textField, block_textField, warehouse_textField);

            TextField sellingPrice_textField = new TextField(); // To input what the price to be sold for customers
            sellingPrice_textField.setPrefWidth(170);
            
            ComboBox type_comboBox = new ComboBox();
            type_comboBox.setPromptText("Choose From Below");
            type_comboBox.getItems().addAll(
                    "Per KG",
                    "Per Item"
            );
            type_comboBox.setPrefWidth(170);
            
            orderNumber_textField.setPromptText("Barcode");
            type_comboBox.setPromptText("Choose From Below");
            quantity_textField.setPromptText("Quantity");
            vendorDescribition_textField.setPromptText("Vendor Title");
            customerDescribition_textField.setPromptText("Customer Title");
            expirationDate_dataPicker.setPromptText("Expiration Date");
            expireDateWorning_datePicker.setPromptText("Expiration Notification");
            quantityWorning_textField.setPromptText("Minimum Quantity");
            additionQunatity_textField.setPromptText("Free Quantity");
            orginalPice_textField.setPromptText("Product Cost");
            additionCost.setPromptText("Addition Cost");
            height_textField.setPromptText("Size Vertically");
            width_textField.setPromptText("Size Horizontally");
            shelf_textField.setPromptText("Shelf");
            block_textField.setPromptText("Block");
            warehouse_textField.setPromptText("Warehouse");
            sellingPrice_textField.setPromptText("Price");
            
            TextArea summary_textArea = new TextArea(); // summary for confirmation that the product already been added to the database
            summary_textArea.setPrefSize(480, 130);
            summary_textArea.setEditable(false);
            GridPane rightSection_pane = new GridPane();
            rightSection_pane.setPadding(new Insets(10,10,10,10));
            rightSection_pane.setHgap(10);
            rightSection_pane.setVgap(10);
            
            rightSection_pane.add(new Label("Bar Code: "), 0, 0);
            rightSection_pane.add(orderNumber_textField, 1, 0);

            rightSection_pane.add(new Label("Type: "), 0, 1);
            rightSection_pane.add(type_comboBox, 1, 1); 
            
            rightSection_pane.add(new Label("Quantity: "), 0, 2);
            rightSection_pane.add(quantity_textField, 1, 2);
            
            rightSection_pane.add(new Label("Vendor Title: "), 0, 3);
            rightSection_pane.add(vendorDescribition_textField, 1, 3);
            
            rightSection_pane.add(new Label("Customer Title: "), 0, 4);
            rightSection_pane.add(customerDescribition_textField, 1, 4);
            
            rightSection_pane.add(new Label("Expiration Date: "), 0, 5);
            rightSection_pane.add(expirationDate_dataPicker, 1, 5);
            
            rightSection_pane.add(new Label("Notify Before Expiration: "), 0, 6);
            rightSection_pane.add(expireDateWorning_datePicker, 1, 6);
            
            rightSection_pane.add(new Label("Tax: "), 0, 7);
            rightSection_pane.add(tax_textField, 1, 7);
            
            GridPane leftSection_pane = new GridPane();
            leftSection_pane.setPadding(new Insets(10,10,10,10));
            leftSection_pane.setHgap(10);
            leftSection_pane.setVgap(10);
            
            
            leftSection_pane.add(new Label("Minimum Quantity: "), 0, 0);
            leftSection_pane.add(quantityWorning_textField, 1, 0);

            leftSection_pane.add(new Label("Addition Items: "), 0, 1);
            leftSection_pane.add(additionQunatity_textField, 1, 1); 
            
            leftSection_pane.add(new Label("Orginal Cost: "), 0, 2);
            leftSection_pane.add(orginalPice_textField, 1, 2);
            
            leftSection_pane.add(new Label("Addition Costs: "), 0, 3);
            leftSection_pane.add(additionCost, 1, 3);
            
            leftSection_pane.add(new Label("Size: "), 0, 4);
            leftSection_pane.add(sizePane, 1, 4);
           
            leftSection_pane.add(new Label("Location: "), 0, 5);
            leftSection_pane.add(locationPane, 1, 5);
            
            leftSection_pane.add(new Label("Selling Price: "), 0, 6);
            leftSection_pane.add(sellingPrice_textField, 1, 6);
            
            leftSection_pane.add(new Label("Zaka: "), 0, 7);
            leftSection_pane.add(azaka_textField, 1, 7);
            
            Button confirmation_button = new Button("Confirm");
            Button cancelation_button = new Button("Cancel");
            
            HBox bottomPane = new HBox(10);
            bottomPane.setPadding(new Insets(10,10,10,10));
            
            bottomPane.getChildren().addAll(confirmation_button, cancelation_button, summary_textArea);
            
            
            
            addItemPane.setRight(leftSection_pane);
            addItemPane.setLeft(rightSection_pane);
            addItemPane.setBottom(bottomPane);
            
            addItem_mainPane.setOnAction(e->controls.addItem_mainPane(primaryStage, addItemScene));
            cancelation_button.setOnAction(e->controls.cancelationButton(primaryStage, scene));
            confirmation_button.setOnAction(e->{
              try {
                  controls.addProducts(orderNumber_textField, summary_textArea, type_comboBox,quantity_textField, vendorDescribition_textField, customerDescribition_textField, expirationDate_dataPicker, expireDateWorning_datePicker, quantityWorning_textField, additionQunatity_textField, orginalPice_textField, additionCost, height_textField, width_textField, shelf_textField, block_textField, warehouse_textField, sellingPrice_textField, tax_textField, azaka_textField);
              } catch (ClassNotFoundException | SQLException | ParseException ex) {
                  Logger.getLogger(VendorManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
              }
          });
        
         
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////    
             ////////////////////////////////////////// Add Juice ///////////////////////////////////////    
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
      
      TextField juiceName = new TextField();
      Button addCompo_button = new Button("Add Component");
      VBox addJuiceTop_pane = new VBox(5);
      addJuiceTop_pane.setPadding(new Insets(10,10,10,10));
      
      addJuiceTop_pane.getChildren().addAll(new Label("Name"), juiceName, addCompo_button );

      Button calculate_button = new Button("Calculate");
      Label totalWeight = new Label("Total Weight"); // This is just to demonstrate the GUI
      Label totalOrginCost = new Label("Total Cost"); // This is just to demonstrate the GUI
      TextField sellingPrice = new TextField();
      TextField totalWeight_textField = new TextField();
      TextField totalOrginCost_TextField = new TextField();
      sellingPrice.setPrefWidth(90);
      totalWeight_textField.setPrefWidth(90);
      totalOrginCost_TextField.setPrefWidth(90);


      
      HBox juiceCalculationBar_Hbox = new HBox(7);
      juiceCalculationBar_Hbox.getChildren().addAll(calculate_button, totalWeight,totalWeight_textField, totalOrginCost,totalOrginCost_TextField, new Label("Sell Cost"), sellingPrice);
      
      Button addJuice_button = new Button("Add Juice");
      Button addJuiceCancel_button = new Button("Cancel");
      
      HBox juiceConfirmBar_Hbox = new HBox(7);
      juiceConfirmBar_Hbox.getChildren().addAll(addJuice_button,addJuiceCancel_button);
      
      VBox addJuiceButtom_pane = new VBox(5);
      addJuiceButtom_pane.getChildren().addAll(juiceCalculationBar_Hbox, juiceConfirmBar_Hbox);
      
      
       
      addCompo_button.setOnAction(e->{
    
          Label nameAddJuice_Label = new Label("Name ");
          TextField nameOfItem_textFiled = new TextField(); // To check if it's better to be a combobox later
          nameOfItem_textFiled.setPrefWidth(120);
          Label weight_label = new Label("Weight");
          TextField weight_textFiled = new TextField();
          weight_textFiled.setPrefWidth(90);
          Label cost_label = new Label("Cost");
          TextField cost_textField = new TextField();
          cost_textField.setPrefWidth(90); // It will calculate the price based on the actualprice from the database

          
          HBox juice_hbox = new HBox(7);
          juice_hbox.getChildren().addAll(nameAddJuice_Label,nameOfItem_textFiled,weight_label,weight_textFiled,cost_label,cost_textField);
          addJuiceTop_pane.getChildren().add(juice_hbox);
    });
            
          BorderPane addJuice_pane = new BorderPane();
          addJuice_pane.setPadding(new Insets(10,10,10,10));
          addJuice_pane.setTop(addJuiceTop_pane);
          addJuice_pane.setBottom(addJuiceButtom_pane);
          Scene addJuice_Scene = new Scene(addJuice_pane);
          
          
          addJuiceCancel_button.setOnAction(e->{
            
                primaryStage.setTitle("Vendor Managment System");
                primaryStage.setScene(scene);
                primaryStage.show();
            
            });

      
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////    
             ////////////////////////////////////////// Sales ///////////////////////////////////////    
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////

      ComboBox chooseItem_sales = new ComboBox();
      chooseItem_sales.setPrefWidth(170);
      chooseItem_sales.setPromptText("Choose From Below");
      TextField barCode_sales = new TextField(); // From Database
      barCode_sales.setPrefWidth(170);
      barCode_sales.setEditable(false);
      barCode_sales.setPromptText("Barcode");
      TextField vendorDescripition = new TextField(); // From Database
      vendorDescripition.setPrefWidth(170);
      vendorDescripition.setEditable(false);
      vendorDescripition.setPromptText("Vendor Description");
      TextField expireDate_sales = new TextField(); // From Database
      expireDate_sales.setPrefWidth(170);
      expireDate_sales.setEditable(false);
      expireDate_sales.setPromptText("Expiration Date");
      TextField quantity_sales = new TextField(); // From Database
      quantity_sales.setPrefWidth(170);
      quantity_sales.setEditable(false);
      quantity_sales.setPromptText("Remain Quantity");
      TextField discount_sales = new TextField();
      discount_sales.setPrefWidth(170);
      discount_sales.setPromptText("Place Discount");
      TextField numberTOSell = new TextField();
      numberTOSell.setPrefWidth(170);
      numberTOSell.setPromptText("Quantity to sell");
      TextField price_sales = new TextField();
      price_sales.setPrefWidth(170);
      price_sales.setEditable(false);
      price_sales.setPromptText("One unit price");
      ComboBox methodOfPayment = new ComboBox();
      methodOfPayment.setPrefWidth(170);
      methodOfPayment.setPromptText("Choose From Below");
      DatePicker purchasedDate = new DatePicker();
      purchasedDate.setPrefWidth(170);
      purchasedDate.setPromptText("Sold Date");
      TextField taxSales_testField = new TextField();
      taxSales_testField.setPrefWidth(170);
      taxSales_testField.setPromptText("Tax per Unit");
      TextField zakaSales_testField = new TextField();
      zakaSales_testField.setPrefWidth(170);
      zakaSales_testField.setPromptText("Zaka per Unit");
      
      methodOfPayment.getItems().addAll(
                    "Cash",
                    "MasterCard",
                    "Visa"
            );

      
      TextArea summary_sales = new TextArea();
      summary_sales.setPrefSize(480, 130);
      summary_sales.setEditable(false);
      
      Button sellSales_button = new Button("Sell");
      Button cancelSale_button = new Button("Cancel");
      
      HBox confirmBarSales_hbox = new HBox(7);
      confirmBarSales_hbox.getChildren().addAll(sellSales_button, cancelSale_button, summary_sales);
      
      
      GridPane salesLeft_gridPane = new GridPane();
      salesLeft_gridPane.setPadding(new Insets(10,10,10,10));
      salesLeft_gridPane.setHgap(10);
      salesLeft_gridPane.setVgap(10);
      
      salesLeft_gridPane.add(new Label("Choose Item"), 0, 0);
      salesLeft_gridPane.add(chooseItem_sales, 1, 0);
      salesLeft_gridPane.add(new Label("Bar Code"), 0, 1);
      salesLeft_gridPane.add(barCode_sales, 1, 1);
      salesLeft_gridPane.add(new Label("Product Description"), 0, 2);
      salesLeft_gridPane.add(vendorDescripition, 1, 2);
      salesLeft_gridPane.add(new Label("Expiration Date"), 0, 3);
      salesLeft_gridPane.add(expireDate_sales, 1, 3);
      salesLeft_gridPane.add(new Label("Quantity"), 0, 4);
      salesLeft_gridPane.add(quantity_sales, 1, 4);
      salesLeft_gridPane.add(new Label("Tax"), 0, 5);
      salesLeft_gridPane.add(taxSales_testField, 1, 5);
      
      
      GridPane salesRight_gridPane = new GridPane();
      salesRight_gridPane.setPadding(new Insets(10,10,10,10));
      salesRight_gridPane.setHgap(10);
      salesRight_gridPane.setVgap(10);
      
      salesRight_gridPane.add(new Label("Zaka"), 0, 0);
      salesRight_gridPane.add(zakaSales_testField, 1, 0);
      salesRight_gridPane.add(new Label("Discount(%)"), 0, 1);
      salesRight_gridPane.add(discount_sales, 1, 1);
      salesRight_gridPane.add(new Label("Price"), 0, 2);
      salesRight_gridPane.add(price_sales, 1, 2);
      salesRight_gridPane.add(new Label("Quantity to sell"), 0, 3);
      salesRight_gridPane.add(numberTOSell, 1, 3);
      salesRight_gridPane.add(new Label("Method of Payment"), 0, 4);
      salesRight_gridPane.add(methodOfPayment, 1, 4);
      salesRight_gridPane.add(new Label("Sold Date"), 0, 5);
      salesRight_gridPane.add(purchasedDate, 1, 5);
      
      
      
      BorderPane salesPane = new BorderPane();
      salesPane.setPadding(new Insets(10,10,10,10));
      
      salesPane.setLeft(salesLeft_gridPane);
      salesPane.setRight(salesRight_gridPane);
      salesPane.setBottom(confirmBarSales_hbox);
      
      
      Scene salesScene = new Scene(salesPane);
     
      cancelSale_button.setOnAction(e->controls.addItem_mainPane(primaryStage, scene));
      
      chooseItem_sales.setOnAction(e->{         
              try {
                  controls.salesInfo(chooseItem_sales.getSelectionModel().getSelectedItem().toString(), barCode_sales, expireDate_sales, quantity_sales, price_sales, discount_sales, vendorDescripition, taxSales_testField, zakaSales_testField);
              } catch (ClassNotFoundException | SQLException ex) {
                  Logger.getLogger(VendorManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
              }
               
          });
      
      sellItem_mainPane.setOnAction(e->{            
              try {
                  controls.sellItem_mainPane(primaryStage, salesScene, chooseItem_sales);
              } catch (ClassNotFoundException | SQLException ex) {
                  Logger.getLogger(VendorManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
              }
       
          });
      
      sellSales_button.setOnAction(e->{
              try {
                  controls.sellConfirmtion(summary_sales, chooseItem_sales, vendorDescripition, expireDate_sales, quantity_sales, discount_sales, price_sales, numberTOSell, methodOfPayment, purchasedDate, taxSales_testField, zakaSales_testField);
              } catch (ClassNotFoundException | SQLException ex) {
                  Logger.getLogger(VendorManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
              }
          });
      
      
      
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////    
             ////////////////////////////////////////// ItemList ///////////////////////////////////////    
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      BorderPane itemList_pane = new BorderPane();
      itemList_pane.setPadding(new Insets(10,10,10,10));
      
      
      TableView dataTable = new TableView();
      dataTable.setPrefSize(650, 30);
      ListView specifyTable = new ListView();
      specifyTable.setPrefSize(150, 30);
      specifyTable.getItems().addAll(
              "All",
              "Quantity Warning",
              "Expiration Warning",
              "Expired",
              "History"
      );
      CheckBox quatityHighlight = new CheckBox("HighLight Quantity");
      CheckBox expirationHighlight = new CheckBox("HighLight Expiraion");
      Button cancel_itemList = new Button("cancel");
      HBox bottomBar = new HBox(40);
      bottomBar.setPadding(new Insets(10,10,10,10));
      bottomBar.getChildren().addAll(cancel_itemList,quatityHighlight, expirationHighlight);
      
      itemList_pane.setLeft(specifyTable);
      itemList_pane.setRight(dataTable);
      itemList_pane.setBottom(bottomBar);
      
      Scene itemList_scene = new Scene(itemList_pane);
      
      itemList_mainPane.setOnAction(e->controls.itemList_mainPane(primaryStage, itemList_scene));
        
             
        
      
      
      
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////    
             ////////////////////////////////////////// ItemList ///////////////////////////////////////    
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////
      addJuice_mainPane.setOnAction(e->{
        
                primaryStage.setTitle("Add New Juice");
                primaryStage.setScene(addJuice_Scene);
                primaryStage.show();
        
        });
      
      cancel_itemList.setOnAction(e->{
        
                primaryStage.setTitle("Vendor Management System");
                primaryStage.setScene(scene);
                primaryStage.show();
        
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
