package pl.dmichalski.reservations.business.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.old.Room;
import pl.dmichalski.reservations.business.repository.old.RoomRepository;

import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public void remove(Room room) {
        roomRepository.delete(room);
    }

    public void save(Room room) {
        roomRepository.save(room);
    }
}
