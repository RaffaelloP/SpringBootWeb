package org.its.dl.appointment;

import java.util.List;

public interface AppointmentDL {
    List<AppointmentDO> getAll();

    AppointmentDO add(AppointmentDO appointmentDO);

    boolean delete(Integer id);

    void update(AppointmentDO appointmentDO) throws Exception;
}
