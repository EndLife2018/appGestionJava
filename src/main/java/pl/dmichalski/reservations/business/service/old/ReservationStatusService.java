package pl.dmichalski.reservations.business.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.old.ReservationStatus;
import pl.dmichalski.reservations.business.repository.old.ReservationStatusRepository;

import java.util.List;

@Service
public class ReservationStatusService {

    private ReservationStatusRepository reservationStatusRepository;

    @Autowired
    public ReservationStatusService(ReservationStatusRepository reservationStatusRepository) {
        this.reservationStatusRepository = reservationStatusRepository;
    }

    public List<ReservationStatus> findAll() {
        return reservationStatusRepository.findAll();
    }

    public void remove(ReservationStatus reservationStatus) {
        reservationStatusRepository.delete(reservationStatus);
    }

    public void save(ReservationStatus reservationStatus) {
        reservationStatusRepository.save(reservationStatus);
    }
}
