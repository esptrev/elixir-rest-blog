package trevor_esparza.elixirrestblog.data;

import lombok.*;
import java.util.Date;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    Long id;
    String username;
    String email;
    String password;
    Date createdAt;
    Role role;

    public enum Role{USER, ADMIN}













}////END OF CLASS
