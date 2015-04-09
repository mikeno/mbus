package org.mikeno.mbus.runtime.command;

import org.mikeno.mbus.runtime.Bus;

/**
 *
 * @author psprague
 */
public interface CommandChannelHandler<COMMAND extends Command<?>> {

    Object onCommand(COMMAND command, Bus bus);
}
