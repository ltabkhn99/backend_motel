package vn.oceantech.l3pre.exceptions;

public class FileUploadException extends L3Exception{
    public FileUploadException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
