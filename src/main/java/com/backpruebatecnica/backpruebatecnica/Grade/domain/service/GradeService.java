package com.backpruebatecnica.backpruebatecnica.Grade.domain.service;

import com.backpruebatecnica.backpruebatecnica.Grade.domain.model.Grade;
import com.backpruebatecnica.backpruebatecnica.Grade.domain.repository.GradeRepository;
import com.backpruebatecnica.backpruebatecnica.Grade.shared.GradeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(UUID id, Grade gradeDetail) {
        Grade grade = gradeRepository.findById(id).orElseThrow(() -> new GradeNotFoundException(id));
        grade.setGrade(gradeDetail.getGrade());

        return gradeRepository.save(grade);
    }

    public Optional<Grade> getGradeById(UUID id) {
        return gradeRepository.findById(id);
    }

    public void deleteGradeById(UUID id) {
        gradeRepository.deleteById(id);
    }
}
