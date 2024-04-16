package org.humber.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tracking {
    private Long trackingId;
    private int timeRemaining; // (In minutes) 3, 2, 1...
    private String orderStatus; // PENDING, CANCELLED, COMPLETED

    public Tracking(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
