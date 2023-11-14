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
public class BreedAnalysisDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public BreedAnalysisDAO() {
        conn = MyConnection.getConnection();
    }
    
    public void add(BreedAnalysisDTO breed)
    {
        try{
            String qry = "insert into BreedAnalysis values ("
                    + "" + breed.getMonth()+ ""
                    + ", "+ "" + breed.getYear()+ ""
                    + ", "+ "'" + breed.getBreedID()+ "'"
                    + ", "+ "" + breed.getSoldQuantity()+ ""
                    + ", "+ "" + breed.getProfit()+ ""
                    + " )";
            stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(qry);
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Thêm analysis thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm analysis thất bại!");
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    public boolean checkMonth(int year, int month, String breedID)
    {
        boolean isExist = false;
        try{
            String qry = "select * from BreedAnalysis"
                    + " where month = "+month+ " and year = "+year+ " and breedID = '" +breedID+ "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            if(rs.next())
            {
                isExist = true;
            }
        }
        catch(SQLException ex)
        {
           
        }
        return isExist;
    }
    
    public void update(int year, int month, String breedID, int soldQuantity, long profit)
    {
        try{
            String qry = " update BreedAnalysis "
                    + " set "
                    + " quantity = quantity + " +soldQuantity
                    + ", " + " profit = profit + "+profit
                    + " where month = "+month+ " and year = "+year+ " and breedID = '" +breedID+ "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
        }
        catch(SQLException ex)
        {
            
        }
        
    }
    
    public ArrayList readList()
    {
        ArrayList list = new ArrayList<BreedAnalysisDTO>();
        try{
            String qry = "Select * from BreedAnalysis";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(qry);
            while(rs.next())
            {
                BreedAnalysisDTO analysis = new BreedAnalysisDTO();
                analysis.setMonth(Integer.parseInt(rs.getString("month")));
                analysis.setYear(Integer.parseInt(rs.getString("year")));
                analysis.setBreedID(rs.getString("breedID"));
                analysis.setSoldQuantity(Integer.parseInt(rs.getString("quantity")));
                analysis.setProfit(Long.parseLong(rs.getString("profit")));
                list.add(analysis);
            }
            
        }
        catch(SQLException ex)
        {
            
        }
        return list;
    }
}
