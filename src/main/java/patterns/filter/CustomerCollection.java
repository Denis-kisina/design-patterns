package patterns.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

class CustomerCollection {
	List<Customer> customers = new ArrayList<>();

	public void add(Customer customer) {
		customers.add(customer);
	}

	public Iterator<Customer> filterIterator(Predicate<Customer> predicate) {
		return new FilterIterator<>(customers, predicate);
	}

	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
