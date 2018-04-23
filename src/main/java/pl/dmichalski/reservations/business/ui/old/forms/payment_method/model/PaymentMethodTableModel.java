package pl.dmichalski.reservations.business.ui.old.forms.payment_method.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.old.PaymentMethod;
import pl.dmichalski.reservations.business.ui.old.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class PaymentMethodTableModel extends DefaultTableModel<PaymentMethod> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentMethod paymentMethod = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return paymentMethod.getName();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.PAYMENT_METHOD};
    }
}
