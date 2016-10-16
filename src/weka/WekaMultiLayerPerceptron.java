package weka;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.*;

/**
 * Created by garciparedes on 16/10/2016.
 */
public class WekaMultiLayerPerceptron {

    public static void main(String[] args) {
        try {

            String filepath = "./dataset/ojo-seco.csv";


            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(filepath));

            Instances data = loader.getDataSet();

            data.setClassIndex(data.numAttributes() - 1);


            MultilayerPerceptron mlp = new MultilayerPerceptron();

            //Setting Parameters
            mlp.setLearningRate(0.1);
            mlp.setMomentum(0.2);
            mlp.setTrainingTime(2000);
            mlp.setHiddenLayers("3");
            mlp.buildClassifier(data);

            Evaluation eval = new Evaluation(data);
            eval.evaluateModel(mlp, data);

            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            System.out.println(eval.toSummaryString()); //Summary of Training


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
