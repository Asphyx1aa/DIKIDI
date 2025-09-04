package ru.dikidi.common.extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EmployeeExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        // Логика созданияя сотрудника перед тестом
    }
}
