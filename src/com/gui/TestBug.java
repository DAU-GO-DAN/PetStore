/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.gui;

import com.bus.PetProductBUS;
import com.bus.PetProductTempBUS;
import com.dao.PetProductDTO;

/**
 *
 * @author DUC PHU
 */
public class TestBug {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PetProductBUS bus = new PetProductBUS();
        System.out.println("size :"+bus.productList.size());
        for(PetProductDTO product : bus.productList)
        {
            System.out.println("id : "+product.getId());
        }
    }
    
}
