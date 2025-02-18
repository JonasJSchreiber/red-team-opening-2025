package com.jonas.demo.appointment;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Entity(name = "appointment")
@Data

public class AppointmentDAO {
    @Id
    private Long id;
    @Column(name = "location_id")
    private Long locationId;
    @Column(name = "patient_id")
    private Long patientId;
    @OneToMany
    @JoinColumn(name = "appointment_id")
    private Set<AppointmentAttributesDAO> attributes;

    public void merge(AppointmentDAO that) {
        if (that == null) return;
        if (that.getLocationId() != null) this.locationId = that.getLocationId();

        if (that.getPatientId() != null) this.patientId = that.getPatientId();
        if (that.getAttributes() != null) {
            this.mergeAttributes(that.getAttributes());
        }
    }

    public void mergeAttributes(Set<AppointmentAttributesDAO> attributes) {
        if (CollectionUtils.isEmpty(this.attributes)) {
            this.attributes = attributes;
        } else {
            // neither collection is empty. copy attribtues from `that` into this.
            for (AppointmentAttributesDAO that : attributes) {
                // TODO
            }
            // remove any attributes which are not present in that's collection from this
        }
    }

}
