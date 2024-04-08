package test.service;

import org.apache.ibatis.session.SqlSession;
import test.common.EmployeeDTO;
import test.mapper.DynamicSqlMapper;

import java.util.List;

import static test.common.Templete.getSqlSession;

public class EmployeeService {

    private DynamicSqlMapper mapper;

    public List<EmployeeDTO> selectAllEmp() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<EmployeeDTO> employeeDTOList = mapper.selectAllEmp();

        sqlSession.close();

        return employeeDTOList;
    }

    public EmployeeDTO selectOneEmpById(int empId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        EmployeeDTO employeeDTO = mapper.selectOneEmpById(empId);

        sqlSession.close();
        return employeeDTO;
    }

    public boolean insertEmp(EmployeeDTO employee) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.insertEmp(employee);

        if (result > 0){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        return result > 0 ? true: false;
    }

    public boolean updateEmp(EmployeeDTO employee) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.updateEmp(employee);

        if (result > 0){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        return result > 0 ? true: false;
    }

    public boolean deleteEmp(int empId) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.deleteEmp(empId);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return result > 0 ? true : false;
    }
}
