/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.InvoiceDetailDAO;
import com.dao.InvoiceDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class InvoiceDetailBUS {
    public ArrayList<InvoiceDetailDTO> invDetailList;
    static private InvoiceDetailDAO invData = new InvoiceDetailDAO();

    public InvoiceDetailBUS() {
        readData();
    }
    
    
    
    public void readData()
    {
        if(invDetailList == null)
        {
            invDetailList = new ArrayList<InvoiceDetailDTO>();
        }
        invDetailList = invData.readList();
    }
    
    public void add(InvoiceDetailDTO inv)
    {
        invData.add(inv);
        invDetailList.add(inv);
    }
    
    public void advanceSearch()
    {
        
    }
}
