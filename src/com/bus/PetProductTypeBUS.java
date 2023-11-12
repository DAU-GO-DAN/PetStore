/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;
import com.dao.PetProductTypeDAO;
import com.dao.PetProductTypeDTO;
import com.gui.Validator;
import java.util.ArrayList;
/**
 *
 * @author huynh
 */
public class PetProductTypeBUS {
    public ArrayList<PetProductTypeDTO> typeList;
    static private PetProductTypeDAO typeData = new PetProductTypeDAO();
    Validator valid = new Validator();

    public PetProductTypeBUS() {
        readData();
    }
    
    
    
    public void readData()
    {
        if(typeList == null)
        {
            typeList = new ArrayList<PetProductTypeDTO>();
        }
        typeList = typeData.readList();
    }
    
    public void add(PetProductTypeDTO type)
    {
        typeData.add(type);
        typeList.add(type);
    }
    
    public void delete(String ID)
    {
        typeData.delete(ID);
        typeList.removeIf(type -> type.getCategoryId().equalsIgnoreCase(ID));
    }
    
    public void edit(PetProductTypeDTO type)
    {
        typeData.edit(type);
        typeList.removeIf(typeTemp -> typeTemp.getCategoryId().equalsIgnoreCase(type.getCategoryId()));
        typeList.add(type);
    }
    
    public String getName(String ID)
    {
        String name = "";
        for(PetProductTypeDTO type : typeList)
        {
            if(type.getCategoryId().equalsIgnoreCase(ID))
            {
                name = type.getName();
            }
        }
        return name;
    }
    
    public String getID(String name)
    {
        String ID = "";
        for(PetProductTypeDTO type : typeList)
        {
            if(valid.normalizeString(type.getName().toLowerCase()).equalsIgnoreCase(valid.normalizeString(name).toLowerCase()))
            {
                ID = type.getCategoryId();
            }
        }
        return ID;
    }
    
    public ArrayList<PetProductTypeDTO> search(String text)
    {
        ArrayList<PetProductTypeDTO> matchingList = new ArrayList<>();
        for(PetProductTypeDTO type : typeList)
        {
            if(valid.normalizeString(type.getName().toLowerCase()).equalsIgnoreCase(valid.normalizeString(text).toLowerCase())  ||
                    type.getCategoryId().equalsIgnoreCase(text))
            {
                matchingList.add(type);
            }
        }
        return matchingList;
    }
}
