package com.odianyun.internship.service;

import com.odianyun.internship.model.DTO.UUserDTO;
import com.odianyun.internship.model.UUser;

import java.util.List;
import java.util.Map;

public interface UserService {
    UUser getById(Long id);

    void update(UUserDTO dto);

    void updateForMap(Map<String, Object> dto);

    void updateParam(UUserDTO dto);

    UUser add(UUserDTO dto);

    List<UUser> list(UUserDTO dto);

    void batchAdd(List<UUserDTO> dtoList);

    void batchUpdate(List<UUserDTO> dtoList);

    void batchInsertOrUpdate(List<UUserDTO> dtoList);

    UUser addAnno(UUserDTO dto);
}
