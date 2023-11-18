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
public class SoldPetDTO extends ProductDTO{
    private LocalDate importDate;
    private String gender;
    private String breedId;
    private String color;
    private int weight;
    private LocalDate soldDate;
    private String customerID;

    public SoldPetDTO() {
        super();
    }

    public SoldPetDTO(String gender, String breedId, String color, int weight, LocalDate date, String customerID) {
        super();
        this.gender = gender;
        this.breedId = breedId;
        this.color = color;
        this.weight = weight;
        this.soldDate = date;
        this.customerID = customerID;
    }

    public LocalDate getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }

    
    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }
    
    
    public String getGender() {
        return gender;
    }

    public String getBreedId() {
        return breedId;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    

    public String getCustomerID() {
        return customerID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBreedId(String breedId) {
        this.breedId = breedId;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    
}
