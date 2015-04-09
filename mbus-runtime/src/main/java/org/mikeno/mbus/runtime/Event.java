package org.mikeno.mbus.runtime;

import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author psprague
 * @param <PAYLOAD> The event payload type.
 */
public interface Event<PAYLOAD> {

    Map<String, String> getHeaders();

    String getName();

    String getCause();

    String getSource();

    LocalDateTime getTimestamp();

    Class<PAYLOAD> getPayloadType();

    PAYLOAD getPayload();
}
