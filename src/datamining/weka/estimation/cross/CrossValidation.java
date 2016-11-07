package datamining.weka.estimation.cross;

import datamining.weka.estimation.AbstractEstimator;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;

import java.util.Random;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class CrossValidation extends AbstractEstimator {



    private final int folds;



    public CrossValidation(Instances instances, int folds) {
        super(instances);
        this.folds = folds;
    }

    public CrossValidation(Instances instances, int folds, Classifier... classifiers) {
        super(instances, classifiers);
        this.folds = folds;
    }

    private int getFolds() {
        return folds;
    }


    @Override
    public String getEstimatorName() {
        return super.getEstimatorName() + ": " + getFolds() + " folds";
    }

    @Override
    protected Evaluation getEvaluation(int i) {
        try {
            Evaluation eval = new Evaluation(getInstances());

            eval.crossValidateModel(getClassifier(i), getInstances(),
                    getFolds(), new Random()
            );

            return eval;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
