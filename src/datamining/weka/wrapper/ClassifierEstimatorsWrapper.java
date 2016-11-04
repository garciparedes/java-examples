package datamining.weka.wrapper;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Classifier;

import java.util.Arrays;
import java.util.List;

/**
 * Created by garciparedes on 04/11/2016.
 */
public class ClassifierEstimatorsWrapper {

    private Classifier classifier;
    private List<AbstractEstimator> estimators;

    public ClassifierEstimatorsWrapper(Classifier classifier,
                                       AbstractEstimator... estimators){
        this.classifier = classifier;
        this.estimators = Arrays.asList(estimators);
    }



    private Classifier getClassifier() {
        return classifier;
    }



    private List<AbstractEstimator> getEstimators() {
        return estimators;
    }



    public String getEstimatorsErrors(){
        String string = "";

        string += ("**********************************************************************\n");
        string += getClassifier().getClass().getSimpleName() + "\n";
        string += ("**********************************************************************\n");
        for(AbstractEstimator estimator: getEstimators()){
            estimator.setClassifier(getClassifier());
            string += estimator.getEstimatorEstimationResults();
        }
        string += ("**********************************************************************\n");
        return string;
    }
}
