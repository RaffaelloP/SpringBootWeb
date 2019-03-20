package org.its.bl.count;

import org.its.bl.appointment.AppointmentMessage;
import org.its.bus.Bus;
import org.its.bus.BusMessage;
import org.its.dl.appointment.AppointmentDL;
import org.its.dl.count.CountAppointmentDL;

import javax.inject.Named;

@Named("countAppointmentBL")
public class CountAppointmentBLImpl implements CountAppointmentBL {

    private final CountAppointmentDL countAppointmentDataLayer;
    private final AppointmentDL appointmentDataLayer;

    public CountAppointmentBLImpl(@Named("countAppointmentDL") CountAppointmentDL countAppointmentDataLayer,
                       @Named("appointmentDL") AppointmentDL appointmentDataLayer,
                       @Named("bus") Bus bus){
        this.countAppointmentDataLayer = countAppointmentDataLayer;
        this.appointmentDataLayer = appointmentDataLayer;
        bus.register(AppointmentMessage.class,  this);
    }

    @Override
    public int countAppointmentByIdUtente(int idUtente) {
        return countAppointmentDataLayer.getAppointment(idUtente);
    }

    @Override
    public void handle(BusMessage messageType) throws Exception {
        AppointmentMessage amsg = (AppointmentMessage) messageType ;
        if (amsg.getStateAppointment()){
            countAppointmentDataLayer.incrementAppointment(amsg.getIdUtente());
        } else {
            countAppointmentDataLayer.decrementAppointment(amsg.getIdUtente());
        }
    }
}
