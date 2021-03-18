
// Static Variable Rules

// In this example, we have created an instance variable named count
// which is incremented in the constructor. Each variable will have
//  its own copy of the instance variable. So each object will have
// the value 1 in the count variable


public class Counter
{  
    int count = 0; // If static varibale then will get 1, 2 ,3 if non- static will get 1,1,1

    Counter()
    {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args)
    {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
    }
} 