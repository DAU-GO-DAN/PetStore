/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.AccountDAO;
import com.dao.AccountDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huynh
 */
public class AccountBUS {
    ArrayList<AccountDTO> accList;
    static AccountDAO accDAO = new AccountDAO();
    public static boolean x = false;
    public AccountBUS() {
        readData();
    }
    
    public void readData(){
        if(accList == null) accList = new ArrayList<>();
        accList = accDAO.readAcctList();
    }
    
    public AccountDTO getAccount(String username){
        return accDAO.getAccount(username);
    }
    public AccountDTO getAccount(int i){
        return accList.get(i);
    }
    public boolean checkExist (String username){
        return accDAO.checkExist(username);
    }
    public AccountDTO searchById(String id){
        for (AccountDTO cus : accList){
            if(cus.getUserId().equalsIgnoreCase(id)){
                return cus;
            }
        }
        return null;
    }
    public DefaultTableModel getModel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã NV");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Địa chỉ");
        for (AccountDTO acc : accList) {
            Vector row = new Vector<>();
            row.add(acc.getUserId());
            row.add(acc.getUsername());
            row.add(acc.getPassword());
            row.add(acc.getRole());
            model.addRow(row);
        }
        return model;
    }
    public void delete(String userID){
        accDAO.delete(userID);
        readData();
    }
    public DefaultTableModel getModel(String id){
        AccountDTO acc = searchById(id);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã NV");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Role");
        if (acc == null){
            JOptionPane.showMessageDialog(null, "Không có mã nhân viên này");
            x = true;
            return model;
            
        }
            Vector row = new Vector<>();
            row.add(acc.getUserId());
            row.add(acc.getUsername());
            row.add(acc.getPassword());
            row.add(acc.getRole());
            model.addRow(row);
        return model;
    }
    public String generateAccountID(){
        String result;
        int i = 1;
        int current = 0;
        for (AccountDTO acc : accList){
            current = Integer.parseInt(acc.getUserId().substring(2));
            if( i != current ) {
                result = "NV" + String.format("%03d", i);
                return result;
            }
            i++;
        }
        result = "NV" +String.format("%03d",current+1);
        return result;
    }
    public void add(String userID, String username, String password, String role){
        AccountDTO add = new AccountDTO(username, password, userID, role);
        accDAO.add(add);
    }
    public void edit(String userID, String username, String password, String role){
        AccountDTO edit = new AccountDTO(username, password, userID, role);
        accDAO.edit(edit);
    }
}
