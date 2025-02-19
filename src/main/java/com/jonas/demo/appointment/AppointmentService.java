package com.jonas.demo.appointment;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    AppointmentDAO upsert(AppointmentDAO appointmentDAO) {
        if (appointmentDAO.getId() == null) {
            appointmentRepository.save(appointmentDAO);
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
