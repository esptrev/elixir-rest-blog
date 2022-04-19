package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.User;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {


    @GetMapping
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Trevor", "coduep@codep", "111111111", null, User.Role.ADMIN));
        users.add(new User(2L, "Kristin", "kristinp@codep", "222222222", null, User.Role.USER));
        users.add(new User(3L, "Wesley", "wesley@codep", "333333333", null, User.Role.USER));
        users.add(new User(4L, "DocRob", "DocRob@codep", "444444444", null, User.Role.USER));
        users.add(new User(5L, "Yellow Duck", "duckey@codep", "555555555", null, User.Role.ADMIN));

        return users;
    }

    @GetMapping("{userId}")
    public User getbyId(@PathVariable Long userId) {
        User user = new User(userId, "Trevor", "coduep@codep", "asdfasdf", null, null);
        return user;
    }


    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println("New User from POstman" + newUser);
    }


    @PutMapping("{userId}")
    private void updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        System.out.println("User " + userId + " has been updated with " + updatedUser);
    }

    @DeleteMapping("{userId}")
    private void deleteUser(@PathVariable Long userId) {
        System.out.println("delete user method reached" + userId);
    }

    @GetMapping("/username")
    @ResponseBody
    public User getByUsername(@RequestParam String userName) {
        return new User(10L, userName, "asdfasdfasdf", "asdfddddddddd", null, null);
    }


    @GetMapping("/email")
    @ResponseBody
    public User getByEmail(@RequestParam String email) {
        return new User(10L, "JimmyJohns", email, "asdfddddddddd", null, null);
    }

    @PutMapping("/api/users/{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        System.out.println("The old password " + oldPassword + " for user " + id + " has been changed to " + newPassword);
    }


}////END OF CLASS
