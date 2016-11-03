package datamining.weka.estimation.split;

import datamining.weka.estimation.AbstractEstimator;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class Bootstrap extends AbstractSplitEstimator {



    public Bootstrap(Instances instances) {
        super(instances);
    }



    @Override
    protected void splitInstances() {

    }
}
