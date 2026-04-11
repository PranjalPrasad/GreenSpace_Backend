package com.gs.greenspace.service;

import com.gs.greenspace.entity.FormFieldEntity;
import com.gs.greenspace.entity.SubmissionEntity;

import java.util.List;
import java.util.Map;

public interface ContactService {

    List<FormFieldEntity> getAllFields();
    FormFieldEntity addField(FormFieldEntity field);
    FormFieldEntity updateField(Long id, FormFieldEntity field);
    FormFieldEntity patchField(Long id, Map<String, Object> updates);
    void deleteField(Long id);

    SubmissionEntity saveSubmission(Map<String, String> answers);
    List<SubmissionEntity> getAllSubmissions();
}