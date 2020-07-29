package wawer.kamil.universitymanager.utils.generator.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class StudentJoinedDateGenerator {

    private final Random random;
    private static final int JOINING_DAY_OF_MONTH = 1;
    private static final int JOINING_AUTUMN_MONTH = 10;
    private static final int JOINING_WINTER_MONTH = 2;

    public LocalDate generateJoiningDate() {
        return LocalDate.of(generateYearOfJoining(), generateMonthOfJoining(), JOINING_DAY_OF_MONTH);
    }

    private int generateMonthOfJoining() {
        return random.nextInt(10) <= 5 ? JOINING_WINTER_MONTH : JOINING_AUTUMN_MONTH;
    }

    private int generateYearOfJoining() {
        return random.nextInt(40) + 1980;
    }
}
