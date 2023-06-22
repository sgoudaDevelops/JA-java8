package com.softtek;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Programs {

	List<Integer> l1 = List.of(1, 2, 3, 4, 6, 7, 7, 4, 12, 10);
	List<String> names = List.of("bham", "sham", "aru", "sitapati", "aru");
	 String str = "shivanagoud";
	Integer arr[][] = { { 1, 2 }, { 2, 3, 4 }, { 7, 8, 9 } };
  int arr1[]= {7,8,9,6,67,56};
  
  public  static  void  test()
  {
	  Programs p1= new Programs();  
	  System.out.println(p1.arr1);
  }

	public void MinAndMax() { // way1
		Integer min = l1.stream().sorted().min(Comparator.comparing(v -> v)).get();
		Integer max = l1.stream().sorted().max(Comparator.comparing(x -> x)).get();
		System.out.println(min);
		System.out.println(max);
		// way2
		Integer min2 = l1.stream().mapToInt(v -> v).min().getAsInt();
		Integer max2 = l1.stream().mapToInt(m -> m).max().getAsInt();
		System.out.println(max2);
		// way3
		Integer min3 = l1.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(min3);
		Integer max3 = l1.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(max3);
		
		Optional<Integer> min4 = Arrays.stream(arr).flatMap(v->Arrays.stream(v)).min(Integer::compareTo);
		System.out.println(min4.get());
		
       OptionalInt min5 = Arrays.stream(arr1).min();
       System.out.println(min5.getAsInt());
       
		
	
	}

	public void GrenullaterThan3() {
		long count = names.stream().filter(v -> v.length() > 3).count();
		System.out.println(count);
	}

	public void Multipy3() {
		List<Integer> collect = l1.stream().map(x -> x * 3).collect(Collectors.toList());
		collect.forEach(x -> System.out.println(x));
	}

	public void rmDuplicate() {
		List<Integer> list1 = l1.stream().distinct().toList();
		TreeSet h1= new TreeSet();
		l1.stream().map(h->h1.add(h)).collect(Collectors.toSet());
		System.out.println(h1 +"using set");
		List<String> list2 = names.stream().distinct().toList();
		Set<String> collect = names.stream().collect(Collectors.toSet());
		System.out.println(collect+"without filter");
	
		System.out.println(list1);
		System.out.println(list2);
	}

	public void lastOfStream() {
		List<Integer> collect = l1.stream().skip(l1.size() - 1).collect(Collectors.toList());
		List<String> collect1 = names.stream().skip(l1.size() - 1).collect(Collectors.toList());
		   Integer int1 = l1.stream().reduce((z,b)->b).orElse(null);
		System.out.println(collect);
		System.out.println(collect1);
		System.out.println(int1);
	}

	public void countCharInString() {
		long count = str.toLowerCase().chars().mapToObj(s -> (char) s).filter(x -> x == 'a').count();
		System.out.println(count);
	}

	// important
	public void countDistinctChar() {
		Map<Character, Long> collect = str.toLowerCase().chars().mapToObj(s -> (char) s)
				.collect(Collectors.groupingBy(Function.identity(), // Collectors.counting())
						Collectors.mapping(s -> s, Collectors.counting())));
		System.out.println(collect);
	}

	public void flatten() {
		List<Integer> collect = Arrays.stream(arr).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
		System.out.println(collect);
	}

	public void intStreamToString() {
	
		
		IntStream of = IntStream.of(97, 98);
		
						String collect = of.mapToObj(s-> (char) s).map(c->c.toString()).collect(Collectors.joining());
						System.out.println(collect);
						
						
		Number []a= {2,3,6,7};
		
	 int a1[]= {1,2,3};
	  OptionalDouble min = Arrays.stream(a).mapToDouble(v->v.longValue()).min();
	//  Arrays.stream(a).mapToDouble(v-v.lo) min(Integer::compareTo);
	
		System.out.println("min"+ min);
		
//		String string = of.collect(StringBuilder::new,
//				StringBuilder::appendCodePoint,
//				StringBuilder::append)
//				.toString();
//		System.out.println(string);
	}

	public void multifilter() {
		double asDouble = l1.stream().map(x -> x * 2).filter(x -> x < 100).mapToDouble(x -> x).average().getAsDouble();
		System.out.println(asDouble);
	}
	
	public void NumStartWith1()
	{
		List<String> list = l1.stream().map(s->s+"").filter(x->x.startsWith("1")).toList();
		System.out.println(list);
	}
	public void numEndsWith2() {
		List<String> list = l1.stream().map(x->x+"").filter(v->v.endsWith("2")).toList();
		System.out.println(list);
	}
	
//	public void primeNumber()
//	{
//		int [] a= {1,2,4,7};
//	      Arrays.stream(a).map(v->v).filter(v-> )
//	}
	
	

	
}
