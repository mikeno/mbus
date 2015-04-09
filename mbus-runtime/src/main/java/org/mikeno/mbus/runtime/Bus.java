package org.mikeno.mbus.runtime;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author psprague
 */
public interface Bus<BUS_MESSAGE extends BusMessage<?>> {
    void dispatch(BUS_MESSAGE message);
    void dispatch(BUS_MESSAGE message, BusMessageCallback<BUS_MESSAGE> callback);
    void subscribe(String messageName, BusMessageHandler<BUS_MESSAGE> handler);
    void unsubscribe(String messageName, BusMessageHandler<BUS_MESSAGE> handler);
}

interface BusGateway<BUS_MESSAGE extends BusMessage<?>> {
    void send(Object message);
    void send(Object message, BusMessageCallback<BUS_MESSAGE> callback);
    void sendAndWait(String messageName);
    void sendAndWait(String messageName, long timeout, TimeUnit unit);
}

interface BusMessage<T> {
    
    Map<String, String> getHeaders();
    
    String getId();
    
    String getName();
    
    LocalDateTime getTimestamp();
    
    T getPayload();
    
    Class<T> getPayloadType();
    
}

interface BusMessageCallback<BUS_MESSAGE extends BusMessage<?>> {
    void onSuccess(BUS_MESSAGE result);
    void onFailure(Throwable cause);
}

interface BusMessageHandler<BUS_MESSAGE extends BusMessage<?>> {
    void onMessage(BUS_MESSAGE message, Bus<BUS_MESSAGE> bus);
}

interface BusMessageDispatchInterceptor<BUS_MESSAGE extends BusMessage<?>> {
    BUS_MESSAGE onMessage(BUS_MESSAGE message);
}

interface BusMessageHandlerInterceptor<BUS_MESSAGE extends BusMessage<?>> {
    BUS_MESSAGE onMessage(BUS_MESSAGE message);
}

// ----------------------------------------------------------------------
// ----------------------------------------------------------------------










