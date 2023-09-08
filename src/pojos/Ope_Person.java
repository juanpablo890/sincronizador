/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Date;

/**
 *
 * @author Juan Pablo
 */
public class Ope_Person {
    private long id;
    private String name;
    private String first_last_name;
    private String second_last_name;
    private String curp;
    private String gender;
    private Date created_at;
    private Date updated_at;
    private boolean status;
    private Date birth_date;

    public Ope_Person(long id, String name, String first_last_name, String second_last_name, String curp, String gender, Date created_at, Date updated_at, boolean status, Date birth_date) {
        this.id = id;
        this.name = name;
        this.first_last_name = first_last_name;
        this.second_last_name = second_last_name;
        this.curp = curp;
        this.gender = gender;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
        this.birth_date = birth_date;
    }

    public Ope_Person() {
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_last_name() {
        return first_last_name;
    }

    public void setFirst_last_name(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
    
    
}
