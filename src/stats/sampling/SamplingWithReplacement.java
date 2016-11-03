package stats.sampling;

import java.util.List;
import java.util.Random;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class SamplingWithReplacement<E> {

    private List<E> samples;
    private int selection;
    private Random random;

    private List<E> selectedSamples;
    private List<E> unselectedSamples;

    public SamplingWithReplacement(List<E> samples, int selection){
        this.samples = samples;
        this.selection = selection;

        this.doSampling();
    }

    private void doSampling() {

       this.clear();

        for (int i = 0; i < getSelection(); i++){
            getSelectedSamples().add(getSamples().get(getRandom().nextInt(getSelection())));
        }
    }





    private void clear(){
        this.getSelectedSamples().clear();
        this.getUnselectedSamples().clear();
    }

    private Random getRandom() {
        return this.random;
    }


    public List<E> getSamples(){
        return this.samples;
    }


    public List<E> getSelectedSamples(){
        return this.selectedSamples;
    }



    public List<E> getUnselectedSamples() {
        return this.unselectedSamples;
    }

    public int getSelection() {
        return selection;
    }
}
