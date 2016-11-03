package datamining.weka.estimation.split;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.adtree.ReferenceInstances;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
abstract class AbstractSplitEstimator extends AbstractEstimator {



    private ReferenceInstances trainInstances;
    private ReferenceInstances testInstances;



    AbstractSplitEstimator(Instances instances) {
        super(instances);
    }



    protected abstract void splitInstances();



    private ReferenceInstances getTrainInstances() {
        return trainInstances;
    }



    void setTrainInstances(ReferenceInstances trainInstances) {
        this.trainInstances = trainInstances;
    }



    private ReferenceInstances getTestInstances() {
        return testInstances;
    }



    void setTestInstances(ReferenceInstances testInstances) {
        this.testInstances = testInstances;
    }



    @Override
    public double getErrorPercent() {
        this.splitInstances();

        try {
            this.getClassifier().buildClassifier(getTrainInstances());

            Evaluation eval = new Evaluation(getTestInstances());
            eval.evaluateModel(getClassifier(), getTestInstances());

            return eval.pctIncorrect();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
