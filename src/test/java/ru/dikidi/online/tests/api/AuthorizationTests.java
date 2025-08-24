package ru.dikidi.online.tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.dikidi.common.api.AuthSteps;
import ru.dikidi.common.base.ApiTestBase;
import ru.dikidi.common.data.UserData;
import ru.dikidi.common.models.AuthResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Owner("Тимур Власов")
@Feature("Авторизация / регистрация")
@Tag("Авторизация")
@Tag("smoke")
@Tag("api")
class AuthorizationTests extends ApiTestBase {
    AuthSteps authSteps = new AuthSteps();

    @Test
    @DisplayName("Проверяем авторизацию через API")
    void successfulAuthorization() {
        UserData user = UserData.fromConfig();

        AuthResponse response = authSteps.loginInAccount(
                AUTH_URL,
                user.getUserNumber(),
                user.getUserPassword()
        );

        final String token = response.getData().getToken();
        assertThat("Токен не должен быть null", token, notNullValue());
        assertThat("Токен не должен быть пустым", token, not(emptyString()));

    }
}
