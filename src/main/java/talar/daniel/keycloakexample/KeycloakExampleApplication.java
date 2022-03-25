package talar.daniel.keycloakexample;

import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class KeycloakExampleApplication {

	@Autowired
	KeyCloakService keyCloakService;

	public static void main(String[] args) {
		SpringApplication.run(KeycloakExampleApplication.class, args);
	}


	@PostConstruct
	public void init(){
		System.out.println("BEGIN");
		keyCloakService.addUser(UserDTO.builder()
						.firstname("Daniel")
						.lastName("Talar")
						.password("test")
						.userName("test")
				.build());
		System.out.println("FINIsHED");
	}

}
