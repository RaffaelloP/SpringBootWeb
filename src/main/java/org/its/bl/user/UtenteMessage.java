package org.its.bl.user;

import org.its.bus.BusMessage;

public class UtenteMessage implements BusMessage {

    private boolean enabled;

    public  UtenteMessage(boolean enabled){
        this.enabled = enabled;
    }

    public  UtenteMessage(){}

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
