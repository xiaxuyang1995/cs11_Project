// testing purposes
import java.util.Scanner;
public class andy{

public static void main(String[] args){
  //in this method we let the customers choose their meal
  Scanner order= new Scanner(System.in);
  int [][] orderarray = new int[22][2];
  System.out.printf("What would you like ? %nPlease enter the item's corresponding number once at a time%n");
  int numberofitem=0;
  int itemnumber=0;
    while(order.hasNextInt()&& numberofitem<=22){
      itemnumber=Integer.valueOf(order.nextLine());
      orderarray[numberofitem][0]= itemnumber;

        if(itemnumber==0){
        System.out.println("Would you like your burger to be Animal Style? ");
        String answer = order.nextLine();
          if(answer.equals("yes")){itemnumber+=2;}
          else{itemnumber+=0;}

        }


        else if(itemnumber==1){
        System.out.println("Would you like your burger to be Animal Style? ");
        String answer2 = order.nextLine();
          if(answer2.equals("yes")){itemnumber+=4;}
          else{itemnumber+=2;}

        }


        else if(itemnumber==2){
        System.out.println("Would you like your burger to be Animal Style? ");
        String answer3 = order.nextLine();
          if(answer3.equals("yes")){itemnumber+=6;}
          else{itemnumber+=4;}

        }

        else {itemnumber+=6;}

      System.out.printf("How many of #%d would you want? ",itemnumber);
      int itemquantity= order.nextInt();
      orderarray[numberofitem][1]= itemquantity;
      System.out.printf("%d of #%d%n",itemquantity,itemnumber);
      System.out.printf("what other item would you like?%n(To finish your order, enter 'finish')%n");
      numberofitem++;
      order.nextLine();

    }



  int[][] customer= new int [numberofitem][2];
  for(int i=0;i<customer.length;i++){
    customer[i][0]=orderarray[i][0];
    customer[i][1]=orderarray[i][1];
  }

  // due to data consistentce issue, transform item to correspond with data file.

  //customer array is the final array
  //
System.out.printf("Here is your order summary!!%n");
System.out.printf("Item#\tquantity%n");
 for(int i=0;i<customer.length;i++){
    System.out.printf("%d\t %d%n",customer[i][0],customer[i][1]);
  }


}
}
