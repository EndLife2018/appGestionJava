package pl.dmichalski.reservations.business.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.old.Payment;
import pl.dmichalski.reservations.business.repository.old.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void remove(Payment payment) {
        paymentRepository.delete(payment);
    }

    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
