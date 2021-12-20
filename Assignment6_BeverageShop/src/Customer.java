
public class Customer {
	
	private String name;
	private int age;
	

	public Customer(String name, int age) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setAge(age);
	}
	
	public Customer(Customer obj) {
		this.setName(obj.getName());
		this.setAge(obj.getAge());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + "," + age;
	}
	
	public boolean equals(Customer obj) {
		if (this.name.equals(obj.getName())) {
			return true;
		}
		return false;
	}
}
