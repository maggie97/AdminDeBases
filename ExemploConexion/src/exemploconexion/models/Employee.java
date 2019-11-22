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
public class Employee {
    private long id;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String workstation;
    private String NSS;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public String getFullName(){
        return name + ' ' + lastname;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the workstation
     */
    public String getWorkstation() {
        return workstation;
    }

    /**
     * @param workstation the workstation to set
     */
    public void setWorkstation(String workstation) {
        this.workstation = workstation;
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
     * @return the NSS
     */
    public String getNSS() {
        return NSS;
    }

    /**
     * @param NSS the NSS to set
     */
    public void setNSS(String NSS) {
        this.NSS = NSS;
    }
    
    
    
}
