package vn.oceantech.l3pre.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private Boolean gender;

    private String email;

    private String phoneNumber;

    private String address;

    private RoleDto role;

    private List<MotelRoomDto> motelRooms;
}
