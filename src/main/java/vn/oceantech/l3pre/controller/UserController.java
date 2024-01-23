package vn.oceantech.l3pre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import vn.oceantech.l3pre.common.ApiMessageError;
import vn.oceantech.l3pre.common.Response;
import vn.oceantech.l3pre.constants.ErrorMessage;
import vn.oceantech.l3pre.dto.UserDto;
import vn.oceantech.l3pre.exceptions.AuthenticateException;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.security.JwtTokenProvider;
import vn.oceantech.l3pre.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public Response<String> login(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return Response.buildResponse(jwtTokenProvider.createToken(username));
        } catch (AuthenticationException e) {
            throw new AuthenticateException(ErrorMessages.UNAUTHORIZED,
                    new ApiMessageError(ErrorMessage.SECURITY.UNAUTHORIZED));
        }
    }

    @PostMapping("/login-system")
    public Response<UserDto> loginSystem(@RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return Response.buildResponse(userService.getUserByUsername(username));
        } catch (AuthenticationException e) {
            return Response.buildResponse(ErrorMessage.SECURITY.UNAUTHORIZED);
        }
    }

    @PostMapping
    public Response<UserDto> create(@RequestBody UserDto userDTO) {
        return Response.buildResponse(userService.create(userDTO));
    }

    @PutMapping
    public Response<UserDto> update(@RequestBody UserDto userDTO) {
        return Response.buildResponse(userService.update(userDTO));
    }

    @DeleteMapping("/{id}")
    public Response<Boolean> deleteById(@PathVariable("id") int id) {
        return Response.buildResponse(userService.deleteById(id));
    }

    @GetMapping("/{id}")
    public Response<UserDto> getById(@PathVariable("id") int id) {
        return Response.buildResponse(userService.getById(id));
    }

    @GetMapping
    public Response<List<UserDto>> getAll() {
        return Response.buildResponse(userService.getAll());
    }


}
