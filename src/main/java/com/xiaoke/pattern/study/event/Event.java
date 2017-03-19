package com.xiaoke.pattern.study.event;

/**
 * Created by  on 17/3/12.
 */
public abstract class Event implements Message{

    protected Class getType(){
        return getClass();
    }

}
