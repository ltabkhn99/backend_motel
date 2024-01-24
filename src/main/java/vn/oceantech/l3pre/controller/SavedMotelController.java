package vn.oceantech.l3pre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.oceantech.l3pre.common.Response;
import vn.oceantech.l3pre.dto.SavedMotelDto;
import vn.oceantech.l3pre.service.SavedMotelService;

@RestController
@RequestMapping("/api/saved-motel")
@RequiredArgsConstructor
public class SavedMotelController {
    private final SavedMotelService savedMotelService;

    @PostMapping
    public Response<SavedMotelDto> create(@RequestBody SavedMotelDto savedMotelDto) {
        return Response.buildResponse(savedMotelService.create(savedMotelDto));
    }

    @DeleteMapping("/{id}")
    public Response<Boolean> deleteById(@PathVariable("id") int id) {
        return Response.buildResponse(savedMotelService.deleteById(id));
    }
}
