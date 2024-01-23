package vn.oceantech.l3pre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.oceantech.l3pre.common.Response;
import vn.oceantech.l3pre.dto.MotelRoomDto;
import vn.oceantech.l3pre.service.MotelRoomService;

import java.util.List;

@RestController
@RequestMapping("/api/motel-room")
@RequiredArgsConstructor
public class MotelRoomController {
    private final MotelRoomService motelRoomService;

    @PostMapping
    public Response<MotelRoomDto> create(@RequestPart("motelRoomDto") MotelRoomDto motelRoomDto,
                                         @RequestPart("image") MultipartFile image,
                                         @RequestPart("coverImage") MultipartFile coverImage) {
        return Response.buildResponse(motelRoomService.create(motelRoomDto, image, coverImage));
    }

    @PutMapping
    public Response<MotelRoomDto> update(@RequestPart("motelRoomDto") MotelRoomDto motelRoomDto,
                                         @RequestPart("image") MultipartFile image,
                                         @RequestPart("coverImage") MultipartFile coverImage) {
        return Response.buildResponse(motelRoomService.update(motelRoomDto, image, coverImage));
    }

    @GetMapping("/search-name")
    public Response<List<MotelRoomDto>> searchByName(String name) {
        return Response.buildResponse(motelRoomService.searchByName(name));
    }

    @GetMapping("/search-location")
    public Response<List<MotelRoomDto>> searchByLocation(Integer proId, Integer dtId, Integer subId) {
        return Response.buildResponse(motelRoomService.searchByLocation(proId, dtId, subId));
    }

    @DeleteMapping("/{id}")
    public Response<Boolean> deleteById(@PathVariable("id") Integer id) {
        return Response.buildResponse(motelRoomService.deleteById(id));
    }

    @GetMapping("/{id}")
    public Response<MotelRoomDto> getById(@PathVariable("id") int id) {
        return Response.buildResponse(motelRoomService.getById(id));
    }

    @GetMapping
    public Response<List<MotelRoomDto>> getAll() {
        return Response.buildResponse(motelRoomService.getAll());
    }
}
