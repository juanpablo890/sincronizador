/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 *
 * @author Juan Pablo
 */
public class OPETransaction {
//
    private long id;
    private long collection_id;
    private String transaction_type;
    private String transaction_folio;
    private String event_date;
    private String card_uid;
    private String product;
    private String ruta;
    private BigDecimal amount;
    private String ini_vig_prod;
    private String fin_vig_prod;
    private String ini_val_day;
    private String fin_val_day;
    private double initial_balance;
    private double final_balance;
    private String station_id;
    private String uid_sam;
    private long consecutive_sam;
    private long consecutive_app;
    private Double latitude;
    private Double longitude;
    private String recharge_type;
    private String debit_type;
    private String sign_parameters;
    private String sign_transaction;
    private String device_id;
    private long profile_code;
    private String created_at;
    private String updated_at;
    private boolean status;
    private String previous_card;

    public OPETransaction(long id, long collection_id, String transaction_type, String transaction_folio, String event_date, String card_uid, String product, String ruta, BigDecimal amount, String ini_vig_prod, String fin_vig_prod, String ini_val_day, String fin_val_day, double initial_balance, double final_balance, String station_id, String uid_sam, long consecutive_sam, long consecutive_app, Double latitude, Double longitude, String recharge_type, String debit_type, String sign_parameters, String sign_transaction, String device_id, long profile_code, String created_at, String updated_at, boolean status, String previous_card) {
        this.id = id;
        this.collection_id = collection_id;
        this.transaction_type = transaction_type;
        this.transaction_folio = transaction_folio;
        this.event_date = event_date;
        this.card_uid = card_uid;
        this.product = product;
        this.ruta = ruta;
        this.amount = amount;
        this.ini_vig_prod = ini_vig_prod;
        this.fin_vig_prod = fin_vig_prod;
        this.ini_val_day = ini_val_day;
        this.fin_val_day = fin_val_day;
        this.initial_balance = initial_balance;
        this.final_balance = final_balance;
        this.station_id = station_id;
        this.uid_sam = uid_sam;
        this.consecutive_sam = consecutive_sam;
        this.consecutive_app = consecutive_app;
        this.latitude = latitude;
        this.longitude = longitude;
        this.recharge_type = recharge_type;
        this.debit_type = debit_type;
        this.sign_parameters = sign_parameters;
        this.sign_transaction = sign_transaction;
        this.device_id = device_id;
        this.profile_code = profile_code;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
        this.previous_card = previous_card;
    }

    public OPETransaction(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getPrevious_card() {
        return previous_card;
    }

    public void setPrevious_card(String previous_card) {
        this.previous_card = previous_card;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(long collection_id) {
        this.collection_id = collection_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getTransaction_folio() {
        return transaction_folio;
    }

    public void setTransaction_folio(String transaction_folio) {
        this.transaction_folio = transaction_folio;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getCard_uid() {
        return card_uid;
    }

    public void setCard_uid(String card_uid) {
        this.card_uid = card_uid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIni_vig_prod() {
        return ini_vig_prod;
    }

    public void setIni_vig_prod(String ini_vig_prod) {
        this.ini_vig_prod = ini_vig_prod;
    }

    public String getFin_vig_prod() {
        return fin_vig_prod;
    }

    public void setFin_vig_prod(String fin_vig_prod) {
        this.fin_vig_prod = fin_vig_prod;
    }

    public String getIni_val_day() {
        return ini_val_day;
    }

    public void setIni_val_day(String ini_val_day) {
        this.ini_val_day = ini_val_day;
    }

    public String getFin_val_day() {
        return fin_val_day;
    }

    public void setFin_val_day(String fin_val_day) {
        this.fin_val_day = fin_val_day;
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

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getUid_sam() {
        return uid_sam;
    }

    public void setUid_sam(String uid_sam) {
        this.uid_sam = uid_sam;
    }

    public long getConsecutive_sam() {
        return consecutive_sam;
    }

    public void setConsecutive_sam(long consecutive_sam) {
        this.consecutive_sam = consecutive_sam;
    }

    public long getConsecutive_app() {
        return consecutive_app;
    }

    public void setConsecutive_app(long consecutive_app) {
        this.consecutive_app = consecutive_app;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRecharge_type() {
        return recharge_type;
    }

    public void setRecharge_type(String recharge_type) {
        this.recharge_type = recharge_type;
    }

    public String getDebit_type() {
        return debit_type;
    }

    public void setDebit_type(String debit_type) {
        this.debit_type = debit_type;
    }

    public String getSign_parameters() {
        return sign_parameters;
    }

    public void setSign_parameters(String sign_parameters) {
        this.sign_parameters = sign_parameters;
    }

    public String getSign_transaction() {
        return sign_transaction;
    }

    public void setSign_transaction(String ign_transaction) {
        this.sign_transaction = ign_transaction;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public long getProfile_code() {
        return profile_code;
    }

    public void setProfile_code(long profile_code) {
        this.profile_code = profile_code;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
