package vn.oceantech.l3pre.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictDto {
    private Integer id;
    private ProvinceDto province;
    private String districtName;
}
