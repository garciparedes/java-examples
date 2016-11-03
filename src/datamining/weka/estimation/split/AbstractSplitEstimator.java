package datamining.weka.estimation.split;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Evaluation;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
abstract class AbstractSplitEstimator extends AbstractEstimator {



    private Instances trainInstances;
    private Instances testInstances;



    AbstractSplitEstimator(Instances instances) {
        super(instances);
    }



    protected abstract void splitInstances();



    private Instances getTrainInstances() {
        return trainInstances;
    }



    void setTrainInstances(Instances trainInstances) {
        this.trainInstances = trainInstances;
    }



    private Instances getTestInstances() {
        return testInstances;
    }



    void setTestInstances(Instances testInstances) {
        this.testInstances = testInstances;
    }



    @Override
    public double getErrorPercent() {
        this.splitInstances();

        try {
            this.getClassifier().buildClassifier(this.getTrainInstances());
            Evaluation eval = new Evaluation(this.getTestInstances());
            eval.evaluateModel(this.getClassifier(), this.getTestInstances());
            return eval.pctIncorrect();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
