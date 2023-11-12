/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.PetProductDTO;
import com.dao.SoldPetDAO;
import com.dao.SoldPetDTO;
import com.gui.Validator;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class SoldPetBUS {
    public ArrayList<SoldPetDTO> soldList;
    static private SoldPetDAO soldData = new SoldPetDAO();
    Validator valid = new Validator();

    public SoldPetBUS() {
        readData();
    }
    
    public void readData()
    {
        if(soldList == null)
        {
            soldList = new ArrayList<SoldPetDTO>();
        }
        soldList = soldData.readSoldPetList();
    }
    
    public void add(SoldPetDTO pet)
    {
        soldData.add(pet);
        soldList.add(pet);
    }
    
    public void delete(String ID)
    {
        soldData.delete(ID);
        soldList.removeIf(pet -> pet.getId().equalsIgnoreCase(ID));
    }
    
    public ArrayList<SoldPetDTO> search(String text)
    {
        ArrayList<SoldPetDTO> matchingList = new ArrayList<>();
        for(SoldPetDTO pet : soldList)
        {
            if(valid.normalizeString(pet.getName().toLowerCase()).equalsIgnoreCase(valid.normalizeString(text.toLowerCase())) ||
                    pet.getId().equalsIgnoreCase(text))
            {
                matchingList.add(pet);
            }
        }
        return matchingList;
    }
    
    public String generateID()
    {
        String ID = "";
        String prefix = "DB";
        String flag = "";
        int i = 1;
        for(SoldPetDTO pet : soldList)
        {
            String number = String.format("%03d", i);
            
            ID = prefix + number;
            if(pet.getId().equalsIgnoreCase(ID))
            {
                flag = "noslot";
                i++;
            }
            else{
                flag = "generated";
            }
        }
        if(flag.equalsIgnoreCase("noslot"))
        {
            String number = String.format("%03d", i);
            ID = prefix + number;
        }
        return ID;
    }
    
}
