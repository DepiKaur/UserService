package com.hobbyprojects.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private JavaMailSender emailSender;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSendEmail(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("martha@test.com");
        message.setSubject("Order Confirmation, Order No : 12345");
        message.setText("Thanks for placing an order with us.");
        emailSender.send(message);

    }

}
