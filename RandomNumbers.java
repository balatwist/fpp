
import java.util.*;

/**
 *  This class keeps hold of an instance of Random and guarantees
 *  that the same instance will be used over and over (so the cost
 *  of re-seeding the random number generator is avoided).
 *  Each time the getRandomInt() method is called, the next integer
 *  from this Random instance is returned.
 */
public class RandomNumbers {

    static Random random;

    private RandomNumbers() {
        random = new Random();
    }


    /**
     *  Use this method to get a random integer, with a call like this:
     *     int myInt = RandomNumbers.getRandomInt();
     */
    public static int getRandomInt() {
        if(random == null) new RandomNumbers();
        return random.nextInt();
    }
    /**
     * Returns a random integer x satisfyingnnj
     * lower <= x <= upper. If lower > upper, returns 0.
     * @param lower
     * @param upper
     * @return
     */
    public static int getRandomInt(int lower, int upper) {
        if(lower > upper) return 0;
        if(lower == upper) return lower;
        int difference = upper - lower;
        int start = getRandomInt();

        //nonneg int in the range 0..difference - 1
        start = Math.abs(start) % (difference+1);

        start += lower;
        return start;
    }

    public static void main(String[] args){
        Random r = new Random();
        System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
        r = new Random();
        System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
        r = new Random();
        System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
        r = new Random();
        System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());

        System.out.println("X Random Number : " + Math.random());

        RandomNumbers rn = new RandomNumbers();
        System.out.println(rn.getRandomInt(100, 500));

        int randomNumber = getRandomInt(0,2_000_000_000);

        if (randomNumber <= Byte.MAX_VALUE) {
            System.out.println("Preferred data type: byte");
        } else if (randomNumber <= Short.MAX_VALUE) {
            System.out.println("Preferred data type: short");
        } else if (randomNumber <= Integer.MAX_VALUE) {
            System.out.println("Preferred data type: int");
        } else {
            System.out.println("Preferred data type: long");
        }


        }


    }



