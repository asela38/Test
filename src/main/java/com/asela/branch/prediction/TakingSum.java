package com.asela.branch.prediction;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class TakingSum {

	@Test
	public void notSorted() throws Exception {
		int[] array = ThreadLocalRandom.current().ints().map(i -> i % 512).limit(10_000_000).toArray();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		IntStream.range(1, 100).forEach(x -> {
			Arrays.stream(array).filter(i -> i > 400).sum();
		});
		stopWatch.suspend();
		System.out.println(Thread.currentThread().getStackTrace()[1] + " -> " + stopWatch);
	}

	@Test
	public void sorted() throws Exception {
		int[] array = ThreadLocalRandom.current().ints().map(i -> i % 512).limit(10_000_000).sorted().toArray();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		IntStream.range(1, 100).forEach(x -> {
			Arrays.stream(array).filter(i -> i > 400).sum();
		});
		stopWatch.suspend();
		System.out.println(Thread.currentThread().getStackTrace()[1] + " -> " + stopWatch);
	}
}
