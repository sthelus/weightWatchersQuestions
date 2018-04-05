import java.util.*;

public class Question3 {

    Question3() {

    }

    private Random rand = new Random();

    public List<Integer> getRandomNumberList() {
        return randomNumberList;
    }

    public void setRandomNumberList(List<Integer> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    private List<Integer> randomNumberList = new ArrayList<>();

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private int n = 0;


    public List<Integer> populateRandomNumberList(List<Integer> numberList) {
        //generate the 500 random numbers
        for (int i = 0; i < 500; i++) {
            int intToBeAdded = new Integer(rand.nextInt(Integer.MAX_VALUE));
            //no range was given to us in the question documentation, so we're just going to
            // use the java's entire range of whole numbers
            if (!numberList.contains(intToBeAdded)) {
                //We use random numbers, so it's technically possible to make duplicates
                //Let's filter those out. No need to override equals() here
                numberList.add(intToBeAdded);
            }
        }
        return numberList;
    }

    public void printList(List<Integer> numberList) {
        Collections.sort(numberList);
        for (int number : numberList) {
            System.out.println(number + "\n");
        }
    }

    public void printNthSmallest(List<Integer> numberList, int n) {
        Collections.sort(numberList);//sort the list before getting the nth value
        System.out.println("The " + n + "(th/st/nd/rd) smallest number is: " + numberList.get(n));
    }

    public void takeInInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("We're getting the nth smallest value. Please enter a number for n:");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            if(n==0){
                System.out.println("There is no 0th number. Please enter a nonzero value.");
                takeInInt();
            }
            if (n >= getRandomNumberList().size()+1) {
                System.out.println("That number was larger than our list. Please enter a smaller number.");
                takeInInt();
            }
            setN(n);
            scanner.close();
        } else {
            System.out.println("Sorry, that wasn't an int. Please try again");
            takeInInt();
        }
        scanner.close();
    }

    public static void main(String arg[]) {
        Question3 q3 = new Question3();
        q3.populateRandomNumberList(q3.getRandomNumberList());
        q3.printList(q3.getRandomNumberList());
        System.out.println("We've made our list of 500 random ints, please see it above.");
        q3.takeInInt();
        q3.printNthSmallest(q3.getRandomNumberList(), q3.getN()-1);
    }


}