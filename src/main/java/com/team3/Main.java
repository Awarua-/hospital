package com.team3;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    private static final String BASE_URI = "http://localhost:8080/";
    private static Hospital hospital;

    private static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("com.team3.rest");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        hospital = new Hospital();
        hospital.run();
        System.out.println(hospital.getNumberOfDeadPatients());

//        final HttpServer server = startServer();
    }
}
