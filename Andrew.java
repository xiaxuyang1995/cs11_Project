public class Andrew{
  public static void main(String[] args){
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

      System.out.printf("How many of #%d would you want? ", itemA[itemnumber-1]);
      int itemquantity= order.nextInt();
      orderarray[numberofitem][1]= itemquantity;
      System.out.printf("%d of #%d%n",itemquantity,itemA[itemnumber-1]);
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

  System.out.printf("Here is your order summary!!%n");
  System.out.printf("Item#\tquantity%n");
  for(int i=0;i<customer.length;i++){
    System.out.printf("%d\t %d%n",customer[i][0],customer[i][1]);
  }
}
}
