package vn.oceantech.l3pre.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.oceantech.l3pre.dto.UserDto;
import vn.oceantech.l3pre.dto.UserPrincipal;
import vn.oceantech.l3pre.entity.User;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.exceptions.NotFoundException;
import vn.oceantech.l3pre.repository.UserRepo;
import vn.oceantech.l3pre.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = getUserByUsername(username);
        if (Objects.isNull(userDto)) {
            throw new UsernameNotFoundException(ErrorMessages.NOT_FOUND.getErrorMessage());
        }
        String role = userDto.getRole().getName();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        authorities.add(authority);
        return new UserPrincipal(userDto.getId(), userDto.getUsername(), userDto.getPassword(), authorities);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepo.getByUsername(username);
        return new ModelMapper().map(user, UserDto.class);
    }

    @Override
    public UserDto create(UserDto userDto) {
        if (userDto.getPassword() != null) {
            userDto.setPassword(new BCryptPasswordEncoder(12).encode(userDto.getPassword()));
        }
        User user = new ModelMapper().map(userDto, User.class);
        return new ModelMapper().map(userRepo.save(user), UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepo.findById(userDto.getId()).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        this.mapDtoToEntity(userDto, user);
        userRepo.save(user);
        return new ModelMapper().map(user, UserDto.class);
    }

    @Override
    public Boolean deleteById(int id) {
        User user = userRepo.findById(id).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        if (Objects.nonNull(user)) {
            userRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public UserDto getById(int id) {
        User user = userRepo.findById(id).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        return new ModelMapper().map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepo.getAll();
        return users.stream().map(user ->
                new ModelMapper().map(user, UserDto.class)).collect(Collectors.toList());
    }

    private void mapDtoToEntity(UserDto userDto, User user) {
        if (userDto.getUsername() != null) {
            user.setUsername(userDto.getUsername());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder(12).encode(userDto.getPassword()));
        }
        if (userDto.getAddress() != null) {
            user.setAddress(userDto.getAddress());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getGender() != null) {
            user.setGender(userDto.getGender());
        }
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getPhoneNumber() != null) {
            user.setPhoneNumber(userDto.getPhoneNumber());
        }
    }
}
