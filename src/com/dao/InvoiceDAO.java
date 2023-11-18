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
public class InvoiceDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public InvoiceDAO() {
        conn = MyConnection.getConnection();
    }
    
    public void add(InvoiceDTO inv)
    {
        try{
            String qry = "insert into Invoice values ("
                    + "'" +inv.getInvoiceID() + "', "
                    + "'" +inv.getCreatedDate()+ "', "
                    + "" +inv.getTotalAmount()+ ", "
                    + "'" +inv.getEmployeeID() + "', "
                    + "'" +inv.getCustomerID() + "' "
                    + " )";
            stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(qry);
            if(rowAffected == 1){
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm không thành công");
        }
    }
    
    public ArrayList readData(){
         ArrayList<InvoiceDTO> InvList= new ArrayList<>();
         try {
            String qry="SELECT * FROM Invoice";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(qry);
            while(rs.next()){
                InvoiceDTO Invv= new InvoiceDTO();
                Invv.setInvoiceID(rs.getString("id"));
                Invv.setCreatedDate(rs.getDate("createdDate").toLocalDate());
                Invv.setTotalAmount((long) rs.getFloat("totalAmount"));
                Invv.setEmployeeID(rs.getString("employeeID"));
                Invv.setCustomerID(rs.getString("customerID"));
                InvList.add(Invv);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Lỗi tải dữ liệu !");
        }
         return InvList;
    }
    
    public void delete(String id){
        try{
            String qry = "delete from Invoice where id = '" + id + "'";
            stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(qry);
            if(rowAffected == 1){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa không thành công");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Xóa không thành công");
        }
    }
}
