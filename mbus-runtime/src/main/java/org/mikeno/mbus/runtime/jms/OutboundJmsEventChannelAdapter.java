package org.mikeno.mbus.runtime.jms;

import org.mikeno.mbus.runtime.Event;
import org.mikeno.mbus.runtime.EventChannelListener;



/**
 * Receive events from the {@link EventChannel} and publish them to an external system.
 * 
 * @author psprague
 */
public abstract class OutboundJmsEventChannelAdapter implements EventChannelListener {

    @Override
    public void onEvent(Event event) {
        // forward event to external system
    }
    
}
