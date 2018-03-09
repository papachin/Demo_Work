public class ThreadDemo {
   public static void main(String args[]) {
      TestThreadDemo T1 = new TestThreadDemo( "Thread-1");
      T1.start();
     
      TestThreadDemo T2 = new TestThreadDemo( "Thread-2");
      T2.start();
      
      GuessANumber T3 = new GuessANumber(1);
      T3.start();
      
      GuessANumber T4 = new GuessANumber(2);
      T4.start();
      
      
   }  
}

class TestThreadDemo extends Thread {
   
   private String threadName;
   
   TestThreadDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
}


class GuessANumber extends Thread {
	
	   private int number;
	   
	   public GuessANumber(int number) {
	      this.number = number;
	   }
	   
	   public void run() {
	      int counter = 0;
	      int guess = 0;
	      do {
	         guess = (int) (Math.random() * 100 + 1);
	         System.out.println(this.getName() + " guesses " + guess);
	         counter++;
	      } while(guess != number);
	      System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
	   }
}