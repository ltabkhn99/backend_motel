package vn.oceantech.l3pre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.oceantech.l3pre.common.Response;
import vn.oceantech.l3pre.dto.SubDistrictDto;
import vn.oceantech.l3pre.service.SubDistrictService;

import java.util.List;

@RestController
@RequestMapping("/api/sub-district")
@RequiredArgsConstructor
public class SubDistrictController {
    private final SubDistrictService subDistrictService;

    @GetMapping("/{districtId}")
    public Response<List<SubDistrictDto>> getByProvinceId(@PathVariable("districtId") Integer districtId) {
        return Response.buildResponse(subDistrictService.getByDistrictId(districtId));
    }

}
