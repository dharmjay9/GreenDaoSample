package com.katerra.greendaosample.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by divum on 24/12/17.
 */
@Entity
public class Student2 {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String devision;
    private int standerd;
    private String address;
    private String contact;
    @Generated(hash = 738845837)
    public Student2(Long id, String name, String devision, int standerd,
            String address, String contact) {
        this.id = id;
        this.name = name;
        this.devision = devision;
        this.standerd = standerd;
        this.address = address;
        this.contact = contact;
    }
    @Generated(hash = 1706727078)
    public Student2() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDevision() {
        return this.devision;
    }
    public void setDevision(String devision) {
        this.devision = devision;
    }
    public int getStanderd() {
        return this.standerd;
    }
    public void setStanderd(int standerd) {
        this.standerd = standerd;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContact() {
        return this.contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
}
