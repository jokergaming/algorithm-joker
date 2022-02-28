package com.joker.basic.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static void main(String[] args) {
        Program[] programs = new Program[]{new Program(3, 4), new Program(4, 5), new Program(3, 7)};
        System.out.println(maxArrange1(programs));
        System.out.println(maxArrange2(programs));
    }

    private static class Program {
        public int start;
        public int end;
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Program[] removeIndex(Program[] programs, int index) {
        Program[] res = new Program[programs.length - 1];
        int cur = 0;

        for (int i = 0; i < programs.length; i++) {
            if (i != index)
                res[cur++] = programs[i];
        }
        return res;
    }

    public static int maxArrange2(Program[] programs) {
        Arrays.sort(programs, Comparator.comparingInt(p -> p.end));
        int now = 0;
        int res = 0;
        for (Program program : programs) {
            if (now <= program.start) {
                res++;
                now = program.end;
            }
        }
        return res;
    }

    public static int maxArrange1(Program[] programs) {
        if (programs == null || programs.length == 0) return 0;

        return process(programs, 0, 0);
    }

    public static int process(Program[] programs, int done, int timeStart) {
        if (programs.length == 0) return done;

        int max = done;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeStart) {
                Program[] next = removeIndex(programs, i);
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }
        return max;
    }
}
