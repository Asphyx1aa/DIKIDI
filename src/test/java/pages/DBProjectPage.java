package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBProjectPage {

    //Добавить проект
    private final SelenideElement CreateNew = $x("jj"),
    //Создание нового проекта
            CreateNesw = $x("uj"),


    // Получить доступ к проекту
            AccessProject = $x("uj"),


    //Тип проекта
            Company = $x("uj"),
            Specialist= $x("uj"),


    // Сфера деятельности и
                Cleaning = $x("uj"),
                ServicesMassage = $x("uj"),
                Other = $x("uj"),
                Coworking = $x("uj"),
                Psychology = $x("uj"),
                Photostudio = $x("uj"),
            Beauty = $x("uj"),
                Cosmetology_care = $x("uj"),
                Hairdressing_services = $x("uj"),
                Permanent_tattoo = $x("uj"),
                BeautyMassage = $x("uj"),
                Eyelashes = $x("uj"),
                Eyebrows = $x("uj"),
                Make_up = $x("uj"),
                Nail_service = $x("uj"),
                Moustache_beard = $x("uj"),
                Depilation_epilation = $x("uj"),
                Barbershop = $x("uj"),
            Healing = $x("uj"),
                Dentistry = $x("uj"),
                Sauna = $x("uj"),
                Medicine = $x("uj"),
                Analyzes = $x("uj"),
                SPA = $x("uj"),
            Sport = $x("uj"),
                Fitness = $x("uj"),
                Yoga = $x("uj"),
                Yedinoborstva = $x("uj"),
                Dancing = $x("uj"),
            Rent = $x("uj"),
                Rent_Rent = $x("uj"),
                Rent_Coworking = $x("uj"),
            Pet = $x("uj"),
                Grooming = $x("uj"),
                Veterinary = $x("uj"),
            Car = $x("uj"),
                Avtoservis = $x("uj"),
                Tekhosmotr = $x("uj"),
                Shinomontazh = $x("uj"),
                Car_wash = $x("uj"),
            Game = $x("uj"),
                Bouling = $x("uj"),
                Kibersport = $x("uj"),
                Quest = $x("uj"),
            Education = $x("uj"),
                Repetitor = $x("uj"),
                Language_school = $x("uj"),
            Restaurants = $x("uj"),
                Restaurants_Restaurants = $x("uj"),


    //О вашем бизнесе
        //Есть ли филиалы (только у компании)
//        Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//        //Количество сотрудников
//        Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//        //Опыт
//        Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//        Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),
//            Restaurants_Restaurants = $x("uj"),


    //Основная информация
        FIO = $x("uj"),
        COUNTRY = $x("uj"),
            //Очень много
        City = $x("uj"),
        Street = $x("uj"),
        House = $x("uj"),
        Zip_code = $x("uj"),
        Phones = $x("uj"),
        Promo_code = $x("uj"),
        Consent_checkbox = $x("uj"),
        User_agreement = $x("uj"),
        Privacy_policies = $x("uj"),
        Create_company = $x("uj"),

    BACK = $x("uj"),
    Сontinue = $x("uj");







    @Step("Открываем Мои проекты")
    public DBProjectPage openProdjectPage() {
        open("/ru/business/projects");
        return this;
    }

}
