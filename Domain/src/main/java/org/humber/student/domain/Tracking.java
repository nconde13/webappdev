package org.humber.student.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tracking {
    private Long trackingId;
    private int timeRemaining; // (In minutes) 3, 2, 1...
    private String orderStatus; // PENDING, CANCELLED, COMPLETED
}
