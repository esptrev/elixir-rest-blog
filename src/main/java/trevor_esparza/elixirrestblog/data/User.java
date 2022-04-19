package trevor_esparza.elixirrestblog.data;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {


    public enum Role{USER, ADMIN}

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDate createdAt;
    private Role role;




}////END OF CLASS
