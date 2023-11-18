/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import java.util.ArrayList;
import com.dao.ImportDTO;
import com.dao.ImportDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author huynh
 */
public class ImportBUS {  
    ImportDAO impDAO = new ImportDAO();
    public <impDAO> ArrayList<ImportDTO> getList() throws SQLException{
        return impDAO.readImpList();
    }

    
    public ImportDTO findById(String id)  throws SQLException{
        boolean isSuccess=impDAO.checkExistById(id);
        if (isSuccess) {
            return impDAO.findById(id);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy import Id = " + id);
            return null;
        }
    }
    
    public void add(ImportDTO imp) throws SQLException {
    	boolean isExist = impDAO.checkExistById(imp.getImportID());
        if (!isExist) {
             impDAO.add(imp);
            } 
        else {
             JOptionPane.showMessageDialog(null, "ID đã tồn tại ");
        }      
    }
    
    public String generateID() throws SQLException
    {
        String ID = "";
        String prefix = "PN";
        String flag = "";
        if(getList().isEmpty())
        {
            ID = "PN001";
        }
        else{
            int i = 1;
            for(ImportDTO impTemp : getList())
            {
                String number = String.format("%03d", i);

                ID = prefix + number;
                if(impTemp.getImportID().equalsIgnoreCase(ID))
                {
                    flag = "noslot";
                    i++;
                }
                else{
                    flag = "generated";
                    break;
                }
            }
        
            if(flag.equals("noslot"))
            {

                String number = String.format("%03d", i);
                ID = prefix + number;
            }
        }
        
        return ID;
    }
}
