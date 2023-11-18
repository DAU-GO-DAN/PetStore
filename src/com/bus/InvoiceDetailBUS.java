/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.InvoiceDetailDAO;
import com.dao.InvoiceDetailDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huynh
 */
public class InvoiceDetailBUS {
    public ArrayList<InvoiceDetailDTO> invDetailList;
    static ArrayList<InvoiceDetailDTO> invDList = new ArrayList<>();
    static private InvoiceDetailDAO invData = new InvoiceDetailDAO();

    public InvoiceDetailBUS(String Id){
        readInvoiceDetail(Id);
    }
    
    public void readInvoiceDetail(String Id){
        invDList=invData.readInvoiceDetail(Id);
        
    }
    
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
    
     public DefaultTableModel getModelInvoiceID(String id){
         DefaultTableModel InvD= new DefaultTableModel();
//         InvD.addColumn("Mã hóa đơn");
         InvD.addColumn("Mã Sản Phẩm");
         InvD.addColumn("Tên Sản Phẩm");
         InvD.addColumn("SỐ Lượng");
         InvD.addColumn("Giá cả");
         InvD.addColumn("Tổng Tiền");
         for(InvoiceDetailDTO i: invDList){
             Vector row = new Vector<>();
            // row.add(i.getInvoiceID());
             row.add(i.getProductID());
             row.add(i.getProductName());
             row.add(i.getQuantity());
             row.add(i.getSoldPrice());
             row.add(i.getTotal());
             InvD.addRow(row);
         }
         return InvD;
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
