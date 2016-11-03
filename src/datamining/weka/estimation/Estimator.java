package datamining.weka.estimation;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;

import java.util.Random;

/**
 * Created by garciparedes on 03/11/2016.
 */
public abstract class Estimator {



    private Classifier classifier;
    private Instances instances;


    private Instances trainInstances;
    private Instances testInstances;

    public Estimator(Instances instances) {
        this.instances = instances;
        this.instances.randomize(new Random(0));
    }


    public Estimator(Classifier classifier, Instances instances) {
        this(instances);
        this.classifier = classifier;
    }

    protected abstract void splitInstances();


    public Classifier getClassifier() {
        return classifier;
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }


    public Instances getInstances() {
        return instances;
    }

    public void setInstances(Instances instances) {
        this.instances = instances;
    }

    public abstract Evaluation estimate();



    public String getEstimationResults(){
        this.splitInstances();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClassifier().toString());
        stringBuilder.append(this.estimate().toSummaryString());

        return stringBuilder.toString();
    }

    public Instances getTrainInstances() {
        return trainInstances;
    }

    public void setTrainInstances(Instances trainInstances) {
        this.trainInstances = trainInstances;
    }

    public Instances getTestInstances() {
        return testInstances;
    }

    public void setTestInstances(Instances testInstances) {
        this.testInstances = testInstances;
    }
}
