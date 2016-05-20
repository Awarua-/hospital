package com.team3;

import com.team3.parser.CSVParser;
import com.team3.processor.Processor;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.FileNotFoundException;
import java.net.URI;

public class Main {

    private static final String BASE_URI = "http://172.20.10.2:8080/";
    public static Processor processor;

    private static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("com.team3.rest");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        processor = new Processor(csvParser.patients, csvParser.wards, csvParser.moves);
        try {
            processor.process();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final HttpServer server = startServer();
    }
}
