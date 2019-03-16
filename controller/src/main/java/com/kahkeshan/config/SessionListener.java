package com.kahkeshan.config;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 Author : p-dodangeh
 Date: 1/8/2019
 Time: 4:41 PM
*/
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("==== Session initialized  ====");
        event.getSession().setMaxInactiveInterval(60*60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("==== Session is destroyed ====");


    }
}