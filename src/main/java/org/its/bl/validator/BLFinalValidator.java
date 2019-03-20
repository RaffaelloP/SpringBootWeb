package org.its.bl.validator;

import org.its.bl.user.UtenteBO;

import javax.inject.Named;

@Named("finalBlValidator")
public class BLFinalValidator implements BLValidator{
    @Override
    public boolean validate(UtenteBO utente) {
        return true;
    }
}
