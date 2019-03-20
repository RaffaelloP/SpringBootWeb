package org.its.pl.count;

import org.its.bl.count.CountAppointmentBL;
import org.its.bl.count.CountBL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Named;

@Controller
@RequestMapping ("/api/utente")
public class CountController {

    private CountAppointmentBL countAppointmentBusinessLayer;
    private CountBL countBusinessLayer;

    public CountController(@Named("countAppointmentBL") CountAppointmentBL countAppointmentBusinessLayer,
                           @Named("countBL") CountBL countBusinessLayer){
        this.countAppointmentBusinessLayer = countAppointmentBusinessLayer;
        this.countBusinessLayer = countBusinessLayer;
    }

    //getAbilitazioniUtenti
    @RequestMapping(
            path = "/countEnabled",
            method = RequestMethod.GET,
            produces = "application/json")

    @ResponseBody
    public Count countEnabled() throws  Exception{
        return  new Count(countBusinessLayer.countEnabled());
    }


    @RequestMapping(
            path = "/countDisabled",
            method = RequestMethod.GET,
            produces = "application/json")

    @ResponseBody
    public Count countDisabled() throws  Exception{
        return  new Count(countBusinessLayer.countDisabled());
    }


    //countAppointmentsByID
    @RequestMapping(
            path = "/{id}/countAppointments",
            method = RequestMethod.GET,
            produces = "application/json")

    @ResponseBody
    public Count countAppointmentsByID(@PathVariable("id") String id) throws  Exception{
        return  new Count(countAppointmentBusinessLayer.countAppointmentByIdUtente(Integer.parseInt(id)));
    }

}
