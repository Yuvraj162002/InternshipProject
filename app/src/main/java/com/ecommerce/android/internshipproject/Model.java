package com.ecommerce.android.internshipproject;

public class Model {

    String name;

    String eqty;
    String eunitprice;
    String eprice;

    public Model() {
    }

    public Model(String name,String eqty, String eunitprice, String eprice) {
        this.name = name;

       this.eqty = eqty;
        this.eunitprice = eunitprice;
        this.eprice = eprice;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return eqty;
    }

    public String getPiece() {
        return eunitprice;
    }

    public String getPrice() {
        return eprice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(String qty) {
        this.eqty = qty;
    }

    public void setPiece(String piece) {
        this.eunitprice = piece;
    }

    public void setPrice(String price) {
        this.eprice = price;
    }
}
