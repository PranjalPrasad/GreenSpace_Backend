package com.gs.greenspace.controller;

import com.gs.greenspace.entity.FormFieldEntity;
import com.gs.greenspace.entity.SubmissionEntity;
import com.gs.greenspace.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // GET all form fields
    @GetMapping("/get-all-fields/fields")
    public List<FormFieldEntity> getAllFields() {
        return contactService.getAllFields();
    }

    // POST - add a new field
    @PostMapping("/add-field/fields")
    public FormFieldEntity addField(@RequestBody FormFieldEntity field) {
        return contactService.addField(field);
    }

    // PUT - full update (all fields required)
    @PutMapping("/update-field/fields/{id}")
    public FormFieldEntity updateField(@PathVariable Long id, @RequestBody FormFieldEntity field) {
        return contactService.updateField(id, field);
    }

    // PATCH - partial update (only send fields you want to change)
    @PatchMapping("/patch-field/fields/{id}")
    public FormFieldEntity patchField(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return contactService.patchField(id, updates);
    }

    // DELETE - remove a field by id
    @DeleteMapping("/delete-field/fields/{id}")
    public ResponseEntity<String> deleteField(@PathVariable Long id) {
        contactService.deleteField(id);
        return ResponseEntity.ok("Field deleted successfully");
    }

    // POST - submit the contact form
    @PostMapping("/submit-form/submit")
    public SubmissionEntity submitForm(@RequestBody Map<String, String> answers) {
        return contactService.saveSubmission(answers);
    }

    // GET - retrieve all submissions
    @GetMapping("/get-all-submissions/submissions")
    public List<SubmissionEntity> getAllSubmissions() {
        return contactService.getAllSubmissions();
    }
}