package stock.exchange.example.rest.security;

import stock.exchange.example.rest.authentication.UserSessionView;

public class SecurityContext {

    public SecurityContext() {
    }

    private UserSessionView userSessionView;

    public UserSessionView getUserSessionView() {
        return userSessionView;
    }

    public void setUserSessionView(UserSessionView userSessionView) {
        this.userSessionView = userSessionView;
    }
}
