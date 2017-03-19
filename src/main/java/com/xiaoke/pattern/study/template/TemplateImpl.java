package com.xiaoke.pattern.study.template;

public class TemplateImpl extends Template {

    @Override
    public void before(){
        System.out.println("before.");
    }

    @Override
    public void execute(){
        System.out.println("exe.");
    }

    @Override
    public void after(){
        System.out.println("after.");
    }

    @Override
    public Boolean isOrNot(){
        return true;
    }
}