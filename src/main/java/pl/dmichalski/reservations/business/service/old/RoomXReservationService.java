package pl.dmichalski.reservations.business.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.old.RoomXReservation;
import pl.dmichalski.reservations.business.repository.old.RoomXReservationRepository;

import java.util.List;

@Service
public class RoomXReservationService {

    private RoomXReservationRepository roomXReservationRepository;

    @Autowired
    public RoomXReservationService(RoomXReservationRepository roomXReservationRepository) {
        this.roomXReservationRepository = roomXReservationRepository;
    }

    public List<RoomXReservation> findAll() {
        return roomXReservationRepository.findAll();
    }

    public void remove(RoomXReservation roomXReservation) {
        roomXReservationRepository.delete(roomXReservation);
    }

    public void save(RoomXReservation roomXReservation) {
        roomXReservationRepository.save(roomXReservation);
    }
}
