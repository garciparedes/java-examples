package datamining.weka.wrapper;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Classifier;

import java.util.Arrays;
import java.util.List;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class EstimatorClassifiersWrapper {



    private AbstractEstimator estimator;
    private List<Classifier> classifiers;

    public EstimatorClassifiersWrapper(AbstractEstimator estimator,
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
        string += getEstimator().getEstimatorName() + "\n";
        string += ("**********************************************************************\n");
        for(Classifier classifier: getClassifiers()){
            getEstimator().setClassifier(classifier);
            string += getEstimator().getClassifierEstimationResults();
        }
        string += ("**********************************************************************\n");
        return string;
    }
}
