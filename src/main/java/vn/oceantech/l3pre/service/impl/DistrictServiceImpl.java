package vn.oceantech.l3pre.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.oceantech.l3pre.dto.DistrictDto;
import vn.oceantech.l3pre.entity.District;
import vn.oceantech.l3pre.repository.DistrictRepo;
import vn.oceantech.l3pre.service.DistrictService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepo districtRepo;

    @Override
    public List<DistrictDto> getByProvinceId(Integer provinceId) {
        List<District> districts = districtRepo.getByProvinceId(provinceId);
        return districts.stream().map(district -> new ModelMapper().
                map(district, DistrictDto.class)).collect(Collectors.toList());
    }
}
