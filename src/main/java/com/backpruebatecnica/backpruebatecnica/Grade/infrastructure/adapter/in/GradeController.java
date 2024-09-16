package com.backpruebatecnica.backpruebatecnica.Grade.infrastructure.adapter.in;

import com.backpruebatecnica.backpruebatecnica.Grade.application.command.CreateGradeCommand;
import com.backpruebatecnica.backpruebatecnica.Grade.application.command.DeleteGradeCommand;
import com.backpruebatecnica.backpruebatecnica.Grade.application.command.UpdateGradeCommand;
import com.backpruebatecnica.backpruebatecnica.Grade.application.dto.CreateGradeDTO;
import com.backpruebatecnica.backpruebatecnica.Grade.application.handler.GradeCommandHandler;
import com.backpruebatecnica.backpruebatecnica.Grade.application.handler.GradeQueryHandler;
import com.backpruebatecnica.backpruebatecnica.Grade.application.query.GetGradeByIdQuery;
import com.backpruebatecnica.backpruebatecnica.Grade.domain.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeCommandHandler commandHandler;

    @Autowired
    private GradeQueryHandler queryHandler;

   @PostMapping
   public ResponseEntity<CreateGradeDTO> createGrade(@RequestBody CreateGradeCommand command) {
       Grade grade = commandHandler.handle(command);

       CreateGradeDTO response = new CreateGradeDTO(grade.getId());

       return new ResponseEntity<>(response, HttpStatus.CREATED);
   }

   @PutMapping("/{id}")
    public Grade updateGrade(
            @PathVariable UUID id,
            @RequestBody UpdateGradeCommand command
            ) {
       return commandHandler.handle(new UpdateGradeCommand(
               id,
               command.get_grade(),
               command.get_activityId(),
               command.get_userId()
       ));
   }

   @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable UUID id) {
       commandHandler.handle(new DeleteGradeCommand(id));
   }

   @GetMapping("/{id}")
    public Optional<Grade> getGradeById(@PathVariable UUID id) {
       return queryHandler.handle(new GetGradeByIdQuery(id));
   }
}
