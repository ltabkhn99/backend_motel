package vn.oceantech.l3pre.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.oceantech.l3pre.dto.ProvinceDto;
import vn.oceantech.l3pre.entity.Province;
import vn.oceantech.l3pre.repository.ProvinceRepo;
import vn.oceantech.l3pre.service.ProvinceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepo provinceRepo;

    @Override
    public List<ProvinceDto> getAll() {
        List<Province> provinces = provinceRepo.getAll();
        return provinces.stream().map(province -> new ModelMapper().
                map(province, ProvinceDto.class)).collect(Collectors.toList());
    }
}
