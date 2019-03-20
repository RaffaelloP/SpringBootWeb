package org.its.bl.count;

import org.its.bus.MessageConsumer;

public interface CountBL extends MessageConsumer {
    int countEnabled();
    int countDisabled();
}
