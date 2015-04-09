package org.mikeno.mbus.runtime;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author psprague
 */
public class DefaultEventChannel implements EventChannel {

    private final List<EventChannelListener> listeners = new LinkedList<>();

    private final List<EventChannelPublishInterceptor> publishInterceptors = new LinkedList<>();

    private final List<EventChannelListenerInterceptor> listenerInterceptors = new LinkedList<>();

    @Override
    public void publish(final Event event) {
        Event eventToProcess = event;
        
        for (final EventChannelPublishInterceptor publishInterceptor : publishInterceptors) {
            eventToProcess = publishInterceptor.beforePublish(eventToProcess);
        }

        for (final EventChannelPublishInterceptor publishInterceptor : publishInterceptors) {
            eventToProcess = publishInterceptor.afterPublish(eventToProcess);
        }
        
        for (final EventChannelListenerInterceptor listenerInterceptor : listenerInterceptors) {
            eventToProcess = listenerInterceptor.beforeListener(eventToProcess);
        }
        
        for (final EventChannelListener listener : listeners) {
            listener.onEvent(eventToProcess);
        }

        for (final EventChannelListenerInterceptor listenerInterceptor : listenerInterceptors) {
            eventToProcess = listenerInterceptor.afterListener(eventToProcess);
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
