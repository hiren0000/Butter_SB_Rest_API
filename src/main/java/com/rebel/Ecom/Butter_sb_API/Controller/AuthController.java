package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.jwtCompo.JwtHelper;
import com.rebel.Ecom.Butter_sb_API.jwtCompo.JwtRequest;
import com.rebel.Ecom.Butter_sb_API.jwtCompo.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/generating-token")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest)
    {
       this.doAuthenticate(jwtRequest.getEmail(), jwtRequest.getPassword());

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getEmail());
        String token = this.jwtHelper.generateToken(userDetails);

        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Invalid Credentials !!";
    }

}
