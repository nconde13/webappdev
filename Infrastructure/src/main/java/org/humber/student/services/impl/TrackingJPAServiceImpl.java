package org.humber.student.services.impl;

import org.humber.student.domain.Tracking;
import org.humber.student.repositories.TrackingJPARepository;
import org.humber.student.repositories.entities.TrackingEntity;
import org.humber.student.services.TrackingJPAService;
import org.humber.student.transformers.TrackingEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackingJPAServiceImpl implements TrackingJPAService {

    private final TrackingJPARepository trackingJPARepository;

    @Autowired
    public TrackingJPAServiceImpl(TrackingJPARepository trackingJPARepository) {
        this.trackingJPARepository = trackingJPARepository;
    }

    @Override
    public Tracking save(Tracking tracking) {
        TrackingEntity trackingEntity = trackingJPARepository.save(TrackingEntityTransformer.transformToTrackingEntity(tracking));
        return TrackingEntityTransformer.transformToTracking(trackingEntity);
    }

    @Override
    public boolean deleteById(Long trackingId) {
        Optional<Tracking> tracking = this.findById(trackingId);
        if (tracking.isPresent()) {
            trackingJPARepository.deleteById(trackingId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Tracking> findById(Long trackingId) {
        return trackingJPARepository.findById(trackingId).map(TrackingEntityTransformer::transformToTracking);
    }
}
