package org.humber.student.services;

import org.humber.student.domain.Tracking;

public interface TrackingService {

    Tracking createTracking(Tracking tracking);

    boolean deleteTracking(Long trackingId);

    Tracking updateTracking(Tracking tracking);

    Tracking getTracking(Long trackingId);
}
