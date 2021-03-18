package com.company;

import java.util.ArrayList;

public class cuenta {
    private String Nombre_usuario;
    private String Password;
    private double montoInicial;
    private double deposito;
    private boolean primerIngreso = true;
    private ArrayList<Double> movimientos = new ArrayList<Double>();


    //Constructor
    public cuenta(String usuario, String pass, double montoInicial){
        this.Nombre_usuario=usuario;
        this.Password=pass;
        this.montoInicial=montoInicial;
    }


    //get y set
    public String getNombre_usuario() {
        return Nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        Nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String pass) {
        Password = pass;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double dinero) {
        this.montoInicial = dinero;
    }

    public double getDeposito() {
        return this.deposito;
    }

    public void setDeposito(double dinero) {
        this.deposito += dinero;
    }

    public ArrayList<Double> getMovimientos() {
        return movimientos;
    }

     //controlar movimientos
    public void setMovimientos(double dinero) {
        this.movimientos.add(dinero);
    }

    public boolean getPrimerIngreso() {
        return primerIngreso;
    }
    public void setPrimerIngreso(boolean p) {
        this.primerIngreso = p;
    }


       // verificar usuario y contraseña para ingreso
    public boolean ingreso(String usuario, String pass) {
        if (usuario.contains(this.Nombre_usuario) && pass.contains(this.Password)) {
            return true;
        } else {
            return false;
        }

    }

    //Inspeccionar si el monto inicial es mayor a 1500
    public boolean inspeccionar() {
        if (this.deposito >= 1500) {
            return true;
        } else {
            return false;
        }
    }

    //ver movimientos de retiro y deposito
    public void movi() {
        for (double m : this.movimientos) {
            if (m < 0) {
                System.out.println("Retiro: " + m);
            } else if (m > 0) {
                System.out.println("Depósito: " + m);
            }
        }
    }

    //Ver el total de movimientos
    public void totalMovi() {
        double total = 0;
        for (double m : this.movimientos) {
            total += m;
        }
        this.deposito = total;
    }


    }


