package datamining.weka.main;

import datamining.weka.wrapper.ClassifierEstimatorsWrapper;
import datamining.weka.wrapper.EstimatorClassifiersWrapper;
import datamining.weka.estimation.cross.CrossValidation;
import datamining.weka.estimation.split.Bootstrap;
import datamining.weka.estimation.split.HoldOut;
import datamining.weka.estimation.cross.LeaveOneOut;
import datamining.weka.util.DataImport;


import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Utils;

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


            EstimatorClassifiersWrapper holdOutSet =
                    new EstimatorClassifiersWrapper(new HoldOut(instances, 0.66),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(holdOutSet.getClassifiersErrors());


            EstimatorClassifiersWrapper crossValidationSet =
                    new EstimatorClassifiersWrapper(new CrossValidation(instances, 10),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(crossValidationSet.getClassifiersErrors());


            EstimatorClassifiersWrapper leaveOneOutSet =
                    new EstimatorClassifiersWrapper(new LeaveOneOut(instances),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(leaveOneOutSet.getClassifiersErrors());


            EstimatorClassifiersWrapper bootstrapSet =
                    new EstimatorClassifiersWrapper(new Bootstrap(instances),
                            new J48(), new NaiveBayes(), new IBk(3)
                    );
            System.out.println(bootstrapSet.getClassifiersErrors());



            ClassifierEstimatorsWrapper j48Set = new ClassifierEstimatorsWrapper(
                    new J48(),
                    new HoldOut(instances, 0.66),
                    new CrossValidation(instances, 10),
                    new LeaveOneOut(instances),
                    new Bootstrap(instances)
            );
            System.out.println(j48Set.getEstimatorsErrors());

            ClassifierEstimatorsWrapper naiveBayerSet = new ClassifierEstimatorsWrapper(
                    new NaiveBayes(),
                    new HoldOut(instances, 0.66),
                    new CrossValidation(instances, 10),
                    new LeaveOneOut(instances),
                    new Bootstrap(instances)
            );
            System.out.println(naiveBayerSet.getEstimatorsErrors());

            ClassifierEstimatorsWrapper ibk3Set = new ClassifierEstimatorsWrapper(
                    new IBk(3),
                    new HoldOut(instances, 0.66),
                    new CrossValidation(instances, 10),
                    new LeaveOneOut(instances),
                    new Bootstrap(instances)
            );
            System.out.println(ibk3Set.getEstimatorsErrors());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

