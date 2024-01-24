package vn.oceantech.l3pre.service;

import vn.oceantech.l3pre.dto.ReceiveNotificationDto;

import java.util.List;

public interface ReceiveNotificationService {
    ReceiveNotificationDto create(ReceiveNotificationDto receiveNotificationDto);

    List<ReceiveNotificationDto> getAll();

}
