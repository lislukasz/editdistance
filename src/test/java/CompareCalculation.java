import edu.stanford.nlp.util.EditDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
class CompareCalculation {

    private Instant startTime;

    @Test
    void compareFullFile() throws URISyntaxException, IOException {
        var fileAsString1 = readFileFromResource("file_1.txt");
        var fileAsString2 = readFileFromResource("file_2.txt");

        System.out.println(fileAsString1.length());
        System.out.println(fileAsString2.length());

        System.out.println("Apache way...");
        LevenshteinDistance levenshteinDistance = LevenshteinDistance.getDefaultInstance();
        resetStartTime();
        Integer apply = levenshteinDistance.apply(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + apply);

        System.out.println("Standford way...");
        EditDistance editDistance = new EditDistance();
        resetStartTime();
        double score = editDistance.score(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + score);
    }

    private long stopTime() {
        return Duration.between(startTime, Instant.now()).getNano();
    }

    @Test
    void compareHalfFile() throws URISyntaxException, IOException {
        var fileAsString1 = readFileFromResource("file_1.txt");
        var fileAsString2 = readFileFromResource("file_2.txt");
        fileAsString1 = fileAsString1.substring(0, fileAsString1.length() / 2);
        fileAsString2 = fileAsString2.substring(0, fileAsString2.length() / 2);

        System.out.println("Apache way...");
        LevenshteinDistance levenshteinDistance = LevenshteinDistance.getDefaultInstance();
        resetStartTime();
        Integer apply = levenshteinDistance.apply(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + apply);

        System.out.println("Standford way...");
        EditDistance editDistance = new EditDistance();
        resetStartTime();
        double score = editDistance.score(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + score);
    }

    private void resetStartTime() {
        startTime = Instant.now();
    }

    @Test
    void compareSpecificSizeForFile() throws URISyntaxException, IOException {
        var fileAsString1 = readFileFromResource("file_1.txt").substring(0, 1000);
        var fileAsString2 = readFileFromResource("file_2.txt").substring(0, 1000);

        System.out.println("Apache way...");
        LevenshteinDistance levenshteinDistance = LevenshteinDistance.getDefaultInstance();
        resetStartTime();
        Integer apply = levenshteinDistance.apply(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + apply);

        System.out.println("Standford way...");
        EditDistance editDistance = new EditDistance();
        resetStartTime();
        double score = editDistance.score(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + score);
    }

    @Test
    void compareMaximumPossibleSetSize() throws URISyntaxException, IOException {
        var fileAsString1 = readFileFromResource("file_1.txt").substring(0, 8000);
        var fileAsString2 = readFileFromResource("file_2.txt").substring(0, 8000);

        System.out.println("Apache way...");
        LevenshteinDistance levenshteinDistance = LevenshteinDistance.getDefaultInstance();
        resetStartTime();
        Integer apply = levenshteinDistance.apply(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + apply);

        System.out.println("Standford way...");
        EditDistance editDistance = new EditDistance();
        resetStartTime();
        double score = editDistance.score(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + score);
    }

    @Test
    void runStandfordWithOwnWeights() throws URISyntaxException, IOException {
        var fileAsString1 = readFileFromResource("file_1.txt").substring(0, 1000);
        var fileAsString2 = readFileFromResource("file_2.txt").substring(0, 1000);

        EditDistance editDistance = new HighInsertWeights();
        resetStartTime();
        double score = editDistance.score(fileAsString1, fileAsString2);
        System.out.println("Duration = " + stopTime());
        System.out.println("Result = " + score);
    }




    private String readFileFromResource(String name) throws URISyntaxException, IOException {
        Path path_to_file_1 = Paths.get(getClass().getResource(name).toURI());
        return Files.readString(path_to_file_1);
    }


    static class HighInsertWeights extends EditDistance {
        @Override
        protected double insertCost(Object o) {
            return 2.0;
        }

    }
}
