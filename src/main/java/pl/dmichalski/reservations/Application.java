package pl.dmichalski.reservations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pl.dmichalski.reservations.business.ui.connection.controller.ConnectionController;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        LookAndFeelUtils.setWindowsLookAndFeel();
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
        ConnectionController connectionController = context.getBean(ConnectionController.class);
        connectionController.prepareAndOpenFrame();
    }

}
