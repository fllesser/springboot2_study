package java8_charactoristic.stream_.old;

import java.util.Arrays;
import java.util.List;

public class TestStreamList {

    private static List<Grade> gradeList;
    static {
        Grade aliceGrade = new Grade("2022001", "alice", "101", 90.0, 89.0, 70.0);
        Grade bobGrade = new Grade("2022002", "bob", "101", 91.0, 87.0, 75.0);
        Grade michaleGrade = new Grade("2022003", "michale", "102", 59.0, 90.0, 78.0);
        Grade janeGrade = new Grade("2022004", "jane", "102", 56.0, 97.0, 83.0);
        Grade kangkangGrade = new Grade("2022005", "kangkang", "102", 93.0, 67.0, 65.0);
        gradeList = Arrays.asList(aliceGrade, bobGrade, michaleGrade, janeGrade, kangkangGrade);
    }


}
