package com.odianyun.internship.mapper;

import com.odianyun.internship.model.DTO.UUserDTO;
import com.odianyun.internship.model.UUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    UUser getById(Long id);

    void update(UUserDTO dto);

    void updateForMap(Map<String, Object> dto);

//    void updateParam(String password, String mobile, Long id);

//    void updateParam(@Param("password") String password, @Param("mobile") String mobile, @Param("id") Long id);

    void updateParam(String password, String mobile, Long id);

    void add(UUser user);

    @Insert("insert into u_user(mobile, password, is_deleted, company_id) values (#{mobile}, #{password}, 1, #{companyId})")
    void addAnno(UUser user);

    List<UUser> list(UUserDTO dto);

    void batchAdd(List<UUserDTO> dtoList);

    void batchUpdate(List<UUserDTO> dtoList);

    void batchInsertOrUpdate(List<UUserDTO> dtoList);
}
