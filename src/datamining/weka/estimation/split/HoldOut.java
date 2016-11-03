package datamining.weka.estimation.split;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.adtree.ReferenceInstances;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class HoldOut extends AbstractSplitEstimator {



    private double splitRate;



    public HoldOut(Instances instances, double splitRate) {
        super(instances);
        this.splitRate = splitRate;
    }


    public double getSplitRate() {
        return splitRate;
    }



    @Override
    protected void splitInstances() {
        int trainSize = Math.toIntExact(
                Math.round(getNumInstances() * getSplitRate())
        );

        ReferenceInstances selectedInstances = new ReferenceInstances(
                getInstances(),
                trainSize
        );

        ReferenceInstances unselectedInstances = new ReferenceInstances(
                getInstances(),
                getNumInstances() - trainSize
        );


        for (int i = 0; i < trainSize; i ++){
            selectedInstances.addReference(getInstance(i));
        }


        for (int i = trainSize; i < getNumInstances(); i ++){
            unselectedInstances.addReference(getInstance(i));
        }

        this.setTrainInstances( selectedInstances );
        this.setTestInstances( unselectedInstances );
    }
}
