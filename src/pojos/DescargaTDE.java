/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author n6y
 */
public class DescargaTDE {

    private long id_dgprs;
    private int intTipoFrame;
    private int intSubidas_Pta1;
    private int intBajadas_Pta1;
    private int intBloqueos_Pta1;
    private int intPablos_Pta1;
    private int intSubidas_Pta2;
    private int intBajadas_Pta2;
    private int intBloqueos_Pta2;
    private int intPablos_Pta2;
    private int intNumOperador;
    private int intBanderaLiquidacion;
    private int intVarControl;
    private int intNumApagados_Pta1;
    private int intNumApagados_Pta2;
    private int intId_Asignacion;
    private int intStatus;
    private String strModem_ID;
    private String noSerieAVLOriginal;
    private Timestamp dFehaHoraInsert;

    public DescargaTDE(long id_dgprs, int intTipoFrame, int intSubidas_Pta1, int intBajadas_Pta1, int intBloqueos_Pta1, int intPablos_Pta1, int intSubidas_Pta2, int intBajadas_Pta2, int intBloqueos_Pta2, int intPablos_Pta2, int intNumOperador, int intBanderaLiquidacion, int intVarControl, int intNumApagados_Pta1, int intNumApagados_Pta2, int intId_Asignacion, int intStatus, String strModem_ID, String noSerieAVLOriginal, Timestamp dFehaHoraInsert) {
        this.id_dgprs = id_dgprs;
        this.intTipoFrame = intTipoFrame;
        this.intSubidas_Pta1 = intSubidas_Pta1;
        this.intBajadas_Pta1 = intBajadas_Pta1;
        this.intBloqueos_Pta1 = intBloqueos_Pta1;
        this.intPablos_Pta1 = intPablos_Pta1;
        this.intSubidas_Pta2 = intSubidas_Pta2;
        this.intBajadas_Pta2 = intBajadas_Pta2;
        this.intBloqueos_Pta2 = intBloqueos_Pta2;
        this.intPablos_Pta2 = intPablos_Pta2;
        this.intNumOperador = intNumOperador;
        this.intBanderaLiquidacion = intBanderaLiquidacion;
        this.intVarControl = intVarControl;
        this.intNumApagados_Pta1 = intNumApagados_Pta1;
        this.intNumApagados_Pta2 = intNumApagados_Pta2;
        this.intId_Asignacion = intId_Asignacion;
        this.intStatus = intStatus;
        this.strModem_ID = strModem_ID;
        this.noSerieAVLOriginal = noSerieAVLOriginal;
        this.dFehaHoraInsert = dFehaHoraInsert;
    }

    

    public DescargaTDE(ResultSet rs) throws SQLException {
        this(rs.getLong("id_DGPRS"),
                rs.getInt("intTipoFrame"),
                rs.getInt("intSubidas_Pta1"),
                rs.getInt("intBajadas_Pta1"),
                rs.getInt("intBloqueos_Pta1"),
                rs.getInt("intPablos_Pta1"),
                rs.getInt("intSubidas_Pta2"),
                rs.getInt("intBajadas_Pta2"),
                rs.getInt("intBloqueos_Pta2"),
                rs.getInt("intPablos_Pta2"),
                rs.getInt("intNumOperador"),
                rs.getInt("intBanderaLiquidacion"),
                0,//rs.getInt("intVarControl"),
                rs.getInt("intNumApagados_Pta1"),
                rs.getInt("intNumApagados_Pta2"),
                0,//rs.getInt("intId_Asignacion"),
                0,
                rs.getString("strModem_ID"),
                rs.getString("NoSerieAVLOriginal"),
                rs.getTimestamp("dFechaHoraInsert"));
    }

    public Timestamp getdFehaHoraInsert() {
        return dFehaHoraInsert;
    }

    public void setdFehaHoraInsert(Timestamp dFehaHoraInsert) {
        this.dFehaHoraInsert = dFehaHoraInsert;
    }

    public long getId_dgprs() {
        return id_dgprs;
    }

