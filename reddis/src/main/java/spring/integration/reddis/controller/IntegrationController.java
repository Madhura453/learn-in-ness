package spring.integration.reddis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.integration.reddis.model.Student;
import spring.integration.reddis.service.IntegrationGateway;

@RestController
@RequestMapping("/integrate")
public class IntegrationController {
	@Autowired
	private IntegrationGateway integrationGateway;

	@GetMapping(value = "{name}")
	public String getMessageFromIntegrationService(@PathVariable("name") String name) {
		return integrationGateway.sendMessage(name);
	}
	
	@PostMapping
	public String processStudentDetails(@RequestBody Student student)
	{
		return integrationGateway.processStudentDetails(student);
	}
}
