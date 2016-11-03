package datamining.weka.util;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.File;
import java.io.IOException;

/**
 * Created by garciparedes on 03/11/2016.
 */
public class DataImport {



    public static Instances getInstancesFromCSV(String filePath) throws IOException {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(filePath));

        return loader.getDataSet();

    }


    public static Instances getInstancesFromARFF(String filePath) throws Exception {
        DataSource source = new DataSource(filePath);

        return source.getDataSet();

    }
}
