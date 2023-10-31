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
        Map<String, Integer> gpaSubjectsMap = new LinkedHashMap<>();
        List<Label> gpaSubjectsList = new ArrayList<>();
        int gpa = 0;
        int numberSubjects = pupils.get(0).subjects().size();
        String nameSubject;
        for (int count = 0; count < numberSubjects; count++) {
            for (Pupil pupil : pupils) {
                gpa += pupil.subjects().get(count).score();
            }
            nameSubject = pupils.get(count).subjects().get(count).name();
            gpaSubjectsMap.put(nameSubject, gpa);
            gpa = 0;
        }
        for (Map.Entry<String, Integer> entry : gpaSubjectsMap.entrySet()) {
            gpaSubjectsList.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));

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
        List<Label> gpaSubjectsList = new ArrayList<>();
        double gpa = 0;
        int numberSubjects = pupils.get(0).subjects().size();
        String nameSubject;
        for (int count = 0; count < numberSubjects; count++) {
            for (Pupil pupil : pupils) {
                gpa += pupil.subjects().get(count).score();
            }
            nameSubject = pupils.get(count).subjects().get(count).name();
            gpaSubjectsList.add(new Label(nameSubject, gpa));
            gpa = 0;
        }
        gpaSubjectsList.sort(Comparator.naturalOrder());
        return gpaSubjectsList.get(gpaSubjectsList.size() - 1);
    }
}