package service;

import hibernate.view.Stock.ListStockView;
import hibernate.view.Stock.SaveStockView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ServiceManager {


    //region Stock

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/save")
    public Response.ResponseBuilder saveStock(SaveStockView saveStockView) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stock/get")
    public String getStock(@FormParam("stockid") String stockid) {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/edit")
    public String editStock(@FormParam("stockid") String stockid) {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/list")
    public Response.ResponseBuilder listStock() {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok();
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
    @Path("/user/edit")
    public String editUser(@FormParam("userid") String userid) {
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

    //region Stock Operations

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/buy")
    public String buyStock() {
        return "Hello, World!";
    }



    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/sell")
    public String sellStock() {
        return "Hello, World!";
    }

    //endregion

}
