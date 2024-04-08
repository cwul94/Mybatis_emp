package test.view;

import test.common.EmployeeDTO;
import test.controller.EmployeeController;
import test.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    public void start() {

        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();
        boolean isTrue = true;

        do {
            System.out.println("=========직원 관리========");
            System.out.println("1. 직원 전체 조회 ");
            System.out.println("2. 직원 상세 조회 ");
            System.out.println("3. 직원 추가 ");
            System.out.println("4. 직원 정보 수정 ");
            System.out.println("5. 직원 해고 ");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : employeeController.selectAllEmp();
                    break;
                case 2 : employeeController.selectOneEmpById(inputCode());
                    break;
                case 3 : employeeController.insertEmp(inputEmpInfo());
                    break;
                case 4 : employeeController.updateEmp(updateEmpInfo());
                    break;
                case 5 : employeeController.deleteEmp(inputCode());
                    break;
                case 9 :
                    System.out.println("프로그램을 종료합니다.");
                    isTrue = false;
                    return;
                default:
                    System.out.println("처리할 수 없습니다.");
                    break;
            }
        } while (isTrue);

    }

    private Map<String, String> updateEmpInfo() {
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();

        System.out.println("=========== 사원 정보 수정 ==========");
        System.out.print("수정할 사원의 번호를 입력하세요 : ");
        String empId = sc.nextLine();
        System.out.print("수정할 사원의 이름을 입력하세요 : ");
        String empName = sc.nextLine();
        System.out.print("수정할 사원의 주민등록번호를 입력하세요 : ");
        String empNo = sc.nextLine();
        System.out.print("수정할 사원의 직급코드를 입력하세요 (J1:대표 / J2:부사장 / J3:부장 / J4:차장 / J5:과장 / J6:대리 / J7:사원 ) : ");
        String jobCode = sc.nextLine();
        System.out.print("수정할 사원의 급여등급를 입력하세요 (S1 / S2 / S3 / S4 / S5 / S6) : ");
        String salLevel = sc.nextLine();

        map.put("empId",empId);
        map.put("empName",empName);
        map.put("empNo",empNo);
        map.put("jobCode",jobCode);
        map.put("salLevel",salLevel);

        return map;
    }

    private Map<String,String> inputCode() {

        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();

        System.out.print("조회할 사원의 번호를 입력하세요 : ");
        String empId = sc.nextLine();

        map.put("empId",empId);
        return map;
    }

    private Map<String,String> inputEmpInfo() {

        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();

        System.out.println("=========== 사원 등록 ========");
        System.out.print("사원의 이름을 입력하세요 : ");
        String empName = sc.nextLine();
        System.out.print("사원의 주민등록번호를 입력하세요 : ");
        String empNo = sc.nextLine();
        System.out.print("사원의 직급코드를 입력하세요 (J1:대표 / J2:부사장 / J3:부장 / J4:차장 / J5:과장 / J6:대리 / J7:사원 ) : ");
        String jobCode = sc.nextLine();
        System.out.print("사원의 급여등급를 입력하세요 (S1 / S2 / S3 / S4 / S5 / S6) : ");
        String salLevel = sc.nextLine();

        map.put("empName",empName);
        map.put("empNo",empNo);
        map.put("jobCode",jobCode);
        map.put("salLevel",salLevel);

        return map;
    }
}
