package datamining.weka.estimation;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by garciparedes on 03/11/2016.
 */
public abstract class AbstractEstimator {



    private List<Classifier> classifierList;
    private Instances instances;


    public AbstractEstimator(Instances instances, List<Classifier> classifierList) {
        this.instances = instances;
        //this.instances.randomize(new Random(0));
        this.classifierList = classifierList;
    }


    public AbstractEstimator(Instances instances, Classifier... classifierList) {
        this(instances, Arrays.asList(classifierList));
    }



    public AbstractEstimator(Instances instances) {
        this(instances, new ArrayList<>());
    }


    protected Classifier getClassifier() {
        return getClassifier(0);
    }


    protected Classifier getClassifier(int i) {
        return getClassifierList().get(i);
    }


    private void setClassifier(Classifier classifier, int i){
        getClassifierList().add(i, classifier);
    }


    public void setClassifier(Classifier classifier) {
        this.setClassifier(classifier, 0);
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

    private String getClassifierName(){
        return getClassifierName(0);
    }

    private String getClassifierName(int i){
        return getClassifier(i).getClass().getSimpleName();
    }


    public double getErrorPercent(){
        return getErrorPercent(0);
    };

    public abstract double getErrorPercent(int i);


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
                "Classifier: " + getClassifierName() + "\n" +
                "Error Tase: " + getErrorPercent() + " %" + "\n";
    }

    public String getClassifiersErrors(){
        String string = "";

        string += ("**********************************************************************\n");
        string += getEstimatorName() + "\n";
        string += ("**********************************************************************\n");
        for(int i = 0; i < getClassifierList().size(); i++){
            string += getClassifierName(i) + ": " + getErrorPercent(i) + "%" + "\n";
        }
        string += ("**********************************************************************\n");
        return string;
    }


    public List<Classifier> getClassifierList() {
        return classifierList;
    }

    public void setClassifierList(List<Classifier> classifierList) {
        this.classifierList = classifierList;
    }
}
