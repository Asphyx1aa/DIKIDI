package ru.dikidi.common.annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import ru.dikidi.common.extensions.LoginExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для автоматической авторизации пользователя перед выполнением тестов.
 *
 * <p>Данная аннотация предназначена для упрощения процесса авторизации в тестах,
 * автоматически выполняя вход пользователя с использованием данных из конфигурации
 * и установки необходимых cookies для Selenium WebDriver.</p>
 *
 * <p><b>Функциональность:</b></p>
 * <ul>
 *   <li>Автоматически выполняет API-запрос авторизации с использованием номера телефона и пароля из конфигурации</li>
 *   <li>Извлекает токен авторизации из ответа и устанавливает его в контекст приложения</li>
 *   <li>Открывает браузер и устанавливает cookie с токеном для домена dikidi.tech</li>
 *   <li>Настраивает cookie как HttpOnly и Secure для обеспечения безопасности</li>
 * </ul>
 *
 * <p><b>Использование:</b></p>
 * <pre>{@code
 * // На уровне класса - все тесты в классе будут выполняться с авторизацией
 * @WithLogin
 * public class AuthorizedTestClass {
 *     // тесты
 * }
 *
 * // На уровне метода - только конкретный тест будет выполняться с авторизацией
 * public class TestClass {
 *     @WithLogin
 *     @Test
 *     public void testWithAuthorization() {
 *         // тест, требующий авторизации
 *     }
 * }
 * }</pre>
 *
 * <p><b>Требования:</b></p>
 * <ul>
 *   <li>Должны быть настроены данные пользователя в конфигурации (номер телефона и пароль)</li>
 *   <li>API авторизации должно быть доступно</li>
 *   <li>Браузер должен быть инициализирован через Selenide</li>
 * </ul>
 *
 * <p><b>Примечание:</b> Аннотация выполняется перед каждым тестовым методом (BeforeEach),
 * что гарантирует свежую авторизацию для каждого теста.</p>
 *
 * @see LoginExtension
 *
 * @author Timur Vlasov
 */
@ExtendWith(LoginExtension.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface WithLogin {
}
