package vn.oceantech.l3pre.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import vn.oceantech.l3pre.common.ApiMessageError;
import vn.oceantech.l3pre.constants.ErrorMessage;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.exceptions.JsonConverterException;
import vn.oceantech.l3pre.constants.DateHelper;

import java.text.SimpleDateFormat;

public class JsonConverter {
    public static <T> String toJsonString(T object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.setDateFormat(new SimpleDateFormat(DateHelper.GLOBAL_DATE));
            ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JsonConverterException(ErrorMessages.CONVERT_JSON_ERROR,
                    new ApiMessageError(ErrorMessage.CONVERT_OBJECT_TO_JSON_ERROR));
        }
    }
}


