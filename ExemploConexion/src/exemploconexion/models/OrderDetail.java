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
public class OrderDetail {
    private long id;
    private Product product;
    private int quantity;
    private int discount;
    private int taxes;
    private double price;
    
    public OrderDetail(Product p, int quantity, int discount, int taxes, double price){
        this.product = p;
        this.price = price - price * discount + price * taxes;
        this.quantity = quantity;
        this.discount = discount;
        this.taxes = taxes;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @return the taxes
     */
    public int getTaxes() {
        return taxes;
    }

    /**
     * @param taxes the taxes to set
     */
    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
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
}
