package com.example.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.core.service.user.EmployeeService;
import com.example.persist.entity.user.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {
	@Resource
	private EmployeeService employeeService;

	@Test
	public void test1() throws Exception {
		List<Employee> list = employeeService.list(new QueryWrapper<Employee>());
		System.out.println(list.toString());

	}
}
