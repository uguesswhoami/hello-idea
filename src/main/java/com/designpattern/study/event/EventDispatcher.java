package com.designpattern.study.event;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luotong on 17/3/12.
 */
public class EventDispatcher {

    private Map<Class<? extends Event>, Handler> handlers;

    public EventDispatcher() {
        this.handlers = new HashMap<Class<? extends Event>, Handler>();
    }

    public void registerHandler(Class<? extends Event> c, Handler handler){
        handlers.put(c, handler);
    }

    @SuppressWarnings("unchecked")
    public void onEvent(Event event){
        Handler handler = handlers.get(event.getClass());
        handler.onEvent(event);
    }
}
