package com.jonas.demo.appointment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "appointment_attributes")
public class AppointmentAttributesDAO {
    @Id
    private Long id;
    private String attribute;
    private String val;
}
