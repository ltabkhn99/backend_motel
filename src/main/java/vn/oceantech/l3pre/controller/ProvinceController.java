package vn.oceantech.l3pre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.oceantech.l3pre.common.Response;
import vn.oceantech.l3pre.dto.ProvinceDto;
import vn.oceantech.l3pre.service.ProvinceService;

import java.util.List;

@RestController
@RequestMapping("/api/province")
@RequiredArgsConstructor
public class ProvinceController {
    private final ProvinceService provinceService;

    @GetMapping
    public Response<List<ProvinceDto>> getAll() {
        return Response.buildResponse(provinceService.getAll());
    }

}
