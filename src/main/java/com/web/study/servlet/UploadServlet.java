package com.web.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

@WebServlet(urlPatterns = "/servlet/upload")
@MultipartConfig(
        location = "C:/upload",
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 20
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 分析 part (name = desc1)
        req.getParts().stream()
                .filter(part -> part.getName().equals("desc1"))
                .forEach(part -> {
                    try {
                        String desc1 = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());
                        out.print(desc1);
                    } catch (Exception e) {
                    }
                });
        out.print("<p>");
        // 分析 part (name = myfile1)
        req.getParts().stream()
                .filter(part -> part.getName().equals("myfile1"))
                .forEach(part -> {
                    String fname = part.getSubmittedFileName();
                    try {
                        part.write(fname);
                        out.print("Upload OK<p>");
                        out.print("<img width='500' src='/JavaWeb0829/servlet/image?name=" + fname + "'>");
                        // reload myiframe_imagelist
                        out.println("<script>top.frames['myiframe_imagelist'].location.reload();</script>");
                    } catch (Exception e) {
                        out.print("Upload Error, " + e);
                        e.printStackTrace(out);
                    }
                });
        
    }

}
