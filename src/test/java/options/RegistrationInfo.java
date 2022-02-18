package options;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class RegistrationInfo {
    private final String city;
    private final LocalDate date;
    private final String name;
    private final String phoneNumber;

}
