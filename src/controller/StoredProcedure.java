/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author n6y
 */
public class StoredProcedure {
    private CallableStatement prepareCall;
    private ResultSet resultset;

    public StoredProcedure(CallableStatement prepareCall, ResultSet resultset) {
        this.prepareCall = prepareCall;
        this.resultset = resultset;
    }

    public CallableStatement getPrepareCall() {
        return prepareCall;
    }

    public void setPrepareCall(CallableStatement prepareCall) {
        this.prepareCall = prepareCall;
    }

    public ResultSet getResultset() {
        return resultset;
    }

    public void setResultset(ResultSet resultset) {
        this.resultset = resultset;
    }
    
    
}
