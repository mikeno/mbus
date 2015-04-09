package org.mikeno.mbus.runtime;

/**
 *
 * @author psprague
 */
public interface EventChannelListenerInterceptor {

    Event beforeListener(Event event);

    Event afterListener(Event event);
}
