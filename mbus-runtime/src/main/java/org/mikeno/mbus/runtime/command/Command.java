package org.mikeno.mbus.runtime.command;

import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author psprague
 */
public interface Command<PAYLOAD> {
    
    Map<String, String> getHeaders();
    
    String getId();
    
    String getName();
    
    LocalDateTime getTimestamp();
    
    PAYLOAD getPayload();
    
    Class<PAYLOAD> getPayloadType();
    
}