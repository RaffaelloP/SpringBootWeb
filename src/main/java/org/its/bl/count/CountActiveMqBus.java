package org.its.bl.count;

import org.its.bl.user.UtenteMessage;
import org.its.bus.Bus;
import org.its.bus.BusMessage;
import org.its.dl.count.CountDL;
import org.its.dl.user.UserDL;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("countBL")
@Component
public class CountActiveMqBus extends CountBLImpl {

    public CountActiveMqBus(@Named("countDL") CountDL countDataLayer,
                            @Named("userDl") UserDL userDataLayer,
                            @Named("bus") Bus bus) {
        super(countDataLayer, userDataLayer, bus);
    }

    @JmsListener(
            destination = "queue",
            containerFactory = "queueListenerFactory",
            selector = "classtype='UtenteMessage'")
    public void handle (UtenteMessage utenteMessage) throws Exception{
        super.handle(utenteMessage);

    }
}
