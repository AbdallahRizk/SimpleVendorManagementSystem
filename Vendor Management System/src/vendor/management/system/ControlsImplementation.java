/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendor.management.system;

import static java.lang.Math.abs;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author abdallahrizk
 */
public class ControlsImplementation {
    
    DBImplementation db = new DBImplementation();
    
     
    public void cancelationButton(Stage primaryStage, Scene scene){
        
                primaryStage.setTitle("Vendor Managment System");
                primaryStage.setScene(scene);
                primaryStage.show();
                
    }
    
    // The following method for the add products scene
    public void addProducts(TextField barcode_textField,TextArea summary, ComboBox type_comboBox,TextField quantity_textField,TextField Vdescription_textField,TextField Cdescription_textField,DatePicker expireDate_datePicker,DatePicker NBexpireDate_datePicker,TextField Mquantity_textField,TextField AdditionItem_textField, TextField Ocost_textField, TextField AdditionCost_textField, TextField SizeH_textField, TextField SizeW_textField, TextField Lshelf_textField, TextField Lblock_textField, TextField Lwarehouse_textField, TextField sellsPrice_textField, TextField tax_textField, TextField zaka_textField) throws ClassNotFoundException , SQLException, ParseException{
    
       
            if(barcode_textField.getText() == null || barcode_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Barcode");
            }   
            
            else if(type_comboBox.getValue() == null){
                 summary.setText("Error\nPlease choose the type");
            }   
        
            else if(quantity_textField.getText() == null || quantity_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Quantity");
            }
            
            else if(Vdescription_textField.getText() == null || Vdescription_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Vendor Description");
            }
            
            else if(Cdescription_textField.getText() == null || Cdescription_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Customer Description");
            }
            
            else if(expireDate_datePicker.getValue() == null){
                 summary.setText("Error\nPlease Specify the Expiration Date");
            }
            
            else if(NBexpireDate_datePicker.getValue() == null){
                 summary.setText("Error\nPlease Specify the Worning Expiration Date");
            }
            
            else if(Mquantity_textField.getText() == null || Mquantity_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Minumum Quantity");
            }
            
                        else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty() && AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");
                 AdditionCost_textField.setText("0");

            }
            
            else if(AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty() && tax_textField.getText() == null || tax_textField.getText().trim().isEmpty()){
                AdditionCost_textField.setText("0");
                tax_textField.setText("0");

            }
            
