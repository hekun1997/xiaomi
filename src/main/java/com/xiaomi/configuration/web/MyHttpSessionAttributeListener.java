package com.xiaomi.configuration.web;

import com.xiaomi.pojo.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author hekun
 */
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    private static final String USER_INFO = "userInfo";

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        if (USER_INFO.equals(se.getName())){
            UserThread.set((User) se.getValue());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if (USER_INFO.equals(se.getName())){
            UserThread.remove();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        if (USER_INFO.equals(se.getName())){
            UserThread.set((User) se.getValue());
        }
    }
}
