/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author n6y
 */
public class DescargaOdometro {

    private long id_dgprs;
    private long bintOdometro;
    private String strModemID;
    private String noSerieAVLOriginal;
    private int intVarControl;

    public DescargaOdometro(long id_dgprs, long bintOdometro, String strModemID, String noSerieAVLOriginal, int intVarControl) {
        this.id_dgprs = id_dgprs;
        this.bintOdometro = bintOdometro;
        this.strModemID = strModemID;
        this.noSerieAVLOriginal = noSerieAVLOriginal;
        this.intVarControl = intVarControl;
    }

    

    public DescargaOdometro(ResultSet rs) throws SQLException {
        this(rs.getLong("id_DGPRS"),
                rs.getLong("bintOdometro"),
                rs.getString("strModemID"),
                rs.getString("NoSerieAVLOriginal"),
                rs.getInt("intVarControl"));
    }

    public long getId_dgprs() {
        return id_dgprs;
    }

    public void setId_dgprs(long id_dgprs) {
        this.id_dgprs = id_dgprs;
    }

    public long getBintOdometro() {
        return bintOdometro;
    }

    public void setBintOdometro(long bintOdometro) {
        this.bintOdometro = bintOdometro;
    }

    public String getStrModemID() {
        return strModemID;
    }

    public void setStrModemID(String strModemID) {
        this.strModemID = strModemID;
    }

    public int getIntVarControl() {
        return intVarControl;
    }

    public void setIntVarControl(int intVarControl) {
        this.intVarControl = intVarControl;
    }

    public String getNoSerieAVLOriginal() {
        return noSerieAVLOriginal;
    }

    public void setNoSerieAVLOriginal(String noSerieAVLOriginal) {
        this.noSerieAVLOriginal = noSerieAVLOriginal;
    }
    
    
}
