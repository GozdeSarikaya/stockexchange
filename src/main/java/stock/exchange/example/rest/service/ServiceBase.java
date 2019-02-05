package stock.exchange.example.rest.service;


import stock.exchange.example.rest.authentication.UserSessionView;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public abstract class ServiceBase {
    //region Constructor

    public ServiceBase(@Context HttpServletRequest servletRequest) throws Exception {
        initialize(servletRequest);
    }

    //endregion

    //region Private Members

    @Context
    private HttpServletRequest servletRequest;
    private UserSessionView userSessionView;
    private stock.exchange.example.rest.security.SecurityManager securityManager;

    //endregion

    //region Public Members

    public UserSessionView getUserSessionView() throws Exception {
        UserSessionView userSessionView = null;
        try {
            userSessionView = new UserSessionView();
            securityManager = new stock.exchange.example.rest.security.SecurityManager();
            securityManager.getSecurityContext().setUserSessionView(userSessionView);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return securityManager.getSecurityContext().getUserSessionView();
    }

    //endregion

    //region private Methods

    private void initialize(HttpServletRequest servletRequest) throws Exception {

        this.servletRequest = servletRequest;

        try {
            initializeHttpServletRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initializeHttpServletRequest() throws Exception {
        if (servletRequest != null) {
            servletRequest.setAttribute("TokenUserSessionView", getUserSessionView());
        }
    }
    //endregion

    //region Public Methods

    @PreDestroy
    public void cleanUpResources() {
        this.servletRequest = null;
        userSessionView = null;

    }

    //endregion
}