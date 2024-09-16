package com.backpruebatecnica.backpruebatecnica.Activities.domain.service;

import com.backpruebatecnica.backpruebatecnica.Activities.domain.model.Activities;
import com.backpruebatecnica.backpruebatecnica.Activities.domain.repository.ActivitiesRepository;
import com.backpruebatecnica.backpruebatecnica.Activities.shared.ActivitiesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActivitiesService {
    @Autowired
    private ActivitiesRepository activitiesRepository;

    public Activities createActivity(Activities activities) {
        return activitiesRepository.save(activities);
    }

    public Activities updateActivity(UUID id, Activities activitiesDetail) {
        Activities activities = activitiesRepository.findById(id).orElseThrow(() -> new ActivitiesNotFoundException(id));
        activities.setTitle(activitiesDetail.getTitle());
        activities.setTypeActivity(activitiesDetail.getTypeActivity());
        activities.setUserId(activitiesDetail.getUserId());

        return activitiesRepository.save(activities);
    }

    public List<Activities> listActivities() {
        return activitiesRepository.findAll();
    }

    public Optional<Activities> getActivityById(UUID id) {
        return activitiesRepository.findById(id);
    }

    public void deleteActivityById(UUID id) {
        activitiesRepository.deleteById(id);
    }
}
