package org.its.bl.validator;

import org.its.bl.user.UtenteBO;

import javax.inject.Named;

@Named("blValidateProfanities")
public class BLValidateProfanitiesImpl implements BLValidator {

    private final BLValidator validator;

    public BLValidateProfanitiesImpl(@Named("finalBlValidator")BLValidator validator){
        this.validator = validator;
    }
    @Override
    public boolean validate(UtenteBO utente) {
        /////
        return this.validator.validate(utente) &&
                validateProfanitiesInternal();
    }
    private boolean validateProfanitiesInternal(){
        return true;
    }
}
