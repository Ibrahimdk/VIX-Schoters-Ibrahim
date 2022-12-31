package com.example.localeibra;

public class dataCart {
    private String ID;
    private String BRAND;
    private String TYPE;
    private String SEX;
    private String PRICE;
    private String SIZE;


    public dataCart(String ID, String BRAND, String TYPE, String SEX, String PRICE, String SIZE) {
        this.ID = ID;
        this.BRAND = BRAND;
        this.TYPE = TYPE;
        this.SEX = SEX;
        this.PRICE = PRICE;
        this.SIZE = SIZE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getSIZE() {
        return SIZE;
    }

    public void setSIZE(String SIZE) {
        this.SIZE = SIZE;
    }
}
