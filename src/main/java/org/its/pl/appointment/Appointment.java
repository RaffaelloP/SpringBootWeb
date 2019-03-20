package org.its.pl.appointment;

import java.util.Date;

public class Appointment {
    private  int idAppointment;
    private int idUtente;
    private Date dataInizio;
    private Date dataFine;
    private String testo;

    public Appointment(int idAppointment, int idUtente, Date dataInizio, Date dataFine, String testo) {
        this.idAppointment = idAppointment;
        this.idUtente = idUtente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.testo = testo;
    }

    public  Appointment(){}

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }
}
