package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.Post;
import trevor_esparza.elixirrestblog.data.User;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {
    private static final Post POST1 = new Post(1L, "blogone", "one one one", null);
    private static final Post POST2 = new Post(2L, "blogtwo", "two two two", null);
    private static final Post POST3 = new Post(3L, "blogthree", "three three three", null);
    private static final Post POST4 = new Post(4L, "blogfour", "four four four", null);
    private static final Post POST5 = new Post(5L, "blogfive", "five five five", null);
    private static final Post POST6 = new Post(6L, "blogsix", "six six six", null);
    private static final Post POST7 = new Post(7L, "blogseven", "seven seven seven", null);
    private static final Post POST8 = new Post(8L, "blogeight", "eight eight eight", null);
    private static final Post POST9 = new Post(9L, "blognine", "nine nine nine", null);
    private static final Post POST10 = new Post(10L, "blogten", "ten ten ten", null);


    @GetMapping
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Trevor", "coduep@codep", "111111111", null, User.Role.ADMIN, Arrays.asList(POST1, POST2)));
        users.add(new User(2L, "Kristin", "kristinp@codep", "222222222", null, User.Role.USER, Arrays.asList(POST3, POST4)));
        users.add(new User(3L, "Wesley", "wesley@codep", "333333333", null, User.Role.USER, Arrays.asList(POST5, POST6)));
        users.add(new User(4L, "DocRob", "DocRob@codep", "444444444", null, User.Role.USER, Arrays.asList(POST7, POST8)));
        users.add(new User(5L, "Yellow Duck", "duckey@codep", "555555555", null, User.Role.ADMIN, Arrays.asList(POST9, POST10)));

        return users;
    }

    @GetMapping("{userId}")
    public User getbyId(@PathVariable Long userId) {
        User user = new User(userId, "Trevor", "coduep@codep", "asdfasdf", null, null, Arrays.asList(POST1,POST9));
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
        return new User(10L, userName, "asdfasdfasdf", "asdfddddddddd", null, null,Arrays.asList(POST4,POST5));
    }


    @GetMapping("/email")
    @ResponseBody
    public User getByEmail(@RequestParam String email) {
        return new User(10L, "JimmyJohns", email, "asdfddddddddd", null, null, Arrays.asList(POST6,POST7));
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword,
                                @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println("The old password " + oldPassword + " for user " + id +
                " has been changed to " + newPassword);
    }


}////END OF CLASS
