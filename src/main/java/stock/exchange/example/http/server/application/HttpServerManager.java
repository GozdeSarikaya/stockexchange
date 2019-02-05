package stock.exchange.example.http.server.application;

import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import stock.exchange.example.http.server.base.IHttpServer;
import stock.exchange.example.rest.authentication.AuthenticationFilter;
import stock.exchange.example.rest.service.ServiceManager;

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
/*
    public void start() throws Exception {
        Thread serverThread;
        try {

            httpServer = new JettyServer();

            serverThread = new Thread(httpServer);
            serverThread.start();

        } catch (Exception ex) {
            throw new Exception("HttpServerManager başlatma işleminde hata oluştu", ex);
        }
    }*/

    //endregion


    public void start() throws Exception {
/*
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(9999);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.netas.interview.rest.service");

*/

        ResourceConfig config = new ResourceConfig(ServiceManager.class);

        config.register(AuthenticationFilter.class);
        ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(config));

        Server jettyServer = new Server();

        ServerConnector connector = new ServerConnector(jettyServer, new HttpConnectionFactory());
        connector.setPort(9999);
        connector.setIdleTimeout(10000);


        jettyServer.addConnector(connector);

        ServletContextHandler context = new ServletContextHandler(jettyServer, "/");
        context.addServlet(jerseyServlet, "/*");

        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "stock.exchange.example.rest.service");


        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jettyServer.destroy();
        }

    }
}
