package org.its.bl.count;

import org.its.bl.appointment.AppointmentMessage;
import org.its.bl.user.UtenteMessage;
import org.its.bus.Bus;
import org.its.bus.BusMessage;
import org.its.dl.appointment.AppointmentDL;
import org.its.dl.count.CountDL;
import org.its.dl.user.UserDL;


import javax.inject.Named;

//@Named("countBL")
public class CountBLImpl implements CountBL {
    private final CountDL countDataLayer;
    private final UserDL userDataLayer;

    public CountBLImpl(@Named("countDL") CountDL countDataLayer,
                       @Named("userDl") UserDL userDataLayer,
                       @Named("bus") Bus bus){
        this.countDataLayer = countDataLayer;
        this.userDataLayer = userDataLayer;
        bus.register(UtenteMessage.class,  this);
}

    @Override
    public void handle(BusMessage message) throws Exception {
        //user
        UtenteMessage umsg = (UtenteMessage) message ;
        if (umsg.isEnabled()){
        countDataLayer.incrementEnabled();
        } else {
            countDataLayer.decrementEnabled();
        }

        //
    }

    @Override
    public int countEnabled() {
        return  countDataLayer.getEnabled();
    }

    @Override
    public int countDisabled() {
        return  userDataLayer.getAll().size() - countEnabled();
    }

}
