package vn.oceantech.l3pre.service;

import vn.oceantech.l3pre.dto.SavedMotelDto;

public interface SavedMotelService {
    SavedMotelDto create(SavedMotelDto savedMotelDto);

    Boolean deleteById(int id);

}
