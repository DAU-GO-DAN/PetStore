/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bus;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDTO;
import com.gui.EmployeeGUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//thư viện kiểm tra lỗi tiếng việt
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author DUC PHU
 */
public class EmployeeBUS {

    EmployeeDAO empDAO = new EmployeeDAO();
    static ArrayList<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
    public EmployeeBUS() {
        readData();
       
    }
    public void readData(){
        empList = empDAO.readData();
        
    }
    public DefaultTableModel printTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Họ Tên");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");
        model.addColumn("Ngày tạo");
        model.addColumn("Chức vụ");
        model.addColumn("Lương");
        for (EmployeeDTO emp : empList) {
            Vector row = new Vector<>();
            row.add(emp.getId());
            row.add(emp.getName());
            row.add(emp.getPhone());
            row.add(emp.getAddress());
            row.add(emp.getCreatedDate());
            row.add(emp.getRole());
            row.add(emp.getSalary());
            model.addRow(row);
        }
        return model;
    }
    
    public boolean add(EmployeeDTO emp){
        empDAO.add(emp);
        empList.add(emp);
        return true;
    }
    
    
    public String generateEmployeeID(){
        String id = null;
        String prefix = "NV";
        int num = 0;
        while(id == null){
            num++;
            if(num >= 100){
                id = prefix + num;
            }else if(num >= 10){
                id = prefix + "0" + num;
            }else if(num > 0){
                id = prefix + "00" + num;
            }
            if(empDAO.isUnique(id)) break;
            else id = null;
        }
        return id;
    }
    
    public String normalizeName(String name) {
        // Loại bỏ khoảng trắng thừa ở đầu và cuối chuỗi
        name = name.trim();

        // Loại bỏ khoảng trắng thừa giữa các từ
        name = name.replaceAll("\\s+", " ");

        // Tách chuỗi thành các từ riêng lẻ
        String[] words = name.split(" ");

        // Chuẩn hóa từng từ
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                // Viết hoa chữ cái đầu tiên của mỗi từ
                words[i] = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            }
        }

        // Kết hợp các từ thành một chuỗi đã chuẩn hóa
        String normalizedName = String.join(" ", words);

        return normalizedName;
    }
    
    
    public boolean numOnly(String input){
        return input.matches("\\d+");
    }
    
    
    public boolean startsWithZero(String phoneNumber) {
    return phoneNumber.startsWith("0");
}
    
    public boolean isVietnamese(String input) {
        // Biểu thức chính quy để kiểm tra dấu tiếng Việt
        String regex = "^[\\p{L} .'-]+$";

        // Tạo một đối tượng Pattern từ biểu thức chính quy
        Pattern pattern = Pattern.compile(regex);

        // Tạo một đối tượng Matcher và kiểm tra chuỗi đầu vào
        Matcher matcher = pattern.matcher(input);

        // Trả về true nếu chuỗi hợp lệ (chứa dấu tiếng Việt), ngược lại trả về false
        return matcher.matches();
    }
    
    

    
    public void edit(EmployeeDTO empDTO, String id){
        empDAO.edit(empDTO, id);
        empList.removeIf(emp -> emp.getId().equals(id));
        empList.add(empDTO);
    }
    
    
