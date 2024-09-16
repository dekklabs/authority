package com.backpruebatecnica.backpruebatecnica.User.infrastructure.adapter.in;

import com.backpruebatecnica.backpruebatecnica.User.application.command.CreateUserCommand;
import com.backpruebatecnica.backpruebatecnica.User.application.dto.CreateUserDTO;
import com.backpruebatecnica.backpruebatecnica.User.application.dto.LoginUserDTO;
import com.backpruebatecnica.backpruebatecnica.User.application.handler.UserCommandhandler;
import com.backpruebatecnica.backpruebatecnica.User.application.handler.UserQueryHandler;
import com.backpruebatecnica.backpruebatecnica.User.domain.service.CustomUserDetails;
import com.backpruebatecnica.backpruebatecnica.User.shared.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUti;

    public UserController(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtUtil jwtUti
    ) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUti = jwtUti;
    }

    @Autowired
    private UserCommandhandler commandhandler;

    @Autowired
    private UserQueryHandler queryHandler;

    @PostMapping("/register")
    public String register(@RequestBody CreateUserDTO createUserDTO) {
        CreateUserCommand command = new CreateUserCommand(
                createUserDTO.getUsername(),
                createUserDTO.getPassword(),
                createUserDTO.getEmail());
        commandhandler.handle(command);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginUserDTO loginUserDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUserDTO.getUsername(), loginUserDTO.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(loginUserDTO.getUsername());

        //return jwtUti.generateToken(userDetails, userDetails.getId().toString());
        String token = jwtUti.generateToken(userDetails, userDetails.getId().toString());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }
}
