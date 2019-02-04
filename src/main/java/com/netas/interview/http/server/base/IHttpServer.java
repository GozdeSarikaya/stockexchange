package com.netas.interview.http.server.base;

public interface IHttpServer extends Runnable{
    void destroy() throws Exception;
    boolean isStarted();
}
