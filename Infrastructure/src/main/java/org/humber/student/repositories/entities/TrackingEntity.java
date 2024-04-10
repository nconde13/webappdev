package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Table(name = "tracking")
@Entity
public class TrackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_id")
    private Long trackingId;

    @Column(name = "time_remaining")
    private int timeRemaining;

    @Column(name = "order_status")
    private String orderStatus;

    // Auditing fields
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;
    
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
    
}
