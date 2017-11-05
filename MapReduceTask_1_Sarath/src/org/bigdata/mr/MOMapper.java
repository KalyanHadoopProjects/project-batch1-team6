package org.bigdata.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MOMapper extends
		Mapper<LongWritable, Text, Text, Text> {
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		// 1.read the line
		String line = value.toString();

		// 2.split the line into tokens
		String[] tokens = line.split("\\|");
		
		String countryStatusKey = tokens[2] + "/" + tokens[3];

	
			System.out.println(countryStatusKey + " \n Value: " + value.toString());
			context.write(new Text(countryStatusKey), value);


	}
}

