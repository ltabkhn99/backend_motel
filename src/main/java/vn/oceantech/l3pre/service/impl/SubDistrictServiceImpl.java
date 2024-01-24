package vn.oceantech.l3pre.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.oceantech.l3pre.dto.SubDistrictDto;
import vn.oceantech.l3pre.entity.SubDistrict;
import vn.oceantech.l3pre.repository.SubDistrictRepo;
import vn.oceantech.l3pre.service.SubDistrictService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubDistrictServiceImpl implements SubDistrictService {
    private final SubDistrictRepo subDistrictRepo;

    @Override
    public List<SubDistrictDto> getByDistrictId(Integer districtId) {
        List<SubDistrict> subDistricts = subDistrictRepo.getByDistrictId(districtId);
        return subDistricts.stream().map(subDistrict -> new ModelMapper()
                .map(subDistrict, SubDistrictDto.class)).collect(Collectors.toList());
    }
}
