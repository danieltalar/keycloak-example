package talar.daniel.keycloakexample;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {

    static Keycloak keycloak = null;
    final static String serverUrl = "http://localhost:8080/auth";
    public final static String realm = "SpringBootKeycloak";
    final static String clientId = "admin-cli";
    final static String clientSecret = "0606da95-1eae-4f71-b2d8-ae46313c5a6a";
    final static String userName = "admin";
    final static String password = "admin";

    public KeycloakConfig() {
    }

    public static Keycloak getInstance(){
        if(keycloak == null){
           
//            keycloak = KeycloakBuilder.builder()
//                    .serverUrl(serverUrl)
//                    .realm(realm)
//                    .grantType(OAuth2Constants.PASSWORD)
//                    .username(userName)
//                    .password(password)
//                    .clientId(clientId)
//                    .clientSecret(clientSecret)
//                    .resteasyClient(new ResteasyClientBuilder()
//                                    .connectionPoolSize(10)
//                                   .build()
//                                   )
//                    .build();
            keycloak = Keycloak.getInstance(
                    "http://localhost:8080/auth",
            "master",  //your realm
                    "admin", //user
                    "admin", //password
                    "admin-cli"); //client

//             keycloak = KeycloakBuilder.builder()
//                    .serverUrl(serverUrl) //
//                    .realm(realm) //
//                    .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
//                    .clientId(clientId) //
////                                         .resteasyClient(new ResteasyClientBuilder()
////                                    .connectionPoolSize(10)
////                                   .build())
//                     .username(userName)
//                     .password(password)
//                    .clientSecret(clientSecret).build();
        }
        return keycloak;
    }
}