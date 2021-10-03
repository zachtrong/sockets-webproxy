package com.groupsecond.socketswebproxy;

import java.io.Serializable;

public class ClientRequest  implements Serializable {
    public String SessionId;
    public String url;

    public ClientRequest() {

    }

    public ClientRequest(String sessionId, String url) {
        SessionId = sessionId;
        this.url = url;
    }

    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
