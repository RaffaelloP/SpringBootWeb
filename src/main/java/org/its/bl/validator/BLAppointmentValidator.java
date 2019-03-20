package org.its.bl.validator;

import org.its.bl.appointment.AppointmentBO;

import java.util.List;

public interface BLAppointmentValidator {
    boolean validate(AppointmentBO appointmentBO, List<AppointmentBO> listAppointmentBO, String  source) throws Exception;

}
