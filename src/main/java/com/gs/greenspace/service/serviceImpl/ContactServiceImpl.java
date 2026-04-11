package com.gs.greenspace.service.serviceImpl;

import com.gs.greenspace.entity.FormFieldEntity;
import com.gs.greenspace.entity.SubmissionEntity;
import com.gs.greenspace.repository.FormFieldRepository;
import com.gs.greenspace.repository.SubmissionRepository;
import com.gs.greenspace.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private FormFieldRepository formFieldRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public List<FormFieldEntity> getAllFields() {
        return formFieldRepository.findAllByOrderByDisplayOrderAsc();
    }

    @Override
    public FormFieldEntity addField(FormFieldEntity field) {
        return formFieldRepository.save(field);
    }

    @Override
    public FormFieldEntity updateField(Long id, FormFieldEntity updatedField) {
        FormFieldEntity existing = formFieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found with id: " + id));
        existing.setFieldName(updatedField.getFieldName());
        existing.setFieldType(updatedField.getFieldType());
        existing.setPlaceholder(updatedField.getPlaceholder());
        existing.setDisplayOrder(updatedField.getDisplayOrder());
        return formFieldRepository.save(existing);
    }

    @Override
    public FormFieldEntity patchField(Long id, Map<String, Object> updates) {
        FormFieldEntity existing = formFieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found with id: " + id));

        if (updates.containsKey("fieldName")) {
            existing.setFieldName((String) updates.get("fieldName"));
        }
        if (updates.containsKey("fieldType")) {
            existing.setFieldType((String) updates.get("fieldType"));
        }
        if (updates.containsKey("placeholder")) {
            existing.setPlaceholder((String) updates.get("placeholder"));
        }
        if (updates.containsKey("displayOrder")) {
            existing.setDisplayOrder(((Number) updates.get("displayOrder")).intValue());
        }

        return formFieldRepository.save(existing);
    }

    @Override
    public void deleteField(Long id) {
        formFieldRepository.deleteById(id);
    }

    @Override
    public SubmissionEntity saveSubmission(Map<String, String> answers) {
        SubmissionEntity submission = new SubmissionEntity();

        StringBuilder json = new StringBuilder("{");
        int count = 0;
        for (Map.Entry<String, String> entry : answers.entrySet()) {
            if (count > 0) json.append(",");
            json.append("\"").append(entry.getKey()).append("\":");
            json.append("\"").append(entry.getValue()).append("\"");
            count++;
        }
        json.append("}");

        submission.setAnswersJson(json.toString());
        submission.setSubmittedAt(LocalDateTime.now().toString());
        return submissionRepository.save(submission);
    }

    @Override
    public List<SubmissionEntity> getAllSubmissions() {
        return submissionRepository.findAll();
    }
}