/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.models;

import java.util.Date;

/**
 *
 * @author maggiemendez
 */
public class Order {
    
    private long id;
    
    private long clientSend;
    private String nameClientSend;
    
    private long clientReceives; 
    private String nameClientReceives;
    
    private double total;
    
    private long idVehicle;
    private String brandVehicle;
    private String licensePlate;
    
    private String state;
    
    private Date dateOrder;
    private Date dateDelivery;
    
    private long idEmployee;
    private String nameDriver;

    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @param licensePlate the licensePlate to set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
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
     * @return the clientSend
     */
    public long getClientSend() {
        return clientSend;
    }

    /**
     * @param clientSend the clientSend to set
     */
    public void setClientSend(long clientSend) {
        this.clientSend = clientSend;
    }

    /**
     * @return the nameClientSend
     */
    public String getNameClientSend() {
        return nameClientSend;
    }

    /**
     * @param nameClientSend the nameClientSend to set
     */
    public void setNameClientSend(String nameClientSend) {
        this.nameClientSend = nameClientSend;
    }

    /**
     * @return the clientReceives
     */
    public long getClientReceives() {
        return clientReceives;
    }

    /**
     * @param clientReceives the clientReceives to set
     */
    public void setClientReceives(long clientReceives) {
        this.clientReceives = clientReceives;
    }

    /**
     * @return the nameClientReceives
     */
    public String getNameClientReceives() {
        return nameClientReceives;
    }

    /**
     * @param nameClientReceives the nameClientReceives to set
     */
    public void setNameClientReceives(String nameClientReceives) {
        this.nameClientReceives = nameClientReceives;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the idVehicle
     */
    public long getIdVehicle() {
        return idVehicle;
    }

    /**
     * @param idVehicle the idVehicle to set
     */
    public void setIdVehicle(long idVehicle) {
        this.idVehicle = idVehicle;
    }

    /**
     * @return the brandVehicle
     */
    public String getBrandVehicle() {
        return brandVehicle;
    }

    /**
     * @param brandVehicle the brandVehicle to set
     */
    public void setBrandVehicle(String brandVehicle) {
        this.brandVehicle = brandVehicle;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the dateOrder
     */
    public Date getDateOrder() {
        return dateOrder;
    }

    /**
     * @param dateOrder the dateOrder to set
     */
    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     * @return the dateDelivery
     */
    public Date getDateDelivery() {
        return dateDelivery;
    }

    /**
     * @param dateDelivery the dateDelivery to set
     */
    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    /**
     * @return the idEmployee
     */
    public long getIdEmployee() {
        return idEmployee;
    }

    /**
     * @param idEmployee the idEmployee to set
     */
    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    /**
     * @return the nameDriver
     */
    public String getNameDriver() {
        return nameDriver;
    }

    /**
     * @param nameDriver the nameDriver to set
     */
    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }
}
