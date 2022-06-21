package com.bridgelabz.employeepayrollappication.controller;


import com.bridgelabz.employeepayrollappication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappication.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappication.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    // curl localhost:8080/employeepayrollservice -w "\n"
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
//        List<EmployeePayrollData> empDataList = null;
//        empDataList = employeePayrollService.getEmployePayrollData();
//        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", empDataList);
        return new ResponseEntity<String>("Get Call Success ", HttpStatus.OK);
    }

    // curl localhost:8080/employeepayrollservice/get/{empId} -w "\n"
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") long empId) {
//        List<EmployeePayrollData> empDataList = null;
//        Optional <EmployeePayrollData> empData = null;
//        empData = employeePayrollService.getEmployeePayrollDataById(empId);
//        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successfull ", empData);
        return  new ResponseEntity<String>("Get Call For ID Successfull "+empId, HttpStatus.OK);
    }

    // curl -X POST -H "Content-Type: application/json" -d
    // '{"name": "neha","salary":3000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(
                            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
//        EmployeePayrollData empData = null;
//        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
//        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return  new ResponseEntity<String>("Created Employee Payroll Data for : "+employeePayrollDTO, HttpStatus.OK);
    }

    //curl -X PUT -H "Content-Type: application/json" -d '{"name": "neha","salary": 3000}'
    //"http://localhost:8080/employeepayrollservice/update" -w "\n"
    @PutMapping("/update/{empId}")
    public ResponseEntity<String> updateEmployeePayrollData(@PathVariable("empId") long empId,
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
//        EmployeePayrollData empData = null;
//        empData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
//        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return  new ResponseEntity<String>("Updated Employee Payroll Data For :"+employeePayrollDTO, HttpStatus.OK);
    }

    //curl -X DELETE -H "Content-Type: application/json"
    //localhost:8080/employeepayrollservice/delete/1 -w "\n"
    @DeleteMapping("delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId")int empId) {
//        employeePayrollService.deleteEmployeePayrollData(empId);
//        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " +empId);
        return new ResponseEntity<String>("Delete Call Success For : "+empId, HttpStatus.OK);
    }
}
