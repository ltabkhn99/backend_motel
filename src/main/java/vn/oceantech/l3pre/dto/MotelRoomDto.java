package vn.oceantech.l3pre.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MotelRoomDto {
    private Integer id;

    private String name;

    private String description;  // mô tả

    private Double price;  // giá

    private Double acreage; // diện tích

    private Integer maxNumberPeople; // số lượng người tối đa

    private LocalDateTime postTime; // thời gian đăng tải

    private ProvinceDto province;  // tinh

    private DistrictDto district;  // quận

    private SubDistrictDto subDistrict;  // phường

    private String address; // số nhà, tên đường

    private TypeRoomDto typeRoom;  // loại phòng trọ

    private UserDto user;

    private String neighborUniversity;  // trường đại học lân cận

    private String linkGgMap;  // link gg map

    private String image;  // ảnh phòng

    private String coverImage;  // ảnh bìa
}
