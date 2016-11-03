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



    public Bootstrap(Instances instances) {
        super(instances);
    }



    @Override
    protected void splitInstances() {
        Instances selectedInstances =
                new ReferenceInstances(
                        getInstances(),
                        getInstances().numInstances()
                );

        Instances unselectedInstances =
                new ReferenceInstances(
                        getInstances(),
                        getInstances().numInstances()
                );

        List<Integer> selected= new ArrayList<>(getInstances().numInstances());

        Random random = new Random();
        for (int i = 0; i < getInstances().numInstances(); i++){
            selected.add(random.nextInt(getInstances().numInstances()));
        }


        for (int i = 0, fr = 0; i < getInstances().numInstances(); i++){
            if ( (fr = Collections.frequency(selected, i)) > 0){

                for(int j = 0; j < fr; j++){
                    selectedInstances.add(getInstances().instance(i));
                }

            } else {
                unselectedInstances.add(getInstances().instance(i));
            }

        }

        selectedInstances.randomize(new Random());
        unselectedInstances.randomize(new Random());


        this.setTrainInstances( selectedInstances );
        this.setTestInstances( unselectedInstances );



    }
}
