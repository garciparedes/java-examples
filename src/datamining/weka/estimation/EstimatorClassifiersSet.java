package datamining.weka.estimation;

import datamining.weka.estimation.split.Bootstrap;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class EstimatorClassifiersSet {



    AbstractEstimator estimator;
    List<Classifier> classifiers;

    public EstimatorClassifiersSet(AbstractEstimator estimator,
                                   Classifier... classifiers){
        this.estimator = estimator;
        this. classifiers = Arrays.asList(classifiers);
    }



    private AbstractEstimator getEstimator() {
        return estimator;
    }



    private List<Classifier> getClassifiers() {
        return classifiers;
    }



    public String getClassifiersErrors(){
        String string = "";

        string += ("**********************************************************************\n");
        for(Classifier classifier: getClassifiers()){
            getEstimator().setClassifier(classifier);
            string += getEstimator().getEstimationResults();
        }
        string += ("**********************************************************************\n");
        return string;
    }
}
