package com.odianyun.internship.service.impl;

import com.odianyun.internship.mapper.UserMapper;
import com.odianyun.internship.model.DTO.UUserDTO;
import com.odianyun.internship.model.UUser;
import com.odianyun.internship.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: EDZ
 * @time: 14:26
 * @date: 2021/7/15
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    public static final String CACHE_USER_INFO_KEY_PREFIX = "userInfo";


    @Override
    public UUser getById(Long id) {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = CACHE_USER_INFO_KEY_PREFIX + id;
        Object cacheUUser = operations.get(key);
        if (null != cacheUUser) {
            System.out.println("使用了redis缓存");
            return (UUser) cacheUUser;
        }

        UUser uuser = userMapper.getById(id);
        operations.set(key, uuser);
        return uuser;
    }

    @Override
    public void update(UUserDTO dto) {
        String key = CACHE_USER_INFO_KEY_PREFIX + dto.getId();
        redisTemplate.delete(key);
        userMapper.update(dto);
    }

    @Override
    public void updateForMap(Map<String, Object> dto) {
        userMapper.updateForMap(dto);
    }

    @Override
    public void updateParam(UUserDTO dto) {
        String password = dto.getPassword();
        String mobile = dto.getMobile();
        Long id = dto.getId();
        userMapper.updateParam(password, mobile, id);
    }

    @Override
    public UUser add(UUserDTO dto) {
        UUser user = new UUser();
        // 复制
        BeanUtils.copyProperties(dto, user);

        userMapper.add(user);

        return user;
    }

    @Override
    public List<UUser> list(UUserDTO dto) {
        return userMapper.list(dto);
    }

    @Override
    public void batchAdd(List<UUserDTO> dtoList) {
        userMapper.batchAdd(dtoList);
    }

    @Override
    public void batchUpdate(List<UUserDTO> dtoList) {
        userMapper.batchUpdate(dtoList);
    }

    @Override
    public void batchInsertOrUpdate(List<UUserDTO> dtoList) {
        userMapper.batchInsertOrUpdate(dtoList);
    }

    @Override
    public UUser addAnno(UUserDTO dto) {
        UUser user = new UUser();
        // 复制
        BeanUtils.copyProperties(dto, user);
        userMapper.addAnno(user);

        return user;
    }
}
