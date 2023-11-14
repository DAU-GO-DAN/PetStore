/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.BreedAnalysisDAO;
import com.dao.BreedAnalysisDTO;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class BreedAnalysisBUS {
    public ArrayList<BreedAnalysisDTO> analysisList;
    static private BreedAnalysisDAO analyDAO = new BreedAnalysisDAO();

    public BreedAnalysisBUS(){
        readData();
    }
    
    public void readData()
    {
        if(analysisList == null)
        {
            analysisList = new ArrayList<BreedAnalysisDTO>();
        }
        analysisList = analyDAO.readList();
    }
    
    public void add(BreedAnalysisDTO analy)
    {
        analysisList.add(analy);
        analyDAO.add(analy);
    }
    
    public void update(int year, int month, String breedID, int soldQuantity, long profit)
    {
        analyDAO.update(year, month, breedID, soldQuantity, profit);
        for(BreedAnalysisDTO analyTemp : analysisList)
        {
            if(analyTemp.getMonth() == month && 
                    analyTemp.getYear() == year &&
                    analyTemp.getBreedID().equalsIgnoreCase(breedID))
            {
                analyTemp.setSoldQuantity(analyTemp.getSoldQuantity() + soldQuantity);
                analyTemp.setProfit(analyTemp.getProfit() + profit);
                
            }
        }
    }
    
    public boolean checkExist(int year, int month, String breedID)
    {
        boolean isExist = false;
        
        if(analysisList.isEmpty())
        {
            isExist = false;
        }
        else{
            for(BreedAnalysisDTO analyTemp : analysisList)
            {
                if(analyTemp.getMonth() == month && 
                        analyTemp.getYear() == year &&
                        analyTemp.getBreedID().equalsIgnoreCase(breedID))
                {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }
}
