package org.its.pl;

import org.its.bl.appointment.AppointmentBO;
import org.its.bl.user.UtenteBO;
import org.its.pl.appointment.Appointment;
import org.its.pl.user.Utente;

public class PLConverterService {

    public Utente convertToUtente(UtenteBO utenteBO) throws Exception{
        Utente utente = new Utente(utenteBO.getId(), utenteBO.getName());
        return  utente;
    }

    public UtenteBO convertToUtenteBO(Utente utente){
        UtenteBO utenteBO = new UtenteBO(utente.getId(), utente.getName(), false);
        return  utenteBO;
    }

    public Appointment convertToAppointment(AppointmentBO appointmentBO) throws Exception{
        Appointment appointment = new Appointment(
                appointmentBO.getIdAppointment(),
                appointmentBO.getIdUtente(),
                appointmentBO.getDataInizio(),
                appointmentBO.getDataFine(),
                appointmentBO.getTesto());
        return  appointment;
    }

    public AppointmentBO convertToAppointmentBO(Appointment appointment){
        AppointmentBO appointmentBO = new AppointmentBO(
                appointment.getIdAppointment(),
                appointment.getIdUtente(),
                appointment.getDataInizio(),
                appointment.getDataFine(),
                appointment.getTesto());
        return  appointmentBO;
    }
}
