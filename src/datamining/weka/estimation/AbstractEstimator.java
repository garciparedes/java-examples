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

    public String getEstimatorName(){
        return getClass().getSimpleName();
    }

    public String getClassifierName(){
        return getClassifier().getClass().getSimpleName();
    }



    public abstract double getErrorPercent();


    public String getEstimatorEstimationResults(){

        return "Estimation Method: " + getEstimatorName() + "\n" +
                "Error Tase: " + getErrorPercent() + " %" + "\n";
    }

    public String getClassifierEstimationResults(){

        return "Classifier: " + getClassifierName() + "\n" +
                "Error Tase: " + getErrorPercent() + " %" + "\n";
    }

    public String getDetailedEstimationResults(){

        return "Estimation Method: " + getEstimatorName() + "\n" +
                "Classifier: " + getEstimatorName() + "\n" +
                "Error Tase: " + getErrorPercent() + " %" + "\n";
    }
}
