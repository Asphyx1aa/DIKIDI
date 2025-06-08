package tests.api;

import api.AppointmentSteps;
import api.AuthSteps;
import org.junit.jupiter.api.Test;

public class AppointmentTests extends TestBase {
    AppointmentSteps appointmentSteps = new AppointmentSteps();
    AuthSteps authSteps = new AuthSteps();

    final String token = authSteps.getUserToken(config.getUserPhone(), config.getUserPassword());

    @Test
    void successfulGetUserBookings() {
        appointmentSteps.getAppointmentsOfUser(token);
    }
}
