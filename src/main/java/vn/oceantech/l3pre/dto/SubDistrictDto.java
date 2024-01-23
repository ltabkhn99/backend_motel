package vn.oceantech.l3pre.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubDistrictDto {
    private Integer id;
    private DistrictDto district;
    private String subDistrictName;
}
