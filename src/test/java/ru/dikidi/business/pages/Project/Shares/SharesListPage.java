package ru.dikidi.business.pages.Project.Shares;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SharesListPage {

    final SelenideElement
    addFirstShare = $("button[title='Добавить акцию']"),
    addShare = $(""),
    removeShare = $("");
}
