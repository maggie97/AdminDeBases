/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.models;

/**
 *
 * @author maggiemendez
 */
public class Product {
    private long id;
    private String name;
    private String price;
    private String brand;
    private int excistences;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the excistences
     */
    public int getExcistences() {
        return excistences;
    }

    /**
     * @param excistences the excistences to set
     */
    public void setExcistences(int excistences) {
        this.excistences = excistences;
    }
    
    public String toString(){
        return brand + "-" + name ; 
    }
}
