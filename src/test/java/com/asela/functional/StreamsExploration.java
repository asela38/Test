package com.asela.functional;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamsExploration {

	@Test
	public void test1() throws Exception {
		Stream.of(1, 2, 3, 4, 5, 7).skip(2).forEach(System.out::println);
	}

	@Test
	public void testCount() throws Exception {
		long count = Stream.of(1, 2, 3, 4, 5, 6, 7, 3, 4, 6).skip(7).limit(5).count();
		System.out.println(count);
	}

	@Test
	public void testMap() throws Exception {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).map(i -> i * i).forEach(System.out::println);
	}

	@Test
	public void testMapSqrt() throws Exception {
		double sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.mapToDouble(i -> i + 0.5D)
				.peek(value -> System.out.println("Step1: " + value))
				.map(i -> i + 2)
				.peek(value -> System.out.println("Step2: " + value))
				.sum();
		System.out.printf("%nSum %s%n", sum);

	}

	@Test
	public void testMapSqrt2() throws Exception {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.mapToDouble(i -> i + 0.5D)
				.peek(value -> System.out.println("Step1: " + value))
				.map(i -> i + 2)
				.peek(value -> System.out.println("Step2: " + value));
		// .sum();

		// Binding Operations: map, peek , filter, mapToInt, flatMap,
		// Termination Operation : collect, foreach, reduce ( count, sum, average, mean)
	}

	@Test
	public void testCollect() throws Exception {
		List<String> list = Arrays.stream(new String[] { "AA", "AB", "AC", "AA" })
				.collect(Collectors.toList());

		System.out.println(list);
	}

	@Test
	public void testCollectToSet() throws Exception {
		Set<String> list = Arrays.stream(new String[] { "AA", "AB", "AC", "AA" })
				.collect(Collectors.toSet());

		System.out.println(list);
	}

	@Test
	public void testCollectToMap() throws Exception {
		Map<Integer, String> map = Arrays.stream(new String[] { "AAA", "AB", "A" })
				.collect(Collectors.toMap(String::length, Function.identity()));

		System.out.println(map);
	}

	@Test
	public void testCollectToMapWithDuplicates() throws Exception {
		Map<Integer, String> map = Arrays.stream(new String[] { "AAA", "AB", "A", "B", "C" })
				.collect(Collectors.toMap(String::length, Function.identity(), (a, b) -> a));

		System.out.println(map);
	}

	@Test
	public void testCollectToMapOfList() throws Exception {
		Map<Integer, List<String>> map = Arrays.stream(new String[] { "AAA", "AB", "A", "B", "C" })
				.collect(Collectors.groupingBy(String::length, Collectors.toList()));

		System.out.println(map);
	}

	@Test
	public void findOddEven() throws Exception {
		int i = 12;
		if (i % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
		// i % 2 == 0 ? "Even" : "Odd";

	}

	@Test
	public void findOddEven2() throws Exception {
		int i = 121;

		System.out.println(new String[] { "Even", "Odd" }[i % 2]);
	}

	@Test
	public void findPartition() throws Exception {
		Map<Boolean, List<String>> map = Arrays.stream(new String[] { "AAA", "AB", "A", "B", "C" })
				.collect(Collectors.partitioningBy(s -> s.length() == 1));

		System.out.println(map.get(Boolean.TRUE));
		System.out.println(map.get(Boolean.FALSE));
	}

	@Test
	public void readFile() throws Exception {
		Files.readAllLines(new File("//").toPath()).stream().map(s -> s.contains("<NULL>"))
				.collect(Collectors.toList());
	}

	@Test
	public void streamOfRandom() throws Exception {
		int[] randoms = ThreadLocalRandom.current().ints(0, 30).limit(20).toArray();

		System.out.println(Arrays.toString(randoms));

	}

	private class Customer {
		int id;
		String name;

		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + "]";
		}

	}

	@Test
	public void streamOfRandomCustomers() throws Exception {
		List<Customer> customers = ThreadLocalRandom.current().ints(0, 30).limit(20).mapToObj(i -> {
			Customer customer = new Customer();
			customer.id = i;
			customer.name = "name " + i;
			return customer;
		}).collect(Collectors.toList());

		System.out.println(customers);
	}

}