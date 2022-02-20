package utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import options.RegistrationInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@UtilityClass
public class DataGenerator {
    @UtilityClass
    public static class Registration {

        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(
                    city[n],
                    LocalDate.now(),
                    faker.name().name(),
                    faker.phoneNumber().phoneNumber());
        }

        public String generateDate(int days) {
            return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }


        private String[] city = {"Белгород", "Брянск", "Владимир", "Воронеж", "Иваново", "Калуга", "Кострома",
                "Курск", "Липецк", "Москва", "Орел", "Рязань", "Смоленск", "Тамбов", "Тверь", "Тула", "Ярославль",
                "Архангельск", "Вологда", "Калининград", "Петрозаводск", "Сыктывкар", "Санкт-Петербург",
                "Мурманск", "Салехард", "Великий Новгород", "Псков", "Санкт-Петербург", "Уфа", "Киров",
                "Йошкар-Ола", "Саранск", "Нижний Новгород", "Оренбург", "Пенза", "Пермь", "Самара",
                "Саратов", "Казань", "Ижевск", "Ульяновск", "Чебоксары", "Курган", "Екатеринбург",
                "Тюмень", "Ханты-мансийск", "Челябинск", "Салехард", "Горно-Алтайск", "Барнаул", "Улан-Удэ",
                "Чита", "Иркутск", "Кемерово", "Красноярск", "Новосибирск", "Омск", "Томск", "Кызыл", "Абакан",
                "Благовещенск", "Биробиджан", "Петропавловск-Камчатский", "Магадан", "Владивосток", "Якутск",
                "Южно-Сахалинск", "Хабаровск", "Анадырь", "Майкоп", "Астрахань", "Волгоград", "Элиста",
                "Краснодар", "Ростов", "Махачкала", "Магас", "Нальчик", "Черкесск", "Владивкавказ", "Ставрополь",
                "Грозный"};
        int n = (int) Math.floor(Math.random() * city.length);

    }
}

