package com.groupsecond.socketswebproxycommon;

import java.io.Serializable;

public class ClientRequest implements Serializable {
    private String sessionId;
    private String url;

    public ClientRequest() {
    }

    public ClientRequest(String sessionId, String url) {
        this.sessionId = sessionId;
        this.url = url;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "com.groupsecond.socketswebproxycommon.ClientRequest{" +
                "sessionId='" + sessionId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
