package org.mikeno.mbus.runtime;

/**
 *
 * @author psprague
 */
public interface EventChannel {

    void publish(Event event);

    void subscribe(EventChannelListener eventListener);

    void unsubscribe(EventChannelListener eventListener);
}
