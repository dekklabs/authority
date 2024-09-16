package com.backpruebatecnica.backpruebatecnica.Activities.application.handler;

import com.backpruebatecnica.backpruebatecnica.Activities.application.query.GetActivityByIdQuery;
import com.backpruebatecnica.backpruebatecnica.Activities.domain.model.Activities;
import com.backpruebatecnica.backpruebatecnica.Activities.domain.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityQueryHandler {
    @Autowired
    private ActivitiesService activitiesService;

    public List<Activities> handle() {
        return activitiesService.listActivities();
    }

    public Optional<Activities> handle(GetActivityByIdQuery query) {
        return activitiesService.getActivityById(query.getId());
    }
}
