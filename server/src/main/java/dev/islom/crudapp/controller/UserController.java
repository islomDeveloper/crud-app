package dev.islom.crudapp.controller;


import dev.islom.crudapp.payload.ApiResponse;
import dev.islom.crudapp.payload.UserDto;
import dev.islom.crudapp.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("addUser")
    public HttpEntity<?> addUser(@RequestBody UserDto userDto){
        ApiResponse apiResponse = userService.addUser(userDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("users")
    public HttpEntity<?> getUsers(){
        ApiResponse apiResponse = userService.getUsers();
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("editUser")
    public HttpEntity<?> editUser(@RequestBody UserDto userDto){
        ApiResponse apiResponse = userService.editUser(userDto);
        return ResponseEntity.status(apiResponse.isSuccess()?204:409).body(apiResponse);
    }

    @DeleteMapping("deleteUser")
    public HttpEntity<?> deleteUser(@RequestBody UserDto userDto){
        ApiResponse apiResponse = userService.deleteUser(userDto);
        return ResponseEntity.status(apiResponse.isSuccess()?204:409).body(apiResponse);
    }
}
