package com.team3.rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team3.Main;
import com.team3.models.State;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/api")
public class Service {

    private Gson gson = new GsonBuilder().create();

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/date/{date}")
    public Response getDate(@PathParam("date") String date){
        State[][] states = Main.processor.getStates();
        int day = Integer.parseInt(date);
        String json = gson.toJson(states[day]);
        return Response.status(200).header("Content-Type", "application/json").entity(json).build();
    }

    @GET
    @Path("/range/{date1}/{date2}")
    public Response getRange(@PathParam("date1") String date1, @PathParam("date2") String date2){

        State[][] states = Main.processor.getStates();

        int day1 = Integer.parseInt(date1);
        int day2 = Integer.parseInt(date2);
        State[][] sendStates = new State[day2 - day1][8];

        System.arraycopy(states, day1, sendStates, 0, day2 - day1);
        String json = gson.toJson(sendStates);
        return Response.status(200).header("Content-Type", "application/json").entity(json).build();
    }

}
