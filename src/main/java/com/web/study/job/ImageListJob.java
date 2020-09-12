package com.web.study.job;

import java.io.File;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;

public class ImageListJob implements Runnable {

    private AsyncContext ctx;

    public ImageListJob(AsyncContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = ctx.getResponse().getWriter();
            String path = "C:/upload";
            File root = new File(path);
            String[] names = root.list();
            for (String name : names) {
                File file = new File(path + "/" + name);
                if (file.isFile()) {
                    String imagePath = "/JavaWeb0829/servlet/image?name=" + name;
                    String imageDeletePath = "/JavaWeb0829/servlet/imagedelete?name=" + name;
                    out.print("<img width='500' src='" + imagePath + "' ondblclick='window.location.href=\"" + imageDeletePath + "\"' style='cursor: hand' title='按二下可刪除'><p>");
                    out.flush();
                }
            }
            ctx.complete();
        } catch (Exception e) {
        }

    }

}
