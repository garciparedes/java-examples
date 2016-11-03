package datamining.weka.estimation.split;

import datamining.weka.estimation.AbstractEstimator;
import stats.sampling.SamplingWithReplacement;
import weka.classifiers.trees.adtree.ReferenceInstances;
import weka.core.Instance;
import weka.core.Instances;

import java.util.*;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class Bootstrap extends AbstractSplitEstimator {


    private final int samplingSize;



    public Bootstrap(Instances instances) {
        super(instances);
        this.samplingSize = instances.numInstances();
    }



    public Bootstrap(Instances instances, int samplingSize) {
        super(instances);
        this.samplingSize = samplingSize;
    }




    public int getSamplingSize() {
        return samplingSize;
    }



    @Override
    protected void splitInstances() {
        ReferenceInstances selectedInstances = new ReferenceInstances(
                getInstances(),
                getSamplingSize()
        );

        ReferenceInstances unselectedInstances = new ReferenceInstances(
                getInstances(),
                getNumInstances()
        );

        List<Integer> selected = new ArrayList<>(getNumInstances());

        Random rand = new Random();
        for (int i = 0; i < getSamplingSize(); i++){
            selected.add(rand.nextInt(getNumInstances()));
        }


        for (int i = 0, fr; i < getNumInstances(); i++){
            if ( (fr = Collections.frequency(selected, i)) > 0){

                for(int j = 0; j < fr; j++){
                    selectedInstances.addReference(getInstance(i));
                }

            } else {
                unselectedInstances.addReference(getInstance(i));
            }

        }

        // Necessary because of ordered insertion
        selectedInstances.randomize(new Random());
        unselectedInstances.randomize(new Random());


        this.setTrainInstances( selectedInstances );
        this.setTestInstances( unselectedInstances );



    }
}
