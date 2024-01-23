package vn.oceantech.l3pre.service;

import vn.oceantech.l3pre.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserByUsername(String username);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    Boolean deleteById(int id);

    UserDto getById(int id);

    List<UserDto> getAll();


}
