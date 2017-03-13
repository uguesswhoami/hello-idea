package com.designpattern.study.event;

/**
 * Created by luotong on 17/3/12.
 */
public abstract class Event implements Message{

    protected Class getType(){
        return getClass();
    }

}
