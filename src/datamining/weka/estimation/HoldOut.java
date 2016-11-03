package datamining.weka.estimation;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class HoldOut extends Estimator {

    private double splitRate;

    public HoldOut(Classifier classifier, Instances instances, double splitRate) {
        super(classifier, instances);
        this.splitRate = splitRate;
    }




    @Override
    public Evaluation estimate() {
        return null;
    }
}
