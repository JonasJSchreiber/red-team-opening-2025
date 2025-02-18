package com.jonas.demo.appointment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    AppointmentDAO save(AppointmentDAO appointmentDAO) {
        if (appointmentDAO.getId() == null) {
            // ... step 1
        } else {
            Optional<AppointmentDAO> optional = appointmentRepository.findById(appointmentDAO.getId());
            if (optional.isPresent()) {
                AppointmentDAO existing = optional.get();
                existing.merge(appointmentDAO);
                // ?
            }
        }
        return appointmentDAO;
    }

}
