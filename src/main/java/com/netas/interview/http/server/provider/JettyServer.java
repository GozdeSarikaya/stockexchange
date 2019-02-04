package com.netas.interview.http.server.provider;

import com.netas.interview.http.server.base.IHttpServer;
import com.netas.interview.rest.authentication.AuthenticationFilter;
import com.sun.deploy.services.ServiceManager;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServer implements IHttpServer {
    //region Constructor

    public JettyServer() throws Exception {
        Log.setLog(new Slf4jLog());
    }

    //endregion

    //region Private Members

    private Server jettyServer;
    private boolean isStarted = false;

    //endregion

    //region Public Members

    public Server getJettyServer() {
        return jettyServer;
    }

    //endregion

    //region Private Methods

    //endregion

    //region IHttpServer Methods

    @Override
    public void destroy() throws Exception {
        try {
            jettyServer.stop();
            jettyServer.destroy();
        } catch (Exception ex) {
            throw new Exception("Jetty server kapatma işleminde hata oluştu.", ex);
        }
    }

    @Override
    public boolean isStarted() {
        return isStarted;
    }

    @Override
    public void run() {
        try {

            ResourceConfig config = new ResourceConfig(ServiceManager.class);

            config.register(AuthenticationFilter.class);
            ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(config));

            jettyServer = new Server();

            /*HttpConfiguration httpConfiguration = new HttpConfiguration();
            httpConfiguration.setBlockingTimeout(60000);

            ServerConnector connector = new ServerConnector(jettyServer, new HttpConnectionFactory(httpConfiguration)); */

            ServerConnector connector = new ServerConnector(jettyServer, new HttpConnectionFactory());
            connector.setPort(9999);
            connector.setIdleTimeout(10000);


            jettyServer.addConnector(connector);

            ServletContextHandler context = new ServletContextHandler(jettyServer, "/");
            context.addServlet(jerseyServlet, "/*");

            jettyServer.start();
            isStarted = true;
        } catch (Exception ex) {
            String exceptionMessage = "JettyServer başlatma işlemi (Thread.Run) hata oluştu";
            if (ex.getMessage().contains("in use"))
                exceptionMessage = "Aynı port kullanıldığı için, JettyServer başlatılamadı";
            throw new RuntimeException(exceptionMessage, ex);
        }
    }

//endregion
}
