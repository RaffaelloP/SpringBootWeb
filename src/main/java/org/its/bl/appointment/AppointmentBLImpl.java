package org.its.bl.appointment;

import org.its.bl.BOConverterService;
import org.its.bl.validator.BLAppointmentValidator;
import org.its.bus.Bus;
import org.its.dl.appointment.AppointmentDL;
import org.its.dl.appointment.AppointmentDO;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("appointmentBL")
public class AppointmentBLImpl implements AppointmentBL {
    private final AppointmentDL dataLayer;
    private BLAppointmentValidator validator;
    private BOConverterService boConverterService = new BOConverterService();
    private Bus bus;
    public AppointmentBLImpl(@Named("appointmentDL") AppointmentDL dataLayer,
                             @Named("blAppointmentValidator") BLAppointmentValidator validator,
                             @Named("bus")Bus bus) {
        this.dataLayer = dataLayer;
        this.validator = validator;
        this.bus = bus;
    }

    @Override
    public List<AppointmentBO> getAll() {
        List<AppointmentBO> listaAppuntamentoBO = new ArrayList<AppointmentBO>();
        for (AppointmentDO appointmentDO : dataLayer.getAll()) {
            AppointmentBO appointmentBO = boConverterService.convertToAppointmentBO(appointmentDO);
            listaAppuntamentoBO.add(appointmentBO);
        }
        return listaAppuntamentoBO;
    }

    @Override
    public List<AppointmentBO> getByIdUtente(int idUtente) {
        List<AppointmentBO> listaAppuntamentoBO = new ArrayList<AppointmentBO>();
        for (AppointmentDO appointmentDO : dataLayer.getAll()) {
            if (appointmentDO.getIdUtente() == idUtente) {
                AppointmentBO appointmentBO = boConverterService.convertToAppointmentBO(appointmentDO);
                listaAppuntamentoBO.add(appointmentBO);
            }
        }
        return listaAppuntamentoBO;
    }

    @Override
    public AppointmentBO add(AppointmentBO appointmentBO) throws Exception {
        List<AppointmentBO> listToTest = getByIdUtente(appointmentBO.getIdUtente());
        if (validator.validate(appointmentBO,listToTest, "add")) {
            AppointmentDO appointmentDO = boConverterService.convertToAppointmentDO(appointmentBO);
            AppointmentBO responseAppointmentBO = boConverterService.convertToAppointmentBO(dataLayer.add(appointmentDO));
            bus.send(new AppointmentMessage(appointmentBO.getIdUtente(), true));
            return responseAppointmentBO;
        } else throw new Exception("Data già impegnata");

    }

    @Override
    public boolean delete(String id) {
        String error;
        try {
            int parsedId = Integer.parseInt(id);
            bus.send(new AppointmentMessage(parsedId, false));
            return dataLayer.delete(parsedId);
        } catch (NumberFormatException f) {
            error = "Non è un numero";
            return false;
        }
    }

    @Override
    public AppointmentBO modifyAppointment(AppointmentBO appointmentBO, String idUtente) throws Exception {
        List<AppointmentBO> listToTest = getAll();
        if (validator.validate(appointmentBO, listToTest, "mod")) {
            AppointmentDO appointmentDO = boConverterService.convertToAppointmentDO(appointmentBO);
            dataLayer.update(appointmentDO);
            return appointmentBO;
        } else  throw new Exception("Impossibile modificare l'utente");
    }
}
