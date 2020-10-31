package com.web.tag;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport implements DynamicAttributes {
    private Map<String, Integer> map = new LinkedHashMap<>();
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        int sum = map.entrySet().stream().mapToInt(e -> e.getValue()).sum();
        out.print(sum);
    }

    @Override
    public void setDynamicAttribute(String uri, String key, Object value) throws JspException {
        map.put(key, Integer.parseInt(value + ""));
    }
    
}
