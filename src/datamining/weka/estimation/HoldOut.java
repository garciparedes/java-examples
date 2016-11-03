package datamining.weka.estimation;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class HoldOut extends Estimator {

    private double splitRate;

    public HoldOut(Instances instances, double splitRate) {
        super(instances);
        this.splitRate = splitRate;
    }


    public HoldOut(Classifier classifier, Instances instances, double splitRate) {
        super(classifier, instances);
        this.splitRate = splitRate;
    }


    @Override
    protected void splitInstances() {
        int trainSize = Math.toIntExact(Math.round(this.getInstances().numInstances() * this.splitRate));
        int testSize = this.getInstances().numInstances() - trainSize;

        this.setTrainInstances( new Instances(this.getInstances(), 0, trainSize) );
        this.setTestInstances( new Instances(this.getInstances(), trainSize, testSize) );
    }

    @Override
    public Evaluation estimate() {

        try {
            this.getClassifier().buildClassifier(this.getTrainInstances());
            Evaluation eval = new Evaluation(this.getTestInstances());
            eval.evaluateModel(this.getClassifier(), this.getTestInstances());
            return eval;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
