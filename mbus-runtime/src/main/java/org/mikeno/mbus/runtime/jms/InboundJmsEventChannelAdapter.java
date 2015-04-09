package org.mikeno.mbus.runtime.jms;

import org.mikeno.mbus.runtime.event.Event;
import org.mikeno.mbus.runtime.event.EventChannel;
import javax.jms.Message;

/**
 * Receive events from an external system and publish them the {@link EventChannel}.
 * 
 * @param <T> The message type of the external system being adapted.
 */
public abstract class InboundJmsEventChannelAdapter<T> {

    private final EventChannel eventChannel;

    public InboundJmsEventChannelAdapter(final EventChannel eventChannel) {
        this.eventChannel = eventChannel;
    }

    protected void publish(final Event event) {
        eventChannel.publish(event);
    }

}
