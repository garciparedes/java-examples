package datamining.weka.proofs;

import datamining.weka.estimation.EstimatorClassifiersSet;
import datamining.weka.estimation.cross.CrossValidation;
import datamining.weka.estimation.split.Bootstrap;
import datamining.weka.estimation.split.HoldOut;
import datamining.weka.estimation.cross.LeaveOneOut;
import datamining.weka.util.DataImport;


import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instances;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class MainEstimationTest {

    private static final String IONOSPHERE_FILEPATH = "./dataset/ionosphere.arff";


    public static void main(String[] args) {

        try {
            Instances instances = DataImport.getInstancesFromARFF(IONOSPHERE_FILEPATH);
            instances.setClassIndex(instances.numAttributes() - 1);

            /*
            LibSVM svm = new LibSVM();
            svm.setOptions(Utils.splitOptions("-k 0"));
            */


            EstimatorClassifiersSet holdOutSet =
                    new EstimatorClassifiersSet(new HoldOut(instances, 0.66),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(holdOutSet.getClassifiersErrors());


            EstimatorClassifiersSet crossValidationSet =
                    new EstimatorClassifiersSet(new CrossValidation(instances, 10),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(crossValidationSet.getClassifiersErrors());


            EstimatorClassifiersSet leaveOneOutSet =
                    new EstimatorClassifiersSet(new LeaveOneOut(instances),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(leaveOneOutSet.getClassifiersErrors());


            EstimatorClassifiersSet bootstrapSet =
                    new EstimatorClassifiersSet(new Bootstrap(instances),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(bootstrapSet.getClassifiersErrors());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

