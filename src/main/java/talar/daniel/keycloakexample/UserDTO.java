
package talar.daniel.keycloakexample;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String userName;
    private String emailId;
    private String password;
    private String firstname;
    private String lastName;
}