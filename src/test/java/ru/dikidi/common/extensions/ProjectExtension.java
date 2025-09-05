package ru.dikidi.common.extensions;

import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.dikidi.common.annotations.WithProject;
import ru.dikidi.common.context.AuthContext;
import ru.dikidi.common.enums.ProjectType;

import static io.restassured.RestAssured.given;
import static ru.dikidi.common.context.ProjectContext.setProjectResponse;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;
import static ru.dikidi.common.specs.BaseSpec.baseSpec;
import static ru.dikidi.common.utils.FakerProvider.getFaker;

public class ProjectExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        WithProject withProject = context.getRequiredTestMethod().getAnnotation(WithProject.class);
        createProject(withProject.type());
    }

    private void createProject(ProjectType type) {
        Response authResponse = AuthContext.getAuthResponse();
        boolean isCompany = ProjectType.COMPANY.equals(type);

        if (authResponse == null) {
            throw new IllegalStateException("Не найдены данные авторизации");
        }

        final String token = authResponse.getCookie("token");

        Response projectResponse = given()
                .spec(baseSpec)
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc") //TODO: Убрать ключ
                .cookie("token", token)
                .contentType("multipart/form-data")
                .multiPart("type", isCompany ? 1 : 2)
                .multiPart("name", getFaker().company().name())
                .multiPart("country", "RU")
                .multiPart("city", 468902) // 468902 - Ярославль
                .multiPart("conditions", "1")
                .when()
                .post("https://dikidi.tech/api/company/create")
                .then()
                .spec(baseResponseSpec(200))
                .extract()
                .response();

        setProjectResponse(projectResponse);
    }
}






