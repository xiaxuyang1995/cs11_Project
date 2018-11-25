import java.util.Scanner;

public class Andrew{
  public static void main(String[] args){
  //read data
  /*
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
    public final String itemA[] = item.split(",");

    TextIO.readFile("nutri.txt");
    String nutri = "";
    while (!TextIO.eof()){
      nutri = TextIO.getln();
    }
    String nutriA[] = nutri.split(",");
  //print menu
    System.out.println("                                       MENU");
    System.out.printf("%30s                          %s%n"," ","Price");
    int k=1;
    for(int i=0;i<itemA.length; i++){
      if(i!=1 && i!=2 && i!=4 && i!=5 && i!=7 && i!=8){
          System.out.printf("%2d  %28s........................$%.2f%n",k,itemA[i],data[i][12]);
          k++;
      }
        }
**/

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

  System.out.printf("Here is your order summary!!%n");
  System.out.printf("Item#\tquantity%n");
  for(int i=0;i<customer.length;i++){
    System.out.printf("%d\t %d%n",customer[i][0],customer[i][1]);
  }
}
}
