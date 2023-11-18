/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.time.LocalDate;

/**
 *
 * @author DUC PHU
 */
public class ImportDTO {
    private String importID;
    private LocalDate createdDate;
    private long totalAmount;
    private String employeeID;
    public ImportDTO(){
        
    }
    public ImportDTO(String importID, LocalDate createdDate, long amount, String empId) {
        this.importID = importID;
        this.createdDate = createdDate;
        this.totalAmount = amount;
        this.employeeID = empId;
    }

    public String getImportID() {
        return importID;
    }
    
    

    public long getTotalAmount() {
        return totalAmount;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setImportID(String importID) {
        this.importID = importID;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
    
    

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
    
}
