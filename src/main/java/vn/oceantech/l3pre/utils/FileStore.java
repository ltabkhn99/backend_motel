package vn.oceantech.l3pre.utils;

import org.springframework.web.multipart.MultipartFile;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.exceptions.FileUploadException;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

public class FileStore {
    public static final String UPLOAD_FOLDER = "D:/DA/rent-motel/src/main/resources/uploads/";

    public static String getFileName(MultipartFile multipartFile, String prefix) {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            try {
                int index = Objects.requireNonNull(multipartFile.getOriginalFilename()).lastIndexOf(".");
                String ext = multipartFile.getOriginalFilename().substring(index);
                String fileName = prefix + UUID.randomUUID() + ext;
                File file = new File(UPLOAD_FOLDER + fileName);
                multipartFile.transferTo(file);
                return fileName;
            } catch (Exception e) {
                throw new FileUploadException(ErrorMessages.FILE_UPLOAD_ERROR);
            }
        }
        return null;
    }
}
