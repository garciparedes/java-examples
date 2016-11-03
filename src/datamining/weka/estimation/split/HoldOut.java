package datamining.weka.estimation.split;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Evaluation;
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




    @Override
    protected void splitInstances() {
        int trainSize = Math.toIntExact(Math.round(this.getInstances().numInstances() * this.splitRate));
        int testSize = this.getInstances().numInstances() - trainSize;

        this.setTrainInstances( new Instances(this.getInstances(), 0, trainSize) );
        this.setTestInstances( new Instances(this.getInstances(), trainSize, testSize) );
    }
}
