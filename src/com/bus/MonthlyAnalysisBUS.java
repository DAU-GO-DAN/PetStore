/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.MonthlyAnalysisDAO;
import com.dao.MonthlyAnalysisDTO;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class MonthlyAnalysisBUS {
    public ArrayList<MonthlyAnalysisDTO> analysisList;
    static private MonthlyAnalysisDAO analyDAO = new MonthlyAnalysisDAO();

    public MonthlyAnalysisBUS() {
        readData();
    }
    
    public void readData()
    {
        if(analysisList == null)
        {
            analysisList = new ArrayList<MonthlyAnalysisDTO>();
        }
        analysisList = analyDAO.readAnalysisList();
    }
    
    public void add(MonthlyAnalysisDTO analy)
    {
        analysisList.add(analy);
        analyDAO.add(analy);
    }
    
    public void update(int year, int month, String productID, int soldQuantity, long profit)
    {
        analyDAO.update(year, month, productID, soldQuantity, profit);
        
        for(MonthlyAnalysisDTO analyTemp : analysisList)
        {
            if(analyTemp.getMonth() == month && 
                    analyTemp.getYear() == year &&
                    analyTemp.getProductID().equalsIgnoreCase(productID))
            {
                analyTemp.setSoldQuantity(analyTemp.getSoldQuantity() + soldQuantity);
                analyTemp.setProfit(analyTemp.getProfit() + profit);
            }
        }
    }
    
    public boolean checkExist(int year, int month, String productID)
    {
        boolean isExist = false;
        
        if(analysisList.isEmpty())
        {
            isExist = false;
        }
        else{
            for(MonthlyAnalysisDTO analyTemp : analysisList)
            {
                if(analyTemp.getMonth() == month && 
                        analyTemp.getYear() == year &&
                        analyTemp.getProductID().equalsIgnoreCase(productID))
                {
                    isExist = true;
                }
            }
        }
        return isExist;
    }
}
