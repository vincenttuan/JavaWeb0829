package com.web.captcha;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SSOServletContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Set<String> alreadyLoginMembers = new LinkedHashSet<>();
        sce.getServletContext().setAttribute("alreadyLoginMembers", alreadyLoginMembers);
        
        sce.getServletContext().setAttribute("captcha_verify_url", "https://www.google.com/recaptcha/api/siteverify");
        sce.getServletContext().setAttribute("captcha_remoteip", "localhost");
        sce.getServletContext().setAttribute("captcha_client_key", "6Lf_JtYZAAAAAEIE8pIOhd_yIwvaV2gTrsf7vhPX");
        sce.getServletContext().setAttribute("captcha_server_key", "6Lf_JtYZAAAAAKYtDPaFi-d8gWe-M7L3TejxS5Pa");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce); //To change body of generated methods, choose Tools | Templates.
    }
    
}
