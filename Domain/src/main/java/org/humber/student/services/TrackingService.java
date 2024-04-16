package org.humber.student.services;

import org.humber.student.domain.Tracking;

public interface TrackingService {

    Tracking createTracking(Tracking tracking);

    boolean deleteTracking(Long trackingId);

    Tracking updateTracking(Long trackingId, Tracking tracking);

    Tracking getTracking(Long trackingId);

    boolean updateTracking(Long trackingId, String orderStatus);
    
}
