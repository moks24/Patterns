package utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import options.RegistrationInfo;

import java.time.LocalDate;
import java.util.Locale;
@UtilityClass
public class DataGenerator {
    @UtilityClass
    public static class Registration{

        public static RegistrationInfo generateInfo(String locale){
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(
                    faker.address().city(),
                    LocalDate.now(),
                    faker.name().name(),
                    faker.phoneNumber().phoneNumber());

        }
    }
}
