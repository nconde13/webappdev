package org.humber.student.services;

import org.humber.student.domain.Tracking;

import java.util.Optional;

public interface TrackingJPAService {
    Tracking save(Tracking tracking);

    boolean deleteById(Long trackingId);

    Optional<Tracking> findById(Long trackingId);
}
