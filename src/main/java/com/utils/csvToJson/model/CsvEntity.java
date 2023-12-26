package com.utils.csvToJson.model;

public class CsvEntity {

    private String aa;
    private String bb;
    private String cc;

    public CsvEntity(String aa, String bb, String cc) {
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
    }

    // Getters and setters

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
