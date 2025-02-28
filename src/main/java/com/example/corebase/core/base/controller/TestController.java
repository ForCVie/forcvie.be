package com.example.corebase.core.base.controller;

import com.example.corebase.util.emailCommon.EmailRequest;
import com.example.corebase.util.emailCommon.EmailSender;
import com.example.corebase.util.emailCommon.Sender;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private EmailSender sender;

    @PostMapping
    public Boolean testSender(@RequestBody Sender senderBody) throws MessagingException {
        sender.sendNewMail(senderBody.getTo(), senderBody.getSubject(), senderBody.getBody());
        return true;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            // Đọc template từ frontend (có thể là thông qua ID)
            // Tạo context để thay thế các tham số trong template
            Context context = new Context();
            context.setVariable("name", "Nguyễn Quốc Huy");
            // Thêm các biến khác nếu cần

            // Gửi email
            sender.sendEmailThymeleaf(emailRequest.getTo(), emailRequest.getSubject(), "email-template", context);
            return "Email sent successfully!";
        } catch (MessagingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
