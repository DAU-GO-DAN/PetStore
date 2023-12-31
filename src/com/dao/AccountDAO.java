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
public class AccountDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public AccountDAO() {
        conn = MyConnection.getConnection();
    }
    
    public ArrayList readAcctList()
    {
        ArrayList accountList = new ArrayList<AccountDTO>();
        try{
            String qry = "Select * from Account";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            while (rs.next())
            {
                AccountDTO accountTemp = new AccountDTO();
                accountTemp.setUsername(rs.getString("userName"));
                accountTemp.setUserId(rs.getString("userID"));
                accountTemp.setPassword(rs.getString("password"));
                accountTemp.setRole(rs.getString("role"));
                accountList.add(accountTemp);
            }
        }
        catch (SQLException ex){
            
        }
        return accountList;
    }
    
    public AccountDTO getAccount(String username){
        AccountDTO accTemp = new AccountDTO();
        try{
            String qry = "select * from Account " + "where username = '"+username+"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            if(rs.next()){
                accTemp.setUsername(rs.getString("userName"));
                accTemp.setUserId(rs.getString("userID"));
                accTemp.setPassword(rs.getString("password"));
                accTemp.setRole(rs.getString("role"));
            }
            
        }
        catch(SQLException e){
            
        }
        return accTemp;
    }
    
    public boolean checkExist (String username){
        try{
            String qry = "select * from Account " + "where username = '"+username+"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            if(rs.next()){
                return true;
            }
            else{
                qry = "select * from Employee " + "where empID = '"+ username +"'";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(qry);
                if(rs.next()) return true;
                
            }
        }
        catch(SQLException e){
            
        }
        return false;
    }
    
    
    public ArrayList readData(){
        ArrayList<AccountDTO> accList = new ArrayList<>();
        try{
            String qry = "select * from Account order by userID";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            while(rs.next()){
                AccountDTO accTemp = new AccountDTO();
                accTemp.setUserId(rs.getString("userID"));
                accTemp.setUsername(rs.getString("userName"));
                accTemp.setPassword(rs.getString("passworld"));
                accTemp.setRole(rs.getString("role"));
                accList.add(accTemp);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tải dữ liệu không thành công");
        }
        return accList;
    }
    
    
    public void add(AccountDTO acc){
        try{
            String qry = "insert into Account values('"
                        + acc.getUsername()+ "','"
                        + acc.getUserId()  + "','"
                        + acc.getPassword()+ "',N'"
                        + acc.getRole()    + "')";
            stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(qry);
            if (rowAffected == 1){
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
            else JOptionPane.showMessageDialog(null, "Thêm không thành công");
        }
        catch(SQLException e){
        }
    }
    
    
    public void edit(AccountDTO acc){
        try{
            String qry = "update Account set"
                        +"  userName = '"+ acc.getUsername()
                        + "',userID = '"  + acc.getUserId()  
                        + "',password = '"+ acc.getPassword()
                        + "',role = '"  + acc.getRole()    
                        + "' where userID = '"+acc.getUserId()+"'";
            stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(qry);
            if (rowAffected == 1){
                JOptionPane.showMessageDialog(null, "Sửa thành công");
            }
            else JOptionPane.showMessageDialog(null, rowAffected + "Sửa không thành công");
        }
        catch(SQLException e){
        }
    }
    
    
    public void delete(String id){
        try{
            String qry = "Delete from Account where userID = '"+id+"'";
            stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(qry);
            if (rowAffected == 1){
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
//            else JOptionPane.showMessageDialog(null, "Xóa không thành công");
        }
        catch(SQLException e){
        }
    }
}
