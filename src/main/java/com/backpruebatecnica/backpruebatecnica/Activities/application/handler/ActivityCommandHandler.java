package com.backpruebatecnica.backpruebatecnica.Activities.application.handler;

import com.backpruebatecnica.backpruebatecnica.Activities.application.command.CreateActivityCommand;
import com.backpruebatecnica.backpruebatecnica.Activities.application.command.DeleteActivityCommand;
import com.backpruebatecnica.backpruebatecnica.Activities.application.command.UpdateActivityCommand;
import com.backpruebatecnica.backpruebatecnica.Activities.domain.model.Activities;
import com.backpruebatecnica.backpruebatecnica.Activities.domain.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityCommandHandler {
    @Autowired
    private ActivitiesService activitiesService;

    public Activities handle(CreateActivityCommand command) {
        Activities activities = new Activities();
        activities.setTitle(command.getTitle());
        activities.setUserId(command.getUserId());
        activities.setTypeActivity(command.getTypeActivity());

        return activitiesService.createActivity(activities);
    }

    public Activities handle(UpdateActivityCommand command) {
        Activities activities = new Activities();
        activities.setTitle(command.getTitle());
        activities.setUserId(command.getUserId());
        activities.setTypeActivity(command.getTypeActivity());

        return activitiesService.updateActivity(command.getId(), activities);
    }

    public void handle(DeleteActivityCommand command) {
        activitiesService.deleteActivityById(command.getId());
    }
}
