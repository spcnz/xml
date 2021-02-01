package tim21.EmailApp.service;

import com.sun.istack.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    private Environment env;

    @Autowired
    private JavaMailSender mailSender;


    public String sendMail(MailRequest request) {

        String response;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(request.getTo());
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setSubject(request.getSubject());
            helper.setText(request.getContent());

            ByteArrayDataSource bds = new ByteArrayDataSource(request.getFile().toString().getBytes(), "application/pdf");
            System.out.println(bds);
            helper.addAttachment("attachment.pdf", bds);

            mailSender.send(message);
            response = "Email has been sent to :" + request.getTo();
        } catch (MessagingException e ) {

            response = "Email send failure to :" + request.getTo();
        }

        return response;
    }

}
