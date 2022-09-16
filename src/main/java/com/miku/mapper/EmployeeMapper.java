package com.miku.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miku.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 10833
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
