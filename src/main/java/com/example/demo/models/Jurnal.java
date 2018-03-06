package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Jurnal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jurnalName;
    private int year;

    public Jurnal() {
        this.jurnalName = "" ;
        this.year = 0 ;
    }

    public Jurnal(String bookName, int year) {
        this.jurnalName = jurnalName;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJurnalName() {
        return jurnalName;
    }

    public void setJurnalName(String jurnalName) {
        this.jurnalName = jurnalName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

