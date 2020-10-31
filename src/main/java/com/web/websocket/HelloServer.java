package com.web.websocket;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/hello")
public class HelloServer {
    private static CopyOnWriteArraySet<Session> sessions;
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("進入 session: " + session.getId());
        if(sessions == null) {
            sessions = new CopyOnWriteArraySet<>();
        }
        sessions.add(session);
        sendAll("歡迎 " + session.getId() + " 加入");
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("id=" + session.getId() + " 說: " + message);
        sendAll("id=" + session.getId() + " 說: " + message);
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("關閉/離開 session: " + session.getId());
        if(sessions != null) {
            sessions.remove(session);
            sendAll("哇哩勒~ " + session.getId() + " 離開了!");
        }
    }
}
