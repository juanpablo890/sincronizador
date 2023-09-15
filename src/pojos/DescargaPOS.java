/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 *
 * @author n6y
 */
public class DescargaPOS {

    private long id;
    private long id_DGPRS;
    private String strValidador;
    private String strIDTarjeta;
    private int intTipoTarjeta;
    private int intTipoEventoTarjeta;
    private int intSaldoInicialTarjeta;
    private int intSaldoFinalTarjeta;
    private Timestamp dFechaEventoTarjeta;
    private int intIDPuntoVenta;
    private int intFolioVenta;
    private int intVarControl;
    private int intStatus;
    private Timestamp dFechaAVL;
    private int intNumOperador;
    private int intFolioTarjeta;
    private String idFrameEvento;
    private int intRuta;
    private int intContadorCiclicoTrans;
    private int intIDProducto;
    private int intEntidad;
    private String strIDSAM;
    private int intIdEvento;
    private int IntSaldoUltimaRecarga;
    private Timestamp DtRecarga;
    private boolean BErrorRecarga;
    private boolean BEsVenta;
    private String GuidUsuario;
    private boolean BOffline;
    private String GuidFolio;
    private BigDecimal MSaldoPOSAnterior;
    private String strUID;
    private String strCSAM;
    private int intContadorCiclico;
    private String strModem_ID;
    private Timestamp dFechaHoraInsert;

