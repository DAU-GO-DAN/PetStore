/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.CustomerDTO;
import com.dao.InvoiceDAO;
import com.dao.InvoiceDTO;
import com.gui.Validator;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author huynh
 */


public class InvoiceBUS {
    Validator valid = new Validator();
    static InvoiceDAO invDAO = new InvoiceDAO();
    static ArrayList<InvoiceDTO> invList = new ArrayList<>();
    
    public InvoiceBUS() {
        readData();
    }

    public void readData(){
        invList = invDAO.readData();
        
    }
    
    public void add(InvoiceDTO inv)
    {
        invList.add(inv);
        invDAO.add(inv);
    }
    
    public void delete(String id){
        invDAO.delete(id);
        invList.removeIf(inv -> inv.getInvoiceID().equalsIgnoreCase(id));
    }
   
    public DefaultTableModel getModel(){
     
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Mã hóa đơn");
    model.addColumn("Ngày tạo hóa đơn");
    model.addColumn("Tổng tiền");
    model.addColumn("Mã Nhân viên");
    model.addColumn("Mã khách hàng");
   for (InvoiceDTO invc : invList) {
       Vector row = new Vector<>();
       row.add(invc.getInvoiceID());
       row.add(valid.toUIDate(invc.getCreatedDate()));
       row.add(invc.getTotalAmount());
       row.add(invc.getEmployeeID());
       row.add(invc.getCustomerID());
       model.addRow(row);
    }
    return model;
    }
    
     public ArrayList<InvoiceDTO> searchById(String id) {
        ArrayList<InvoiceDTO> filteredList = new ArrayList<>();
        for (InvoiceDTO inv : invList) {
           // Kiểm tra xem mã hóa đơn, mã khách hàng hoặc mã nhân viên chứa chuỗi tìm kiếm
        if (inv.getInvoiceID().toLowerCase().contains(id.toLowerCase()) ||
            inv.getCustomerID().toLowerCase().contains(id.toLowerCase()) ||
            inv.getEmployeeID().toLowerCase().contains(id.toLowerCase())) {
           
                filteredList.add(inv);
            }
        }
        return filteredList;
    }

    public DefaultTableModel getModelId(String id){
        ArrayList<InvoiceDTO> a = searchById(id);
         DefaultTableModel Id = new  DefaultTableModel();
         Id.addColumn("Mã hóa đơn");
    Id.addColumn("Ngày tạo hóa đơn");
    Id.addColumn("Tổng tiền");
    Id.addColumn("Mã Nhân viên");
    Id.addColumn("Mã khách hàng");
   for (InvoiceDTO invc : a) {
       Vector row = new Vector<>();
       row.add(invc.getInvoiceID());
       row.add(invc.getCreatedDate());
       row.add(invc.getTotalAmount());
       row.add(invc.getEmployeeID());
       row.add(invc.getCustomerID());
       Id.addRow(row);
   }
         return Id;
    }
    
    public String generateID()
    {
        String id = "";
        
        if(invList.isEmpty())
        {
            id = "HD001";
        }
        else{
            int number = 1;
            String prefix = "HD";
            String flag = "";
            for(InvoiceDTO inv : invList)
            {
                String numString = String.format("%03d", number);
                id = prefix + numString;
                if(inv.getInvoiceID().equalsIgnoreCase(id))
                {
                    flag = "noslot";
                    number++;
                }
                else{
                    flag = "generated";
                    break;
                }
            }
            
            if(flag.equalsIgnoreCase("noslot"))
            {
                String numString = String.format("%03d", number);
                id = prefix + numString;
            }
            
            
        }
        return id;
    }
}
