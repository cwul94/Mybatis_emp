package test.controller;

import test.common.EmployeeDTO;

import java.util.List;

public class PrintResult {
    public void printErrorMessage(String selectAllEmp) {
        String errorMessage = "";
        switch (selectAllEmp) {
            case "selectAllEmp" : errorMessage = "전체 사원 정보 조회를 실패하였습니다."; break;
            case "selectOneEmp" : errorMessage = "해당 사원 정보 조회를 실패하였습니다."; break;
            case "insertEmp" : errorMessage = "사원 등록에 실패하였습니다."; break;
            case "updateEmp" : errorMessage = "사원 정보 수정에 실패하였습니다."; break;
            case "deleteEmp" : errorMessage = "사원 정보 처리에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

    public void printEmpList(List<EmployeeDTO> employeeDTOList) {
        for(EmployeeDTO emp : employeeDTOList) {
            System.out.println(emp);
        }
    }

    public void printEmpInfo(EmployeeDTO employee) {
        System.out.println(employee);
    }

    public void printInsertEmp() {
        System.out.println("사원 등록이 완료되었습니다.");
    }

    public void printUpdateEmp(EmployeeDTO employee) {
        System.out.println(employee);
        System.out.println("사원 정보 수정이 완료되었습니다.");
    }

    public void printDeleteEmp(int empId) {
        System.out.println(empId + "번 사원의 해고가 정상적으로 처리되었습니다.");
    }
}
