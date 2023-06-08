import org.exception.GameNotFound;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.model.NBB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameNotFoundExceptionTest {
    private static NBB nbb = new NBB();

    @BeforeAll
    static void app() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("/home/victormoreira/NBB-Games/src/main/java/org/nbb.txt")));
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] lineEdit = line.split("/");
                nbb.createChampionship(lineEdit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void notFindGameShouldRaiseGameNotFindException(){
        Exception exception = assertThrows(GameNotFound.class, () -> {
            List<String> dayAfter = Arrays.asList("12","02");
            List<String> dayBefore = Arrays.asList("16","02");

            nbb.findGame(Arrays.asList(dayAfter,dayBefore));
        });

        String expectedMessage = "Game not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}
