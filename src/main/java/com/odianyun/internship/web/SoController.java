package com.odianyun.internship.web;

import com.odianyun.internship.model.DTO.SoDTO;
import com.odianyun.internship.model.VO.SoVO;
import com.odianyun.internship.service.SoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: EDZ
 * @time: 10:24
 * @date: 2021/7/16
 */
@RestController
@RequestMapping("so")
public class SoController {

    @Resource
    private SoService soService;

    @RequestMapping("list")
    public List<SoVO> list(@RequestBody SoDTO dto) {
        List<SoVO> list = soService.list(dto);
        return list;
    }

    @RequestMapping("get")
    public SoVO get(@RequestBody SoDTO dto) {
        SoVO vo = soService.get(dto);
        return vo;
    }

    @RequestMapping("choose")
    public List<SoVO> choose(@RequestBody SoDTO dto) {
        List<SoVO> list = soService.choose(dto);
        return list;
    }
}
