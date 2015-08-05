package edu.velsan;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkStyleMain {
    public static void main(String[] args) {
        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) {
                return "Hello world!";
            }
        });
    }
}
