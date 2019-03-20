package org.its.bl.validator;

import org.its.bl.user.UtenteBO;

import javax.inject.Named;

@Named("blValidateName")
public class BLValidateNameImpl implements BLValidator {

    private BLValidator validator;

    public BLValidateNameImpl(
            @Named("blValidateProfanities")BLValidator validator){
        this.validator = validator;
    }

    public static final String FORBIDDEN_WORD = "test";

    @Override
    public boolean validate(UtenteBO utenteBO) {
        return validator.validate(utenteBO) &&
                !utenteBO.getName().contains(FORBIDDEN_WORD);
    }
}
