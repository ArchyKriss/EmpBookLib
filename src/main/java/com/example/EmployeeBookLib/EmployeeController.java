package com.example.EmployeeBookLib;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName){
        if(!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(employeeService.addEmployee(firstName, lastName));
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Employee> deliteEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return ResponseEntity.ok(employeeService.deliteEmployee(firstName, lastName));
    }
    @GetMapping("/find")
    public ResponseEntity<Employee> findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return ResponseEntity.ok(employeeService.findEmployee(firstName, lastName));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

}
