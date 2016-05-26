package com.tum.theshop.webapp.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.tum.theshop.webapp.data.properties.GoogleProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class GoogleService {

    @Autowired
    private GoogleProperties googleProperties;

    private List scopes;

    @PostConstruct
    public void init() {
        scopes = new ArrayList<>();
        scopes.add("profile");
    }

    public String doAutherized() {
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder( new NetHttpTransport(),
                new JacksonFactory(),
                googleProperties.getClientId(),
                googleProperties.getClientSecret(),
                scopes).build();
        return flow.newAuthorizationUrl().setRedirectUri(googleProperties.getCallbackURL()).toURI().toString();
    }

}
