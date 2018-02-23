package ru.kpfu.itis.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eljah32 on 2/24/2018.
 */

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionHistory {
    private List<String> usernames=new ArrayList<>();

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
