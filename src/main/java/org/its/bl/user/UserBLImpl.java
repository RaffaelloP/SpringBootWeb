package org.its.bl.user;

import org.its.bl.BOConverterService;
import org.its.bl.validator.BLValidator;
import org.its.bus.Bus;
import org.its.dl.user.UserDL;
import org.its.dl.user.UtenteDL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("userBl")
public class UserBLImpl implements UserBL {
    private final UserDL dataLayer;
    private BLValidator validator;
    private BOConverterService boConverterService = new BOConverterService();
    private Bus bus;

    public UserBLImpl(
            @Named("userDl")UserDL dataLayer,
            @Named("blValidateName")BLValidator validator,
            @Named ("bus")Bus bus){
        this.dataLayer = dataLayer;
        this.validator = validator;
        this.bus = bus;
    }

    @Override
    public List<UtenteBO> getAll() {
        List<UtenteBO> listaUtenteBO = new ArrayList<UtenteBO>();
        for (UtenteDL utenteDL : dataLayer.getAll()) {
            UtenteBO utenteBo = boConverterService.convertToUtenteBO(utenteDL);
            listaUtenteBO.add(utenteBo);
        }
        return listaUtenteBO;
    }

    @Override
    public UtenteBO getById(String id)  {
           UtenteDL utenteDL = dataLayer.getUserById(Integer.parseInt(id));
                UtenteBO result = boConverterService.convertToUtenteBO(utenteDL);
                return  result;
    }

    @Override
    public UtenteBO add(UtenteBO utenteBO) {
        validateBl(utenteBO);
        utenteBO.setEnabled(false);
        UtenteDL utenteDL = boConverterService.convertToUtenteDL(utenteBO);
        UtenteBO responseUtenteBo = boConverterService.convertToUtenteBO(dataLayer.add(utenteDL));
        return responseUtenteBo;
    }


    @Override
    public boolean delete(String id) {
        String error;
        try {
            int parsedId = Integer.parseInt(id);
            return dataLayer.delete(parsedId);
        } catch (NumberFormatException f) {
          error =   "Non è un numero";
          return false;
        }
    }

    @Override
    public UtenteBO modificaUtente(UtenteBO utenteBO, String id) {
        validateBl(utenteBO);
        delete(id);
        return add(utenteBO);
    }

    @Override
    public void abilitaUtente(String id) throws Exception {
        UtenteBO existingUtente = getById(id);
        if (existingUtente == null){
            throw  new Exception("Utente non esiste");
        }
        existingUtente.setEnabled(true);
        UtenteDL utenteDL = boConverterService.convertToUtenteDL(existingUtente);
        dataLayer.update(utenteDL);
        bus.send(new UtenteMessage(true));
    }

    @Override
    public void disabilitaUtente(String id) throws Exception {
        UtenteBO existingUtente = getById(id);
        if (existingUtente == null){
            throw  new Exception("Utente non esiste");
        }
        existingUtente.setEnabled(false);
        UtenteDL utenteDL = boConverterService.convertToUtenteDL(existingUtente);
        dataLayer.update(utenteDL);
        bus.send(new UtenteMessage(false));
    }




    private boolean validateBl(UtenteBO utenteBO) {
        return validator.validate(utenteBO);
    }
}

