package com.xiaoke.pattern.study.event;

/**
 * Created by luotong on 17/3/12.
 */
public interface Handler<T extends Event> {

    void onEvent(T event);
}