    public DescargaPOS(long id, long id_DGPRS, String strValidador, String strIDTarjeta, int intTipoTarjeta, int intTipoEventoTarjeta, int intSaldoInicialTarjeta, int intSaldoFinalTarjeta, Timestamp dFechaEventoTarjeta, int intIDPuntoVenta, int intFolioVenta, int intVarControl, int intStatus, Timestamp dFechaAVL, int intNumOperador, int intFolioTarjeta, String idFrameEvento, int intRuta, int intContadorCiclicoTrans, int intIDProducto, int intEntidad, String strIDSAM, int intIdEvento, int IntSaldoUltimaRecarga, Timestamp DtRecarga, boolean BErrorRecarga, boolean BEsVenta, String GuidUsuario, boolean BOffline, String GuidFolio, BigDecimal MSaldoPOSAnterior, String strUID, String strCSAM, int intContadorCiclico, String strModem_ID, Timestamp dFechaHoraInsert) {
        this.id = id;
        this.id_DGPRS = id_DGPRS;
        this.strValidador = strValidador;
        this.strIDTarjeta = strIDTarjeta;
        this.intTipoTarjeta = intTipoTarjeta;
        this.intTipoEventoTarjeta = intTipoEventoTarjeta;
        this.intSaldoInicialTarjeta = intSaldoInicialTarjeta;
        this.intSaldoFinalTarjeta = intSaldoFinalTarjeta;
        this.dFechaEventoTarjeta = dFechaEventoTarjeta;
        this.intIDPuntoVenta = intIDPuntoVenta;
        this.intFolioVenta = intFolioVenta;
        this.intVarControl = intVarControl;
        this.intStatus = intStatus;
        this.dFechaAVL = dFechaAVL;
        this.intNumOperador = intNumOperador;
        this.intFolioTarjeta = intFolioTarjeta;
        this.idFrameEvento = idFrameEvento;
        this.intRuta = intRuta;
        this.intContadorCiclicoTrans = intContadorCiclicoTrans;
        this.intIDProducto = intIDProducto;
        this.intEntidad = intEntidad;
        this.strIDSAM = strIDSAM;
        this.intIdEvento = intIdEvento;
        this.IntSaldoUltimaRecarga = IntSaldoUltimaRecarga;
        this.DtRecarga = DtRecarga;
        this.BErrorRecarga = BErrorRecarga;
        this.BEsVenta = BEsVenta;
        this.GuidUsuario = GuidUsuario;
        this.BOffline = BOffline;
        this.GuidFolio = GuidFolio;
        this.MSaldoPOSAnterior = MSaldoPOSAnterior;
        this.strUID = strUID;
        this.strCSAM = strCSAM;
        this.intContadorCiclico = intContadorCiclico;
        this.strModem_ID = strModem_ID;
        this.dFechaHoraInsert = dFechaHoraInsert;
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

    public long getId_DGPRS() {
        return id_DGPRS;
    }

    public void setId_DGPRS(long id_DGPRS) {
        this.id_DGPRS = id_DGPRS;
    }

    public String getStrValidador() {
        return strValidador;
    }

    public void setStrValidador(String strValidador) {
        this.strValidador = strValidador;
    }

    public String getStrIDTarjeta() {
        return strIDTarjeta;
    }

    public void setStrIDTarjeta(String strIDTarjeta) {
        this.strIDTarjeta = strIDTarjeta;
    }

    public int getIntTipoTarjeta() {
        return intTipoTarjeta;
    }

    public void setIntTipoTarjeta(int intTipoTarjeta) {
        this.intTipoTarjeta = intTipoTarjeta;
    }

    public int getIntTipoEventoTarjeta() {
        return intTipoEventoTarjeta;
    }

    public void setIntTipoEventoTarjeta(int intTipoEventoTarjeta) {
        this.intTipoEventoTarjeta = intTipoEventoTarjeta;
    }

    public int getIntSaldoInicialTarjeta() {
        return intSaldoInicialTarjeta;
    }

    public void setIntSaldoInicialTarjeta(int intSaldoInicialTarjeta) {
        this.intSaldoInicialTarjeta = intSaldoInicialTarjeta;
    }

    public int getIntSaldoFinalTarjeta() {
        return intSaldoFinalTarjeta;
    }

    public void setIntSaldoFinalTarjeta(int intSaldoFinalTarjeta) {
        this.intSaldoFinalTarjeta = intSaldoFinalTarjeta;
    }

    public Timestamp getdFechaEventoTarjeta() {
        return dFechaEventoTarjeta;
    }

    public void setdFechaEventoTarjeta(Timestamp dFechaEventoTarjeta) {
        this.dFechaEventoTarjeta = dFechaEventoTarjeta;
    }

    public int getIntIDPuntoVenta() {
        return intIDPuntoVenta;
    }

    public void setIntIDPuntoVenta(int intIDPuntoVenta) {
        this.intIDPuntoVenta = intIDPuntoVenta;
    }

    public int getIntFolioVenta() {
        return intFolioVenta;
    }

    public void setIntFolioVenta(int intFolioVenta) {
        this.intFolioVenta = intFolioVenta;
    }

    public int getIntVarControl() {
        return intVarControl;
    }

    public void setIntVarControl(int intVarControl) {
        this.intVarControl = intVarControl;
    }

    public int getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(int intStatus) {
        this.intStatus = intStatus;
    }

    public Timestamp getdFechaAVL() {
        return dFechaAVL;
    }

    public void setdFechaAVL(Timestamp dFechaAVL) {
        this.dFechaAVL = dFechaAVL;
    }

    public int getIntNumOperador() {
        return intNumOperador;
    }

    public void setIntNumOperador(int intNumOperador) {
        this.intNumOperador = intNumOperador;
    }

    public int getIntFolioTarjeta() {
        return intFolioTarjeta;
    }

    public void setIntFolioTarjeta(int intFolioTarjeta) {
        this.intFolioTarjeta = intFolioTarjeta;
    }

    public String getIdFrameEvento() {
        return idFrameEvento;
    }

    public void setIdFrameEvento(String idFrameEvento) {
        this.idFrameEvento = idFrameEvento;
    }

    public int getIntRuta() {
        return intRuta;
    }

    public void setIntRuta(int intRuta) {
        this.intRuta = intRuta;
    }

    public int getIntContadorCiclicoTrans() {
        return intContadorCiclicoTrans;
    }

    public void setIntContadorCiclicoTrans(int intContadorCiclicoTrans) {
        this.intContadorCiclicoTrans = intContadorCiclicoTrans;
    }

    public int getIntIDProducto() {
        return intIDProducto;
    }

    public void setIntIDProducto(int intIDProducto) {
        this.intIDProducto = intIDProducto;
    }

    public int getIntEntidad() {
        return intEntidad;
    }

    public void setIntEntidad(int intEntidad) {
        this.intEntidad = intEntidad;
    }

    public String getStrIDSAM() {
        return strIDSAM;
    }

    public void setStrIDSAM(String strIDSAM) {
        this.strIDSAM = strIDSAM;
    }

    public int getIntIdEvento() {
        return intIdEvento;
    }

    public void setIntIdEvento(int intIdEvento) {
        this.intIdEvento = intIdEvento;
    }

    public int getIntSaldoUltimaRecarga() {
        return IntSaldoUltimaRecarga;
    }

    public void setIntSaldoUltimaRecarga(int IntSaldoUltimaRecarga) {
        this.IntSaldoUltimaRecarga = IntSaldoUltimaRecarga;
    }

    public Timestamp getDtRecarga() {
        return DtRecarga;
    }

    public void setDtRecarga(Timestamp DtRecarga) {
        this.DtRecarga = DtRecarga;
    }

    public boolean isBErrorRecarga() {
        return BErrorRecarga;
    }

    public void setBErrorRecarga(boolean BErrorRecarga) {
        this.BErrorRecarga = BErrorRecarga;
    }

    public boolean isBEsVenta() {
        return BEsVenta;
    }

    public void setBEsVenta(boolean BEsVenta) {
        this.BEsVenta = BEsVenta;
    }

    public String getGuidUsuario() {
        return GuidUsuario;
    }

    public void setGuidUsuario(String GuidUsuario) {
        this.GuidUsuario = GuidUsuario;
    }

    public boolean isBOffline() {
        return BOffline;
    }

    public void setBOffline(boolean BOffline) {
        this.BOffline = BOffline;
    }

    public String getGuidFolio() {
        return GuidFolio;
    }

    public void setGuidFolio(String GuidFolio) {
        this.GuidFolio = GuidFolio;
    }

    public BigDecimal getMSaldoPOSAnterior() {
        return MSaldoPOSAnterior;
    }

    public void setMSaldoPOSAnterior(BigDecimal MSaldoPOSAnterior) {
        this.MSaldoPOSAnterior = MSaldoPOSAnterior;
    }

    public String getStrUID() {
        return strUID;
    }

    public void setStrUID(String strUID) {
        this.strUID = strUID;
    }

    public String getStrCSAM() {
        return strCSAM;
    }

    public void setStrCSAM(String strCSAM) {
        this.strCSAM = strCSAM;
    }

    public int getIntContadorCiclico() {
        return intContadorCiclico;
    }

    public void setIntContadorCiclico(int intContadorCiclico) {
        this.intContadorCiclico = intContadorCiclico;
    }

    public String getStrModem_ID() {
        return strModem_ID;
    }

    public void setStrModem_ID(String strModem_ID) {
        this.strModem_ID = strModem_ID;
    }
}
