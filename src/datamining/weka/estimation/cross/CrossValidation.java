package datamining.weka.estimation.cross;

import datamining.weka.estimation.AbstractEstimator;
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



    @Override
    public double getErrorPercent() {
        try {
            Evaluation eval = new Evaluation(this.getInstances());
            eval.crossValidateModel(this.getClassifier(), this.getInstances(),this.folds, new Random());
            return eval.pctIncorrect();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
