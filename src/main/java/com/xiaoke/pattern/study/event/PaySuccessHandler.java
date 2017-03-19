package com.xiaoke.pattern.study.event;

/**
 * Created by luotong on 17/3/12.
 */
public class PaySuccessHandler implements Handler<PaySuccessEvent> {

    public void onEvent(PaySuccessEvent event) {
        System.out.println("pay success handle" + event);
    }
}
