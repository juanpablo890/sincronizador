/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 *
 * @author n6y
 */
public class OPERecharge {

    private long id;
    private long id_shift;
    private long id_beneficiary;
    private String uid_card;
    private String operation;
    private String product;
    private double initial_balance;
    private double final_balance;
    private long travels;
    private long surplus_trips;
    private String start_date;
    private String expiration_date;
    private String created_at;
    private String updated_at;
    private boolean status;
    private BigDecimal amount;
    private String profile;

    public OPERecharge(long id, long id_shift, long id_beneficiary, String uid_card, String operation, String product, double initial_balance, double final_balance, long travels, long surplus_trips, String start_date, String expiration_date, String created_at, String updated_at, boolean status, BigDecimal amount, String profile) {
        this.id = id;
        this.id_shift = id_shift;
        this.id_beneficiary = id_beneficiary;
        this.uid_card = uid_card;
        this.operation = operation;
        this.product = product;
        this.initial_balance = initial_balance;
        this.final_balance = final_balance;
        this.travels = travels;
        this.surplus_trips = surplus_trips;
        this.start_date = start_date;
        this.expiration_date = expiration_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
        this.amount = amount;
        this.profile = profile;
    }

    public OPERecharge(ResultSet rs) {
        System.out.println("");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_shift() {
        return id_shift;
    }

    public void setId_shift(long id_shift) {
        this.id_shift = id_shift;
    }

    public long getId_beneficiary() {
        return id_beneficiary;
    }

    public void setId_beneficiary(long id_beneficiary) {
        this.id_beneficiary = id_beneficiary;
    }

    public String getUid_card() {
        return uid_card;
    }

    public void setUid_card(String uid_card) {
        this.uid_card = uid_card;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getInitial_balance() {
        return initial_balance;
    }

    public void setInitial_balance(double initial_balance) {
        this.initial_balance = initial_balance;
    }

    public double getFinal_balance() {
        return final_balance;
    }

    public void setFinal_balance(double final_balance) {
        this.final_balance = final_balance;
    }

    public long getTravels() {
        return travels;
    }

    public void setTravels(long travels) {
        this.travels = travels;
    }

    public long getSurplus_trips() {
        return surplus_trips;
    }

    public void setSurplus_trips(long surplus_trips) {
        this.surplus_trips = surplus_trips;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
