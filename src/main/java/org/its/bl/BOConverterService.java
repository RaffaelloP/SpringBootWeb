package org.its.bl;

import org.its.bl.appointment.AppointmentBO;
import org.its.bl.user.UtenteBO;
import org.its.dl.appointment.AppointmentDO;
import org.its.dl.user.UtenteDL;
import org.its.pl.appointment.Appointment;

public class BOConverterService {

    public UtenteDL convertToUtenteDL(UtenteBO utenteBO){
        UtenteDL utenteDL = new UtenteDL(
                utenteBO.getId(),
                utenteBO.getName(),
                utenteBO.isEnabled());
        return  utenteDL;
    }

    public UtenteBO convertToUtenteBO(UtenteDL utenteDL){
        UtenteBO utenteBO = new UtenteBO(
                utenteDL.getId(),
                utenteDL.getName(),
                utenteDL.isEnabled());
        return  utenteBO;
    }



    public AppointmentBO convertToAppointmentBO(AppointmentDO appointmentDO){
        AppointmentBO appointmentBO = new AppointmentBO(
                appointmentDO.getIdAppointment(),
                appointmentDO.getIdUtente(),
                appointmentDO.getDataInizio(),
                appointmentDO.getDataFine(),
                appointmentDO.getTesto());
        return  appointmentBO;
    }

    public AppointmentDO convertToAppointmentDO(AppointmentBO appointmentBO) throws Exception{
        AppointmentDO appointmentDO = new AppointmentDO(
                appointmentBO.getIdAppointment(),
                appointmentBO.getIdUtente(),
                appointmentBO.getDataInizio(),
                appointmentBO.getDataFine(),
                appointmentBO.getTesto());
        return  appointmentDO;
    }
}
