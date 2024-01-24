package vn.oceantech.l3pre.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import vn.oceantech.l3pre.entity.*;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.exceptions.NotFoundException;
import vn.oceantech.l3pre.repository.DistrictRepo;
import vn.oceantech.l3pre.repository.ProvinceRepo;
import vn.oceantech.l3pre.repository.SubDistrictRepo;
import vn.oceantech.l3pre.repository.TypeRoomRepo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailSender {
    private final JavaMailSender javaMailSender;
    private final ProvinceRepo provinceRepo;
    private final DistrictRepo districtRepo;
    private final SubDistrictRepo subDistrictRepo;
    private final TypeRoomRepo typeRoomRepo;

    public void sendEmailPostMotel(MotelRoom motelRoom, String ToEmail) {
        Province province = provinceRepo.findById(motelRoom.getProvince().getId()).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        District district = districtRepo.findById(motelRoom.getDistrict().getId()).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        SubDistrict subDistrict = subDistrictRepo.findById(motelRoom.getSubDistrict().getId()).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        TypeRoom typeRoom = typeRoomRepo.findById(motelRoom.getTypeRoom().getId()).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        String address = motelRoom.getAddress() + ", " +
                subDistrict.getSubDistrictName() + ", " +
                district.getDistrictName() + ", " +
                province.getProvinceName();
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());
            helper.setTo(ToEmail);
            helper.setFrom("longdybala12345@gmail.com");
            helper.setSubject("Thông báo có phòng trọ mới vừa đăng lên");
            helper.setText("<html xmlns:th=http://www.thymeleaf.org>" +
                    "<head>" +
                    "    <meta charset=UTF-8/>" +
                    "    <title>Thông báo có phòng trọ mới</title>" +
                    "</head>" +
                    "<body>" +
                    "    <p>Chào bạn,</p>" +
                    "    <p>Chúng tôi xin thông báo có một phòng trọ mới vừa được đăng lên.</p>" +
                    "    <p>Thông tin phòng trọ:</p>" +
                    "    <ul>" +
                    "        <li>Tên phòng:" + motelRoom.getName() + "</li>" +
                    "        <li>Địa chỉ:" + address + "</li>" +
                    "        <li>Loại phòng:" + typeRoom.getName() + "</li>" +
                    "        <li>Gía phòng:" + motelRoom.getPrice() + "Đồng" + "</li>" +
                    "        <li>Số lượng người tối đa:" + motelRoom.getMaxNumberPeople() + "</li>" +
                    "        <!-- Thêm các thông tin khác về phòng trọ tại đây -->" +
                    "    </ul>" +
                    "</body>" +
                    "</html>", true);
            javaMailSender.send(message);
            log.info("Send email post motel {} ", motelRoom.getUser().getEmail());
        } catch (MessagingException e) {
            log.error("Email sent with error: " + e.getMessage());
        }
    }
}
