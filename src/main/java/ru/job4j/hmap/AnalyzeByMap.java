package ru.job4j.hmap;

import java.util.*;

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
        List<Label> gpaSubjectsList = new ArrayList<>();
        double value;
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                value = gpaSubjectsMap.getOrDefault(subject.name(), 0.0) + subject.score();
                gpaSubjectsMap.put(subject.name(), value);
            }
        }
        for (Map.Entry<String, Double> entry : gpaSubjectsMap.entrySet()) {
            gpaSubjectsList.add(new Label(entry.getKey(),
                    entry.getValue() / pupils.size()));
        }
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
        double value;
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                value = sumScoresMap.getOrDefault(subject.name(), 0.0) + subject.score();
                sumScoresMap.put(subject.name(), value);
            }
        }
        for (Map.Entry<String, Double> entry : sumScoresMap.entrySet()) {
            sumScoresList.add(new Label(entry.getKey(),
                    entry.getValue()));
        }
        sumScoresList.sort(Comparator.naturalOrder());
        return sumScoresList.get(sumScoresList.size() - 1);
    }
}