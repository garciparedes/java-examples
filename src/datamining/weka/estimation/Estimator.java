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



    public Estimator(Classifier classifier, Instances instances) {
        this.classifier = classifier;
        this.instances = instances;
        this.instances.randomize(new Random(0));
    }

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClassifier().toString());
        stringBuilder.append(this.getInstances().toSummaryString());
        stringBuilder.append(this.estimate().toSummaryString());

        return stringBuilder.toString();
    }
}
