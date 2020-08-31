package com.eagle.mailer.controller;

import static com.eagle.mailer.constants.MailerConstants.Endpoints.TEMPLATE_END_POINT;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.mailer.mail.service.TemplateService;
import com.eagle.mailer.modal.Template;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(TEMPLATE_END_POINT)
@AllArgsConstructor
public class TemplateController {
	
	private final TemplateService templateService;
	
	@PostMapping
	public ResponseEntity<Template> save(@RequestBody Template template) {
		 return ResponseEntity.ok(templateService.save(template));
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Template> getByTempateId(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(templateService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Template> updateCard(@PathVariable("id") Long id, 
    		@RequestBody @Validated Template template) {
    	template.setId(id);
        return ResponseEntity.ok(templateService.update(template));
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTempate(@PathVariable("id") Long id) {
    	templateService.delete(id);
		return  ResponseEntity.noContent().build();

	}
    @GetMapping("/all")
    public  ResponseEntity<List<Template>> findAll() {
		return ResponseEntity.ok(templateService.findAll());

	}
    

}
