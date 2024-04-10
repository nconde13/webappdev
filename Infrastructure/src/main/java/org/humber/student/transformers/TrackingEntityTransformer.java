package org.humber.student.transformers;

import org.humber.student.domain.Tracking;
import org.humber.student.repositories.entities.TrackingEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class TrackingEntityTransformer {

    private TrackingEntityTransformer() {
    }

    public static Tracking transformToTracking(TrackingEntity trackingEntity) {
        return Tracking.builder()
                .trackingId(trackingEntity.getTrackingId())
                .timeRemaining(trackingEntity.getTimeRemaining())
                .orderStatus(trackingEntity.getOrderStatus())
                .build();
    }

    public static TrackingEntity transformToTrackingEntity(Tracking tracking) {
        TrackingEntity trackingEntity = new TrackingEntity();
        trackingEntity.setTrackingId(tracking.getTrackingId());
        trackingEntity.setTimeRemaining(tracking.getTimeRemaining());
        trackingEntity.setOrderStatus(tracking.getOrderStatus());
        return trackingEntity;
    }

    public static List<Tracking> transformToTrackings(List<TrackingEntity> trackingEntities) {
        return trackingEntities.stream()
                .map(TrackingEntityTransformer::transformToTracking)
                .collect(Collectors.toList());
    }

    public static List<TrackingEntity> transformToTrackingEntities(List<Tracking> trackings) {
        return trackings.stream()
                .map(TrackingEntityTransformer::transformToTrackingEntity)
                .collect(Collectors.toList());
    }
}
