/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.gui;

import com.bus.PetOnStoreBUS;
import com.bus.PetProductBUS;
import com.bus.PetProductTempBUS;
import com.dao.PetOnStoreDTO;
import com.dao.PetProductDTO;
import com.dao.ProductDTO;
import java.util.ArrayList;

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
        PetOnStoreBUS petBus = new PetOnStoreBUS();
        ArrayList<ProductDTO> findList = new ArrayList<>();
        System.out.println("pro size : "+bus.productList.size());
        System.out.println("pet size : "+petBus.petList.size());
//        for(PetProductDTO product : bus.productList)
//        {
//            System.out.println("id : "+product.getId());
//        }
        for(PetOnStoreDTO pet : petBus.petList)
        {
            ProductDTO productTemp = (ProductDTO) pet;
            findList.add(productTemp);
        }
        
        for(PetProductDTO product : bus.productList)
        {
            ProductDTO productTemp = (ProductDTO) product;
            findList.add(productTemp);
        }
        System.out.println("dto size : "+findList.size());
        
        for(ProductDTO productTemp : findList)
        {
            System.out.println("id: "+productTemp.getId());
            System.out.println("name : "+productTemp.getName());
            if(productTemp instanceof PetProductDTO)
            {
                PetProductDTO petProductTemp = (PetProductDTO) productTemp;
                System.out.println("in stock: "+petProductTemp.getInStock());
            }
//            System.out.println("quantity : "+productTemp.get);
        }
        
    }
    
}
