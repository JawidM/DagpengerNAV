package test;

import com.jawidm.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void checkDagsatsen() {

        //eks test1
        User newUser = new User(500000, 450000, 400000);
        double expected = newUser.incomeLastYear/260;
        double actual = newUser.checkDagsatsen(0);
        assertEquals(expected, actual, "incomeLastYear is bigger than avrageIncome og dagsatsen må være incomeLastYear/260");

    }

    @Test
    void testGranted(){

        User newUser = new User(500000, 450000, 400000);
        boolean actual = newUser.testGranted();
        assertTrue(actual, "Summen av inntekten i tre siste årene er ikke høyere enn 36 eller " +
                "inntekten i siste åtet er mindre enn 1.5G");
    }
}