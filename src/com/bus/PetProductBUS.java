/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.PetProductDAO;
import com.dao.PetProductDTO;
import com.dao.PetProductTempDAO;
import com.gui.Validator;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class PetProductBUS {
    public ArrayList<PetProductDTO> productList;
    static private PetProductTempDAO productData = new PetProductTempDAO();
    Validator valid = new Validator();
    
    public PetProductBUS() {
        readData();
    }
    
    
    public void readData()
    {
        if(productList == null)
        {
            productList = new ArrayList<PetProductDTO>();
        }
        productList = productData.readList();
    }
    
    public void add(PetProductDTO product)
    {
        productData.add(product);
        productList.add(product);
    }
    
    public void edit(PetProductDTO product)
    {
        productData.edit(product);
        productList.removeIf(productTemp -> productTemp.getId().equalsIgnoreCase(product.getId()));
        productList.add(product);
    }
    
    public void updateQuantity(String ID, int quantity)
    {
        productData.updateQuantity(ID, quantity);
        for(PetProductDTO product : productList)
        {
            if(product.getId().equalsIgnoreCase(ID))
            {
                product.setInStock(quantity + product.getInStock());
            }
        }
    }
    
    public void delete(String ID)
    {
        productData.delete(ID);
        productList.removeIf(product -> product.getId().equalsIgnoreCase(ID));
    }
    
    public ArrayList<PetProductDTO> search(String text)
    {
        ArrayList<PetProductDTO> matchingList = new ArrayList<>();
        for(PetProductDTO product : productList)
        {
            if(valid.normalizeString(product.getName().toLowerCase()).equalsIgnoreCase(valid.normalizeString(text).toLowerCase()) || 
                    product.getId().equalsIgnoreCase(text))
            {
                matchingList.add(product);
            }
        }
        return matchingList;
    }
    
    public String getName(String ID)
    {
        String name = "";
        for(PetProductDTO product : productList)
        {
            if(product.getId().equalsIgnoreCase(ID))
            {
                name = product.getName();
            }
        }
        return name;
    }
    
    public String generateID()
    {
        String ID = "";
        String prefix = "SP";
        String flag = "";
        int i = 1;
        for(PetProductDTO product : productList)
        {
            String number = String.format("%03d", i);
            
            ID = prefix + number;
            if(product.getId().equalsIgnoreCase(ID))
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
