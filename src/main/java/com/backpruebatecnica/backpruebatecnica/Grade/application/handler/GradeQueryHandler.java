package com.backpruebatecnica.backpruebatecnica.Grade.application.handler;

import com.backpruebatecnica.backpruebatecnica.Grade.application.query.GetGradeByIdQuery;
import com.backpruebatecnica.backpruebatecnica.Grade.domain.model.Grade;
import com.backpruebatecnica.backpruebatecnica.Grade.domain.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeQueryHandler {
    @Autowired
    private GradeService gradeService;

    public Optional<Grade> handle(GetGradeByIdQuery query) {
        return gradeService.getGradeById(query.get_id());
    }
}
