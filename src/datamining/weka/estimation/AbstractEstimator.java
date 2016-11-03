package datamining.weka.estimation;

import weka.classifiers.Classifier;
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



    public void setInstances(Instances instances) {
        this.instances = instances;
    }



    public abstract double getErrorPercent();



    public String getEstimationResults(){

        StringBuilder sb = new StringBuilder();

        sb.append("Estimation Method: ");
        sb.append(this.getClass().getSimpleName());
        sb.append("\n");

        sb.append("Classifier: ");
        sb.append(this.getClassifier().getClass().getSimpleName());
        sb.append("\n");

        sb.append("Error Tase: ");
        sb.append(this.getErrorPercent() );
        sb.append(" %");
        sb.append("\n");

        return sb.toString();
    }
}
