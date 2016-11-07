package stats.sampling;

import java.util.*;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class SamplingWithReplacement<E> extends AbstractSampling<E> {



    public SamplingWithReplacement(int selection, List<E> samples){
        super(selection, samples);
    }

    public SamplingWithReplacement(int selection, E[] samples){
        this(selection, Arrays.asList(samples));
    }


    @Override
    protected void doSampling() {

       clear();

        List<Integer> selected = new ArrayList<>(getSelection());

        for (int i = 0; i < getSelection(); i++){
            selected.add(getRandom().nextInt(getSamplesSize()));
        }


        for (int i = 0, fr; i < getSamplesSize(); i++) {
            if ((fr = Collections.frequency(selected, i)) > 0) {

                for (int j = 0; j < fr; j++) {
                    addSelectedSample(getSample(i));
                }

            } else {
                addUnselectedSample(getSample(i));
            }

        }
    }

}
