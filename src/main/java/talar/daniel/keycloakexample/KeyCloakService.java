package talar.daniel.keycloakexample;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collections;

@Service
public class KeyCloakService {

    public void addUser(UserDTO userDTO){
        CredentialRepresentation credential = Credentials
                .createPasswordCredentials(userDTO.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmailId());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);

        Keycloak keycloak =  KeycloakConfig.getInstance();
// Get realm
        RealmResource realmResource = keycloak.realm("SpringBootKeycloak");
        UsersResource userRessource = realmResource.users();

// Create user (requires manage-users role)
        try {
            Response response = userRessource.create(user);
            System.out.println(response.getStatus());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
