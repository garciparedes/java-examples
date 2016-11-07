package datamining.weka.estimation.split;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.adtree.ReferenceInstances;
import weka.core.Instances;

import java.util.List;

/**
 * Created by garciparedes on 03/11/2016.
 */
abstract class AbstractSplitEstimator extends AbstractEstimator {



    private ReferenceInstances trainInstances;
    private ReferenceInstances testInstances;



    AbstractSplitEstimator(Instances instances) {
        super(instances);
    }

    AbstractSplitEstimator(Instances instances, List<Classifier> classifierList) {
        super(instances, classifierList);
    }

    AbstractSplitEstimator(Instances instances, Classifier... classifierList) {
        super(instances, classifierList);
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
    public double getErrorPercent(int i) {
        this.splitInstances();

        try {
            getClassifier(i).buildClassifier(getTrainInstances());

            Evaluation eval = new Evaluation(getTestInstances());
            eval.evaluateModel(getClassifier(i), getTestInstances());

            return eval.pctIncorrect();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
