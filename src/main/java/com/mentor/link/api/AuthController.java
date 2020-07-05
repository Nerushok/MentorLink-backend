package com.mentor.link.api;

import com.mentor.link.Constants;
import com.mentor.link.config.JwtTokenUtil;
import com.mentor.link.model.AuthorizationResponse;
import com.mentor.link.model.LoginRequest;
import com.mentor.link.model.RegistrationRequest;
import com.mentor.link.model.User;
import com.mentor.link.model.mappers.UserResponseMapper;
import com.mentor.link.service.AuthService;
import com.mentor.link.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(Constants.API_V1 + "auth")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private UserResponseMapper userResponseMapper;

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        final User user = authService.login(loginRequest);

        authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        final UserDetails userDetails = userDetailsService.getUserDetailsByUser(user);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthorizationResponse(userResponseMapper.map(user), token));
    }

    @PostMapping("/registration")
    public ResponseEntity<AuthorizationResponse> registration(@RequestBody RegistrationRequest registrationRequest) {
        final User user = authService.registration(registrationRequest);

        final UserDetails userDetails = userDetailsService.getUserDetailsByUser(user);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthorizationResponse(userResponseMapper.map(user), token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
