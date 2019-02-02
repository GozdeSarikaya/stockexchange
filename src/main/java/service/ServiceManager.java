package service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public String getStock() {
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

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/save")
    public String saveUser() {
        return "Hello, World!";
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/get")
    public String getUser() {
        return "Hello, World!";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/delete")
    public String deleteUser() {
        return "Hello, World!";
    }


    //endregion

}
