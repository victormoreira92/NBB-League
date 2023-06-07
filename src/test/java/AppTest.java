import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.model.NBB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AppTest {
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

    }
}
