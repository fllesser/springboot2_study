package java8_charactoristic.stream_;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamList {

    public List<Grade> filterByStream(List<Grade> gradeList) {
        return gradeList.stream()
                .filter(Objects::nonNull)
                .filter(g -> g.getChineseScore() >= 60)
                .collect(Collectors.toList());
    }

    public List<Grade> orderByStream(List<Grade> gradeList) {
        return gradeList.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Grade::getChineseScore))
                .collect(Collectors.toList());
    }

    /**
     * 按班级分组
     * @param gradeList
     * @return
     */
    public Map<String, List<Grade>> groupByStream(List<Grade> gradeList) {
        return gradeList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Grade::getStuClass));
    }

    public Double avgByStream(List<Grade> gradeList) {
        return gradeList.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Grade::getChineseScore)
                .average()
                .orElseThrow(IllegalStateException::new);
    }

    public Double avgByStream2(List<Grade> gradeList) {
        return gradeList.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Grade::getEnglishScore)
                .sum() / (double) gradeList.size();
    }
}
