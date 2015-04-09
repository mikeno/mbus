package org.mikeno.mbus.runtime;

import org.mikeno.mbus.runtime.command.CommandChannel;
import org.mikeno.mbus.runtime.command.CommandGateway;
import org.mikeno.mbus.runtime.event.EventChannel;
import org.mikeno.mbus.runtime.event.EventGateway;

/**
 *
 * @author psprague
 */
public class DefaultBus implements Bus {

    private final CommandChannel commandChannel;
    private final CommandGateway commandGateway;
    
    private final EventChannel eventChannel;
    private final EventGateway eventGateway;
    
    public DefaultBus(final CommandChannel commandChannel, final CommandGateway commandGateway, final EventChannel eventChannel, final EventGateway eventGateway) {
        this.commandChannel = commandChannel;
        this.commandGateway = commandGateway;
        this.eventChannel = eventChannel;
        this.eventGateway = eventGateway;
    }
    
    @Override
    public CommandGateway getCommandGateway() {
        return commandGateway;
    }

    @Override
    public EventGateway getEventGateway() {
        return eventGateway;
    }
    
}
