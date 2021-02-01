package tim21.EmailApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.core.env.Environment;
import tim21.EmailApp.model.MailRequest;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Async
    public void sendFile(String content, String email, String subject) throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject(subject);
        mail.setText(content);
        javaMailSender.send(mail);
    }

    @Autowired
    private JavaMailSender mailSender;


    public String sendMail(MailRequest request) {

        String response;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            ClassPathResource pdf = new ClassPathResource("static/attachment.pdf");

            helper.setTo(request.getTo());
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setSubject(request.getSubject());
            helper.setText(request.getContent());
            helper.addAttachment("attachment.pdf", pdf);

            mailSender.send(message);
            response = "Email has been sent to :" + request.getTo();
        } catch (MessagingException e ) {
            response = "Email send failure to :" + request.getTo();
        }

        return response;
    }

}
