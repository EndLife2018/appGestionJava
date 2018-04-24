package pl.dmichalski.reservations.business.repository.old;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.entity.old.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}