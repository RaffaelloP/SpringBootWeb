package org.its.dl.appointment;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Named("appointmentDL")
public class AppointmentDLImpl implements AppointmentDL {

    HashMap<Integer, AppointmentDO> appointmentDLHashMap = new HashMap<Integer, AppointmentDO>();
    int maxId= 1;

    @Override
    public List<AppointmentDO> getAll() {
        return new ArrayList<AppointmentDO>(appointmentDLHashMap.values());
    }

    @Override
    public AppointmentDO add(AppointmentDO appointmentDO) {
        appointmentDO.setIdAppointment(maxId);
        maxId++;
        appointmentDLHashMap.put(appointmentDO.getIdAppointment(), appointmentDO);
        return appointmentDO;    }

    @Override
    public boolean delete(Integer IdAppointment) {
        if (!appointmentDLHashMap.containsKey(IdAppointment)){
            return  false;
        } else{
            appointmentDLHashMap.remove(IdAppointment);
            return true;
        }    }

    @Override
    public void update(AppointmentDO appointmentDO) throws Exception {
        if (!appointmentDLHashMap.containsKey(appointmentDO.getIdAppointment())) {
            throw new Exception("appointmentDO non presente");
        }
        appointmentDLHashMap.put(appointmentDO.getIdAppointment(), appointmentDO);
    }
}
