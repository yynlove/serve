package com.yyn.serve.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyn.serve.bean.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getUserMenus(Long uid);
}
