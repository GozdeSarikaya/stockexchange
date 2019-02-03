package com.netas.interview.service;

import com.netas.interview.hibernate.manager.UserManager;
import com.netas.interview.hibernate.view.Stock.SaveStockView;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class ServiceManager {


    //region Stock

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/isAlive")
    public String isAlive() {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/list")
    public String listUser() {

        UserManager user;
        try {

            user = new UserManager();
            user.getUserList();
            int x = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "OK";
    }


/*
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/save")
    public String saveStock(SaveStockView saveStockView) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
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
    public String listStock() {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/delete")
    public String deleteStock() {
        return "Hello, World!";
    }
*/

    //endregion

    //region User

/*


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
    }*/

    //endregion

}
