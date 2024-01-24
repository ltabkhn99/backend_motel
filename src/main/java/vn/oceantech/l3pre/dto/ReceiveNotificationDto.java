package vn.oceantech.l3pre.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiveNotificationDto {
    private Integer id;

    private UserDto user;

    private ProvinceDto province;  // tinh

    private DistrictDto district;  // quận

    private SubDistrictDto subDistrict;  // phường
}
