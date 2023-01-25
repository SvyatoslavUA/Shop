package shop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dto.UserDTO;
import shop.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public UserDTO getUser(@PathVariable Long userId, @PathVariable String password){
        return userService.getUser(userId, password);
    }

    @PutMapping("/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/update/{userId}/{password}")
    public UserDTO updateUserInformation(@PathVariable Long userId, @PathVariable String password){
        return userService.updateUserInformation(userId, password);
    }
}

