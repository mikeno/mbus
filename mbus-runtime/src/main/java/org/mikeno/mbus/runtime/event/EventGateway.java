package org.mikeno.mbus.runtime.event;

/**
 *
 * @author psprague
 */
public interface EventGateway {
    
    void publish(Object event);
    
}
