package com.vaibhav.example.rabbitmqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeProducer employeeProducer;

    @RequestMapping(value = "/hello-rabbit", method = RequestMethod.GET)
    public String producer(@RequestParam("empname") String empName,@RequestParam("empid") String empId) {

        Employee emp= new Employee();
        emp.setId(empId);
        emp.setEmpName(empName);

        employeeProducer.send(emp);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
