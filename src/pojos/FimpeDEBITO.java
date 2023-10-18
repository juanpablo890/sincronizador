/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author n6y
 */
public class FimpeDEBITO {

    private String intNumArch;
    private long id;
    private int intTipoTarjeta;
    private int intTipoEventoTarjeta;
    private int intIDProducto;
    private int idSIR;
    private int idEmpresa;
    private String corredor;
    private String fIdentidad;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private BigDecimal c5;
    private BigDecimal c6;
    private BigDecimal c7;
    private String c8;
    private String c9;
    private String c10;
    private int c11;
    private BigDecimal c12;
    private BigDecimal c13;
    private String c14;
    private String c15;
    private String c16;
    private String c17;
    private String c172;
    private String c18;
    private int estatus;

    public FimpeDEBITO(String intNumArch, long id, int intTipoTarjeta, int intTipoEventoTarjeta, int intIDProducto, int idSIR, int idEmpresa, String corredor, String fIdentidad, String c1, String c2, String c3, String c4, BigDecimal c5, BigDecimal c6, BigDecimal c7, String c8, String c9, String c10, int c11, BigDecimal c12, BigDecimal c13, String c14, String c15, String c16, String c17, String c172, String c18, int estatus) {
        this.intNumArch = intNumArch;
        this.id = id;
        this.intTipoTarjeta = intTipoTarjeta;
        this.intTipoEventoTarjeta = intTipoEventoTarjeta;
        this.intIDProducto = intIDProducto;
        this.idSIR = idSIR;
        this.idEmpresa = idEmpresa;
        this.corredor = corredor;
        this.fIdentidad = fIdentidad;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
        this.c8 = c8;
        this.c9 = c9;
        this.c10 = c10;
        this.c11 = c11;
        this.c12 = c12;
        this.c13 = c13;
        this.c14 = c14;
        this.c15 = c15;
        this.c16 = c16;
        this.c17 = c17;
        this.c172 = c172;
        this.c18 = c18;
        this.estatus = estatus;
    }

    

    public FimpeDEBITO(ResultSet rs) throws SQLException {
        this(rs.getString("intNumArch"),
                rs.getLong("id"),
                rs.getInt("intTipoTarjeta"),
                rs.getInt("intTipoEventoTarjeta"),
                rs.getInt("intIDProducto"),
                rs.getInt("IdSIR"),
                rs.getInt("IdEmpresa"),
                rs.getString("Corredor"),
                rs.getString("FIdentidad"),
                rs.getString("C1"),
                rs.getString("C2"),
                rs.getString("C3"),
                rs.getString("C4"),
                rs.getBigDecimal("C5"),
                rs.getBigDecimal("C6"),
                rs.getBigDecimal("C7"),
                rs.getString("C8"),
                rs.getString("C9"),
                rs.getString("C10"),
                rs.getInt("C11"),
                rs.getBigDecimal("C12"),
                rs.getBigDecimal("C13"),
                rs.getString("C14"),
                null,//rs.getString("C15"),
                null,//rs.getString("C16"),
                rs.getString("C17"),
                rs.getString("C172"),
                null,//rs.getString("C18"),
                rs.getInt("Estatus"));
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getIntNumArch() {
        return intNumArch;
    }

    public void setIntNumArch(String intNumArch) {
        this.intNumArch = intNumArch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getIntIDProducto() {
        return intIDProducto;
    }

    public void setIntIDProducto(int intIDProducto) {
        this.intIDProducto = intIDProducto;
    }

    public int getIdSIR() {
        return idSIR;
    }

    public void setIdSIR(int idSIR) {
        this.idSIR = idSIR;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public String getfIdentidad() {
        return fIdentidad;
    }

    public void setfIdentidad(String fIdentidad) {
        this.fIdentidad = fIdentidad;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public BigDecimal getC5() {
        return c5;
    }

    public void setC5(BigDecimal c5) {
        this.c5 = c5;
    }

    public BigDecimal getC6() {
        return c6;
    }

    public void setC6(BigDecimal c6) {
        this.c6 = c6;
    }

    public BigDecimal getC7() {
        return c7;
    }

    public void setC7(BigDecimal c7) {
        this.c7 = c7;
    }

    public String getC8() {
        return c8;
    }

    public void setC8(String c8) {
        this.c8 = c8;
    }

    public String getC9() {
        return c9;
    }

    public void setC9(String c9) {
        this.c9 = c9;
    }

    public String getC10() {
        return c10;
    }

    public void setC10(String c10) {
        this.c10 = c10;
    }

    public int getC11() {
        return c11;
    }

    public void setC11(int c11) {
        this.c11 = c11;
    }

    public BigDecimal getC12() {
        return c12;
    }

    public void setC12(BigDecimal c12) {
        this.c12 = c12;
    }

    public BigDecimal getC13() {
        return c13;
    }

    public void setC13(BigDecimal c13) {
        this.c13 = c13;
    }

    public String getC14() {
        return c14;
    }

    public void setC14(String c14) {
        this.c14 = c14;
    }
    
    public String getC15() {
        return c15;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    public String getC16() {
        return c16;
    }

    public void setC16(String c16) {
        this.c16 = c16;
    }

    public String getC18() {
        return c18;
    }

    public void setC18(String c18) {
        this.c18 = c18;
    }

    public String getC17() {
        return c17;
    }

    public void setC17(String c17) {
        this.c17 = c17;
    }

    public String getC172() {
        return c172;
    }

    public void setC172(String c172) {
        this.c172 = c172;
    }

}
