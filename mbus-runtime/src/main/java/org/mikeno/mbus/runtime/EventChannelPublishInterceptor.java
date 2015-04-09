package org.mikeno.mbus.runtime;

/**
 *
 * @author psprague
 */
public interface EventChannelPublishInterceptor {

    Event beforePublish(Event event);

    Event afterPublish(Event event);
}
