package com.googlecode.gwtstreamer.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.googlecode.gwtstreamer.test.client.shared.Benchmark;

public class ClientBenchmark  extends GWTTestCase {
	@Override
	public String getModuleName() {
		return "com.googlecode.gwtstreamer.test.GWTStreamerJUnit";
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// warm up VM
		Benchmark bench = new Benchmark( 5 );
		bench.serializeBenchmark();
		bench.deserializeBenchmark();
	}
	
	private void log( String s ) {
		GWT.log( s );
	}
	
	/**
	 * Simple serialization serialization
	 */
	public void testTask()
	{
		log( "Preparing test..." );
		Benchmark bench = new Benchmark( 10 );
		log( "    Tree depth: "+bench.getTreeDepth() );
		log( "    Node count: "+bench.getTreeCreator().getNodeCount() );
		log( "Executing serialization..." );
		long t = bench.serializeBenchmark();
		log( "Serialization time: "+t );
		log( "    Buffer length: "+bench.getBuffer().length() );
		log( "Executing deserialization..." );
		t = bench.deserializeBenchmark();
		log( "Deserialization time: "+t );
	}
}
