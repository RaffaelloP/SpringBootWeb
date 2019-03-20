package org.its.pl.validator;

import org.its.pl.user.Utente;

import javax.inject.Named;

@Named("plValidator")
public class PLValidateNameLength implements PLValidator {
    @Override
    public boolean validate(Utente utenteBO) {
        return utenteBO.getName().length() >= 3;
    }
}
