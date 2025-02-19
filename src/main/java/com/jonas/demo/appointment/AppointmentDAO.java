package com.jonas.demo.appointment;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;
import org.springframework.util.CollectionUtils;

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

    public void mergeAttributes(Set<AppointmentAttributesDAO> that) {
        if (CollectionUtils.isEmpty(this.attributes)) {
            this.attributes = that;
        } else {

            // neither collection is empty. copy attribtues from `that` into this.
            // this.attr = {foo: be, baz: x, n: q}
            // that.attr = {foo: bar, baz: boq, z: y}
            // after this code runs we should have this,attr = {foo: bar, baz: boq, z: y}
            for (AppointmentAttributesDAO thatAttribute : that) {
                // TODO
                boolean found = false;
                for (AppointmentAttributesDAO thisAttribute : this.attributes) {
                    if (thisAttribute.getAttribute().equals(thatAttribute.getAttribute())) {
                        thisAttribute.setVal(thatAttribute.getVal());
                        found = true;
                        break;
                    }
                }
                if (found) {
                    continue;
                }
                this.attributes.add(thatAttribute);
            }

            // remove any attributes which are not present in that's collection from this
        }
    }
}
