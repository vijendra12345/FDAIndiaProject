//package com.fdaindia.hrms.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fdaindia.hrms.request.EmailRequest;
//import com.fdaindia.hrms.request.OTPRequest;
//import com.fdaindia.hrms.service.impl.EmailServiceImpl;
//import com.fdaindia.hrms.service.impl.OTPServiceImpl;
//
//
//
//@RestController
//@RequestMapping("/api/email")
//public class EmailController {
//
//    @Autowired
//    private EmailServiceImpl emailSenderService;
//    
//    @Autowired
//    private OTPServiceImpl otpService;
//
//    @CrossOrigin("*")
//    @PostMapping("/send")
//    public String sendEmail(@RequestBody EmailRequest request) {
//        int otp = otpService.generateOTP(request.getToEmail());
//        String subject = "Your OTP Code that is provided by FDAINDIA ";
////        String body = "Your OTP code is: please paste this otp for verification " + otp;
//        
//        emailSenderService.sendEmail(request.getToEmail(), subject, generateHTML());
//        
//        return "Email sent successfully to " + request.getToEmail();
//    }
//
//    @CrossOrigin("*")
//    @PostMapping("/verify")
//    public String verifyEmail(@RequestBody OTPRequest otpRequest) {
//        boolean isVerified = otpService.verifyOTP(otpRequest.getToEmail(), otpRequest.getOtp());
//        
//        if (isVerified) {
//            return "Email verified successfully";
//        } else {
//            return "Invalid OTP";
//        }
//    }
//    
//    public static String generateHTML() {
//        StringBuffer html = new StringBuffer();
//
//        html.append("<html>\n");
//        html.append("<head>\n");
//        html.append("<title>Colorful Message</title>\n");
//        html.append("</head>\n");
//        html.append("<body>\n");
//        html.append("<p style='color:red;'>Hello your OTP will be generated by testing purpose of this email api dont be confused ,please share the screen shot in the whatsapp group for better clarification those who get the email  </p>\n");
//        html.append("</body>\n");
//        html.append("</html>");
//
//        return html.toString();
//    }
//}
//