package com.netas.interview.rest.service;

import com.netas.interview.hibernate.manager.StockManager;
import com.netas.interview.hibernate.manager.UserManager;
import com.netas.interview.hibernate.tables.Stock;
import com.netas.interview.hibernate.tables.User;
import com.netas.interview.hibernate.view.stock.EditStockView;
import com.netas.interview.hibernate.view.stock.SaveStockView;
import com.netas.interview.hibernate.view.user.EditUserView;
import com.netas.interview.hibernate.view.user.SaveUserView;
import com.netas.interview.rest.authentication.Secured;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/")
public class ServiceManager {


    //region Is Alive?
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/isAlive")
    public String isAlive() {
        return "Hello, World!";
    }

    //endregion

    //region Validation
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/validate")
    public Response validateUser(@FormParam("loginname") String loginname, @FormParam("password") String password) {
        JSONObject jsonObject = new JSONObject();
        UserManager userManager;
        try {

            userManager = new UserManager();
            jsonObject= userManager.validateUser(loginname, password);
            // stock = stockManager.getStock(stockid);
            // jsonObject.put("stock", objectMapper.writeValueAsString(stock));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
    }

    //endregion

    //region Stock


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stock/get")
    public Response getStock(@QueryParam("code") String code) {
        JSONObject jsonObject = new JSONObject();
        Stock stock;
        StockManager stockManager;
        try {

            stockManager = new StockManager();
            stock = stockManager.getStock(code);
            if (stock != null)
                jsonObject.put("stock", stock);
            else
                Response.ok().entity("Stock is NOT found!").build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
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
            jsonObject.put("stocklist", stockList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/delete")
    @Secured
    public Response deleteStock(@QueryParam("code") String code) {

        StockManager stockManager;
        try {

            stockManager = new StockManager();
            stockManager.deleteStock(code);

        } catch (Exception e) {
            Response.status(Response.Status.EXPECTATION_FAILED).entity("Stock could not deleted!").build();
        }

        return Response.ok().entity("Stock Deleted!").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/save")
    public Response saveStock(SaveStockView saveStockView) throws Exception {

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
    public Response editStock(EditStockView editStockView) throws Exception {

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
            jsonObject.put("userlist", userList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/get")
    public Response getUser(@QueryParam("userid") int userid) {

        JSONObject jsonObject = new JSONObject();
        User user;
        UserManager userManager;
        try {

            userManager = new UserManager();
            user = userManager.getUser(userid);
            if (user != null)
                jsonObject.put("user", user);
            else
                Response.ok().entity("User is NOT found!").build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
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
    @Secured
    public Response saveUser(SaveUserView saveUserView) throws Exception {

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
    public Response editUser(EditUserView saveUserView) throws Exception {

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

    //region User- Stock Operations

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
