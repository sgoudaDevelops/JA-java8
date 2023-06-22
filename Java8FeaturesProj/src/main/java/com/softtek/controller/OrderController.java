package com.softtek.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.entity.Customer;
import com.softtek.entity.Order;
import com.softtek.entity.Product;
import com.softtek.service.OrderImpl;
import com.softtek.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public ResponseEntity<?> Home() {
		return new ResponseEntity<String>("welcome java 8", HttpStatus.OK);
	}

	@PostMapping("/createOrder")
	public ResponseEntity<?> CreateOrder(@RequestBody Order order) {
		try {
			String body = orderService.insertOrder(order);
			return new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise1")
	public ResponseEntity<?> FilterBooks() {
		try {
			List<Product> body = orderService.Excercise1();
			return new ResponseEntity<List<Product>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise2")
	public ResponseEntity<?> BabycategoryOrders() {
		try {
			List<Order> body = orderService.Excercise2();
			return new ResponseEntity<List<Order>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise3")
	public ResponseEntity<?> ToysDiscount() {
		try {
			List<Product> body = orderService.Excercise3();
			return new ResponseEntity<List<Product>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise4")
	public ResponseEntity<?> PeriodAndTier() {
		try {
			List<Product> body = orderService.Excercise4();
			return new ResponseEntity<List<Product>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise5")
	public ResponseEntity<?> chepeastBook() {
		try {
			Product body = orderService.Excercise5();
			return new ResponseEntity<Product>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise6")
	public ResponseEntity<?> MostrecentOrders() {
		try {
			List<Order> body = orderService.Excercise6();
			return new ResponseEntity<List<Order>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise7")
	public ResponseEntity<?> OrdersOnSpecificDate() {
		try {
			List<Product> body = orderService.Excercise7();
			return new ResponseEntity<List<Product>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise8")
	public ResponseEntity<?> PriceSum() {
		try {
			double body = orderService.Excercise8();
			return new ResponseEntity<Double>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise9")
	public ResponseEntity<?> avgPayment() {
		try {
			double body = orderService.Excercise9();
			return new ResponseEntity<Double>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise10")
	public ResponseEntity<?> Stats() {
		try {
			Map<String, String> body = orderService.Excercise10();
			return new ResponseEntity<Map<String, String>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise11")
	public ResponseEntity<?> datamapOid_ProductCount() {
		try {
			Map<Long, Integer> body = orderService.Excercise11();
			return new ResponseEntity<Map<Long, Integer>>(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise12")
	public ResponseEntity<?> OrderGroupedByCutomer() {
		try {
			Map<Customer, List<Order>> body = orderService.Excercise12();
			return new ResponseEntity(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise13")
	public ResponseEntity<?> OrderToTotalPrice() {
		try {
			Map<Customer, List<Order>> body = orderService.Excercise13();
			return new ResponseEntity(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Employee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise14")
	public ResponseEntity<?> ByCategoryListOfProductName() {
		try {
			Map<String, List<String>> body = orderService.Excercise14();
			return new ResponseEntity(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Eployee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Excerise15")
	public ResponseEntity<?> expProductByCategory() {
		try {
			Map<String, Optional<Product>> body = orderService.Excercise15();
			return new ResponseEntity(body, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Eployee Pension details... Try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
