package ru.dikidi.online.tests.api;

import org.junit.jupiter.api.Test;
import ru.dikidi.common.api.ProjectSteps;
import ru.dikidi.common.data.UserData;

import static ru.dikidi.common.api.AuthSteps.*;
import static ru.dikidi.common.base.ApiTestBase.AUTH_URL;

// class ProjectTests {
//    ProjectSteps projectSteps = new ProjectSteps();

//    @Test
//    void successfulCreateProject() {
//
//        final String token = extractToken(loginInAccount(
//                AUTH_URL,
//                UserData.fromConfig().getUserNumber(),
//                UserData.fromConfig().getUserPassword())
//        );
//
//        projectSteps.createProject(token);
//    }
//}
