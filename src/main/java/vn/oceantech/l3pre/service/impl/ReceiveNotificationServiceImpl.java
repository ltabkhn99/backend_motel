package vn.oceantech.l3pre.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.oceantech.l3pre.dto.ReceiveNotificationDto;
import vn.oceantech.l3pre.entity.ReceiveNotification;
import vn.oceantech.l3pre.repository.ReceiveNotificationRepo;
import vn.oceantech.l3pre.service.ReceiveNotificationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceiveNotificationServiceImpl implements ReceiveNotificationService {
    private final ReceiveNotificationRepo receiveNotificationRepo;

    @Override
    public ReceiveNotificationDto create(ReceiveNotificationDto receiveNotificationDto) {
        ReceiveNotification receiveNotification = new ModelMapper().map(receiveNotificationDto, ReceiveNotification.class);
        return new ModelMapper().map(receiveNotificationRepo.save(receiveNotification), ReceiveNotificationDto.class);
    }

    @Override
    public List<ReceiveNotificationDto> getAll() {
        List<ReceiveNotification> receiveNotifications = receiveNotificationRepo.getAll();
        return receiveNotifications.stream().map(receiveNotification -> new ModelMapper()
                .map(receiveNotification, ReceiveNotificationDto.class)).collect(Collectors.toList());
    }


}
