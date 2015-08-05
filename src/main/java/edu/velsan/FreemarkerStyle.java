package edu.velsan;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerStyle {

    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreemarkerStyle.class, "/");
        try {
            final Template helloTemplate = configuration.getTemplate("hello.ftl");
            final Map<String, String> map = new HashMap<String,String>();
            map.put("name", "velsan");
            final StringWriter out = new StringWriter();
            helloTemplate.process(map, out);
            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
