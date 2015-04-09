package org.mikeno.mbus.runtime.event;

import org.mikeno.mbus.runtime.Bus;

/**
 *
 * @author psprague
 */
public interface EventChannelListener {

    void onEvent(Event event, Bus bus);
}
