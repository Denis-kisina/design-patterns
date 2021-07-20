package patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CustomerCollection {
	List<Customer> customers = new ArrayList<>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}

	public Iterator<Customer> ageIterator() {
		return new AgeIterator<>(customers);
	}

	public Iterator<Customer> oddNumberIterator() {
		return new OddNumberIterator<>(customers);
	}
	
	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
