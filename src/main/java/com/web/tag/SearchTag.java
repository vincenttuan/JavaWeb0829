package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class SearchTag implements BodyTag {
    private PageContext pageContext;
    private Tag parentTag;
    private BodyContent bodyContent;
    private String key;
    
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    

    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public void setBodyContent(BodyContent bc) {
        bodyContent = bc;
    }

    @Override
    public void doInitBody() throws JspException {
        
    }

    @Override
    public int doAfterBody() throws JspException {
        return Tag.SKIP_BODY;
    }
    
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }

    
    
}
