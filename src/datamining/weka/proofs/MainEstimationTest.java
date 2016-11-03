package datamining.weka.proofs;

import datamining.weka.util.DataImport;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class MainEstimationTest {

    private static final String IONOSPHERE_FILEPATH = "./dataset/ionosphere.arff";


    public static void main(String[] args) {

        try {
            Instances instances = DataImport.getInstancesFromARFF(IONOSPHERE_FILEPATH);

            J48 j48 = new J48();
            NaiveBayes naiveBayes = new NaiveBayes();
            IBk iBk3 = new IBk(3);
            LibSVM svm = new LibSVM();

            /*
            Normalize normalize = new Normalize();
            normalize.setInputFormat(instances);
            instances = Filter.useFilter(instances, normalize);
            */
            
            instances.setClassIndex(instances.numAttributes() - 1);


            System.out.println(instances.toSummaryString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

