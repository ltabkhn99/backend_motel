package vn.oceantech.l3pre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.oceantech.l3pre.common.Response;
import vn.oceantech.l3pre.dto.ReceiveNotificationDto;
import vn.oceantech.l3pre.service.ReceiveNotificationService;

@RestController
@RequestMapping("/api/receive-notification")
@RequiredArgsConstructor
public class ReceiveNotificationController {
    private final ReceiveNotificationService receiveNotificationService;

    @PostMapping
    public Response<ReceiveNotificationDto> create(@RequestBody ReceiveNotificationDto receiveNotificationDto) {
        return Response.buildResponse(receiveNotificationService.create(receiveNotificationDto));
    }


}
