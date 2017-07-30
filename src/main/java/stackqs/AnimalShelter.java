package stackqs;

public class AnimalShelter implements MyQueue<Animal> {

	private MyQueue<Animal> dogs = new MyLinkedListQueue<>();
	private MyQueue<Animal> cats = new MyLinkedListQueue<>();

	public Animal dequeueDog() {
		if (dogs.isEmpty()) {
			return null;
		}
		return dogs.dequeue();
	}

	public Animal dequeueCat() {
		if (cats.isEmpty()) {
			return null;
		}
		return cats.dequeue();
	}

	public Animal dequeueAny() {
		return dequeue();
	}

	@Override
	public boolean enqueue(Animal element) {
		if (element instanceof Cat) {
			return cats.enqueue(element);
		} else {
			return dogs.enqueue(element);
		}
	}

	@Override
	public Animal dequeue() {
		if (cats.isEmpty() && dogs.isEmpty()) {
			return null;
		}
		if (cats.isEmpty()) {
			return dogs.dequeue();
		}
		if (dogs.isEmpty()) {
			return cats.dequeue();
		}
		Animal dog = dogs.head();
		Animal cat = cats.head();

		if (dog.getArrivalTime().compareTo(cat.getArrivalTime()) <= 0) {
			return dogs.dequeue();
		} else {
			return cats.dequeue();
		}
	}

	@Override
	public Animal head() {
		if (cats.isEmpty() && dogs.isEmpty()) {
			return null;
		}
		if (cats.isEmpty()) {
			return dogs.head();
		}
		if (dogs.isEmpty()) {
			return cats.head();
		}
		Animal dog = dogs.head();
		Animal cat = cats.head();

		if (dog.getArrivalTime().compareTo(cat.getArrivalTime()) <= 0) {
			return dog;
		} else {
			return cat;
		}
	}

	@Override
	public int size() {
		return dogs.size() + cats.size();
	}
}
