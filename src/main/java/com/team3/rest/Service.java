package com.team3.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/api")
public class Service {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();
    }
/*
    @GET
    @Path("/date/{date}")
    public Response getDate(@PathParam("date") String date){

    }

    @GET
    @Path("/range/{date1}/{date2}")
    public Response getRange(@PathParam("date1") String date1, @PathParam("date2") String date2){

    }
*/
}
