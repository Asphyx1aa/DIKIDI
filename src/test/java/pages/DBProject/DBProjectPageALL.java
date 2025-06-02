package pages.DBProject;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBProjectPageALL {

    //Добавить проект
    private final SelenideElement CreateNew = $x("//button[@class='new-elements-button blue create-promotions']"),

    //Создание нового проекта
            CreateNesw = $x("//div[@class='list-item add-company']"),

    // Получить доступ к проекту
            AccessProject = $x("//div[@class='list-item add-access']"),


    //Тип проекта
            Company = $x("//div[text()='Компания']"),
            Specialist= $x("//div[text()='Работаю самостоятельно']"),


    // Сфера деятельности
            Servise = $x("//div[@data-name='services']"),
                Photostudio = $x("//label[@for='services-52']"),
                Cleaning = $x("//label[@for='services-55']"),
                ServicesMassage = $x("//label[@for='services-19']"),
                Other = $x("//label[@for='services-27']"),
                Coworking = $x("//label[@for='services-54']"),
                Psychology = $x("//label[@for='services-56']"),
            Beauty = $x("//div[@data-name='beauty']"),
                Usy_boroda = $x("//label[@for='beauty-25']"),
                Depilation_epilation = $x("//label[@for='beauty-11']"),
                Barberchop = $x("//label[@for='beauty-29']"),
                Kosmetologiya_ukhod = $x("//label[@for='beauty-15']"),
                Hairdressing_services = $x("//label[@for='beauty-1']"),
                BeautyMassage = $x("//label[@for='beauty-19']"),

                Permanent_tattoo = $x("//label[@for='beauty-23']"),
                Resnitsy = $x("//label[@for='beauty-9']"),
                Brovi = $x("//label[@for='beauty-13']"),
                Vizazh = $x("//label[@for='beauty-17']"),
                Nogtevoy_servis = $x("//label[@for='beauty-7']"),
            Healing = $x("//div[@data-name='health']"),
                Dentistry = $x("//label['@for='health-31']"),
                Sauna = $x("//label['@for='health-44']"),
                Medicine = $x("//label['@for='health-30']"),
                Analyzes = $x("//label['@for='health-32']"),
                SPA = $x("//label['@for='health-21']"),
            Sport = $x("//div[@data-name='sport']"),
                Fitness = $x("//label['@for='sport-33']"),
                Yoga = $x("//label['@for='sport-35']"),
                Yedinoborstva = $x("//label['@for='sport-34']"),
                Dancing = $x("//label['@for='sport-36']"),
            Rent = $x("//label[@data-name='rent-2']"),
                Rent_Rent = $x("label[@for='rent-2-53']"),
                Rent_Coworking = $x("label[@for='rent-2-54']"),
            Pet = $x("//div[@data-name='pets']"),
                Grooming = $x("label[@for='pets-42']"),
                Veterinary = $x("label[@for='pets-41']"),
            Car = $x("//div[@data-name='auto']"),
                Avtoservis = $x("label[@for='auto-38']"),
                Tekhosmotr = $x("label[@for='auto-40']"),
                Shinomontazh = $x("label[@for='auto-37']"),
                Avtomoyka = $x("label[@for='auto-39']"),
            Game = $x("//div[@data-name='recreation']"),
                Bouling = $x("label[@for='recreation-47']"),
                Kibersport = $x("label[@for='recreation-46']"),
                Quest = $x("label[@for='recreation-43']"),
            Education = $x("//div[@data-name='education']"),
                Repetitor = $x("label[@for='recreation-49']"),
                Language_school = $x("label[@for='recreation-51']"),
                Driving_school = $x("label[@for='recreation-48']"),
                Kursy = $x("label[@for='education-50']"),
            Restaurants = $x("//div[@data-name='food']"),
                Restaurants_Restaurants = $x("label[@for='food-45']"),


    //О вашем бизнесе
        //Есть ли филиалы (только у компании)
            Odin_filial = $x("//label[@for='one']"),
            neskolko = $x("//label[@for='more']"),
        //Количество сотрудников
            ot_2_do_5 = $x("//label[@for='small']"),
            ot_6_do_9 = $x("//label[@for='medium']"),
            ot_10 = $x("//label[@for='big']"),
        //Опыт
            first_experience = $x("//label[@for='first']"),
            Work_DIKIDI = $x("//label[@for='work']"),
            Work_v_drugom_meste = $x("//label[@for='change']"),
         //Откуда узнали о DIKIDI
            recomendation = $x("//label[@for='recomendation']"),
            reklama_v_internete = $x("//label[@for='ads']"),
            conference = $x("//label[@for='conf']"),
            dovno_znayu = $x("//label[@for='know']"),
            ne_pomnyu = $x("//label[@for='remember']"),


    //Основная информация
        FIO = $x("//input[@placeholder='Введите название компании']"),
        COUNTRY = $x("//span[@class='filter-option pull-left']"),
            //Очень много
        City = $x("//input[@class='form-control input-city filled']"),
        Street = $x("//input[@placeholder='Введите название компании']"),
        House = $x("//input[@placeholder='Введите название компании']"),
        Indecs = $x("//input[@placeholder='Введите название компании']"),
        Phones = $x("//input[@placeholder='Введите название компании']"),
        Promo_code = $x("//input[@placeholder='Введите название компании']"),
        Consent_checkbox = $x("uj"),
        User_agreement = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/202-polzovatelskoe-soglashenie']"),
        Privacy_policies = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/224-politika-konfidentsialnosti']"),
        Create_company = $x("//button[@class='action-btn new-elements-button blue success']"),

    BACK = $x("//button[@class='action-btn new-elements-button-outline blue back']"),
     Continue = $x("//button[@class='action-btn new-elements-button blue next'");

//    @Step("Открываем Мои проекты")
//    public DBProjectPage openProdjectPage() {
//        open("/ru/business/projects");
//        return this;
//    }


//    @Step("Добавить проект")
//    @Step("Создать новый проект")
//    @Step("Компания")
//    @Step("Рестораны")
//    @Step("Специализация -  Ресторан")
//    @Step("Продолжить")
//    @Step("Сколько филиалов - Только один филиал")
//    @Step("Сколько сотрудников - от 2 до 5")
//    @Step("Опыт похожих программ - Первый опыт")
//    @Step("Узнал о DIKIDI из Рекомендации")
//    @Step("Продолжить")
//    @Step("FIO")
//    @Step("Принимаю условия")
//    @Step("Создание компании")





}
