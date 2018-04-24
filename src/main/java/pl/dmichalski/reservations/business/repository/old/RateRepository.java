package pl.dmichalski.reservations.business.repository.old;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.entity.old.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}