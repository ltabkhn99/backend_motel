package vn.oceantech.l3pre.service;

import vn.oceantech.l3pre.dto.DistrictDto;

import java.util.List;

public interface DistrictService {
    List<DistrictDto> getByProvinceId(Integer provinceId);
}
