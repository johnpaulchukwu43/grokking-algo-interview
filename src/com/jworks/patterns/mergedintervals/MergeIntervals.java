package com.jworks.patterns.mergedintervals;

import java.util.*;

public class MergeIntervals {

    /*
    * Given a list of intervals, merge all the overlapping intervals
    * to produce a list that has only mutually exclusive intervals.
    *
    * Intervals: [[1,4], [2,5], [7,9]]
      Output: [[1,5], [7,9]]
      Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
    * */

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.getStart() + "," + interval.getEnd() + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.getStart() + "," + interval.getEnd() + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.getStart() + "," + interval.getEnd() + "] ");
        System.out.println();
    }

    public static List<Interval> merge(List<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(Interval::getStart));

        LinkedList<Interval> mergedIntervals = new LinkedList<>();

        intervals.forEach(currentInterval -> {

            //if merged intervals list is empty or if the end of the merged interval greater
            // than current interval start there is no overlap just append.
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast().getEnd() < currentInterval.getStart()){
                mergedIntervals.add(currentInterval);
            }
            else{

                Interval lastMergedInterval = mergedIntervals.getLast();
                lastMergedInterval.setEnd(Math.max(currentInterval.getEnd(), lastMergedInterval.getEnd()));
            }
        });
        return mergedIntervals;
    }
}
