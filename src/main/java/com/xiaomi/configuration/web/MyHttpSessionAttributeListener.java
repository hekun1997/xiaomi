package com.xiaomi.configuration.web;

import com.xiaomi.pojo.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        if ("userInfo".equals(se.getName())){
            System.out.println("User 添加 : " + se.getValue().toString());
            UserThread.set((User) se.getValue());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if ("userInfo".equals(se.getName())){
            UserThread.remove();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        if ("userInfo".equals(se.getName())){
            UserThread.set((User) se.getValue());
        }
    }
}
