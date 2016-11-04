package stats.sampling;

import java.util.*;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class SamplingWithoutReplacement <E> extends AbstractSampling{




    public SamplingWithoutReplacement(int selection, List<E> samples){
        super(selection, samples);
    }

    public SamplingWithoutReplacement(int selection, E[] samples){
        this(selection, Arrays.asList(samples));
    }


    @Override
    protected void doSampling() {

        clear();

        LinkedHashSet<Integer> selected = new LinkedHashSet<>(getSelection());
        for (int i = 0; i < getSelection(); ){

            Integer index = getRandom().nextInt(getSamplesSize());

            if(!selected.contains(index)){
                selected.add(index);
                i++;
            }
        }


        for (int i = 0; i < getSamplesSize(); i++) {
            if (selected.contains(i)) {
                addSelectedSample(getSample(i));
            } else {
                addUnselectedSample(getSample(i));
            }

        }
    }

}
