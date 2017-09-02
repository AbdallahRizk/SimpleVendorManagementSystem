/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendor.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DBImplementation {
    

    
            Connection conn =null;
            String dbuser = "root";
            String dbpassw = "0557724289";
            String databasename = "DrAbdalNassirInventory";
            String url = "jdbc:mysql://127.0.0.1:3306/DrAbdalNassirInventory";
            String driver = "com.mysql.jdbc.Driver";
            PreparedStatement ps;
            
            
            public void addProducts_insetIntoDB(String barcode,String type,int quantity,String Vdescription,String Cdescription,String expireDate,String NBexpireDate,int Mquantity,int AdditionItem, int Ocost, int AdditionCost, String SizeH, String SizeW, String Lshelf, String Lblock, String Lwarehouse, int sellsPrice, int totalCost, int totalItems, int discount, int tax, int zaka, int totalTax, int totalZaka, int fullCost) throws ClassNotFoundException, SQLException{

         Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            Statement st = conn.createStatement();
            
            ps = conn.prepareStatement("insert into products(barcode,type,quantity,Vdescription,Cdescription,expireDate,NBexpireDate,Mquantity,AdditionItem,Ocost,AdditionCost,SizeH,SizeW,Lshelf,Lblock,Lwarehouse,sellsPrice,totalCost,totaltems,discount,tax,zaka,totalTax,totalZaka,fullCost)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
           ps.setString(1, barcode);
           ps.setString(2, type);
           ps.setInt(3, quantity);
           ps.setString(4, Vdescription);
           ps.setString(5, Cdescription);
           ps.setString(6, expireDate);
           ps.setString(7, NBexpireDate);
           ps.setInt(8, Mquantity);
           ps.setInt(9, AdditionItem);
           ps.setInt(10, Ocost);
           ps.setInt(11, AdditionCost);
           ps.setString(12, SizeH);
           ps.setString(13, SizeW);
           ps.setString(14, Lshelf);
           ps.setString(15, Lblock);
           ps.setString(16, Lwarehouse);
           ps.setInt(17, sellsPrice);
           ps.setInt(18, totalCost);
           ps.setInt(19, totalItems);
           ps.setInt(20, discount);
           ps.setInt(21, tax);
           ps.setInt(22, zaka);
           ps.setInt(23, totalTax);
           ps.setInt(24, totalZaka);
           ps.setInt(25, fullCost);




           ps.executeUpdate();
           
           conn.close();
           
    }
            


            
            public ObservableList productsBarCode() throws ClassNotFoundException, SQLException{
        
                 ObservableList<String>  barcodeList_list = FXCollections.observableArrayList();
        
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT Cdescription , barcode FROM products");
            
            while(rs.next()){
            barcodeList_list.add(rs.getString("Cdescription" ) +" - "+rs.getString("barcode"));                                      
        }
            
            
         conn.close();

            
          return barcodeList_list;  
          

    }
            
            
     public String barcode(String item, String bacode) throws ClassNotFoundException, SQLException{
         
         String barcode="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT barcode FROM products where Cdescription = '"+item+"' and barcode = '"+bacode+"'");
            
            while(rs.next()){
            barcode = rs.getString("barcode");                                    
        }
                conn.close();

          return barcode; 
         
     
     }    
     
     public String expireDate(String item, String barcode) throws ClassNotFoundException, SQLException{
         
         String expireDate="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT expireDate FROM products where Cdescription = '"+item+"' and barcode = '"+barcode+"'");
            
            while(rs.next()){
            expireDate = rs.getString("expireDate");                                    
        }
                conn.close();

          return expireDate; 
         
     
     }       
     
     
     public String quantity(String item, String barcode) throws ClassNotFoundException, SQLException{
         
         String quantity="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT quantity FROM products where Cdescription = '"+item+"' and barcode = '"+barcode+"'");
            
            while(rs.next()){
            quantity = rs.getString("quantity");                                    
        }
                conn.close();

          return quantity; 
         
     
     }       
     
     
     public String sellsPrice(String item, String barcode) throws ClassNotFoundException, SQLException{
         
         String sellsPrice="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT sellsPrice FROM products where Cdescription = '"+item+"' and barcode = '"+barcode+"'");
            
            while(rs.next()){
            sellsPrice = rs.getString("sellsPrice");                                    
        }
                conn.close();

          return sellsPrice; 
         
     
     }      
     
     public String discount(String item, String barcode) throws ClassNotFoundException, SQLException{
         
         String discount="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT discount FROM products where Cdescription = '"+item+"' and barcode = '"+barcode+"'");
            
            while(rs.next()){
            discount = rs.getString("discount");                                    
        }
                conn.close();

          return discount; 
         
     
     }    
     
     
     public String vdiscription(String item, String barcode) throws ClassNotFoundException, SQLException{
         
         String vdiscription="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT Vdescription FROM products where Cdescription = '"+item+"' and barcode = '"+barcode+"'");
            
            while(rs.next()){
            vdiscription = rs.getString("Vdescription");                                    
        }
                conn.close();

          return vdiscription; 
         
     
     } 
     
     public String tax(String item, String barcode) throws ClassNotFoundException, SQLException{
         
         String tax="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT tax FROM products where Cdescription = '"+item+"' and barcode = '"+barcode+"'");
            
            while(rs.next()){
            tax = rs.getString("tax");                                    
        }
                conn.close();

          return tax; 
         
     
     }
     
     public String zaka(String item, String barcode) throws ClassNotFoundException, SQLException{
         
         String zaka="";
                
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT zaka FROM products where Cdescription = '"+item+"' and barcode = '"+barcode+"'");
            
            while(rs.next()){
            zaka = rs.getString("zaka");                                    
        }
                conn.close();

          return zaka; 
         
     
     }
     
    
     // To add history in sales
     public void addSales(String item, String barCode, int discount, int soldQuantity, int price, String methodOfPayment, String soldDate, int totalPrice, int totalPriceWithDiscount, int tax, int zaka, int totalTax, int totalZaka) throws ClassNotFoundException, SQLException{

         Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            Statement st = conn.createStatement();
            
            ps = conn.prepareStatement("insert into sales(item,barCode,discount,soldQuantity,price,methodOfPayment,soldDate,totalPrice,totalPriceWithDiscount,tax,zaka,totalTax,totalZaka)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
           ps.setString(1, item);
           ps.setString(2, barCode);
           ps.setInt(3, discount);
           ps.setInt(4, soldQuantity);
           ps.setInt(5, price);
           ps.setString(6, methodOfPayment);
           ps.setString(7, soldDate);
           ps.setInt(8, totalPrice);
           ps.setInt(9, totalPriceWithDiscount);
           ps.setInt(10, tax);
           ps.setInt(11, zaka);
           ps.setInt(12, totalTax);
           ps.setInt(13, totalZaka);




           ps.executeUpdate();
           
           conn.close();
           
    }
     
   public void updateProduct(String item, String bacode, int quantity) throws ClassNotFoundException, SQLException{
        
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            
            if(quantity == 0){
            PreparedStatement st = conn.prepareStatement("DELETE FROM products where Cdescription = ? and barcode = ?");
            
            st.setString(1,item);
            st.setString(2,bacode);
            st.executeUpdate(); 

                conn.close();   
       
            }
            
            else{
            PreparedStatement st = conn.prepareStatement("update products set quantity = ? where Cdescription = ? and barcode = ?");
            
            st.setInt(1,quantity);
            st.setString(2,item);
            st.setString(3,bacode);
            st.executeUpdate(); 

                conn.close();   
       
            }
    }  
   
   
   
 /*  public ObservableList movies_tableView() throws ClassNotFoundException, SQLException{
        
        ObservableList<movieDetails>  movieDetails_Table = FXCollections.observableArrayList();   
        
        Class.forName(driver);
            conn = DriverManager.getConnection(url,dbuser,dbpassw);
            ResultSet rs = conn.createStatement().executeQuery("SELECT movie_name,description,cinema_location,time,threator FROM movie");
            
            while(rs.next()){
            movieDetails_Table.add(new movieDetails(
            
                                rs.getString("movie_name"),
                                rs.getString("description"),
                                rs.getString("cinema_location"),
                                rs.getString("time"),
                                rs.getInt("threator")

            
                                 ));                                   
        }
                conn.close();

            
          return movieDetails_Table;  
    }
     
     
    */ 
  

}