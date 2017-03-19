package com.xiaoke.pattern.study.event;

/**
 * Created by luotong on 17/3/12.
 */
public class bootstrap {

    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerHandler(PaySuccessEvent.class, new PaySuccessHandler());
        dispatcher.registerHandler(PayFailedEvent.class, new PayFailedHandler());



        dispatcher.onEvent(new PaySuccessEvent());
        dispatcher.onEvent(new PayFailedEvent());
    }
}
