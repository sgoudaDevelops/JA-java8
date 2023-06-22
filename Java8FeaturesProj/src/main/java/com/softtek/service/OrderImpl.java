package com.softtek.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Customer;
import com.softtek.entity.Order;
import com.softtek.entity.Product;
import com.softtek.repo.CustomerRepo;
import com.softtek.repo.OrderRepo;
import com.softtek.repo.ProductRepo;

@Service
public class OrderImpl implements OrderService {
	@Autowired
	private OrderRepo Orepo;
	@Autowired
	private ProductRepo Prepo;

	@Autowired
	private CustomerRepo Crepo;

	@Override
	public String insertOrder(Order order) {
		List<Product> Plist = order.getProduct();

		Optional<Customer> Id = Crepo.findById(order.getCust().getCid());

		if (Id.isPresent()) {

			order.setCust(Id.get());

			order.setDeliverDate(LocalDate.now().plusDays(2));

			order.setOrderDate(LocalDate.now());

			List<Product> listOfProducts = new ArrayList<Product>();
			// System.out.println(Plist);
			Plist.forEach(i -> listOfProducts.add(Prepo.findById(i.getPid()).get()));
			// System.out.println(Prepo.findById(1l));
			order.setProduct(listOfProducts);

			order.setStatus("OK");

			Orepo.save(order);

			return "Inserted succesfully";

		}

		return "Not inserted";
	}

	@Override
	public List<Product> Excercise1() {
		List<Product> filterdBooks = Prepo.findAll().stream()
				.filter(a -> a.getProductCategory().equalsIgnoreCase("book") && a.getPrice() > 100).toList();
		return filterdBooks;
	}

	@Override
	public List<Order> Excercise2() {
		List<Order> collect4 = Orepo.findAll().stream()
				.filter(order -> order.getProduct().stream()
						.anyMatch(product -> product.getProductCategory().equalsIgnoreCase("Baby")))
				.collect(Collectors.toList());
		return collect4;
	}

	@Override
	public List<Product> Excercise3() {

		List<Product> collect2 = Prepo.findAll().stream().filter(l -> l.getProductCategory().equalsIgnoreCase("toy"))
				.map(p -> {
					p.setPrice(p.getPrice() - (p.getPrice() * 0.10));
					return p;
				}).collect(Collectors.toList());
		return collect2;
		// collect2.forEach(p -> System.out.println(p.toString()));
	}

	@Override
	public List<Product> Excercise4() {
		List<Product> list = Orepo.findAll().stream()
				.filter(s -> s.getCust().getTier() == 2 && s.getOrderDate().isAfter(LocalDate.of(2023, 02, 01))
						&& s.getOrderDate().isBefore(LocalDate.of(2023, 04, 10)))
				.flatMap(v -> v.getProduct().stream()).map(m -> m).collect(Collectors.toList());
		return list;
	}

	@Override
	public Product Excercise5() {
		Optional<Product> min = Prepo.findAll().stream().filter(s -> s.getProductCategory().equalsIgnoreCase("book"))
				.min(Comparator.comparing(Product::getPrice));
		return min.get();
	}

	@Override
	public List<Order> Excercise6() {
		List<Order> collect = Orepo.findAll().stream().sorted(Comparator.comparing(Order::getOrderDate).reversed())
				.limit(3).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<Product> Excercise7() {
		List<Product> collect = Orepo.findAll().stream().filter(v -> v.getOrderDate().equals(LocalDate.of(2023, 4, 7)))
				.peek(a -> System.out.println(a.toString())).flatMap(a -> a.getProduct().stream())
				.collect(Collectors.toList());
		return null;
	}

	@Override
	public double Excercise8() {
		double sum = Orepo.findAll().stream().filter(n->n.getOrderDate().compareTo(LocalDate.of(2023, 04, 1))>=0)
		.filter(m->m.getOrderDate().compareTo(LocalDate.of(2023, 04, 31))<0)
		.flatMap(o->o.getProduct().stream()).mapToDouble(x->x.getPrice()).sum();
		return sum;
	}

	@Override
	public double Excercise9() {
		double sum = Orepo.findAll().stream().filter(x->x.getOrderDate().isEqual(LocalDate.of(2023, 04, 07)))
		.flatMap(x->x.getProduct().stream()).mapToDouble(v->v.getPrice()).sum();
		return sum;
	}

	@Override
	public Map<String,String> Excercise10() {
		 DoubleSummaryStatistics summaryStatistics = Prepo.findAll().stream().filter(x->x.getProductCategory().equalsIgnoreCase("book"))
		.mapToDouble(x->x.getPrice()).summaryStatistics();
		 Map m1 = new HashMap<String, String>();
		 m1.put("sum", summaryStatistics.getSum());
		 m1.put("avg", summaryStatistics.getAverage());
		 m1.put("max", summaryStatistics.getMax());
		 m1.put("min", summaryStatistics.getMin());
		 m1.put("count",summaryStatistics.getCount());
		return m1;
	}

	@Override
	public Map<Long, Integer> Excercise11() {
		Map<Long, Integer> collect = Orepo.findAll().stream()
		.collect(Collectors
				.toMap(o->o.getId(), o->o.getProduct().size()));
		return collect;
	}

	@Override
	public Map<Customer, List<Order>> Excercise12() {
		Map<Customer, List<Order>> collect = Orepo.findAll().stream().collect(Collectors.groupingBy(Order::getCust));
		return collect;
	}

	@Override
	public Map<Customer, List<Order>> Excercise13() {
		Map<Order, Double> collect = Orepo
				.findAll()
				.stream()
				.collect(Collectors.toMap(v->v, n->n.getProduct()
				.stream()
				.mapToDouble(v->v.getPrice()).sum()));
		return null;
	}

	@Override
	public Map<String, List<String>> Excercise14() {
        Map<String, List<String>> collect = Prepo.findAll().stream()
        		.collect(Collectors.groupingBy(Product::getProductCategory,
        		Collectors.mapping(v->v.getProductname(), Collectors.toList())
        		));
		return collect;  
	}

	@Override
	public Map<String, Optional<Product>> Excercise15() {
		 Map<String, Optional<Product>> collect = Prepo.findAll().stream()
		 .collect(
				 Collectors.groupingBy(Product::getProductCategory,
				 Collectors.maxBy(Comparator.comparing(Product::getPrice)))
				 );
		return collect;
	}
	


	

}
