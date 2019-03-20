package org.its.bl.validator;

import org.its.bl.appointment.AppointmentBO;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named("blAppointmentValidator")
public class BLAppointmentValidatorImpl implements BLAppointmentValidator {

    @Override
    public boolean validate(AppointmentBO appointmentBO, List<AppointmentBO>listAppointmentBO, String source) throws Exception {
        if (listAppointmentBO.size() < 1) return true;
        for (int i = 0; i < listAppointmentBO.size(); i++) {
            if (source == "mod"){
                for (int j = 0; j < listAppointmentBO.size(); j++) {
                   if (appointmentBO.getIdAppointment() != listAppointmentBO.get(i).getIdAppointment()) {
                        if (overlap(listAppointmentBO.get(i).getDataInizio(),
                                listAppointmentBO.get(i).getDataFine(),
                                appointmentBO.getDataInizio(),
                                appointmentBO.getDataFine())){
                            return false;
                } }}
        } else if (overlap(listAppointmentBO.get(i).getDataInizio(),
                    listAppointmentBO.get(i).getDataFine(),
                    appointmentBO.getDataInizio(),
                    appointmentBO.getDataFine())) {
                return false;
            }
    }
        return true;

    }



    boolean overlap(Date start1, Date end1, Date start2, Date end2){
        return start1.getTime() <= end2.getTime() && start2.getTime() <= end1.getTime();
    }
}
