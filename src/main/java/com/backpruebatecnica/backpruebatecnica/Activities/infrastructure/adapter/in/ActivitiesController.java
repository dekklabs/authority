package com.backpruebatecnica.backpruebatecnica.Activities.infrastructure.adapter.in;

import com.backpruebatecnica.backpruebatecnica.Activities.application.command.CreateActivityCommand;
import com.backpruebatecnica.backpruebatecnica.Activities.application.command.DeleteActivityCommand;
import com.backpruebatecnica.backpruebatecnica.Activities.application.command.UpdateActivityCommand;
import com.backpruebatecnica.backpruebatecnica.Activities.application.dto.CreateActivityDTO;
import com.backpruebatecnica.backpruebatecnica.Activities.application.handler.ActivityCommandHandler;
import com.backpruebatecnica.backpruebatecnica.Activities.application.handler.ActivityQueryHandler;
import com.backpruebatecnica.backpruebatecnica.Activities.application.query.GetActivityByIdQuery;
import com.backpruebatecnica.backpruebatecnica.Activities.domain.model.Activities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/activity")
public class ActivitiesController {
    @Autowired
    private ActivityCommandHandler commandHandler;

    @Autowired
    private ActivityQueryHandler queryHandler;

    @PostMapping
    public ResponseEntity<CreateActivityDTO> createActivity(@RequestBody CreateActivityCommand command) {
        Activities activities = commandHandler.handle(command);

        CreateActivityDTO response = new CreateActivityDTO(activities.getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Activities updateActivity(@PathVariable UUID id, @RequestBody UpdateActivityCommand command) {
        return commandHandler.handle(new UpdateActivityCommand(
                id,
                command.getTitle(),
                command.getTypeActivity(),
                command.getUserId()));
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable UUID id) {
        commandHandler.handle(new DeleteActivityCommand(id));
    }

    @GetMapping
    public List<Activities> getActivities() {
        return queryHandler.handle();
    }

    @GetMapping("/{id}")
    public Optional<Activities> getActivities(@PathVariable UUID id) {
        return queryHandler.handle(new GetActivityByIdQuery(id));
    }
}
