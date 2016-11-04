package datamining.weka.estimation;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

import java.util.Random;

/**
 * Created by garciparedes on 03/11/2016.
 */
public abstract class AbstractEstimator {



    private Classifier classifier;
    private Instances instances;



    public AbstractEstimator(Instances instances) {
        this.instances = instances;
        this.instances.randomize(new Random(0));
    }



    protected Classifier getClassifier() {
        return classifier;
    }



    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }



    public Instances getInstances() {
        return instances;
    }



    protected Instance getInstance(int i) {
        return getInstances().instance(i);
    }



    protected int getNumInstances(){
        return getInstances().numInstances();
    }

    private String getClassifierName(){
        return this.getClassifier().getClass().getSimpleName();
    }



    public abstract double getErrorPercent();



    public String getEstimationResults(){

        return "Estimation Method: " + this.getClass().getSimpleName() + "\n" +
                "Classifier: " + getClassifierName() + "\n" +
                "Error Tase: " + this.getErrorPercent() + " %" + "\n";
    }
}
