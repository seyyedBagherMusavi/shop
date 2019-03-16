package com.kahkeshan.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 Author : p-dodangeh
 Date: 1/9/2019
 Time: 12:59 PM
*/
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.printf("======================Context Initialized================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.printf("======================Context Destroyed================");
    }
}
