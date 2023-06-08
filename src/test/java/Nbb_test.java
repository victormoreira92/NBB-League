import org.application.App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.NBB;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class Nbb_test {

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
    void numberOfTeamsInNBBShouldBe17(){
       assertEquals(17, nbb.teamsInNBB().size());

    }

    @Test
    void numberOfGamesInNBBShouldbe63(){
        assertEquals(63, nbb.gamesInNBB().size());
    }






}
