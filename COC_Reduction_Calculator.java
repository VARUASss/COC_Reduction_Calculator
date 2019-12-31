/**
 * Find the time for a construction to finish when using items
 * @author Siddhartha Saurav Regmi
 *version 1.1
 */

import java.util.Scanner;



public class COC_Reduction_Calculator {

    Scanner scan = new Scanner(System.in);

    private double timeUnreadableHours;
    private int timeReadableHours;
    private double timeUnreadableDays;
    private int timeReadableDays;
    private double timeUnreadableMinutes;
    private int timeReadableMinutes;

    public double getTimeUnreadableDays(){
        return timeUnreadableDays;
    }
    public int getTimeReadableDays(){
        return timeReadableDays;
    }
    public double getTimeUnreadableHours(){
        return timeUnreadableHours;
    }
    public int getTimeReadableHours(){
        return timeReadableHours;
    }
    public double getTimeUnreadableMinutes(){
        return timeUnreadableMinutes;
    }
    public int getTimeReadableMinutes(){
        return timeReadableMinutes;
    }

    /**
     * the calculates how long it will take for a construction to finish or how long it will take after the use of builder boost
     */
    public void  construction(){
        //ask question how how long the construction is and items
    System.out.println("How long is the construction in hours? (without the reduction)");

    double trainTime = scan.nextDouble();
    System.out.println("How many items? (1-5)");
    int items = scan.nextInt();

    int timeReduction;

    double timeToFinish;
    double timeItWillTakeAfterFinishing;
    // if the construction finishes before items runs out
    if(items >= trainTime) {
        timeReduction = (int) (trainTime * 10);
        //find how many area going to be used
        items = (int) trainTime;

       double timeToFinishHour = trainTime - (trainTime - (items * trainTime / 10));

        if(timeToFinishHour < 1){
            double timeToFinishMinutes = timeToFinishHour * 60;
            System.out.println(timeToFinishMinutes + " minutes to finish");
        }
        else {
            System.out.println(timeToFinishHour + " hours to finish");
        }
    }
    //if construction does not run out before items run out
    //this will tell how long it will take after the boost runs out.
    //all the methods are the same and they essentially do the same thing
    else {

        timeItWillTakeAfterFinishing = trainTime - ((items * trainTime) / (10));
        //calculates how long it will take if its longer than 24 hours and it will also display in terms of minutes and seconds

        System.out.println("I it will take:");
        if(timeItWillTakeAfterFinishing >= 24) {
            //finds how many days
             timeUnreadableDays = timeItWillTakeAfterFinishing / 24;
             timeReadableDays = (int) timeItWillTakeAfterFinishing / 24;
            //finds how many hours
            if (timeUnreadableDays - timeReadableDays != 0) {

                 timeUnreadableHours = (timeUnreadableDays - timeReadableDays) * 60;

                 timeReadableHours = (int) (timeUnreadableHours);

                while (timeReadableHours >= 24) {
                    timeReadableDays = timeReadableDays + 1;
                    timeReadableHours = timeReadableHours - 24;
                    timeUnreadableHours = timeUnreadableHours  - 24;

                }
                //finds how how many minutes
                if (timeUnreadableHours - timeReadableHours != 0) {
                     timeUnreadableMinutes = ((timeUnreadableHours) - timeReadableHours) * 60;

                     timeReadableMinutes = (int) (timeUnreadableMinutes);

                    while (timeReadableMinutes > 60) {
                        timeReadableHours++;
                        timeReadableMinutes = timeReadableMinutes - 60;

                    }
                }
            }
            System.out.println(getTimeReadableDays() + " Days. " + getTimeReadableHours() + " Hours. " + getTimeReadableMinutes() + " Minutes.");
        }
        else {
            System.out.println(timeItWillTakeAfterFinishing + " Hours");
        }
    }
}


public void training(){
    System.out.println("Do you know your time for training?(yes/no)");
    if(scan.next().equals("Yes")){

        System.out.println("How long is it? (in hours)");
        double trainTime = scan.nextDouble();
        System.out.println("How many items? (1-5)");
        int items = scan.nextInt();

        int timeReduction = items * 4;

        double timeToFinish;
        double timeItWillTakeAfterFinishing;
        if(items > trainTime) {
             timeToFinish = (trainTime / (double) timeReduction);
            System.out.println(timeToFinish);

        }
        else {
             timeItWillTakeAfterFinishing =  trainTime - (trainTime / (double) timeReduction);
             if(timeItWillTakeAfterFinishing > 1){
                 timeItWillTakeAfterFinishing = timeItWillTakeAfterFinishing * 60;
             }
            System.out.println(timeItWillTakeAfterFinishing + " minutes");

        }
    }
    else {
        if(scan.next().equalsIgnoreCase("No")){
            //very hard things need to happen.
        }
    }
}

    /**
     * run the instance of the object
     */
    public void  run(){
        this.construction();

}


    public static void main(String[] args) {
        COC_Reduction_Calculator crc = new COC_Reduction_Calculator();
        crc.run();
    }


}