    public void setId_dgprs(long id_dgprs) {
        this.id_dgprs = id_dgprs;
    }

    public int getIntTipoFrame() {
        return intTipoFrame;
    }

    public void setIntTipoFrame(int intTipoFrame) {
        this.intTipoFrame = intTipoFrame;
    }

    public int getIntSubidas_Pta1() {
        return intSubidas_Pta1;
    }

    public void setIntSubidas_Pta1(int intSubidas_Pta1) {
        this.intSubidas_Pta1 = intSubidas_Pta1;
    }

    public int getIntBajadas_Pta1() {
        return intBajadas_Pta1;
    }

    public void setIntBajadas_Pta1(int intBajadas_Pta1) {
        this.intBajadas_Pta1 = intBajadas_Pta1;
    }

    public int getIntBloqueos_Pta1() {
        return intBloqueos_Pta1;
    }

    public void setIntBloqueos_Pta1(int intBloqueos_Pta1) {
        this.intBloqueos_Pta1 = intBloqueos_Pta1;
    }

    public int getIntPablos_Pta1() {
        return intPablos_Pta1;
    }

    public void setIntPablos_Pta1(int intPablos_Pta1) {
        this.intPablos_Pta1 = intPablos_Pta1;
    }

    public int getIntSubidas_Pta2() {
        return intSubidas_Pta2;
    }

    public void setIntSubidas_Pta2(int intSubidas_Pta2) {
        this.intSubidas_Pta2 = intSubidas_Pta2;
    }

    public int getIntBajadas_Pta2() {
        return intBajadas_Pta2;
    }

    public void setIntBajadas_Pta2(int intBajadas_Pta2) {
        this.intBajadas_Pta2 = intBajadas_Pta2;
    }

    public int getIntBloqueos_Pta2() {
        return intBloqueos_Pta2;
    }

    public void setIntBloqueos_Pta2(int intBloqueos_Pta2) {
        this.intBloqueos_Pta2 = intBloqueos_Pta2;
    }

    public int getIntPablos_Pta2() {
        return intPablos_Pta2;
    }

    public void setIntPablos_Pta2(int intPablos_Pta2) {
        this.intPablos_Pta2 = intPablos_Pta2;
    }

    public int getIntNumOperador() {
        return intNumOperador;
    }

    public void setIntNumOperador(int intNumOperador) {
        this.intNumOperador = intNumOperador;
    }

    public int getIntBanderaLiquidacion() {
        return intBanderaLiquidacion;
    }

    public void setIntBanderaLiquidacion(int intBanderaLiquidacion) {
        this.intBanderaLiquidacion = intBanderaLiquidacion;
    }

    public int getIntVarControl() {
        return intVarControl;
    }

    public void setIntVarControl(int intVarControl) {
        this.intVarControl = intVarControl;
    }

    public int getIntNumApagados_Pta1() {
        return intNumApagados_Pta1;
    }

    public void setIntNumApagados_Pta1(int intNumApagados_Pta1) {
        this.intNumApagados_Pta1 = intNumApagados_Pta1;
    }

    public int getIntNumApagados_Pta2() {
        return intNumApagados_Pta2;
    }

    public void setIntNumApagados_Pta2(int intNumApagados_Pta2) {
        this.intNumApagados_Pta2 = intNumApagados_Pta2;
    }

    public int getIntId_Asignacion() {
        return intId_Asignacion;
    }

    public void setIntId_Asignacion(int intId_Asignacion) {
        this.intId_Asignacion = intId_Asignacion;
    }

    public int getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(int intStatus) {
        this.intStatus = intStatus;
    }

    public String getStrModem_ID() {
        return strModem_ID;
    }

    public void setStrModem_ID(String strModem_ID) {
        this.strModem_ID = strModem_ID;
    }

    public String getNoSerieAVLOriginal() {
        return noSerieAVLOriginal;
    }

    public void setNoSerieAVLOriginal(String noSerieAVLOriginal) {
        this.noSerieAVLOriginal = noSerieAVLOriginal;
    }
    
    

}
