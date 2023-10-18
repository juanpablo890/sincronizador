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
import java.sql.Timestamp;

/**
 *
 * @author n6y
 */
public class RangoAVL {

    private long id;
    private long id_primero;
    private long id_ultimo;
    private long cantidad_insertada;
    private long cantidad_esperada;
    private boolean proceso_completo;
    private boolean reprocesado;
    private Timestamp created_at;

    public RangoAVL(long id, long id_primero, long id_ultimo, long cantidad_insertada, long cantidad_esperada, boolean proceso_completo, boolean reprocesado, Timestamp created_at) {
        this.id = id;
        this.id_primero = id_primero;
        this.id_ultimo = id_ultimo;
        this.cantidad_insertada = cantidad_insertada;
        this.cantidad_esperada = cantidad_esperada;
        this.proceso_completo = proceso_completo;
        this.reprocesado = reprocesado;
        this.created_at = created_at;
    }

    public RangoAVL(ResultSet rs) throws SQLException {
        this(rs.getLong("id"),
                rs.getLong("id_primero"),
                rs.getLong("id_ultimo"),
                rs.getLong("cantidad_insertada"),
                rs.getLong("cantidad_esperada"),
                rs.getBoolean("proceso_completo"),
                rs.getBoolean("reprocesado"),
                rs.getTimestamp("created_at")
               );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_primero() {
        return id_primero;
    }

    public void setId_primero(long id_primero) {
        this.id_primero = id_primero;
    }

    public long getId_ultimo() {
        return id_ultimo;
    }

    public void setId_ultimo(long id_ultimo) {
        this.id_ultimo = id_ultimo;
    }

    public long getCantidad_insertada() {
        return cantidad_insertada;
    }

    public void setCantidad_insertada(long cantidad_insertada) {
        this.cantidad_insertada = cantidad_insertada;
    }

    public long getCantidad_esperada() {
        return cantidad_esperada;
    }

    public void setCantidad_esperada(long cantidad_esperada) {
        this.cantidad_esperada = cantidad_esperada;
    }

    public boolean isProceso_completo() {
        return proceso_completo;
    }

    public void setProceso_completo(boolean proceso_completo) {
        this.proceso_completo = proceso_completo;
    }

    public boolean isReprocesado() {
        return reprocesado;
    }

    public void setReprocesado(boolean reprocesado) {
        this.reprocesado = reprocesado;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

}
