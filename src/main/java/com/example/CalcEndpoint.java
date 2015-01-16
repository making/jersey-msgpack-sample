package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Named
@Path("/")
public class CalcEndpoint {


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
        private int left;
        private int right;
        private long answer;
    }

    @GET
    @Produces({"application/json", "application/x-msgpack"})
    @Path("calc")
    public Result calc(@QueryParam("left") int left, @QueryParam("right") int right) {
        return new Result(left, right, left + right);
    }
}
