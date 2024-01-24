package vn.oceantech.l3pre.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavedMotelDto {
    private Integer id;

    private MotelRoomDto motelRoom;

    private UserDto user;
}
