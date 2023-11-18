/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;
import java.sql.ResultSet;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.security.Security;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author DUC PHU
 */
public class PetProductDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public PetProductDAO() {
        conn = MyConnection.getConnection();
    }
    
    public void add(PetProductDTO product)
    {
  
        try {
            String qry = "INSERT INTO PetProduct VALUES ("
                    + "'" + product.getId() + "', "
                    + "N'" + product.getName() + "', "
                    + "" + product.getSoldPrice() + ", "
                    + "" + product.getImportPrice() + ", "
                    + "N'" + product.getDescription() + "', "
                    + "'" + product.getSupplierId() + "', "
                    + "'" + product.getCategoryID() + "', "
                    + "" + product.getInStock() + ", "
                    + "'" + product.getImageUrl() + "' "
                    + ")";
            stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(qry);
            if(rowAffected == 1){
//                JOptionPane.showMessageDialog(null, "Thêm thành công");
            }else{
//                JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        catch(SQLException ex)
        {
//            JOptionPane.showMessageDialog(null, "Thêm không thành công");
            ex.printStackTrace();
        }
    }
    
    public void delete(String ID)
    {
        try{
            String qry = "delete from PetProduct "
                    + " where ID ='" +ID+ "'";
            stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(qry);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void edit(PetProductDTO product)
    {
        try{
            String qry = "Update PetProduct "
                    + " set "
                    + " petName = N'" +product.getName()+"', "
                    + " soldPrice = " +product.getSoldPrice()+", "
                    + " importPrice = " +product.getImportPrice()+", "
                    + " Description = N'" +product.getDescription()+"', "
                    + " supplierID = '" +product.getSupplierId()+"', "
                    + " categoryID = '" +product.getCategoryID()+"', "
                    + " inStock = " +product.getInStock()+", "
                    + " imageUrl = '" +product.getImageUrl()+"' "
                    + " where ID = '" +product.getId()+ "'";
            stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(qry);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void updateQuantity(String ID, int quantity)
    {
        try{
            String qry = "Update PetProduct "
                    + " set "
                    + " inStock =  inStock + " +quantity
                    + " where ID = '" +ID+ "'";
            stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(qry);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public ArrayList readPetProductList()
    {
        ArrayList list = new ArrayList<PetProductDTO>();
        
        try {
            String qry = "Select * from PetProduct ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            while(rs.next())
            {
                PetProductDTO product = new PetProductDTO();
                product.setId(rs.getString("petID"));
                product.setName(rs.getString("petName"));
                product.setSoldPrice(Long.parseLong(rs.getString("soldPrice")));
                product.setImportPrice(Long.parseLong(rs.getString("importPrice")));
                product.setDescription(rs.getString("Description"));
                product.setSupplierId(rs.getString("supplierID"));
                product.setCategoryID(rs.getString("categoryID"));
                product.setInStock(Integer.parseInt(rs.getString("inStock")));
                product.setImageUrl(rs.getString("imageUrl"));
                list.add(product);
//                System.out.println("id :"+rs.getString("petID"));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
//        System.out.println("list size :"+list.size());
        return list;
        
    }
    
}
