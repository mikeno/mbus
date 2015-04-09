package org.mikeno.mbus.runtime.command;

/**
 *
 * @author psprague
 */
public interface CommandChannelCallback<RESULT> {

    void onSuccess(RESULT result);

    void onFailure(Throwable cause);
}
