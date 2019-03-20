package org.its.pl.appointment;

import org.its.bl.appointment.AppointmentBL;
import org.its.bl.appointment.AppointmentBO;
import org.its.pl.PLConverterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/utente")
public class AppointmentController {
    private PLConverterService plConverterService = new PLConverterService() ;
    private final AppointmentBL businessLayer;

    @Inject
    public AppointmentController(
            @Named("appointmentBL")AppointmentBL businessLayer){
        this.businessLayer = businessLayer; }

    //post
    @RequestMapping(
            path = "/addAppointment",
            method= RequestMethod.POST,
            produces="application/json",
            consumes = "application/json")
    @ResponseBody
    public Appointment addAppointment(@RequestBody Appointment request) throws Exception{
        AppointmentBO appointmentBO = plConverterService.convertToAppointmentBO(request);
        AppointmentBO responsePostUtenteBO = businessLayer.add(appointmentBO);
        Appointment response = plConverterService.convertToAppointment(responsePostUtenteBO);
        return response;
        }



    //getAll
    @RequestMapping(
            path = "/getAllAppointment",
            method = RequestMethod.GET,
            produces = "application/json")

    @ResponseBody
    public List<Appointment> getAllAppointments() {
        List<Appointment> result = new ArrayList<Appointment>();
        for (AppointmentBO appointmentBO: businessLayer.getAll()){
            Appointment appointment = null;
            try {
                appointment = plConverterService.convertToAppointment(appointmentBO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.add(appointment);
        }
        return result;
    }



    //getByIdUtente
    @RequestMapping(
            path = "/{idUtente}/appointments",
            method = RequestMethod.GET,
            produces = "application/json")

    @ResponseBody
    public List<Appointment> getAppointmentsByIdUser(@PathVariable("idUtente") String idUtente) throws Exception {
        int currentId =Integer.parseInt(idUtente);
        List<AppointmentBO> listAppointmentBO = businessLayer.getByIdUtente(currentId);
        List<Appointment> listAppointment = new ArrayList<Appointment>();
        for (AppointmentBO element : listAppointmentBO) {
            listAppointment.add(plConverterService.convertToAppointment(element));
        }
        if (listAppointment.size()==0) throw new Exception("Nessun appuntamento presente per l'utente");
        return listAppointment;
    }


    //deleteById
    @RequestMapping(
            path = "/delete/{id}/appointment",
            method = RequestMethod.DELETE,
            produces = "application/json")

    @ResponseBody
    public String deleteAppointmentByIdUser(@PathVariable("id") String id) throws Exception {
        if (businessLayer.delete(id) == true) return "Appuntamento eliminato" ;
        else  throw new Exception("Impossibile eliminare l'appuntamento");
    }


    //modifica
    @RequestMapping(
            path = "/modify/{id}/appointment",
            method= RequestMethod.PUT,
            produces="application/json",
            consumes = "application/json")
    @ResponseBody
    public Appointment modificaAppointment(@RequestBody Appointment request, @PathVariable("id") String id) throws Exception{
        AppointmentBO appointmentBO = plConverterService.convertToAppointmentBO(request);
        AppointmentBO responseAppointmentBO = businessLayer.modifyAppointment(appointmentBO, id);
        Appointment response = plConverterService.convertToAppointment(responseAppointmentBO);
        return response;
        }

    }
