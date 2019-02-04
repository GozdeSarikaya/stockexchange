package com.netas.interview.http.server.application;

import com.netas.interview.http.server.base.IHttpServer;
import com.netas.interview.http.server.provider.JettyServer;

public class HttpServerManager {
//region Constructor

    public HttpServerManager() {

        initialize();
    }

    //endregion

    //region Private Members

    private IHttpServer httpServer;

    //endregion

    //region Public Members

    //endregion

    //region Private Methods

    private void initialize() {

    }

    //endregion

    public void close() {

        if (isHttpServerStarted()) {
            try {
                httpServer.destroy();
            } catch (Exception exception) {

            }
        }

    }
    //endregion

    //region Public Methods


    public IHttpServer getHttpServer() {
        return httpServer;
    }

    public Boolean isHttpServerStarted() {
        return (httpServer != null);
    }

    public void start() throws Exception {
        Thread serverThread;
        try {

            httpServer = new JettyServer();

            serverThread = new Thread(httpServer);
            serverThread.start();

        } catch (Exception ex) {
            throw new Exception("HttpServerManager başlatma işleminde hata oluştu", ex);
        }
    }

    //endregion

    /*
    public void start() throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(9999);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.netas.interview.rest.service");

        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jettyServer.destroy();
        }

    }*/
}
