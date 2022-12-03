package java8_charactoristic.stream_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Grade {
    private String stuNo;
    private String stuName;
    private String stuClass;
    private Double chineseScore;
    private Double mathScore;
    private Double englishScore;
}
