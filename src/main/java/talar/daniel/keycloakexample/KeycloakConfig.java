package talar.daniel.keycloakexample;

import org.keycloak.admin.client.Keycloak;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    private final static String serverUrl = "http://localhost:8080/auth";
    private final static String realm = "master";
    private final static String clientId = "admin-cli";
    private final static String userName = "admin";
    private final static String password = "admin";


    @Bean
    public static Keycloak getInstance(){
            return Keycloak.getInstance(
                    serverUrl,
                    realm,
                    userName,
                    password,
                    clientId);
        }
}