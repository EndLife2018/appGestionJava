package pl.dmichalski.reservations.business.ui.old.forms.reservation_status.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.old.ReservationStatus;
import pl.dmichalski.reservations.business.ui.old.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class ReservationStatusTableModel extends DefaultTableModel<ReservationStatus> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReservationStatus reservationStatus = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reservationStatus.getReservationStatus();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.RESERVATION_STATUS};
    }
}
