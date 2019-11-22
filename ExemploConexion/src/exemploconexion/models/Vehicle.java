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
public class Vehicle {
    private long id;
    private String placa ;
    private int brand;
    private int weight;
    private boolean disponibility;

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
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the brand
     */
    public int getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(int brand) {
        this.brand = brand;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the disponibility
     */
    public boolean isDisponibility() {
        return disponibility;
    }

    /**
     * @param disponibility the disponibility to set
     */
    public void setDisponibility(boolean disponibility) {
        this.disponibility = disponibility;
    }
    
    public String getString(){
        return this.id + "-" + this.placa + "-" + this.brand;
    }
}
