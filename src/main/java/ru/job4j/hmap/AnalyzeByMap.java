package ru.job4j.hmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScores = 0;
        int divider = pupils.size() * pupils.get(0).subjects().size();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScores += subject.score();
            }
        }
        return totalScores / divider;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> gpaStudentsList = new ArrayList<>();
        double gpa = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                gpa += subject.score();
            }
            gpa /= pupil.subjects().size();
            gpaStudentsList.add(new Label(pupil.name(), gpa));
            gpa = 0;
        }
        return gpaStudentsList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> gpaSubjectsMap = new LinkedHashMap<>();
        BiFunction<Double, Double, Double> sumScoresSubject = Double::sum;
        List<Label> gpaSubjectsList = new ArrayList<>();
        pupils.forEach(student -> student.subjects().forEach(subject ->
                gpaSubjectsMap.merge(subject.name(), (double) subject.score(), sumScoresSubject)));
        gpaSubjectsMap.forEach((key, value) ->
                gpaSubjectsList.add(new Label(key, value / pupils.size())));
        return gpaSubjectsList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentsList = new ArrayList<>();
        double sumScores = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScores += subject.score();
            }
            studentsList.add(new Label(pupil.name(), sumScores));
            sumScores = 0;
        }
        studentsList.sort(Comparator.naturalOrder());
        return studentsList.get(studentsList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> sumScoresMap = new LinkedHashMap<>();
        List<Label> sumScoresList = new ArrayList<>();
        BiFunction<Double, Double, Double> sumScoresSubject = Double::sum;
        pupils.forEach(student -> student.subjects().forEach(subject ->
                sumScoresMap.merge(subject.name(), (double) subject.score(), sumScoresSubject)));
        sumScoresMap.forEach((key, value) -> sumScoresList.add(new Label(key, value)));
        sumScoresList.sort(Comparator.naturalOrder());
        return sumScoresList.get(sumScoresList.size() - 1);
    }
}