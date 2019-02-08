package stock.exchange.example.rest.service;

import org.json.simple.JSONObject;
import stock.exchange.example.hibernate.tables.Stock;
import stock.exchange.example.hibernate.tables.User;
import stock.exchange.example.hibernate.view.stock.EditStockView;
import stock.exchange.example.hibernate.view.stock.SaveStockView;
import stock.exchange.example.hibernate.view.user.EditUserView;
import stock.exchange.example.hibernate.view.user.SaveUserView;
import stock.exchange.example.rest.authentication.Secured;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/")
public class ServiceManager extends ServiceBase {


    public ServiceManager(@Context HttpServletRequest servletRequest) throws Exception {
        super(servletRequest);
    }

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
    public Response validateUser(@FormParam("loginname") String loginname, @FormParam("password") String password) throws Exception {
        JSONObject jsonObject;
        try {
            if (loginname == null || password == null)
                throw new Exception("Username/password is not valid!");

            jsonObject = this.getSecurityManager().getUserManager().validateUser(loginname, password);

            if (jsonObject.get("token").equals(""))
                throw new Exception("Validation could not be completed!");

        } catch (Exception e) {
            throw new Exception("Username/password is not valid!");
        }

        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
    }

    //endregion

    //region Stock


    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/stock/get")
    public Response getStock(@QueryParam("code") String code) throws Exception {
        Stock stock;
        try {
            stock = this.getSecurityManager().getStockManager().getStock(code);
            if (stock == null)
                return Response.ok().entity("Stock not found!").build();

        } catch (Exception e) {
            throw new Exception("Stock not found!");
        }

        return Response.ok(stock, MediaType.APPLICATION_JSON).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stock/list")
    public Response listStock() throws Exception {

        List<Stock> stockList;
        try {

            stockList = this.getSecurityManager().getStockManager().getStockList();

        } catch (Exception e) {
            throw new Exception("Stock list not found!");
        }

        return Response.ok(stockList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/delete")
    @Secured
    public Response deleteStock(@QueryParam("code") String code) throws Exception {

        try {

            if (this.getUserSessionView().getProfilename().equalsIgnoreCase("admin"))
                this.getSecurityManager().getStockManager().deleteStock(code);
            else
                return Response.ok().entity("Unauthorized Operation!").build();

        } catch (Exception e) {
            throw new Exception("Stock could not deleted!");
        }

        return Response.ok().entity("Stock Deleted!").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/save")
    @Secured
    public Response saveStock(SaveStockView saveStockView) throws Exception {
        try {
            saveStockView.setLastmodifiedby(this.getUserSessionView().getLoginname());
            this.getSecurityManager().getStockManager().saveStock(saveStockView);

        } catch (Exception e) {
            throw new Exception("Stock could not be saved!");
        }

        return Response.ok().entity("Stock Saved!").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/edit")
    @Secured
    public Response editStock(EditStockView editStockView) throws Exception {

        try {
            editStockView.setLastmodifiedby(this.getUserSessionView().getLoginname());
            this.getSecurityManager().getStockManager().editStock(editStockView);

        } catch (Exception e) {
            throw new Exception("Stock could not be edited!");
        }

        return Response.ok().entity("Stock Edited!").build();
    }


    //endregion

    //region User

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/list")
    @Secured
    public Response listUser() throws Exception {
        List<User> userList = null;
        try {
            if (this.getUserSessionView().getProfilename().equalsIgnoreCase("admin"))
                userList = this.getSecurityManager().getUserManager().getUserList();
            else
                return Response.ok().entity("Unauthorized Operation!").build();


        } catch (Exception e) {
            throw new Exception("User list not found!");
        }

        return Response.ok(userList, MediaType.APPLICATION_JSON).build();
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/user/get")
    @Secured
    public Response getUser(@QueryParam("userid") int userid) throws Exception {

        User user;
        try {
            if (this.getUserSessionView().getProfilename().equalsIgnoreCase("admin"))
                user = this.getSecurityManager().getUserManager().getUser(userid);
            else
                return Response.ok().entity("Unauthorized Operation!").build();

        } catch (Exception e) {
            throw new Exception("User not found!");
        }

        return Response.ok(user, MediaType.APPLICATION_JSON).build();
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/delete")
    @Secured
    public Response deleteUser(@QueryParam("userid") int userid) throws Exception {

        try {
            if (this.getUserSessionView().getProfilename().equalsIgnoreCase("admin"))
                this.getSecurityManager().getUserManager().deleteUser(userid);
            else
                return Response.ok().entity("Unauthorized Operation!").build();

        } catch (Exception e) {
            throw new Exception("User could not deleted!");
        }

        return Response.ok().entity("User Deleted!").build();
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/save")
    @Secured
    public Response saveUser(SaveUserView saveUserView) throws Exception {

        try {

            if (this.getUserSessionView().getProfilename().equalsIgnoreCase("admin"))
                this.getSecurityManager().getUserManager().saveUser(saveUserView);
            else
                return Response.ok().entity("Unauthorized Operation!").build();


        } catch (Exception e) {
            throw new Exception("User could not be saved!");
        }

        return Response.ok().entity("User Saved!").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user/edit")
    @Secured
    public Response editUser(EditUserView saveUserView) throws Exception {

        try {
            this.getSecurityManager().getUserManager().editUser(saveUserView);

        } catch (Exception e) {
            throw new Exception("User could not be edited!");
        }

        return Response.ok().entity("User Edited!").build();
    }

    //endregion

    //region User- Stock Operations

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/buy")
    @Secured
    public Response buyStock(@QueryParam("stockcode") String stockcode, @QueryParam("amount") int amount) {

        try {
            this.getSecurityManager().getUserStockManager().buyStock(this.getUserSessionView().getLoginname(),stockcode,amount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok("").build();

    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/stock/sell")
    public Response sellStock(@QueryParam("stockcode") String stockcode, @QueryParam("amount") int amount) {

        try {
            this.getSecurityManager().getUserStockManager().sellStock(this.getUserSessionView().getLoginname(),stockcode,amount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok("").build();

    }
    //endregion


}
