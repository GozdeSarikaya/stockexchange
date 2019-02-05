package stock.exchange.example.http.server.base;

public interface IHttpServer extends Runnable{
    void destroy() throws Exception;
    boolean isStarted();
}
