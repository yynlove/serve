package com.yyn.serve.service;

import java.util.Map;


public interface Authable {

    String getIssuer();

    Map<String, Object> getClaims();

    //boolean isEnabled();

}
