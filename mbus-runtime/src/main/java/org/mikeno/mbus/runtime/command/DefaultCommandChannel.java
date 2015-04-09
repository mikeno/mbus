package org.mikeno.mbus.runtime.command;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.mikeno.mbus.runtime.Bus;

/**
 *
 * @author psprague
 */
public class DefaultCommandChannel implements CommandChannel {

    private final Bus bus;
    
    private final Map<String, CommandChannelHandler> handlers = new HashMap<>();

    private final List<CommandChannelInterceptor> interceptors = new LinkedList<>();
    
    public DefaultCommandChannel(final Bus bus) {
        this.bus = bus;
    }
    
    @Override
    public void dispatch(final Command command) {
        dispatch(command, null);
    }

    @Override
    public void dispatch(final Command command, final CommandChannelCallback callback) {
        final CommandChannelHandler handler = handlers.get(command.getName());
        if (handler != null) {
            Command commandToProcess = command;
            for (CommandChannelInterceptor interceptor : interceptors) {
                commandToProcess = interceptor.onBeforeDispatch(commandToProcess);
            }
            
            try {
                final Object result = handler.onCommand(commandToProcess, bus);
                
                if (callback != null) {
                    callback.onSuccess(result);
                }
            } catch (RuntimeException e) {
                // TODO: log error
                
                if (callback != null) {
                    callback.onFailure(e);
                }
            }
            
            for (CommandChannelInterceptor interceptor : interceptors) {
                commandToProcess = interceptor.onAfterDispatch(commandToProcess);
            }
        }
    }

    @Override
    public void subscribe(final String commandName, final CommandChannelHandler handler) {
        handlers.put(commandName, handler);
    }

    @Override
    public void unsubscribe(final String commandName, final CommandChannelHandler handler) {
        handlers.remove(commandName, handler);
    }
    
}
