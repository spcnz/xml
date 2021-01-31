package tim21.EmailApp.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim21.EmailApp.service.EmailService;

@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
public class MailSenderController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/send-mail")
	public ResponseEntity<String> sendMail() {


		String response = emailService.sendMail("neki sadrzaj hehe", "laketic.milena98@gmail.com", "naslov");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}