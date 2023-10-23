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
public class DescargaAVL {

    private long id;
    private int tipoAVL;
    private String modemID;
    private String noSerieAVLOriginal;
    private double fLongitud_grad;
    private double fLalitud_grad;
    private int velocidad;
    private int altitud;
    private int num_Sat;
    private int heading;
    private Timestamp dFecha_hora_Sat;
    private int tipo_evento;
    private int variable1;
    private int variable2;
    private int variable3;
    private int variable4;
    private Timestamp dFechaHoraComputadora;
    private int varControl;
    private int status;

    public DescargaAVL(long id, int tipoAVL, String modemID, String noSerieAVLOriginal, double fLongitud_grad, double fLalitud_grad, int velocidad, int altitud, int num_Sat, int heading, Timestamp dFecha_hora_Sat, int tipo_evento, int variable1, int variable2, int variable3, int variable4, Timestamp dFechaHoraComputadora, int varControl, int status) {
        this.id = id;
        this.tipoAVL = tipoAVL;
        this.modemID = modemID;
        this.noSerieAVLOriginal = noSerieAVLOriginal;
        this.fLongitud_grad = fLongitud_grad;
        this.fLalitud_grad = fLalitud_grad;
        this.velocidad = velocidad;
        this.altitud = altitud;
        this.num_Sat = num_Sat;
        this.heading = heading;
        this.dFecha_hora_Sat = dFecha_hora_Sat;
        this.tipo_evento = tipo_evento;
        this.variable1 = variable1;
        this.variable2 = variable2;
        this.variable3 = variable3;
        this.variable4 = variable4;
        this.dFechaHoraComputadora = dFechaHoraComputadora;
        this.varControl = varControl;
        this.status = status;
    }


    public DescargaAVL(ResultSet rs) throws SQLException {
        this(rs.getLong("id"),
                rs.getInt("intTipoAVL"),
                rs.getString("strModemID"),
                rs.getString("NoSerieAVLOriginal"),
                rs.getDouble("fLongitud_grad"),
                rs.getDouble("fLatitud_grad"),
                rs.getInt("intVelocidad"),
                rs.getInt("intAltitud"),
                rs.getInt("intNum_Sat"),
                rs.getInt("intHeading"),
                rs.getTimestamp("dFecha_Hora_SAT"),
                rs.getInt("intTipo_Evento"),
                rs.getInt("intVariable1"),
                rs.getInt("intVariable2"),
                rs.getInt("intVariable3"),
                rs.getInt("intVariable4"),
                rs.getTimestamp("dFechaHoraComputadora"),
                0,
                0);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTipoAVL() {
        return tipoAVL;
    }

    public void setTipoAVL(int tipoAVL) {
        this.tipoAVL = tipoAVL;
    }

    public String getModemID() {
        return modemID;
    }

    public void setModemID(String modemID) {
        this.modemID = modemID;
    }

    public double getfLongitud_grad() {
        return fLongitud_grad;
    }

    public void setfLongitud_grad(float fLongitud_grad) {
        this.fLongitud_grad = fLongitud_grad;
    }

    public double getfLalitud_grad() {
        return fLalitud_grad;
    }

    public void setfLalitud_grad(float fLalitud_grad) {
        this.fLalitud_grad = fLalitud_grad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public int getNum_Sat() {
        return num_Sat;
    }

    public void setNum_Sat(int num_Sat) {
        this.num_Sat = num_Sat;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public Timestamp getdFecha_hora_Sat() {
        return dFecha_hora_Sat;
    }

    public void setdFecha_hora_Sat(Timestamp dFecha_hora_Sat) {
        this.dFecha_hora_Sat = dFecha_hora_Sat;
    }

    public int getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(int tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public int getVariable1() {
        return variable1;
    }

    public void setVariable1(int variable1) {
        this.variable1 = variable1;
    }

    public int getVariable2() {
        return variable2;
    }

    public void setVariable2(int variable2) {
        this.variable2 = variable2;
    }

    public int getVariable3() {
        return variable3;
    }

    public void setVariable3(int variable3) {
        this.variable3 = variable3;
    }

    public int getVariable4() {
        return variable4;
    }

    public void setVariable4(int variable4) {
        this.variable4 = variable4;
    }

    public Timestamp getdFechaHoraComputadora() {
        return dFechaHoraComputadora;
    }

    public void setdFechaHoraComputadora(Timestamp dFechaHoraComputadora) {
        this.dFechaHoraComputadora = dFechaHoraComputadora;
    }

    public int getVarControl() {
        return varControl;
    }

    public void setVarControl(int varControl) {
        this.varControl = varControl;
    }

    public String getNoSerieAVLOriginal() {
        return noSerieAVLOriginal;
    }

    public void setNoSerieAVLOriginal(String noSerieAVLOriginal) {
        this.noSerieAVLOriginal = noSerieAVLOriginal;
    }
    
    
}
