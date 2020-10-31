package com.web.tag;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class BmiTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private double h, w;
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    

    @Override
    public int doStartTag() throws JspException {
        // code
        JspWriter out = pageContext.getOut();
        try {
            double bmi = w / Math.pow(h/100, 2);
            String result = (bmi>23)?"過重":(bmi<=18)?"過輕":"正常";
            String data = String.format("h: %.1f w: %.1f bmi: %.2f (%s)", h, w, bmi, result);
            out.print(data);
            out.print(new Date());
        } catch (IOException ex) {
            
        }
        
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        // code
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
