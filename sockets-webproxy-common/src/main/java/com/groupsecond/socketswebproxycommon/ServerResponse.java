package com.groupsecond.socketswebproxycommon;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    private String sessionId;
    private String url;
    private String content;

    public ServerResponse() {
    }

    public ServerResponse(String sessionId, String url, String content) {
        this.sessionId = sessionId;
        this.url = url;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "sessionId='" + sessionId + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
