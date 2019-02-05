package stock.exchange.example.rest.security;

public class SecurityManager {

    public SecurityManager() {
        initialize();
    }

    private SecurityContext securityContext;

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    private void initialize() {

        securityContext = new SecurityContext();

    }


}
