package org.its.bl.count;

import org.its.bus.MessageConsumer;

public interface CountAppointmentBL extends MessageConsumer {
    int countAppointmentByIdUtente(int idUtente);
}