//    public LocalDate generateEmployeeCreatedDate(){
//        LocalDate currentDate = LocalDate.now();
//        return currentDate;
//    }
    
    public boolean delete(String id){
        empDAO.delete(id);
        empList.removeIf(emp -> emp.getId().equals(id));
        return true;
    }
    
    
    public EmployeeDTO searchByID(String id){
        EmployeeDTO emp  = new EmployeeDTO();
        String normalizedInput = normalizeID(id.toLowerCase()); 
        for (EmployeeDTO empDTO : empList) 
        {
            String normalizedEmpId = normalizeID(empDTO.getId().toLowerCase());
             
            //Tìm kiếm nhân viên theo ID chỉ cần nhập 1-2 kí tự
            if (empDTO.getId().matches(".*" + id + ".*")) {
            return emp;
            }
        
        }
        return emp;
    }
    
    private String normalizeID(String input) {
        String normalized = Normalizer.normalize(input, Form.NFD);
        normalized = normalized.replaceAll("[^a-zA-Z0-9]", ""); // Giữ lại chỉ chữ cái và số
        return normalized;
    }
    
     public ArrayList<EmployeeDTO> searchByIDList(String id){
        ArrayList<EmployeeDTO> filtered = new ArrayList<>();
        String normalizedInput = normalizeID(id.toLowerCase()); 
//        String[] result = new String[2];
//        result[1] = normalizedInput.replaceAll("[^a-zA-Z]", "");
//        result[2] = normalizedInput.replaceAll("[^0-9]", "");
        for (EmployeeDTO empDTO : empList) {
            String normalizedEmpId = normalizeID(empDTO.getId().toLowerCase());
//            String[] results = new String[2];
//            results[1] = normalizedEmpId.replaceAll("[^a-zA-Z]", "");
//            results[2] = normalizedEmpId.replaceAll("[^0-9]", "");
    //        if (empDTO.getId().contains(id)) {
             if(normalizedEmpId.contains(normalizedInput)){
//            if(results[1].contains(result[1]) || results[2].contains(result[2])){
                filtered.add(empDTO);
            
            }
        }
        return filtered;
    }
    
     
     
    public DefaultTableModel getIdModel(String id){
        ArrayList<EmployeeDTO> filtered = searchByIDList(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Họ tên");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");
        model.addColumn("Ngày tạo");
        model.addColumn("Chức vụ");
        model.addColumn("Lương");  
        for (EmployeeDTO empDTO : filtered) {
            Vector row = new Vector<>();
            row.add(empDTO.getId());
            row.add(empDTO.getName());
            row.add(empDTO.getPhone());
            row.add(empDTO.getAddress());
            row.add(empDTO.getCreatedDate().format(formatter));
            row.add(empDTO.getRole());
            row.add(empDTO.getSalary());
            model.addRow(row);
        }
        return model;
    }
    
    public DefaultTableModel getNameModel(String name){
        ArrayList<EmployeeDTO> filtered = searchByName(name);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Họ tên");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");
        model.addColumn("Ngày tạo");
        model.addColumn("Chức vụ");
        model.addColumn("Lương");     
        for (EmployeeDTO empDTO : filtered) {
            Vector row = new Vector<>();
            row.add(empDTO.getId());
            row.add(empDTO.getName());
            row.add(empDTO.getPhone());
            row.add(empDTO.getAddress());
            row.add(empDTO.getCreatedDate().format(formatter));
            row.add(empDTO.getRole());
            row.add(empDTO.getSalary());
            model.addRow(row);
        }
        return model;
    }
    public boolean containsInput(String input) {
          return input.matches("^[a-zA-Z0-9\\p{L} \\p{Punct}]*$");
    }
    
    public ArrayList<EmployeeDTO> searchByName(String name) {
        ArrayList<EmployeeDTO> filteredList = new ArrayList<>();
        for (EmployeeDTO empDTO : empList) {
            String normalizedEmpName = normalizeString(empDTO.getName());
            String normalizedSearchName = normalizeString(name);
            if (normalizedEmpName.toLowerCase().contains(normalizedSearchName.toLowerCase())) {
                filteredList.add(empDTO);
            }
        }
        return filteredList;
    }
    
    
    private String normalizeString(String input) {
        String normalized = Normalizer.normalize(input, Form.NFD);
        normalized = normalized.replaceAll("[đĐ]", "d");
        normalized = normalized.replaceAll("[^\\p{ASCII} \\t\\n\\x0B\\f\\r]", "");
        return normalized;
    }
    
     
     
    public boolean containsOnlyLetters(String input) {
        return input.matches("^[a-zA-Z\\p{L} ]*$");
    }
    
    public void printExcel(String fileName, String folder){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try{
                //Khởi tạo file excel
                HSSFWorkbook workBook = new HSSFWorkbook();
                HSSFSheet sheet = workBook.createSheet("Employee");
                //Tạo font cho cell
                HSSFFont font = workBook.createFont();
                font.setBold(true);
                //Áp font vào cell
                HSSFCellStyle style = workBook.createCellStyle();
                style.setFont(font);
                //Bắt đầu truyền dữ liệu cho excel
                Cell cell;
                Row row;
                int rownum = 0;
                row = sheet.createRow(rownum); // tạo dòng đầy tiên trên sheet
                //Tạo tiêu đề cho file muốn in
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("ID");
                cell.setCellStyle(style);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Họ tên");
                cell.setCellStyle(style);
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Số điện thoại");
                cell.setCellStyle(style);
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Địa chỉ");
                cell.setCellStyle(style);
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Ngày tạo");
                cell.setCellStyle(style);
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Chức vụ");
                cell.setCellStyle(style);
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("Lương");
                cell.setCellStyle(style);
                //add data
                for (EmployeeDTO empDTO : empList) {
                    rownum++;
                    row = sheet.createRow(rownum);

                    cell = row.createCell(0,CellType.STRING);
                    cell.setCellValue(empDTO.getId());
                    sheet.autoSizeColumn(0);
                    cell = row.createCell(1,CellType.STRING);
                    cell.setCellValue(empDTO.getName());
                    sheet.autoSizeColumn(1);
                    cell = row.createCell(2,CellType.STRING);
                    cell.setCellValue(empDTO.getPhone());
                    sheet.autoSizeColumn(2);
                    cell = row.createCell(3,CellType.STRING);
                    cell.setCellValue(empDTO.getAddress());
                    sheet.autoSizeColumn(3);
                    cell = row.createCell(4,CellType.STRING);
                    cell.setCellValue(empDTO.getCreatedDate().format(formatter));
                    sheet.autoSizeColumn(4);
                    cell = row.createCell(5,CellType.STRING);
                    cell.setCellValue(empDTO.getRole());
                    sheet.autoSizeColumn(5);
                    cell = row.createCell(6,CellType.NUMERIC);
                    cell.setCellValue(empDTO.getSalary());
                    sheet.autoSizeColumn(6);
                }
                File f = new File(folder + fileName + ".xls");
                FileOutputStream outFile = new FileOutputStream(f);
                workBook.write(outFile);
                JOptionPane.showMessageDialog(null, "In Excel thành công");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    
    public void importData(JTable table, String namePath){
        try {
            FileInputStream file = new FileInputStream(new File(namePath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount][columnCount];

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString();
                    
                }
            }

            String[] columnNames = new String[columnCount];
            Row headerRow = sheet.getRow(0);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = headerRow.getCell(j);
                columnNames[j] = cell.toString();
            }
//            table.getColumnModel().getColumn(3).setCellRenderer(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
            
            
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getName(String ID)
    {
        String name = "";
        System.out.println("id : "+ID);
        for(EmployeeDTO emp : empList)
        {
            if(emp.getId().equalsIgnoreCase(ID))
            {
                name = emp.getName();
                System.out.println("co tim thay");
            }
        }
        return name;
    }
    
    
}
