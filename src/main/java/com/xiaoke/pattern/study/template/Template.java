package com.xiaoke.pattern.study.template;

abstract public class Template{

    public void template(){

        init();
        if(isOrNot()){
            before();
        }
        execute();
        after();

    }

    abstract public void before();

    abstract public void execute();

    abstract public void after();

    private void init(){
        System.out.println("init.");
    }

    public Boolean isOrNot(){
        return false;
    }
}