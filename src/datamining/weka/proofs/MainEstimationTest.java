package datamining.weka.proofs;

import datamining.weka.estimation.cross.CrossValidation;
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


            System.out.println("**********************************************************************");

            HoldOut holdOut = new HoldOut(instances, 0.66);

            holdOut.setClassifier(new J48());
            System.out.println(holdOut.getEstimationResults());

            holdOut.setClassifier(new NaiveBayes());
            System.out.println(holdOut.getEstimationResults());

            holdOut.setClassifier(new IBk(3));
            System.out.println(holdOut.getEstimationResults());

            //holdOut.setClassifier(svm);
            //System.out.println(holdOut.getEstimationResults());
            System.out.println("**********************************************************************");


            CrossValidation crossValidation = new CrossValidation(instances, 10);

            crossValidation.setClassifier(new J48());
            System.out.println(crossValidation.getEstimationResults());

            crossValidation.setClassifier(new NaiveBayes());
            System.out.println(crossValidation.getEstimationResults());

            crossValidation.setClassifier(new IBk(3));
            System.out.println(crossValidation.getEstimationResults());

            //crossValidation.setClassifier(svm);
            //System.out.println(crossValidation.getEstimationResults());
            System.out.println("**********************************************************************");



            LeaveOneOut leaveOneOut = new LeaveOneOut(instances);

            leaveOneOut.setClassifier(new J48());
            System.out.println(leaveOneOut.getEstimationResults());

            leaveOneOut.setClassifier(new NaiveBayes());
            System.out.println(leaveOneOut.getEstimationResults());

            leaveOneOut.setClassifier(new IBk(3));
            System.out.println(leaveOneOut.getEstimationResults());

            //leaveOneOut.setClassifier(svm);
            //System.out.println(leaveOneOut.getEstimationResults());
            System.out.println("**********************************************************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

