package vn.oceantech.l3pre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.oceantech.l3pre.common.Response;
import vn.oceantech.l3pre.dto.DistrictDto;
import vn.oceantech.l3pre.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("/api/district")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/{provinceId}")
    public Response<List<DistrictDto>> getByProvinceId(@PathVariable("provinceId") Integer provinceId) {
        return Response.buildResponse(districtService.getByProvinceId(provinceId));
    }
}
