package com.example.core.service.user.impl;

import com.example.persist.entity.user.Employee;
import com.example.persist.mapper.user.EmployeeMapper;
import com.example.core.service.user.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qmt
 * @since 2019-02-17
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
