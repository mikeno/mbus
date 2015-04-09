package org.mikeno.mbus.runtime;

import org.mikeno.mbus.runtime.command.CommandGateway;
import org.mikeno.mbus.runtime.event.EventGateway;

/**
 *
 * @author psprague
 */
public interface Bus {
    
    CommandGateway getCommandGateway();
    
    EventGateway getEventGateway();

}










