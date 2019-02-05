package stock.exchange.example.rest.authentication;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter
{

    @Context
    public transient HttpServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext requestContext)
    {
        UserSessionView tokenUserSessionView;
        try {
            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader == null) {
                throw new NotAuthorizedException("AuthorizationHeader bilgisi bulunamadı");
            }

            byte[] decoded;
            String accessToken;
            try {
                authorizationHeader = authorizationHeader.replaceFirst("[B|b]asic ", "");
                decoded = java.util.Base64.getDecoder().decode(authorizationHeader);
                accessToken = new String(decoded).split(":", 2)[0]; //0:UserName,1:PAssword alanı. UserName içinde, accesstoken bilgisi var.
            } catch (Exception ex) {
                throw new NotAuthorizedException("AccessToken bilgisi alınamadı", ex);
            }

            JWTManager.validateToken(servletRequest, accessToken);
        } catch (Exception exception) {

        }
    }

}
