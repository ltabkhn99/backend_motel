package vn.oceantech.l3pre.service;

import org.springframework.web.multipart.MultipartFile;
import vn.oceantech.l3pre.dto.MotelRoomDto;

import java.util.List;

public interface MotelRoomService {
    MotelRoomDto create(MotelRoomDto motelRoomDto, MultipartFile image, MultipartFile coverImage);

    MotelRoomDto update(MotelRoomDto motelRoomDto, MultipartFile image, MultipartFile coverImage);

    Boolean deleteById(int id);

    MotelRoomDto getById(int id);

    List<MotelRoomDto> getAll();

}
