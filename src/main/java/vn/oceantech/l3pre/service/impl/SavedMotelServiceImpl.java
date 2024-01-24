package vn.oceantech.l3pre.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.oceantech.l3pre.dto.SavedMotelDto;
import vn.oceantech.l3pre.entity.SavedMotel;
import vn.oceantech.l3pre.exceptions.ErrorMessages;
import vn.oceantech.l3pre.exceptions.NotFoundException;
import vn.oceantech.l3pre.repository.SavedMotelRepo;
import vn.oceantech.l3pre.service.SavedMotelService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SavedMotelServiceImpl implements SavedMotelService {
    private final SavedMotelRepo savedMotelRepo;

    @Override
    public SavedMotelDto create(SavedMotelDto savedMotelDto) {
        SavedMotel savedMotel = new ModelMapper().map(savedMotelDto, SavedMotel.class);
        return new ModelMapper().map(savedMotelRepo.save(savedMotel), SavedMotelDto.class);
    }

    @Override
    public Boolean deleteById(int id) {
        SavedMotel savedMotel = savedMotelRepo.findById(id).
                orElseThrow(() -> new NotFoundException(ErrorMessages.NOT_FOUND));
        if (Objects.nonNull(savedMotel)) {
            savedMotelRepo.deleteById(id);
        }
        return true;
    }
}
