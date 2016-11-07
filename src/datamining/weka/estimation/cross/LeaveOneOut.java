package datamining.weka.estimation.cross;

import weka.classifiers.Classifier;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class LeaveOneOut extends CrossValidation{



    public LeaveOneOut(Instances instances) {
        super(instances, instances.numInstances());
    }

    public LeaveOneOut(Instances instances, Classifier... classifiers) {
        super(instances, instances.numInstances(), classifiers);
    }
}

