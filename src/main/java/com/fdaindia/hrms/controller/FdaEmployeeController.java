package com.fdaindia.hrms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.request.UserRequest;
import com.fdaindia.hrms.response.UserResponse;
import com.fdaindia.hrms.service.EmailService;
import com.fdaindia.hrms.service.FdaEmployeeService;
import com.fdaindia.hrms.service.impl.EmailServiceImpl;
import com.fdaindia.hrms.service.impl.FdaEmployeeServiceImpl;





@RestController
@RequestMapping("/Hrms/emp")
public class FdaEmployeeController {
	 @Autowired
 private EmailServiceImpl emailSenderService;
    @Autowired
    private FdaEmployeeService fdaEmployeeService;
    @Autowired
    private FdaEmployeeServiceImpl employeeService;
    @GetMapping("/test")
    public String user() {
        System.out.println("Employee hit");
        return "Employee hit";
    }
    
    @CrossOrigin()
    @PostMapping("/registration")
    public UserResponse registerEmployee(@RequestBody Employee employee) {
        return fdaEmployeeService.registerEmployee(employee);
    }
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        return employeeService.generateOtp(email);
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email,
                                @RequestParam String otp,
                                @RequestParam String newPassword,
                                @RequestParam String confirmPassword) {
        return employeeService.verifyOtpAndResetPassword(email, otp, newPassword, confirmPassword);
    }
  
    @PostMapping("/login")
    public UserResponse loginEmployee(@RequestParam String username, @RequestParam String password) {
        UserResponse response = fdaEmployeeService.authenticate(username, password);
        if (response.isStatus()) {
            Employee employee = new Employee();
            employee.setUsername(username);
            employee.setRole(response.getRole());

         
            response.setMessage("Login Successful");
            response.setUsername(username);
        } else {
            response.setMessage("Invalid username or password");
        }
        return response;
    }

    @CrossOrigin
    @PostMapping("/hrmslogin")
    public UserResponse hrmsUser(@RequestBody UserRequest request) {
        UserResponse response = new UserResponse();
        System.out.println(request.getUsername() + " " + request.getPassword());
        if (request.getUsername().equals("ADMIN") && request.getPassword().equals("Fdaindia@2024")) {
            response.setStatus(true);
            String role = "ADMIN"; // Admin role
           
            Employee employee = new Employee(); // Initialize the object properly
            employee.setUsername(request.getUsername());
            employee.setRole(role); // Set the role
           
            response.setMessage("HRMS Login Successful");
        } else {
            response.setStatus(false);
            response.setMessage("Failed");
            response.setUsername(request.getUsername());
        }
        return response;
    }
}