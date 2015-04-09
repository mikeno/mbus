package org.mikeno.mbus.runtime.event;

import java.util.LinkedList;
import java.util.List;
import org.mikeno.mbus.runtime.Bus;

/**
 *
 * @author psprague
 */
public class DefaultEventChannel implements EventChannel {

    private final Bus bus;
    
    private final List<EventChannelListener> listeners = new LinkedList<>();

    private final List<EventChannelInterceptor> interceptors = new LinkedList<>();

    public DefaultEventChannel(final Bus bus) {
        this.bus = bus;
    }
    
    @Override
    public void publish(final Event event) {
        Event eventToProcess = event;
        
        for (final EventChannelInterceptor interceptor : interceptors) {
            eventToProcess = interceptor.onBeforePublish(eventToProcess);
        }
        
        for (final EventChannelListener listener : listeners) {
            listener.onEvent(eventToProcess, bus);
        }

        for (final EventChannelInterceptor interceptor : interceptors) {
            eventToProcess = interceptor.onAfterPublish(eventToProcess);
        }
    }

    @Override
    public void subscribe(final EventChannelListener eventListener) {
        listeners.add(eventListener);
    }

    @Override
    public void unsubscribe(final EventChannelListener eventListener) {
        listeners.remove(eventListener);
    }

}
