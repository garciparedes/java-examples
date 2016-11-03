package stats.sampling;

import java.util.*;

/**
 * Created by garciparedes on 03/11/2016.
 */
public abstract class AbstractSampling<E> {

    private List<E> samples;
    private int selection;
    private Random random;

    private List<E> selectedSamples;
    private List<E> unselectedSamples;


    AbstractSampling(int selection, List<E> samples){
        this.samples = samples;
        this.selection = selection;

        this.selectedSamples = new ArrayList<E>(selection);
        this.unselectedSamples = new ArrayList<E>();

        this.random = new Random();

        this.doSampling();
    }

    public AbstractSampling(int selection, E[] samples){
        this(selection, Arrays.asList(samples));
    }


    protected abstract void doSampling();


    void addUnselectedSample(E sample) {
        getUnselectedSamples().add(sample);
    }

    void addSelectedSample(E sample) {
        getSelectedSamples().add(sample);
    }


    void clear(){
        this.getSelectedSamples().clear();
        this.getUnselectedSamples().clear();
    }

    Random getRandom() {
        return random;
    }


    private List<E> getSamples(){
        return samples;
    }

    E getSample(int i) {
        return getSamples().get(i);
    }

    int getSamplesSize(){
        return getSamples().size();
    }

    public List<E> getSelectedSamples(){
        return selectedSamples;
    }



    public List<E> getUnselectedSamples() {
        return unselectedSamples;
    }

    int getSelection() {
        return selection;
    }
}

