import java.util.Scanner;

public class Project{
  public static void main(String[] args){
    System.out.println();
    System.out.println("Hello there!!");
    System.out.println();
    System.out.printf("Welcome to the Food Heaven simulator!%nAt here, we'll try to satisfy all your hunger!%n");
    System.out.println();
    System.out.println("Please insert your name:");
    String username = TextIO.getln();
    System.out.println();

    System.out.printf("%s? Nice name!%n",username);
    System.out.println();

    TextIO.readFile("dataA.txt");
    double[][] data = new double[23][13];
      for (int i=0;i<23;i++) {
        for(int j=0; j<13; j++){
          data[i][j]=TextIO.getDouble();
        }
      }

      TextIO.readFile("item.txt");
      String item = "";
      while (!TextIO.eof()){
        item = TextIO.getln();
      }

      String itemA[] = item.split(",");

      //System.out.println(Arrays.toString(itemA));

      TextIO.readFile("nutri.txt");
      String nutri = "";
      while (!TextIO.eof()){
        nutri = TextIO.getln();
      }
      String nutriA[] = nutri.split(",");

      //System.out.println(Arrays.toString(nutriA));

    System.out.printf("Hey %s, here is Today's Menu!%n",username);
    System.out.println();
    System.out.println("                                       MENU");
    System.out.printf("%30s                          %s%n"," ","Price");
    int k=1;
    for(int i=0;i<itemA.length; i++){
      if(i!=1 && i!=2 && i!=4 && i!=5 && i!=7 && i!=8){
          System.out.printf("%2d  %28s........................$%.2f %n",k,itemA[i],data[i][12]);
          k++;
      }
    }

    //order
     Scanner order= new Scanner(System.in);
     int [][] orderarray = new int[23][2];
     System.out.printf("What would you like? %n(Please enter the item's corresponding number once at a time)%n");
     int numberofitem=0;
     int itemnumber=0;
       while(order.hasNextInt()&& numberofitem<23){
         itemnumber=Integer.valueOf(order.nextLine());
         orderarray[numberofitem][0]= itemnumber;

           if(itemnumber==1){
           System.out.println("Would you like your burger to be Animal Style? ");
           String answer = order.nextLine();
             if(answer.equals("yes")){itemnumber+=2;}
             else{itemnumber+=0;}
           }

           else if(itemnumber==2){
           System.out.println("Would you like your burger to be Animal Style? ");
           String answer2 = order.nextLine();
             if(answer2.equals("yes")){itemnumber+=4;}
             else{itemnumber+=2;}
           }

           else if(itemnumber==3){
           System.out.println("Would you like your burger to be Animal Style? ");
           String answer3 = order.nextLine();
             if(answer3.equals("yes")){itemnumber+=6;}
             else{itemnumber+=4;}
           }

           else {
             itemnumber+=6;
           }

         orderarray[numberofitem][0]= itemnumber;

         System.out.println("How many would you want?");
         int itemquantity= order.nextInt();
         orderarray[numberofitem][1]= itemquantity;
         System.out.printf("%d of %s%n%n",itemquantity,itemA[itemnumber-1]);


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

     System.out.printf("%nHere is your order summary!!%n");
     System.out.printf("Quantity          Item%n");
     for(int i=0;i<customer.length;i++){
       System.out.printf("%d                 %s%n", customer[i][1],itemA[customer[i][0]-1]);
     }

    calculate(orderarray, data, itemA, nutriA);
    thanks();

  }

public static void calculate(int[][] orderarray, double[][] data, String[] itemA, String[] nutriA){
  //in this method we calculate the calories based on the customer's choice
  double totalCalories = 0;
  double calories;
  for (int i=0; i<orderarray.length; i++){
    calories = data[(orderarray[i][0]-1)][0]*orderarray[i][1];
    totalCalories = totalCalories+calories;
    System.out.printf("The calories for %s are %.2f%n", itemA[orderarray[i][0]-1], calories);
  }
  System.out.println("The total amount of calorie is "+totalCalories);
  System.out.println();

  //we calculate the bill
  double totalPrice = 0;
  double price;
  for (int i=0; i<orderarray.length; i++){
    price = data[(orderarray[i][0])-1][12]*orderarray[i][1];
    totalPrice = totalPrice+price;
  }
  System.out.println("The total price is "+totalPrice);
  System.out.println("Do you want to split the bill?");
  Scanner order= new Scanner(System.in);
  String answer = order.nextLine();
  if(answer.equals("yes")){
    System.out.println("How many people?");
    int people = order.nextInt();
    System.out.println("Each should pay "+(totalPrice/people)+"dollar");
  }else{}
}

  public static void thanks(){
    System.out.println("Thank you very much for visiting our restaurant. We will be happy to return to serve you with our best service. We hope to see you again soon!");
  }

}
