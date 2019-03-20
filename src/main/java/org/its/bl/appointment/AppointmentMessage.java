package org.its.bl.appointment;

import org.its.bus.BusMessage;

import java.util.HashMap;

public class AppointmentMessage implements BusMessage {


    private int idUtente = 0;
    HashMap<Integer, Boolean> stateAppointment = new HashMap<>();

    public  AppointmentMessage(int idUtente, Boolean add){
        this.stateAppointment.put(idUtente, add);
        this.idUtente = idUtente;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }



    public boolean getStateAppointment() {
        return  stateAppointment.get(this.idUtente);
    }


    public void setEnabled(int idUtente, boolean appointmentAdded) {
        stateAppointment.put(idUtente, appointmentAdded );
    }

}
