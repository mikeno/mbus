package org.mikeno.mbus.runtime.command;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author psprague
 */
public interface CommandGateway {

    void send(Object message);

    <RESULT> void send(Object message, CommandChannelCallback<RESULT> callback);

    <RESULT> RESULT sendAndWait(String messageName);

    <RESULT> RESULT sendAndWait(String messageName, long timeout, TimeUnit unit);
}