            else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty() && tax_textField.getText() == null || tax_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");
                 tax_textField.setText("0");
            }
            
            else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty() && zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");
                 zaka_textField.setText("0");
            }
            
            else if(AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty() && zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                AdditionCost_textField.setText("0"); 
                zaka_textField.setText("0");

            }
            
            else if(tax_textField.getText() == null || tax_textField.getText().trim().isEmpty() && zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                tax_textField.setText("0"); 
                zaka_textField.setText("0");

            }
            
            else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty() && AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty() && tax_textField.getText() == null || tax_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");
                 AdditionCost_textField.setText("0");
                 tax_textField.setText("0");
            }
                    
            else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty() && AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty() && zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");
                 AdditionCost_textField.setText("0");
                 zaka_textField.setText("0");
            }  

            else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty() && tax_textField.getText() == null || tax_textField.getText().trim().isEmpty() && zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");
                 tax_textField.setText("0");
                 zaka_textField.setText("0");
            }  
            
            else if(AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty() && tax_textField.getText() == null || tax_textField.getText().trim().isEmpty() && zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                 AdditionCost_textField.setText("0");
                 tax_textField.setText("0");
                 zaka_textField.setText("0");
            }  
            
            else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty() && AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty() && tax_textField.getText() == null || tax_textField.getText().trim().isEmpty() && zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");
                 AdditionCost_textField.setText("0");
                 tax_textField.setText("0");
                 zaka_textField.setText("0");
            }  
            
            else if(AdditionItem_textField.getText() == null || AdditionItem_textField.getText().trim().isEmpty()){
                 AdditionItem_textField.setText("0");

            }
            
            else if(AdditionCost_textField.getText() == null || AdditionCost_textField.getText().trim().isEmpty()){
                 AdditionCost_textField.setText("0");

            }
            
            else if(tax_textField.getText() == null || tax_textField.getText().trim().isEmpty()){
                 tax_textField.setText("0");

            }
            
            else if(zaka_textField.getText() == null || zaka_textField.getText().trim().isEmpty()){
                 zaka_textField.setText("0");

            }
            

            

            else if(Ocost_textField.getText() == null || Ocost_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Orginal Cost");
            }
            
            
            else if(SizeH_textField.getText() == null || SizeH_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Hight of the Product");
            }
            
            else if(SizeW_textField.getText() == null || SizeW_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Width of the Product");
            }
            
            else if(Lshelf_textField.getText() == null || Lshelf_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Position of the Product");
            }
            
            else if(Lblock_textField.getText() == null || Lblock_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Position of the Product");
            }
            
            else if(Lwarehouse_textField.getText() == null || Lwarehouse_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Position of the Product");
            }
            
            else if(sellsPrice_textField.getText() == null || sellsPrice_textField.getText().trim().isEmpty()){
                 summary.setText("Error\nPlease Specify the Selling Price");
            }
            
           
            
            
            
            
        try{    
        String type = type_comboBox.getSelectionModel().getSelectedItem().toString();
        int quantity = Integer.parseInt(quantity_textField.getText());
        String Vdescription = Vdescription_textField.getText();
        String Cdescription = Cdescription_textField.getText();
        String expireDate = expireDate_datePicker.getValue().toString();
        String NBexpireDate = NBexpireDate_datePicker.getValue().toString();
        int Mquantity = Integer.parseInt(Mquantity_textField.getText());
        int AdditionItem = Integer.parseInt(AdditionItem_textField.getText());
        int Ocost = Integer.parseInt(Ocost_textField.getText());
        int AdditionCost = Integer.parseInt(AdditionCost_textField.getText());
        String SizeH = SizeH_textField.getText();
        String SizeW = SizeW_textField.getText();
        String Lshelf = Lshelf_textField.getText();
        String Lblock = Lblock_textField.getText();
        String Lwarehouse = Lwarehouse_textField.getText();
        int sellsPrice = Integer.parseInt(sellsPrice_textField.getText());
        int totalCost =0;
        int totalItems=0;
        
        
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date expireDate_date = date.parse(expireDate);
            Date NexpireDate_date = date.parse(NBexpireDate);

           if(NexpireDate_date.after(expireDate_date)){
                
                summary.setText("Error\nPlease Make Sure The expiration Warning Date must be Before The Actual Expire Date.");    
            }
            
            else if(Mquantity > quantity){
                
                summary.setText("Error\nPlease Make Sure The Minumum Quantity less than the Actual Quantity.");
            
            }
       
            else{
            int fullCost = Ocost + AdditionCost + Integer.parseInt(tax_textField.getText()) + Integer.parseInt(zaka_textField.getText());
            totalCost = fullCost * quantity;
            totalItems = quantity + AdditionItem;
            int totalTax = quantity * Integer.parseInt(tax_textField.getText());
            int totalZaka = quantity * Integer.parseInt(zaka_textField.getText());
            int discount = 0;
            
            db.addProducts_insetIntoDB(barcode_textField.getText(), type, quantity, Vdescription, Cdescription, expireDate, NBexpireDate, Mquantity, AdditionItem, Ocost, AdditionCost, SizeH, SizeW, Lshelf, Lblock, Lwarehouse, sellsPrice, totalCost, totalItems, discount, Integer.parseInt(tax_textField.getText()), Integer.parseInt(zaka_textField.getText()), totalTax, totalZaka, fullCost);
            summary.setText("Summary\nTitle: " +Cdescription+"\nQuantity: "+quantity+"\nExpire Date: "+expireDate+"\nSuccessfully Saved in the Inventory  ");
          
            
            barcode_textField.setText("");
            type_comboBox.setValue(null);
            quantity_textField.setText("");
            Vdescription_textField.setText("");
            Cdescription_textField.setText("");
            expireDate_datePicker.setValue(null);
            NBexpireDate_datePicker.setValue(null);
            Mquantity_textField.setText("");
            AdditionItem_textField.setText("");
            Ocost_textField.setText("");
            AdditionCost_textField.setText("");
            SizeH_textField.setText("");
            SizeW_textField.setText("");
            Lshelf_textField.setText("");
            Lblock_textField.setText("");
            Lwarehouse_textField.setText("");
            sellsPrice_textField.setText("");
            tax_textField.setText("");
            zaka_textField.setText("");
            }
           
           }catch(NumberFormatException e){
            
            summary.setText("Error\nPlease Make sure to type in the right inputs");
        
        }
    }
    
    
    
    public void addItem_mainPane(Stage stage, Scene scene){
        
        
            stage.setTitle("Vendor Managment System");
            stage.setScene(scene);
            stage.show();
           
                
    }
    
    
    public void sellItem_mainPane(Stage stage, Scene scene, ComboBox barcode) throws ClassNotFoundException, SQLException{
        
            stage.setTitle("Sales");
            stage.setScene(scene);
            barcode.setItems(db.productsBarCode());
            stage.show();
        
        
        
           
    }
    
    // the following method for sales scene
    public void salesInfo(String special, TextField barCode, TextField expirationDate, TextField quantity, TextField price, TextField discount, TextField vendorDescripition, TextField tax, TextField zaka) throws ClassNotFoundException, SQLException{
        
        
        String[] spliter = special.split(" - ");
        String desription = spliter[0];
        String barcode = spliter[1];
        barCode.setText(db.barcode(desription , barcode));
        expirationDate.setText(db.expireDate(desription , barcode));
        quantity.setText(db.quantity(desription , barcode));
        price.setText(db.sellsPrice(desription , barcode));
        discount.setText(db.discount(desription, barcode));
        vendorDescripition.setText(db.vdiscription(desription, barcode));
        tax.setText(db.tax(desription, barcode));
        zaka.setText(db.zaka(desription, barcode));
    
    }
    
    public void sellConfirmtion(TextArea summary_textArea, ComboBox item_comboBox, TextField description_textField, TextField expirationDate_textField, TextField quantity_textField, TextField discount_textField, TextField price_textField, TextField quantitySell_textField, ComboBox methodOfPayment_comboBox, DatePicker soldDate_datePicker, TextField tax_textField, TextField zaka_textField) throws ClassNotFoundException, SQLException{
    
        String[] spliter = item_comboBox.getSelectionModel().getSelectedItem().toString().split(" - ");
        String desription = spliter[0];
        String barcode = spliter[1];
        
        if(quantitySell_textField.getText() == null || quantitySell_textField.getText().trim().isEmpty()){
                 summary_textArea.setText("Error\nPlease Specify the Quantity to be Sold");
            } 
        
        else if(methodOfPayment_comboBox.getValue() == null){
                 summary_textArea.setText("Error\nPlease Specify the Payment Method");
            }
        
        else if(soldDate_datePicker.getValue() == null){     
            soldDate_datePicker.setValue(LocalDate.now());  
        }
        
        try{
        int quantity = Integer.parseInt(quantity_textField.getText());
        int quatityToSell = Integer.parseInt(quantitySell_textField.getText());
        
        
        if(quatityToSell > quantity){     
           summary_textArea.setText("Error\nQuantity can not cover the required order");
        }
        
        
        else{
        
        int remainQuantity = abs(quantity - quatityToSell);
        int totalPrice = quatityToSell * Integer.parseInt(price_textField.getText());
        int percentageToPrice = (int)(totalPrice*(Integer.parseInt(discount_textField.getText())/100.0f));
        int totalPriceWithDiscount = abs(percentageToPrice - totalPrice);
        int totalTax = Integer.parseInt(tax_textField.getText()) * quatityToSell;
        int totalZaka = Integer.parseInt(zaka_textField.getText()) * quatityToSell;
        
        db.addSales(desription, barcode, Integer.parseInt(discount_textField.getText()), quatityToSell, Integer.parseInt(price_textField.getText()), methodOfPayment_comboBox.getSelectionModel().getSelectedItem().toString(), soldDate_datePicker.getValue().toString(), totalPrice, totalPriceWithDiscount, Integer.parseInt(tax_textField.getText()), Integer.parseInt(zaka_textField.getText()), totalTax, totalZaka);
        db.updateProduct(desription, barcode, remainQuantity);
        
        summary_textArea.setText("Summary\nTitle: "+desription+"\nSold Quantity: "+quatityToSell+"Remain Quantity: "+remainQuantity+"Total Price: "+totalPriceWithDiscount);
        
        item_comboBox.setValue(null);
        description_textField.setText("");
        expirationDate_textField.setText("");
        quantity_textField.setText("");
        discount_textField.setText("");
        price_textField.setText("");
        quantitySell_textField.setText("");
        methodOfPayment_comboBox.setValue(null);
        soldDate_datePicker.setValue(null);
          
                
        }
        
        }catch(NumberFormatException e){
            
            summary_textArea.setText("Error\nPlease Make sure to type in the right inputs");
        
        }
        
        
        
    
    
    }
    
    
    public void itemList_mainPane(Stage stage, Scene scene){
        
        
                stage.setTitle("Item List");
                stage.setScene(scene);
                stage.show();
           
                
    }
    
    
    
    
    
}
