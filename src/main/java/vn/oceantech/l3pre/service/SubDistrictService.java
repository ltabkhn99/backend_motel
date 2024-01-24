package vn.oceantech.l3pre.service;

import vn.oceantech.l3pre.dto.SubDistrictDto;

import java.util.List;

public interface SubDistrictService {
    List<SubDistrictDto> getByDistrictId(Integer districtId);
}
