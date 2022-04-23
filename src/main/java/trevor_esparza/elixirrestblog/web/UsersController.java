package trevor_esparza.elixirrestblog.web;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.User;
import trevor_esparza.elixirrestblog.data.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.*;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {
    private final UserRepository userRepository;
    private final PasswordEncoder pwhashmaker;

    public UsersController(UserRepository userRepository, PasswordEncoder pwhashmaker) {
        this.userRepository = userRepository;
        this.pwhashmaker = pwhashmaker;
    }

    @GetMapping
    public List<User> getAll() {
       return userRepository.findAll();
    }

    @GetMapping("{userId}")
    public Optional<User> getbyId(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }


    @PostMapping
    private void createUser(@RequestBody User newUser) {
        newUser.setRole(User.Role.USER);
        newUser.setPassword(newUser.getPassword());
        newUser.setUsername(newUser.getUsername());
        String encryptedPW = newUser.getPassword();
        encryptedPW = pwhashmaker.encode(encryptedPW);
        newUser.setPassword(encryptedPW);
        userRepository.save(newUser);
        System.out.println("Create User in UC reached");
    }


    @PutMapping("{userId}")
    private void updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User userToUpdate = userRepository.getById(userId);
        userToUpdate.setUsername(updatedUser.getUsername());
        userToUpdate.setEmail(updatedUser.getEmail());
        userToUpdate.setPassword(updatedUser.getPassword());
        System.out.println("updateUser UC reached");
    }

    @DeleteMapping("{userId}")
    private void deleteUser(@PathVariable Long userId) {
        User userToDelete = userRepository.getById(userId);
        userRepository.delete(userToDelete);
        System.out.println("deleteUser in UC reached");
    }

    @GetMapping("userName")
    public User getByUsername(@RequestParam String userName) {
        return userRepository.findByUsername(userName);
    }


    @GetMapping("email")
    User getByEmail(@RequestParam String email) {
       return userRepository.findByEmail(email);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword,
                                @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println("The old password " + oldPassword + " for user " + id +
                " has been changed to " + newPassword);
    }


}////END OF CLASS
