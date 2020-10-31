package com.web.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/hello")
public class HelloServer {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("進入 session: " + session.getId());
    }
    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("id=" + session.getId() + " 說: " + message);
        return "id=" + session.getId() + " 說: " + message;
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("關閉/離開 session: " + session.getId());
    }
}
