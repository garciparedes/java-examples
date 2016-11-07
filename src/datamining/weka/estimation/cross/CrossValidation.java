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
    public double getErrorPercent(int i) {
        try {
            Evaluation eval = new Evaluation(getInstances());

            eval.crossValidateModel(getClassifier(i), getInstances(),
                    getFolds(), new Random()
            );

            return eval.pctIncorrect();
        } catch (Exception e) {
            e.printStackTrace();
            return 100;
        }
    }
}
