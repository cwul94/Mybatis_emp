package test.mapper;

import test.common.EmployeeDTO;

import java.util.List;

public interface DynamicSqlMapper {
    List<EmployeeDTO> selectAllEmp();

    EmployeeDTO selectOneEmpById(int empId);

    int insertEmp(EmployeeDTO employee);

    int updateEmp(EmployeeDTO employee);

    int deleteEmp(int empId);
}
