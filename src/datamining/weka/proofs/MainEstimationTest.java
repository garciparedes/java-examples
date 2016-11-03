package datamining.weka.proofs;

import datamining.weka.estimation.HoldOut;
import datamining.weka.util.DataImport;


import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.SelectedTag;
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



            J48 j48 = new J48();

            NaiveBayes naiveBayes = new NaiveBayes();

            IBk iBk3 = new IBk(3);

            LibSVM svm = new LibSVM();
            svm.setOptions(Utils.splitOptions("-k 0"));



            HoldOut holdOut = new HoldOut(instances, 0.66);

            holdOut.setClassifier(j48);
            System.out.println(holdOut.getEstimationResults());

            holdOut.setClassifier(naiveBayes);
            System.out.println(holdOut.getEstimationResults());

            holdOut.setClassifier(iBk3);
            System.out.println(holdOut.getEstimationResults());

            holdOut.setClassifier(svm);
            System.out.println(holdOut.getEstimationResults());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

