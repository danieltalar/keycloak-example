package talar.daniel.keycloakexample;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
public class Controller {

    @GetMapping(path = "/admin")
    public String helloAdmin(Principal principal) {
        AccessToken accessToken = getAccessToken((KeycloakAuthenticationToken) principal);
        Set<String> roles = accessToken.getRealmAccess().getRoles();
        String name = accessToken.getPreferredUsername();
        return "Hello admin, "+ name + " Your roles " + roles;
    }

    @GetMapping(path = "/user")
    public String helloUser(Principal principal) {
        AccessToken accessToken = getAccessToken((KeycloakAuthenticationToken) principal);
        return "Hello user:, " + accessToken.getPreferredUsername();
    }
    @GetMapping(path = "/public")
    public String helloAnonymous() {
        return "Public endpoint";
    }

    private AccessToken getAccessToken(KeycloakAuthenticationToken principal) {
        return principal.getAccount().getKeycloakSecurityContext().getToken();
    }
}
