package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.GeneralResponse.ApiResponse;
import com.rebel.Ecom.Butter_sb_API.Models.User;
import com.rebel.Ecom.Butter_sb_API.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/butter/api/v1/user")
public class UserController
{
    @Autowired
    private UserService userService;

    //Creating new User
    @PostMapping("/adding-new-user")
    public ResponseEntity<User> addNewUser(@RequestBody User user)
    {
        User createdUser = this.userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    //Updating user
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User updatedUser = this.userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Fetching all users
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    //Fetching Single User
    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer id)
    {

        return new ResponseEntity<>(this.userService.getSingleUserById(id), HttpStatus.OK);
    }

    //Deleting user
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id)
    {
        this.userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User is successfully deleted with Id "+id ), HttpStatus.OK);
    }

}
