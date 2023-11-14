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
public class InvoiceDetailDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public InvoiceDetailDAO() {
        conn = MyConnection.getConnection();
    }
    
    public void add(InvoiceDetailDTO inv)
    {
        try{
            String qry = "insert into InvoiceDetail values ("
                    + "'" +inv.getInvoiceID() + "', "
                    + "'" +inv.getProductID() + "', "
                    + "N'" +inv.getProductName() + "', "
                    + "" +inv.getQuantity() + ", "
                    + "" +inv.getSoldPrice() + ", "
                    + "" +inv.getTotal() + " "
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
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm không thành công");
        }
    }
    
    public ArrayList readList()
    {
        ArrayList list = new ArrayList<InvoiceDetailDTO>();
        
        try{
            String qry = "select * from InvoiceDetail ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            while(rs.next())
            {
                InvoiceDetailDTO inv = new InvoiceDetailDTO();
                inv.setInvoiceID(rs.getString("id"));
                inv.setProductID(rs.getString("productID"));
                inv.setProductName(rs.getString("productName"));
                inv.setQuantity(Integer.parseInt(rs.getString("quantity")));
                inv.setSoldPrice(Long.parseLong(rs.getString("soldPrice")));
                inv.setTotal(Long.parseLong(rs.getString("amount")));
                list.add(inv);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
    
}
