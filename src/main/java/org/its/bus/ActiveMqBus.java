package org.its.bus;

import org.springframework.jms.core.JmsTemplate;

import javax.inject.Named;

@Named("bus")
public class ActiveMqBus implements Bus {

    private JmsTemplate jmsQueueTemplate;

    public  ActiveMqBus(
            @Named("jmsQueueTemplate") JmsTemplate jmsQueueTemplate){
            this.jmsQueueTemplate = jmsQueueTemplate;
    }


    @Override
    public <T> void register(Class<T> clazz, MessageConsumer consumer) {
    }

    @Override
    public void send(BusMessage message) {
    jmsQueueTemplate.convertAndSend("queue", message, m -> {
        m.setStringProperty("classtype",
                message.getClass().getSimpleName());
        return m;
    });
    }
}
