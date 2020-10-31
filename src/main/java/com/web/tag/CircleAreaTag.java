package com.web.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CircleAreaTag extends SimpleTagSupport {
    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        double area = Math.pow(r, 2) * Math.PI;
        out.print(String.format("r: %.1f area: %.2f", r, area));
    }
    
}
