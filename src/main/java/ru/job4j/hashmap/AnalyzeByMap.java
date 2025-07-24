package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalSum = 0;
        int totalCount = 0;

        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subj : subjects) {
                totalSum += subj.score();
                totalCount += 1;
            }
        }
        return totalCount == 0 ? 0D : totalSum / totalCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();

            int sum = 0;
            for (Subject subj : subjects) {
                sum += subj.score();
            }
            int count = subjects.size();

            double average = count == 0 ? 0D : (double) sum / count;

            Label label = new Label(pupil.name(), average);

            result.add(label);
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> sums = new LinkedHashMap<>();
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                String name = subj.name();
                int score = subj.score();

                sums.put(name, sums.getOrDefault(name, 0) + score);
                counts.put(name, counts.getOrDefault(name, 0) + 1);
            }
        }

        List<Label> result = new ArrayList<>();
        for (String name : sums.keySet()) {
            double total = sums.get(name);
            int times = counts.get(name);
            double average = times == 0 ? 0D : total / times;
            result.add(new Label(name, average));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = new Label("", 0D);

        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subj : pupil.subjects()) {
                sum += subj.score();
            }
            if (sum > best.score()) {
                best = new Label(pupil.name(), sum);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> sums = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                String name = subj.name();
                int score = subj.score();
                sums.put(name, sums.getOrDefault(name, 0) + score);
            }
        }

        Label best = null;
        for (Map.Entry<String, Integer> entry : sums.entrySet()) {
            String subjectName = entry.getKey();
            double totalScore = entry.getValue();
            Label current = new Label(subjectName, totalScore);
            if (best == null || current.score() > best.score()) {
                best = current;
            }
        }
        return best;
    }
}