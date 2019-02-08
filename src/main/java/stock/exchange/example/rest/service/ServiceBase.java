package stock.exchange.example.rest.service;


import stock.exchange.example.rest.authentication.UserSessionView;
import stock.exchange.example.rest.security.SecurityManager;

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


    public SecurityManager getSecurityManager() throws Exception{
        if (securityManager == null)
            initializeSecurityManager();
        return securityManager;
    }

    public UserSessionView getUserSessionView() throws Exception{
        return securityManager.getSecurityContext().getUserSessionView();
    }


    //endregion

    //region private Methods

    private void initialize(HttpServletRequest servletRequest) throws Exception {

        this.servletRequest = servletRequest;

        try {
            securityManager = new SecurityManager();
            initializeHttpServletRequest(securityManager);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initializeHttpServletRequest(SecurityManager securityManager) throws Exception {
        if (servletRequest != null) {
            servletRequest.setAttribute("TokenUserSessionView", securityManager.getSecurityContext().getUserSessionView());
        }
    }

    private void initializeSecurityManager() throws Exception {
        securityManager = new SecurityManager();
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