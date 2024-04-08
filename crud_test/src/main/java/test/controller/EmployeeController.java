package test.controller;

import test.common.EmployeeDTO;
import test.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class EmployeeController {

    private final EmployeeService employeeService;

    private final PrintResult printResult;

    public EmployeeController(){
        employeeService = new EmployeeService();
        printResult = new PrintResult();

    }


    public void selectAllEmp() {
        List<EmployeeDTO> employeeDTOList = employeeService.selectAllEmp();

        if( employeeDTOList != null && employeeDTOList.size() > 0 ) {
            printResult.printEmpList(employeeDTOList);
        } else {
            printResult.printErrorMessage("selectAllEmp");
        }
    }

    public void selectOneEmpById(Map<String, String> parameter) {
        int empId = Integer.parseInt(parameter.get("empId"));

        EmployeeDTO employeeDTO = employeeService.selectOneEmpById(empId);

        if ( employeeDTO != null ) {
            printResult.printEmpInfo(employeeDTO);
        } else {
            printResult.printErrorMessage("selectOneEmp");
        }
    }

    public void insertEmp(Map<String, String> employeeInfo) {
        EmployeeDTO employee = new EmployeeDTO();

        String empName = employeeInfo.get("empName");
        String empNo = employeeInfo.get("empNo");
        String jobCode = employeeInfo.get("jobCode");
        String salLevel = employeeInfo.get("salLevel");

        employee.setEmpName(empName);
        employee.setEmpNo(empNo);
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);

        if ( employeeService.insertEmp(employee) ) {
            printResult.printInsertEmp();
        } else {
            printResult.printErrorMessage("insertEmp");
        }
    }

    public void updateEmp(Map<String, String> employeeInfo) {
        EmployeeDTO employee = new EmployeeDTO();

        int empId = Integer.parseInt(employeeInfo.get("empId"));
        String empName = employeeInfo.get("empName");
        String empNo = employeeInfo.get("empNo");
        String jobCode = employeeInfo.get("jobCode");
        String salLevel = employeeInfo.get("salLevel");

        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setEmpNo(empNo);
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);

        if ( employeeService.updateEmp(employee) ) {
            printResult.printUpdateEmp(employee);
        } else {
            printResult.printErrorMessage("updateEmp");
        }
    }

    public void deleteEmp(Map<String, String> employee) {
        int empId = Integer.parseInt(employee.get("empId"));

        if(employeeService.deleteEmp(empId)){
            printResult.printDeleteEmp(empId);
        } else {
            printResult.printErrorMessage("deleteEmp");
        }

    }
}
