package org.humber.student.controllers;

import org.humber.student.domain.Tracking;
import org.humber.student.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trackings")
public class TrackingController {

    private final TrackingService trackingService;

    @Autowired
    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @PostMapping
    public ResponseEntity<Tracking> createTracking(@RequestBody Tracking tracking) {
        Tracking createdTracking = trackingService.createTracking(tracking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTracking);
    }

    @GetMapping("/{trackingId}")
    public Tracking getTracking(@PathVariable Long trackingId) {
        return trackingService.getTracking(trackingId);
    }

    @PutMapping("/{trackingId}")
    public ResponseEntity<Tracking> updateTracking(@PathVariable Long trackingId, @RequestBody Tracking tracking) {
        // Set the trackingId from path variable
        tracking.setTrackingId(trackingId);
        Tracking updatedTracking = trackingService.updateTracking(tracking);
        return ResponseEntity.ok(updatedTracking);
    }

    @DeleteMapping("/{trackingId}")
    public ResponseEntity<Void> deleteTracking(@PathVariable Long trackingId) {
        boolean deleted = trackingService.deleteTracking(trackingId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
