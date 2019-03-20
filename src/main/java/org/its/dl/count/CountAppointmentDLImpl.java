package org.its.dl.count;

import javax.inject.Named;
import java.util.HashMap;

@Named("countAppointmentDL")
public class CountAppointmentDLImpl implements CountAppointmentDL {

    HashMap<Integer, Integer> mapCountAppointment = new HashMap<>();


    @Override
    public void incrementAppointment(int idUtente) {
        if (mapCountAppointment.get(idUtente) == null){
            mapCountAppointment.put(idUtente, 1);
        } else {
            mapCountAppointment.put(idUtente, mapCountAppointment.get(idUtente)+1);
        }
    }

    @Override
    public void decrementAppointment(int idUtente) throws Exception {
        if (mapCountAppointment.get(idUtente) == null) {
            throw new Exception("Appuntamento non presente nella mappa di conteggio");
        } else {
            mapCountAppointment.put(idUtente, mapCountAppointment.get(idUtente)-1);
        }
    }

    @Override
    public int getAppointment(int idUtente) {
    return mapCountAppointment.get(idUtente);
    }
}
