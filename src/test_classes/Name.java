package test_classes;

public class Name{
	
	public static void main (String [] args) {
		// Using the class above, what is the result of the follow lines of code?
		Name name1 = new Name ("John", "Doe");
		Name name2 = new Name ("Susan", "Doe");
		Name name3 = name1;
		 
		System.out.println(name1.equals(name2));
		System.out.println(name1.equals(name3));
		
		System.out.println("\n");
		
		
		for (int i=1; i<=50; i++) {
			if(i%3==0 || i%5==0) {
				if (i%3==0 && i%5==0) {
					System.out.println("FizzBuzz");
				} else {
					if (i%3==0) {
						System.out.println("Fizz");
					}
					if (i%5==0) {
						System.out.println("Buzz");
					}
				}
			}
			else {
				System.out.println(i);
			}
		}
	}
	 
    private String firstName;
    private String lastName;
 
    public Name(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }
  
    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}
  
