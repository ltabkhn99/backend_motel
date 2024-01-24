package vn.oceantech.l3pre.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.oceantech.l3pre.dto.MotelRoomDto;
import vn.oceantech.l3pre.email.EmailSender;
import vn.oceantech.l3pre.entity.*;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.exceptions.NotFoundException;
import vn.oceantech.l3pre.repository.*;
import vn.oceantech.l3pre.service.MotelRoomService;
import vn.oceantech.l3pre.utils.FileStore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotelRoomServiceImpl implements MotelRoomService {
    private final MotelRoomRepo motelRoomRepo;
    private final ProvinceRepo provinceRepo;
    private final DistrictRepo districtRepo;
    private final SubDistrictRepo subDistrictRepo;
    private final TypeRoomRepo typeRoomRepo;
    private final ReceiveNotificationRepo receiveNotificationRepo;
    private final EmailSender emailSender;

    @Override
    public MotelRoomDto create(MotelRoomDto motelRoomDto, MultipartFile image, MultipartFile coverImage) {
        if (image != null && !image.isEmpty()) {
            motelRoomDto.setImage(FileStore.getFileName(image, "image_motel"));
        }
        if (coverImage != null && !coverImage.isEmpty()) {
            motelRoomDto.setCoverImage(FileStore.getFileName(coverImage, "cover_image_motel"));
        }
        motelRoomDto.setPostTime(LocalDateTime.now());
        MotelRoom motelRoom = new ModelMapper().map(motelRoomDto, MotelRoom.class);
        MotelRoom motelRoomSave = motelRoomRepo.save(motelRoom);
        List<ReceiveNotification> receiveNotifications = receiveNotificationRepo.getAll();
        for (ReceiveNotification receiveNotification : receiveNotifications) {
            if (Objects.equals(receiveNotification.getProvince().getId(), motelRoom.getProvince().getId())
                    && Objects.equals(receiveNotification.getDistrict().getId(), motelRoom.getDistrict().getId())
                    && Objects.equals(receiveNotification.getSubDistrict().getId(), motelRoom.getSubDistrict().getId())) {
                if (image != null && !image.isEmpty()) {
                    emailSender.sendEmailPostMotel(motelRoomSave, receiveNotification.getUser().getEmail());
                }
            }
        }
        return new ModelMapper().map(motelRoomSave, MotelRoomDto.class);
    }

    @Override
    public MotelRoomDto update(MotelRoomDto motelRoomDto, MultipartFile image, MultipartFile coverImage) {
        if (image != null && !image.isEmpty()) {
            motelRoomDto.setImage(FileStore.getFileName(image, "image_motel"));
        }
        if (coverImage != null && !coverImage.isEmpty()) {
            motelRoomDto.setCoverImage(FileStore.getFileName(coverImage, "cover_image_motel"));
        }
        MotelRoom motelRoom = motelRoomRepo.findById(motelRoomDto.getId()).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        this.mapDtoToEntity(motelRoomDto, motelRoom);
        return new ModelMapper().map(motelRoomRepo.save(motelRoom), MotelRoomDto.class);
    }

    @Override
    public Boolean deleteById(int id) {
        MotelRoom motelRoom = motelRoomRepo.findById(id).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        if (Objects.nonNull(motelRoom)) {
            motelRoomRepo.deleteById(id);
        }
        return true;
    }

    @Override
    public MotelRoomDto getById(int id) {
        MotelRoom motelRoom = motelRoomRepo.findById(id).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        return new ModelMapper().map(motelRoom, MotelRoomDto.class);
    }

    @Override
    public List<MotelRoomDto> getAll() {
        List<MotelRoom> motelRooms = motelRoomRepo.getAll();
        return motelRooms.stream().
                map(motelRoom -> new ModelMapper().map(motelRoom, MotelRoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MotelRoomDto> searchByName(String name) {
        List<MotelRoom> motelRooms = motelRoomRepo.searchByName(name);
        return motelRooms.stream().map(motelRoom -> new ModelMapper().
                map(motelRoom, MotelRoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MotelRoomDto> searchByLocation(Integer proId, Integer dtId, Integer subId) {
        List<MotelRoom> motelRooms = motelRoomRepo.searchByLocation(proId, dtId, subId);
        return motelRooms.stream().map(motelRoom -> new ModelMapper().
                map(motelRoom, MotelRoomDto.class)).collect(Collectors.toList());
    }

    private void mapDtoToEntity(MotelRoomDto motelRoomDto, MotelRoom motelRoom) {
        if (motelRoomDto.getAcreage() != null) {
            motelRoom.setAcreage(motelRoomDto.getAcreage());
        }
        if (motelRoomDto.getCoverImage() != null) {
            motelRoom.setCoverImage(motelRoomDto.getCoverImage());
        }
        if (motelRoomDto.getDescription() != null) {
            motelRoom.setDescription(motelRoomDto.getDescription());
        }
        if (motelRoomDto.getImage() != null) {
            motelRoom.setImage(motelRoomDto.getImage());
        }
        if (motelRoomDto.getLinkGgMap() != null) {
            motelRoom.setLinkGgMap(motelRoomDto.getLinkGgMap());
        }
        if (motelRoomDto.getMaxNumberPeople() != null) {
            motelRoom.setMaxNumberPeople(motelRoomDto.getMaxNumberPeople());
        }
        if (motelRoomDto.getName() != null) {
            motelRoom.setName(motelRoomDto.getName());
        }
        if (motelRoomDto.getNeighborUniversity() != null) {
            motelRoom.setNeighborUniversity(motelRoomDto.getNeighborUniversity());
        }
        if (motelRoomDto.getPrice() != null) {
            motelRoom.setPrice(motelRoomDto.getPrice());
        }
        if (motelRoomDto.getProvince() != null) {
            Province province = provinceRepo.findById(motelRoomDto.getProvince().getId()).
                    orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
            motelRoom.setProvince(province);
        }
        if (motelRoomDto.getDistrict() != null) {
            District district = districtRepo.findById(motelRoomDto.getDistrict().getId()).
                    orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
            motelRoom.setDistrict(district);
        }
        if (motelRoomDto.getSubDistrict() != null) {
            SubDistrict subDistrict = subDistrictRepo.findById(motelRoomDto.getSubDistrict().getId()).
                    orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
            motelRoom.setSubDistrict(subDistrict);
        }
        if (motelRoomDto.getTypeRoom() != null) {
            TypeRoom typeRoom = typeRoomRepo.findById(motelRoomDto.getTypeRoom().getId()).
                    orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
            motelRoom.setTypeRoom(typeRoom);
        }
        if (motelRoomDto.getAddress() != null) {
            motelRoom.setAddress(motelRoomDto.getAddress());
        }
    }
}
