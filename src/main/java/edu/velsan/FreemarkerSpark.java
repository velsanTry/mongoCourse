package edu.velsan;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerSpark {
    public static void main(String[] args) {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("name", "velsan");
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreemarkerSpark.class, "/");
        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) {
                final StringWriter out = new StringWriter();
                try {
                    final Template helloTemplate = configuration.getTemplate("hello.ftl");
                    helloTemplate.process(map, out);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
                ;
                return out;
            }
        });

    }
}
