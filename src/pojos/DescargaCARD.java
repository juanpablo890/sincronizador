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
public class DescargaCARD {

    private long id;
    private long id_dgprs;
    private String validator;
    private String idTarjeta;
    private int tipoTarjeta;
    private int tipoEvento;
    private int saldoInicial;
    private int saldoFinal;
    private Timestamp fechaEventoTarjeta;
    private int idPuntoVenta;
    private int folioVenta;
    private int varControl;
    private int status;
    private Timestamp dFechaAVL;
    private int numOperador;
    private int folioTarjeta;
    private String idFrameEvento;
    private int ruta;
    private int contadorCiclico;
    private int idProducto;
    private int entidad;
    private String dsam;
    private int idEvento;
    private String uid;
    private String consecutivoSAM;
    private String modemID;
    private Timestamp dFechaHoraInsert;

    public DescargaCARD(long id, long id_dgprs, String validator, String idTarjeta, int tipoTarjeta, int tipoEvento, int saldoInicial, int saldoFinal, Timestamp fechaEventoTarjeta, int idPuntoVenta, int folioVenta, int varControl, int status, Timestamp dFechaAVL, int numOperador, int folioTarjeta, String idFrameEvento, int ruta, int contadorCiclico, int idProducto, int entidad, String dsam, int idEvento, String uid, String consecutivoSAM, String modemID, Timestamp dFechaHoraInsert) {
        this.id = id;
        this.id_dgprs = id_dgprs;
        this.validator = validator;
        this.idTarjeta = idTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.tipoEvento = tipoEvento;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.fechaEventoTarjeta = fechaEventoTarjeta;
        this.idPuntoVenta = idPuntoVenta;
        this.folioVenta = folioVenta;
        this.varControl = varControl;
        this.status = status;
        this.dFechaAVL = dFechaAVL;
        this.numOperador = numOperador;
        this.folioTarjeta = folioTarjeta;
        this.idFrameEvento = idFrameEvento;
        this.ruta = ruta;
        this.contadorCiclico = contadorCiclico;
        this.idProducto = idProducto;
        this.entidad = entidad;
        this.dsam = dsam;
        this.idEvento = idEvento;
        this.uid = uid;
        this.consecutivoSAM = consecutivoSAM;
        this.modemID = modemID;
        this.dFechaHoraInsert = dFechaHoraInsert;
    }

    public DescargaCARD(ResultSet rs) throws SQLException {
        this(rs.getLong("id"),
                rs.getLong("id_DGPRS"),
                rs.getString("strValidador"),
                rs.getString("strIDTarjeta"),
                rs.getInt("intTipoTarjeta"),
                rs.getInt("intTipoEventoTarjeta"),
                rs.getInt("intSaldoInicialTarjeta"),
                rs.getInt("intSaldoFinalTarjeta"),
                rs.getTimestamp("dFechaEventoTarjeta"),
                rs.getInt("intIDPuntoVenta"),
                rs.getInt("intFolioVenta"),
                0,//rs.getInt("intVarControl"),
                0,//rs.getInt("intStatus"),
                rs.getTimestamp("dFechaAVL"),
                rs.getInt("intNumOperador"),
                rs.getInt("intFolioTarjeta"),
                rs.getString("idFrameEvento"),
                rs.getInt("intRuta"),
                rs.getInt("intContadorCiclicoTrans"),
                rs.getInt("intIDProducto"),
                rs.getInt("intEntidad"),
                rs.getString("strIDSAM"),
                rs.getInt("intIdEvento"),
                rs.getString("strUID"),
                rs.getString("strConsecutivoSAM"),
                rs.getString("strModem_ID"),
                rs.getTimestamp("dFechaHoraInsert"));
    }

    public Timestamp getdFechaHoraInsert() {
        return dFechaHoraInsert;
    }

    public void setdFechaHoraInsert(Timestamp dFechaHoraInsert) {
        this.dFechaHoraInsert = dFechaHoraInsert;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_dgprs() {
        return id_dgprs;
    }

    public void setId_dgprs(long id_dgprs) {
        this.id_dgprs = id_dgprs;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    public String getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(int tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public int getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(int saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Timestamp getFechaEventoTarjeta() {
        return fechaEventoTarjeta;
    }

    public void setFechaEventoTarjeta(Timestamp fechaEventoTarjeta) {
        this.fechaEventoTarjeta = fechaEventoTarjeta;
    }

    public int getIdPuntoVenta() {
        return idPuntoVenta;
    }

    public void setIdPuntoVenta(int idPuntoVenta) {
        this.idPuntoVenta = idPuntoVenta;
    }

    public int getFolioVenta() {
        return folioVenta;
    }

    public void setFolioVenta(int folioVenta) {
        this.folioVenta = folioVenta;
    }

    public int getVarControl() {
        return varControl;
    }

    public void setVarControl(int varControl) {
        this.varControl = varControl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getdFechaAVL() {
        return dFechaAVL;
    }

    public void setdFechaAVL(Timestamp dFechaAVL) {
        this.dFechaAVL = dFechaAVL;
    }

    public int getNumOperador() {
        return numOperador;
    }

    public void setNumOperador(int numOperador) {
        this.numOperador = numOperador;
    }

    public int getFolioTarjeta() {
        return folioTarjeta;
    }

    public void setFolioTarjeta(int folioTarjeta) {
        this.folioTarjeta = folioTarjeta;
    }

    public String getIdFrameEvento() {
        return idFrameEvento;
    }

    public void setIdFrameEvento(String idFrameEvento) {
        this.idFrameEvento = idFrameEvento;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public int getContadorCiclico() {
        return contadorCiclico;
    }

    public void setContadorCiclico(int contadorCiclico) {
        this.contadorCiclico = contadorCiclico;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getEntidad() {
        return entidad;
    }

    public void setEntidad(int entidad) {
        this.entidad = entidad;
    }

    public String getDsam() {
        return dsam;
    }

    public void setDsam(String dsam) {
        this.dsam = dsam;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getConsecutivoSAM() {
        return consecutivoSAM;
    }

    public void setConsecutivoSAM(String consecutivoSAM) {
        this.consecutivoSAM = consecutivoSAM;
    }

    public String getModemID() {
        return modemID;
    }

    public void setModemID(String modemID) {
        this.modemID = modemID;
    }
}
