package org.humber.student.services.impl;

import org.humber.student.domain.Tracking;
import org.humber.student.services.TrackingJPAService;
import org.humber.student.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingServiceImpl implements TrackingService {

    private final TrackingJPAService trackingJPAService;

    @Autowired
    public TrackingServiceImpl(TrackingJPAService trackingJPAService) {
        this.trackingJPAService = trackingJPAService;
    }

    @Override
    public Tracking createTracking(Tracking tracking) {
        return trackingJPAService.save(tracking);
    }

    @Override
    public boolean deleteTracking(Long trackingId) {
        return trackingJPAService.deleteById(trackingId);
    }

    @Override
    public Tracking updateTracking(Long trackingId, Tracking tracking) {
        Tracking existingTracking = trackingJPAService.findById(trackingId)
                .orElseThrow(() -> new RuntimeException("Tracker not found with id: " + trackingId));

        existingTracking.setTimeRemaining(tracking.getTimeRemaining());
        existingTracking.setOrderStatus(tracking.getOrderStatus());

        return trackingJPAService.save(existingTracking);
    }

    @Override
    public Tracking getTracking(Long trackingId) {
        return trackingJPAService.findById(trackingId)
                .orElseThrow(() -> new RuntimeException("Tracker not found with id: " + trackingId));
    }

    @Override
    public boolean updateTracking(Long trackingId, String orderStatus) {
        Tracking existingTracking = trackingJPAService.findById(trackingId)
                .orElseThrow(() -> new RuntimeException("Tracker not found with id: " + trackingId));

        existingTracking.setOrderStatus(orderStatus);

        trackingJPAService.save(existingTracking);
        return true;
    }
}
