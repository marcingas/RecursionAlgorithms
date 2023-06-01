import java.util.Arrays;
import java.util.List;

public class NinjaTraining {
    public static void main(String[] args) {
        int day = 3;
        int task = 3;
        int last = task + 1;
        int[][] points = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
//optimalization by memoization:
        int[][] answers = new int[day][last];
        for (int[] row : answers) {
            Arrays.fill(row, -1);
        }


//        System.out.println(trainingPointsCounter(day - 1, 3, points, answers));
        System.out.println(trainingPointsCounterTabulation(3, points));

    }

    public static int trainingPointsCounter(int day, int lastTask, int[][] points, int[][] answers) {
        if (answers[day][lastTask] != -1) return answers[day][lastTask];
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    max = Math.max(max, points[0][task]);
                }
            }
            return answers[0][lastTask] = max;
        }
        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int point = points[day][task] + trainingPointsCounter(day - 1, task, points, answers);
                max = Math.max(max, point);
            }

        }
        return answers[day][lastTask] = max;
    }

    public static int trainingPointsCounterTabulation(int days, int[][] points) {
        //in day 0 you have 4 solutions to check:
        int answers[][] = new int[days][4];
        answers[0][0] = Math.max(points[0][1], points[0][2]);
        answers[0][1] = Math.max(points[0][0], points[0][2]);
        answers[0][2] = Math.max(points[0][1], points[0][0]);
        answers[0][3] = Math.max(points[0][0], Math.max(points[0][2], points[0][1]));
        //from day 1 :
        for (int dayIndex = 1; dayIndex < days; dayIndex++) {
            for (int lastTask = 0; lastTask < 4; lastTask++) {
                answers[dayIndex][lastTask] = 0;

                for (int task = 0; task <= 2; task++) {
                    if (task != lastTask) {
                        int point = points[dayIndex][task] + answers[dayIndex - 1][task];
                        answers[dayIndex][lastTask] = Math.max(answers[dayIndex][lastTask], point);
                    }
                }

            }

        }

        return answers[days - 1][3];
    }

}
