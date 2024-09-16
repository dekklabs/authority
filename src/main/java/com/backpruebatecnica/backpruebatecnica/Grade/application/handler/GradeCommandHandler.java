package com.backpruebatecnica.backpruebatecnica.Grade.application.handler;

import com.backpruebatecnica.backpruebatecnica.Grade.application.command.CreateGradeCommand;
import com.backpruebatecnica.backpruebatecnica.Grade.application.command.DeleteGradeCommand;
import com.backpruebatecnica.backpruebatecnica.Grade.application.command.UpdateGradeCommand;
import com.backpruebatecnica.backpruebatecnica.Grade.domain.model.Grade;
import com.backpruebatecnica.backpruebatecnica.Grade.domain.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeCommandHandler {
    @Autowired
    private GradeService gradeService;

    public Grade handle(CreateGradeCommand command) {
        Grade grade = new Grade();
        grade.setGrade(command.get_grade());
        grade.setUserId(command.get_userId());
        grade.setActivityId(command.get_activityId());

        return gradeService.createGrade(grade);
    }

    public Grade handle(UpdateGradeCommand command) {
        Grade grade = new Grade();
        grade.setGrade(command.get_grade());
        grade.setUserId(command.get_userId());
        grade.setActivityId(command.get_activityId());

        return gradeService.updateGrade(command.get_id(), grade);
    }

    public void handle(DeleteGradeCommand command) {
        gradeService.deleteGradeById(command.get_id());
    }
}
