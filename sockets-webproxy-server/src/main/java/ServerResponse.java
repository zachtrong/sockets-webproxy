import java.io.Serializable;

public class ServerResponse implements Serializable {
    String SessionId;
    String Url;
    String Content;

    public ServerResponse() {
    }

    public ServerResponse(String sessionId, String url, String content) {
        SessionId = sessionId;
        Url = url;
        Content = content;
    }

    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
