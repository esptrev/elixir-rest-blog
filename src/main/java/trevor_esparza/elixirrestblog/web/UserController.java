package trevor_esparza.elixirrestblog.web;


import org.springframework.web.bind.annotation.*;
import trevor_esparza.elixirrestblog.data.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers="Accept=application/json")
public class UserController {


    @GetMapping
    public List<User> getAll (){
        List<User> users = new ArrayList<>();
        users.add(new User(1L,"Trevor","coduep@codep","asdfasdf",null,null));
        users.add(new User(2L,"Kristin","kristinp@codep","asdfasdf",null,null));
        users.add(new User(3L,"Wesley","wesley@codep","asdfasdf",null,null));
        users.add(new User(4L,"DocRob","DocRob@codep","asdfasdf",null,null));
        users.add(new User(5L,"Yellow Duck","duckey@codep","asdfasdf",null,null));

        return users;
    }

    @GetMapping("{userId}")
    public User getbyId(@PathVariable Long userId){
        return new User(userId, "Trevor","coduep@codep","asdfasdf",null,null);
    }


    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println("New User from POstman" + newUser);
    }


    @PutMapping("{userId}")
    private void updateUser(@PathVariable Long userId, @RequestBody User updatedUser){
        System.out.println("User " + userId + " has been updated with " + updatedUser);
    }

    @DeleteMapping("{userId}")
    private void deleteUser (@PathVariable Long userId){
        System.out.println("delete method reached" + userId);
    }









}////END OF CLASS
