package talar.daniel.keycloakexample;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController("/user")
public class UserController {

    @GetMapping(path = "/info")
    public String helloUser(Principal principal) {
        AccessToken accessToken = getAccessToken((KeycloakAuthenticationToken) principal);
        Set<String> roles = accessToken.getRealmAccess().getRoles();
        String name = accessToken.getPreferredUsername();
        return "Hello, "+ name + " Your roles " + roles;
    }

    private AccessToken getAccessToken(KeycloakAuthenticationToken principal) {
        return principal.getAccount().getKeycloakSecurityContext().getToken();
    }
}
