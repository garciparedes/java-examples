package weka;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.CSVLoader;

import java.util.Random;
import java.io.*;

/**
 * Created by garciparedes on 16/10/2016.
 */
public class WekaMultiLayerPerceptron {

    public static void main(String[] args) {
        try {

            String filepath = "./dataset/ojo-seco.csv";
            double percent = 66;

            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(filepath));

            Instances data = loader.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            data.randomize(new Random(0));


            int trainSize = (int) Math.round(data.numInstances() * percent / 100);
            int testSize = data.numInstances() - trainSize;

            Instances train = new Instances(data, 0, trainSize);
            Instances test = new Instances(data, trainSize, testSize);


            System.out.println(data.toSummaryString());


            MultilayerPerceptron mlp = new MultilayerPerceptron();

            //Setting Parameters
            mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a"));

            mlp.buildClassifier(train);

            System.out.println(mlp.toString());



            Evaluation eval = new Evaluation(test);
            eval.evaluateModel(mlp, test);

            System.out.println(eval.toSummaryString()); //Summary of Training


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
