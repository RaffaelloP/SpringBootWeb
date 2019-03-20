package org.its.bl.appointment;


import java.util.List;

public interface AppointmentBL {
    List<AppointmentBO> getAll();

    List<AppointmentBO> getByIdUtente(int idUtente);

    AppointmentBO add(AppointmentBO utenteBO) throws Exception;

    boolean delete(String id);

    AppointmentBO modifyAppointment(AppointmentBO utenteBO, String idUtente) throws Exception;
}
