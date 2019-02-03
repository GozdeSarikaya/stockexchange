package com.netas.interview.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netas.interview.hibernate.manager.StockManager;
import com.netas.interview.hibernate.manager.UserManager;
import com.netas.interview.hibernate.tables.Stock;
import com.netas.interview.hibernate.tables.User;
import com.netas.interview.hibernate.view.Stock.EditStockView;
import com.netas.interview.hibernate.view.Stock.SaveStockView;
import com.netas.interview.hibernate.view.User.EditUserView;
import com.netas.interview.hibernate.view.User.SaveUserView;
import com.netas.interview.utility.EntityManagerUtility;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/")
public class ServiceManager {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/isAlive")
    public String isAlive() {
        return "Hello, World!";
    }


    //region Stock


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stock/get")
    public Response getStock(@QueryParam("stockid") int stockid) {
        JSONObject jsonObject = new JSONObject();
        ObjectMapper objectMapper = new ObjectMapper();
        Stock stock;
        StockManager stockManager;
        try {

            stockManager = new StockManager();
            stock = stockManager.getStock(stockid);
            jsonObject.put("stock", objectMapper.writeValueAsString(stock));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().entity(jsonObject.toJSONString()).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stock/list")
    public Response listStock() {

        JSONObject jsonObject = new JSONObject();
        List<Stock> stockList;
        StockManager stockManager;
        try {

            stockManager = new StockManager();
            stockList = stockManager.getStockList();
            jsonObject.put("stocklist", stockList.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().entity(jsonObject.toJSONString()).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/delete")
    public Response deleteStock(@QueryParam("stockid") int stockid) {

        StockManager stockManager;
        try {

            stockManager = new StockManager();
            stockManager.deleteStock(stockid);

        } catch (Exception e) {
            Response.status(Response.Status.EXPECTATION_FAILED).entity("Stock could not deleted!").build();
        }

        return Response.ok().entity("Stock Deleted!").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/save")
    public Response saveStock(SaveStockView saveStockView)  throws Exception {

        StockManager stockManager;
        try {

            stockManager = new StockManager();
            stockManager.saveStock(saveStockView);

        } catch (Exception e) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Stock could not be saved!").build();
        }

        return Response.ok().entity("Stock Saved!").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/edit")
    public Response editStock(EditStockView editStockView)  throws Exception {

        StockManager stockManager;
        try {

            stockManager = new StockManager();
            stockManager.editStock(editStockView);

        } catch (Exception e) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Stock could not be edited!").build();
        }

        return Response.ok().entity("Stock Edited!").build();
    }


    //endregion

    //region User

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/list")
    public Response listUser() {

        JSONObject jsonObject = new JSONObject();
        List<User> userList;
        UserManager user;
        try {

            user = new UserManager();
            userList = user.getUserList();
            jsonObject.put("userlist", userList.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().entity(jsonObject.toJSONString()).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/get")
    public Response getUser(@QueryParam("userid") int userid) {

        JSONObject jsonObject = new JSONObject();
        ObjectMapper objectMapper = new ObjectMapper();
        User user;
        UserManager userManager;
        try {

            userManager = new UserManager();
            user = userManager.getUser(userid);
            jsonObject.put("user", objectMapper.writeValueAsString(user));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().entity(jsonObject.toJSONString()).build();
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/delete")
    public Response deleteUser(@QueryParam("userid") int userid) {

        UserManager user;
        try {

            user = new UserManager();
            user.deleteUser(userid);

        } catch (Exception e) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("User could not deleted!").build();
        }

        return Response.ok().entity("User Deleted!").build();
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/save")
    public Response saveUser(SaveUserView saveUserView)  throws Exception {

        UserManager user;
        try {

            user = new UserManager();
            user.saveUser(saveUserView);

        } catch (Exception e) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("User could not be saved!").build();
        }

        return Response.ok().entity("User Saved!").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/edit")
    public Response seditUser(EditUserView saveUserView)  throws Exception {

        UserManager user;
        try {

            user = new UserManager();
            user.editUser(saveUserView);

        } catch (Exception e) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("User could not be edited!").build();
        }

        return Response.ok().entity("User Edited!").build();
    }

    //endregion





/*



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/edit")
    public String editUser(@FormParam("userid") String userid) {
        return "Hello, World!";
    }







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

    */



}
