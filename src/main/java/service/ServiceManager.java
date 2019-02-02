package service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class ServiceManager {


    //region Stock

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/save")
    public String saveStock() {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/get")
    public String getStock(@FormParam("stockid") String stockid) {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/list")
    public String listStock() {
        return "Hello, World!";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/delete")
    public String deleteStock() {
        return "Hello, World!";
    }


    //endregion

    //region User




    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/get")
    public String getUser(@FormParam("userid") String userid) {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/list")
    public String listUser() {
        return "Hello, World!";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/delete")
    public String deleteUser() {
        return "Hello, World!";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/save")
    public String saveUser() {
        return "Hello, World!";
    }


    //endregion

}
