package org.bigdata.mr;


import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class MOReducer extends Reducer<Text, Text, NullWritable, Text> {

	private MultipleOutputs<NullWritable, Text> mos;

	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		mos = new MultipleOutputs<NullWritable, Text>(context);
	}

	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

	
		String outputValue = "";
		for (Text value : values) {
			System.out.println("value " + value);
			outputValue += value;
			outputValue += "\n";
		}
	//	System.out.println("outputValue  " + outputValue);
	//	outputValue += "\n";
        //outputValue.substring(0, outputValue.lastIndexOf('|'));
		// 2.assign sum to the corresponding word
		// context.write(key, new LongWritable(sum));
            //System.out.println("o/p : " + outputValue);
		
		 //  String countryStatusKey = key + "\n";
		
			//mos.write("EVEN", key, new LongWritable(sum));
			//mos.write("INDIA", countryStatusKey, new Text(outputValue));
			
			//String baseOutputPath = countryStatusKey.replace("|", "_");
		   
		//   String baseOutputPath = countryStatusKey;
			
			System.out.println("countryStatusKey " + key.toString());
			
		//	System.out.println("baseOutputPath " + baseOutputPath);
			
			
			mos.write(NullWritable.get(), new Text(outputValue), key.toString());
	
		
			//mos.write("ODD", key, new LongWritable(sum));
		
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
		mos.close();
	}
}










