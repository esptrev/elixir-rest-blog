package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.User;
import trevor_esparza.elixirrestblog.data.UserRepository;
import trevor_esparza.elixirrestblog.data.Post;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.*;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
       return userRepository.findAll();
    }

    @GetMapping("{userId}")
    public User getbyId(@PathVariable Long userId) {
        User queriedUser = userRepository.getById(userId);
        return queriedUser;
    }


    @PostMapping
    private void createUser(@RequestBody User newUser) {
        User userToAdd = new User(newUser.getUsername(), newUser.getEmail(), newUser.getPassword());
        userRepository.save(userToAdd);
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

//    @GetMapping("/username")
//    @ResponseBody
//    public User getByUsername(@RequestParam String userName) {
//        return new User(10L, userName, "asdfasdfasdf", "asdfddddddddd", null, null,Arrays.asList(POST4,POST5));
//    }


//    @GetMapping("/email")
//    @ResponseBody
//    public User getByEmail(@RequestParam String email) {
//        return new User(10L, "JimmyJohns", email, "asdfddddddddd", null, null, Arrays.asList(POST6,POST7));
//    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword,
                                @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println("The old password " + oldPassword + " for user " + id +
                " has been changed to " + newPassword);
    }


}////END OF CLASS
