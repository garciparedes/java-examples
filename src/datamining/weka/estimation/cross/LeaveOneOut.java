package datamining.weka.estimation.cross;

import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class LeaveOneOut extends CrossValidation{



    public LeaveOneOut(Instances instances) {
        super(instances, instances.numInstances());
    }
}

