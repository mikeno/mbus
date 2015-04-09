package org.mikeno.mbus.runtime.event;

/**
 *
 * @author psprague
 */
public interface EventChannelInterceptor {

    Event onBeforePublish(Event event);

    Event onAfterPublish(Event event);
}
