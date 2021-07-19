package com.odianyun.internship.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.odianyun.internship.mapper.SoMapper;
import com.odianyun.internship.model.DTO.SoDTO;
import com.odianyun.internship.model.ListResult;
import com.odianyun.internship.model.VO.SoVO;
import com.odianyun.internship.service.SoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: EDZ
 * @time: 10:28
 * @date: 2021/7/16
 */
@Service
public class SoServiceImpl implements SoService {

    @Resource
    private SoMapper soMapper;

    @Override
    public List<SoVO> list(SoDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
//        PageHelper.offsetPage(dto.getPageNum(), dto.getPageSize());
//        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), false);
        return soMapper.list(dto);
    }

    @Override
    public SoVO get(SoDTO dto) {
        return soMapper.get(dto);
    }

    @Override
    public List<SoVO> choose(SoDTO dto) {
        return soMapper.choose(dto);
    }

    @Override
    public ListResult<SoVO> listPage(SoDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<SoVO> list = soMapper.list(dto);
        PageInfo page = new PageInfo(list);

        /*ListResult<SoVO> result = new ListResult<SoVO>();
        result.setPages(page.getPages());
        result.setTotal(page.getTotal());
        result.setList(page.getList());
        return result;*/

        return new ListResult<SoVO>(page.getTotal(), page.getPages(), page.getList());
    }
}
