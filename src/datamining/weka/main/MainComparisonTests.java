package datamining.weka.main;

import datamining.weka.estimation.AbstractEstimator;
import datamining.weka.estimation.cross.CrossValidation;
import datamining.weka.estimation.split.HoldOut;
import datamining.weka.util.DataImport;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instances;

/**
 * Created by garciparedes on 07/11/2016.
 */
public class MainComparisonTests {

    private static final String IONOSPHERE_FILEPATH = "./dataset/ionosphere.arff";

    public static void main(String[] args) throws Exception {

        Instances instances = DataImport.getInstancesFromARFF(IONOSPHERE_FILEPATH);
        instances.setClassIndex(instances.numAttributes() - 1);


        AbstractEstimator holdOutSet =
                new HoldOut(instances, 0.66,
                        new J48(), new NaiveBayes());
        System.out.println(holdOutSet.getClassifiersErrors());

        /*
        AbstractEstimator crossValidationSet =
                new CrossValidation(instances, 10,
                        new J48(), new NaiveBayes());
        System.out.println(crossValidationSet.getClassifiersErrors());
        */
    }
}
