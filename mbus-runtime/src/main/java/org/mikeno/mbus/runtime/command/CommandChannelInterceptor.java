package org.mikeno.mbus.runtime.command;

/**
 *
 * @author psprague
 * @param <COMMAND>
 */
public interface CommandChannelInterceptor<COMMAND extends Command<?>> {

    COMMAND onBeforeDispatch(COMMAND command);

    COMMAND onAfterDispatch(COMMAND command);
}
