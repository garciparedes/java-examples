package stats.main;

import stats.sampling.SamplingWithReplacement;
import stats.sampling.SamplingWithoutReplacement;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class MainSampling {


    public static void main(String[] args) {
        Integer[] numbers = loop(10000);

        SamplingWithReplacement<Integer> sampling =
                new SamplingWithReplacement<>(numbers.length, numbers);

        System.out.println(
                (double) sampling.getUnselectedSamples().size() /
                (double) sampling.getSelectedSamples().size()
        );


        SamplingWithoutReplacement<Integer> sampling2 =
                new SamplingWithoutReplacement<>(numbers.length, numbers);

        System.out.println(
                (double) sampling2.getUnselectedSamples().size() /
                (double) sampling2.getSelectedSamples().size()
        );
    }

    public static Integer[] loop(int size) {
        Integer[] a = new Integer[size];
        for (Integer i = 0; i < size; ++i) {
            a[i] = i;
        }
        return a;
    }
}
