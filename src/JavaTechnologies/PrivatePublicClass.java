package JavaTechnologies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PrivatePublicClass {
	// class array list
	private static ArrayList <Body> personList = new ArrayList<>();
	private static ArrayList <Object> objectList = new ArrayList<>();
	private static ArrayList <Object> regexLst = new ArrayList<>();
	private static Map <String, Integer> uniqueSet = new HashMap<>();
	
	public static void main (String [] args) throws Exception {
		
		//StartTestOne();
		//StartTestTwo();
		StartHadoopCycle("hello world, the girl is very zealous. "
				+ "the jealous cat had all the cheese. "
				+ "now, think about New Zealand and the "
				+ "town near the zoo. "
				+ "the cat and the hat was a great book.");
		
	}

	// print method
	static void Print(Object obj) {
		System.out.println(obj);
	}
	
	static void StartHadoopCycle (String strTest) {
		// local variable
		String hadoopCycle = strTest;
		// regex types
		String regexForZ = "\\b[Z|z]\\w*\\b";
		String regexForSingleton = "";
		String regexForStopWordPair = "\\b[the]\\s*\\w*";
		
		// loop through string
		for (String word: hadoopCycle.replaceAll("[^\\w\\s]", " ").split("\\s+")) {
			regexLst.add(word);
			
			if (!uniqueSet.containsKey(word)) {
				uniqueSet.put(word, 1);
			} else {
				uniqueSet.put(word, uniqueSet.get(word)+1);
			}
		}
		
		int iteration=0;
		while (iteration < regexLst.size()) {
			String ob = regexLst.get(iteration).toString();
			// find match
			if (ob.matches(regexForZ)) {
				//regexLst.add("Z or z match: "+t);
				//Print(ob);
			}
			if (ob.equals("the")) {
				//regexLst.add("Singleton match: "+t);
				//Print(ob +" "+ regexLst.get(iteration+1));
			}
			iteration++;
		}
		
		// unique set
		for (String name: uniqueSet.keySet()) {
			Print(name +":"+uniqueSet.get(name).toString());
		}
	}
	
	// test 1
	static void StartTestOne() {
		// fizz buzz
		for (int i=1; i<=50; ++i) {
			if (i%5==0 && i%9==0) {
				Print("Fizz Buzz");
			} else if (i%5==0) {
				Print("Fizz");
			} else if (i%9==0) {
				Print("Buzz");
			} else {
				Print(i);
			}
		}
		
	}
	
	// test 2
	static void StartTestTwo() throws Exception {
		// instance
		Person p1;
		Person p2;
		Person p3;
		Person p4 = new Person();
		
		// create instance
		p1 = new Person("Name");
		p2 = new Employee("Name", 1);
		p3 = new Programmer("Name1", 1, "Java");
		p4 = new Programmer("Name2", 2, "C#");
				
		//# access with instance
		Print(p1.toString());
		Print(p2.toString());
		Print(p3.toString());
				
		//# access with cast
		Print(((Programmer)p4).toString());
				
		// add to generic list
		objectList.add(1);
		objectList.add("Hello");
		objectList.add(p1);
		
		// access with list
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
				
		Print("Are these Equal: "+p3.equals(p4));
				
		// body class and subclass list
		for (Body pi: personList) {
			Print(pi);
		}
				
		// generic object list
		for (Object obj: objectList) {
			Print(obj);
		}
				
		Print("\n----\n");
				
		// static
		StaticClass.setName("StaticName");
		Print(StaticClass.getName());
		Print("Pi is equal to: "+StaticClass.PI);
				
		//@SuppressWarnings("all")
		StaticClass c1 = new StaticClass();
		StaticClass c2 = new StaticClass();
		c1.setName("instance_of_static");
		c2.setName("New_example");
				
				
		// BAD EXAMPLE, how NOT to use
		ArrayList<StaticClass> pc = new ArrayList<>();
		pc.add(c1);
		pc.add(c2);
				
		Object temp;
		for (StaticClass ci: pc) {
			Print(ci.getName());
		}
				
		Print("\n----\n");
				
		// static reference
		Something.doSomething();
				
		// non-static reference
		Something something = new Something();
		something.setNumber(2);
		something.setBalance(0.1);
		something.doSomethingElse();
	}
	
}

class Something {
	// static methods must reference static variables
	public static final int ONE = 1;
	public static double balance;
	
	// instance variable must have get/set
	private int number;
	
	public static void doSomething() throws Exception {
		System.out.println(ONE);
		System.out.println(balance);
	}
	
	void doSomethingElse() throws Exception {
		// number will have a new reference
		System.out.println(number);
		// balance will have the same reference
		System.out.println(balance);
	}
	void setNumber(int number) {
		this.number = number;
	}
	int getNumber () {
		return this.number;
	}
	void setBalance(double d) {
		balance = d;
	}
}


abstract class Body {
	public abstract String toString();
}

class Word extends Body {
	private String word = null;
	private Integer count = 0;
	Word () {/*default*/}
	Word (String word){this.word = word; this.count++;}
	Word (String word, Integer count){
		this.word=word; this.count = this.count + count;
	}
	void setWord(String word) {
		this.word=word;
	}
	String getWord() {
		return this.word;
	}
	void setCount (int count) {
		this.count = this.count + count;
	}
	Integer getCount() {
		return this.count;
	}
	@Override
	public String toString() {
		return ""+this.getWord()+":"+this.getCount()+".";
	}
}

class Person extends Body {
	private String name;
	Person () {}
	Person (String name) {
		this.setName(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Person: "+this.getName();
	}
}

class Employee extends Person {
	private int number;
	Employee(){}
	Employee(String name, int number){
		super(name);
		this.setNumber(number);
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return this.number;
	}
	@Override
	public String toString() {
		return "Employee: "+this.getName()+" "+this.getNumber();
	}
}

class Programmer extends Employee {
	private String code;
	
	Programmer () {/*default*/}
	// constructor for object 
	Programmer (String code) { 
		this.setCode(code); 
	}
	// constructor for superclass
	Programmer (String name, int number, String code) {
		// references superclass
		super (name, number);
		this.setCode (code);
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	public String getCode () {
		return this.code;
	}
	
	@Override // to string, overrides java method
	public String toString () {
		return "Programmer: "+this.getName()+" "+this.getNumber()+" "+this.getCode();
	}

	@Override // check equality, overrides java method
	public boolean equals (Object obj) {
		// this references instance, object references method parameter
		return this == obj;
	}
}


class StaticClass {
	private static String name;
	public static final float PI = (float) 3.1416;
	StaticClass() {}
	static String getName () {
		return name;
	}
	static void setName (String n) {
		name = n;
	}
}