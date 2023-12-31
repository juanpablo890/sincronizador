/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author n6y
 */
public class DescargaPagaBus {

    private long id_dgprs;
    private BigDecimal dTotalEfectivoRegistrado;
    private BigDecimal dTotalVentas;
    private BigDecimal dTotalVentasTarifa0;
    private BigDecimal dTotalVentasTarifa1;
    private BigDecimal dTotalVentasTarifa2;
    private BigDecimal dTotalVentasTarifa3;
    private BigDecimal dTotalVentasTarifa4;
    private BigDecimal dTotalVentasTarifa5;
    private BigDecimal dTotalVentasTarifa6;
    private BigDecimal dTotalVentasTarifa7;
    private BigDecimal dTotalVentasTarifa8;
    private BigDecimal dTotalVentasTarifa9;
    private Timestamp dFechaHoraEnvio;
    private String strModem_ID;
    private String noSerieAVLOriginal;
    private Timestamp dFechaHoraInsert;
    private int contadorCiclico;

    public DescargaPagaBus(long id_dgprs, BigDecimal dTotalEfectivoRegistrado, BigDecimal dTotalVentas, BigDecimal dTotalVentasTarifa0, BigDecimal dTotalVentasTarifa1, BigDecimal dTotalVentasTarifa2, BigDecimal dTotalVentasTarifa3, BigDecimal dTotalVentasTarifa4, BigDecimal dTotalVentasTarifa5, BigDecimal dTotalVentasTarifa6, BigDecimal dTotalVentasTarifa7, BigDecimal dTotalVentasTarifa8, BigDecimal dTotalVentasTarifa9, Timestamp dFechaHoraEnvio, String strModem_ID, String noSerieAVLOriginal, Timestamp dFechaHoraInsert, int contadorCiclico) {
        this.id_dgprs = id_dgprs;
        this.dTotalEfectivoRegistrado = dTotalEfectivoRegistrado;
        this.dTotalVentas = dTotalVentas;
        this.dTotalVentasTarifa0 = dTotalVentasTarifa0;
        this.dTotalVentasTarifa1 = dTotalVentasTarifa1;
        this.dTotalVentasTarifa2 = dTotalVentasTarifa2;
        this.dTotalVentasTarifa3 = dTotalVentasTarifa3;
        this.dTotalVentasTarifa4 = dTotalVentasTarifa4;
        this.dTotalVentasTarifa5 = dTotalVentasTarifa5;
        this.dTotalVentasTarifa6 = dTotalVentasTarifa6;
        this.dTotalVentasTarifa7 = dTotalVentasTarifa7;
        this.dTotalVentasTarifa8 = dTotalVentasTarifa8;
        this.dTotalVentasTarifa9 = dTotalVentasTarifa9;
        this.dFechaHoraEnvio = dFechaHoraEnvio;
        this.strModem_ID = strModem_ID;
        this.noSerieAVLOriginal = noSerieAVLOriginal;
        this.dFechaHoraInsert = dFechaHoraInsert;
        this.contadorCiclico = contadorCiclico;
    }

    

    public DescargaPagaBus(ResultSet rs) throws SQLException {
        this(rs.getLong("id_DGPRS"),
                rs.getBigDecimal("dTotalEfectivoRegistrado"),
                rs.getBigDecimal("dTotalVentas"),
                rs.getBigDecimal("dTotalVentasTarifa0"),
                rs.getBigDecimal("dTotalVentasTarifa1"),
                rs.getBigDecimal("dTotalVentasTarifa2"),
                rs.getBigDecimal("dTotalVentasTarifa3"),
                rs.getBigDecimal("dTotalVentasTarifa4"),
                rs.getBigDecimal("dTotalVentasTarifa5"),
                rs.getBigDecimal("dTotalVentasTarifa6"),
                rs.getBigDecimal("dTotalVentasTarifa7"),
                rs.getBigDecimal("dTotalVentasTarifa8"),
                rs.getBigDecimal("dTotalVentasTarifa9"),
                rs.getTimestamp("dFechaHoraEnvio"),
                rs.getString("strModem_ID"),
                rs.getString("NoSerieAVLOriginal"),
                rs.getTimestamp("dFechaHoraInsert"),
                rs.getInt("intContadorCiclico"));
    }

    public int getContadorCiclico() {
        return contadorCiclico;
    }

    public void setContadorCiclico(int contadorCiclico) {
        this.contadorCiclico = contadorCiclico;
    }

    public long getId_dgprs() {
        return id_dgprs;
    }

