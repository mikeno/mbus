package org.mikeno.mbus.runtime.command;

/**
 *
 * @author psprague
 */
public interface CommandChannel {

    void dispatch(Command command);

    void dispatch(Command command, CommandChannelCallback callback);

    void subscribe(String commandName, CommandChannelHandler handler);

    void unsubscribe(String commandName, CommandChannelHandler handler);
}
