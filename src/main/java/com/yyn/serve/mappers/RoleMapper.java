package com.yyn.serve.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyn.serve.bean.Menu;
import com.yyn.serve.bean.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