    public void setId_dgprs(long id_dgprs) {
        this.id_dgprs = id_dgprs;
    }

    public BigDecimal getdTotalEfectivoRegistrado() {
        return dTotalEfectivoRegistrado;
    }

    public void setdTotalEfectivoRegistrado(BigDecimal dTotalEfectivoRegistrado) {
        this.dTotalEfectivoRegistrado = dTotalEfectivoRegistrado;
    }

    public BigDecimal getdTotalVentas() {
        return dTotalVentas;
    }

    public void setdTotalVentas(BigDecimal dTotalVentas) {
        this.dTotalVentas = dTotalVentas;
    }

    public BigDecimal getdTotalVentasTarifa0() {
        return dTotalVentasTarifa0;
    }

    public void setdTotalVentasTarifa0(BigDecimal dTotalVentasTarifa0) {
        this.dTotalVentasTarifa0 = dTotalVentasTarifa0;
    }

    public BigDecimal getdTotalVentasTarifa1() {
        return dTotalVentasTarifa1;
    }

    public void setdTotalVentasTarifa1(BigDecimal dTotalVentasTarifa1) {
        this.dTotalVentasTarifa1 = dTotalVentasTarifa1;
    }

    public BigDecimal getdTotalVentasTarifa2() {
        return dTotalVentasTarifa2;
    }

    public void setdTotalVentasTarifa2(BigDecimal dTotalVentasTarifa2) {
        this.dTotalVentasTarifa2 = dTotalVentasTarifa2;
    }

    public BigDecimal getdTotalVentasTarifa3() {
        return dTotalVentasTarifa3;
    }

    public void setdTotalVentasTarifa3(BigDecimal dTotalVentasTarifa3) {
        this.dTotalVentasTarifa3 = dTotalVentasTarifa3;
    }

    public BigDecimal getdTotalVentasTarifa4() {
        return dTotalVentasTarifa4;
    }

    public void setdTotalVentasTarifa4(BigDecimal dTotalVentasTarifa4) {
        this.dTotalVentasTarifa4 = dTotalVentasTarifa4;
    }

    public BigDecimal getdTotalVentasTarifa5() {
        return dTotalVentasTarifa5;
    }

    public void setdTotalVentasTarifa5(BigDecimal dTotalVentasTarifa5) {
        this.dTotalVentasTarifa5 = dTotalVentasTarifa5;
    }

    public BigDecimal getdTotalVentasTarifa6() {
        return dTotalVentasTarifa6;
    }

    public void setdTotalVentasTarifa6(BigDecimal dTotalVentasTarifa6) {
        this.dTotalVentasTarifa6 = dTotalVentasTarifa6;
    }

    public BigDecimal getdTotalVentasTarifa7() {
        return dTotalVentasTarifa7;
    }

    public void setdTotalVentasTarifa7(BigDecimal dTotalVentasTarifa7) {
        this.dTotalVentasTarifa7 = dTotalVentasTarifa7;
    }

    public BigDecimal getdTotalVentasTarifa8() {
        return dTotalVentasTarifa8;
    }

    public void setdTotalVentasTarifa8(BigDecimal dTotalVentasTarifa8) {
        this.dTotalVentasTarifa8 = dTotalVentasTarifa8;
    }

    public BigDecimal getdTotalVentasTarifa9() {
        return dTotalVentasTarifa9;
    }

    public void setdTotalVentasTarifa9(BigDecimal dTotalVentasTarifa9) {
        this.dTotalVentasTarifa9 = dTotalVentasTarifa9;
    }

    public Timestamp getdFechaHoraEnvio() {
        return dFechaHoraEnvio;
    }

    public void setdFechaHoraEnvio(Timestamp dFechaHoraEnvio) {
        this.dFechaHoraEnvio = dFechaHoraEnvio;
    }

    public String getStrModem_ID() {
        return strModem_ID;
    }

    public void setStrModem_ID(String strModem_ID) {
        this.strModem_ID = strModem_ID;
    }

    public Timestamp getdFechaHoraInsert() {
        return dFechaHoraInsert;
    }

    public void setdFechaHoraInsert(Timestamp dFechaHoraInsert) {
        this.dFechaHoraInsert = dFechaHoraInsert;
    }

    public String getNoSerieAVLOriginal() {
        return noSerieAVLOriginal;
    }

    public void setNoSerieAVLOriginal(String noSerieAVLOriginal) {
        this.noSerieAVLOriginal = noSerieAVLOriginal;
    }
    
    
}
