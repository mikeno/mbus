package org.mikeno.mbus.runtime.event;

/**
 *
 * @author psprague
 */
public interface EventChannel {

    void publish(Event event);

    void subscribe(EventChannelListener eventListener);

    void unsubscribe(EventChannelListener eventListener);
}
