package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.GeneralResponse.ApiResponse;
import com.rebel.Ecom.Butter_sb_API.Models.User;
import com.rebel.Ecom.Butter_sb_API.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/butter/api/v1/user")
public class UserController
{
    @Autowired
    private UserService userService;

    //Creating new User
    @PostMapping("/adding-new-user")
    public ResponseEntity<?> addNewUser(@RequestBody User user)
    {

            User createdUser = this.userService.addUser(user);

            Map<String, Object> map;
            HttpStatus status = null;
            String message = "";


                if (createdUser != null) {
                    status = HttpStatus.CREATED;
                    message = "User has been successfully added into db";

                } else {
                    status = HttpStatus.NO_CONTENT;
                    message = "User has not been successfully added into db";

                }
        map = Map.of("object", createdUser, "status", status, "message", message);
        return ResponseEntity.ok(map);


    }

    //Updating user
    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody User user)
    {
        User updatedUser = this.userService.updateUser(user);

        Map<String, Object> map;
        HttpStatus status = null;
        String message = "";

        if (updatedUser != null) {
            status = HttpStatus.OK;
            message = "User has been updated successfully";

        } else {
            status = HttpStatus.NO_CONTENT;
            message = "User has not been found";

        }
        map = Map.of("object", updatedUser, "status", status, "message", message);
        return ResponseEntity.ok(map);
    }

    //Fetching all users
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);


    }

    //Fetching Single User
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable Integer id)
    {

       User user = this.userService.getSingleUserById(id);

        Map<String, Object> map;
        HttpStatus status = null;
        String message = "";


        if (user != null) {
            status = HttpStatus.OK;
            message = "User has been successfully fetched";

        } else {
            status = HttpStatus.NOT_FOUND;
            message = "User has not been found";

        }
        map = Map.of("object", user, "status", status, "message", message);
        return ResponseEntity.ok(map);

    }

    //Deleting user
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id)
    {
        this.userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User is successfully deleted with Id "+id ), HttpStatus.OK);
    }

}
