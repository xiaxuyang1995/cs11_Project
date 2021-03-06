import java.util.Scanner;

public class finalVersionMac{
  public static void main(String[] args){
    //greating
    System.out.println();
    System.out.println("ヾ(*・▽・)ﾂ Hello there!!");
    System.out.println();
    System.out.printf("Welcome to the Food Heaven simulator!%nAt here, we'll try to satisfy all your hunger!%n");
    System.out.println();
    System.out.println("Please insert your name:");
    String username = TextIO.getln();
    System.out.println();

    System.out.printf("%s? Nice name!%n",username);
    System.out.println();

    //read data
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


    TextIO.readFile("nutri.txt");
    String nutri = "";
    while (!TextIO.eof()){
      nutri = TextIO.getln();
    }
    String nutriA[] = nutri.split(",");

    //print menu
    System.out.printf("Hey %s, here is Today's Menu!%n",username);
    System.out.println();
    System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
    System.out.println("│                    MENU                    │");
    System.out.println("┝━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┥");
    System.out.printf("│%30s         %s│%n","  ","Price");
    int k=1;
    for(int i=0;i<itemA.length; i++){
      if(i!=1 && i!=2 && i!=4 && i!=5 && i!=7 && i!=8){
        System.out.printf("│%2d  %-28s       $%-3.2f│%n",k,itemA[i],data[i][12]);
        k++;
      }
    }
    System.out.println("└────────────────────────────────────────────┘");


    //user order the meal
    Scanner order= new Scanner(System.in);
    int [][] orderarray = new int[23][2];
    System.out.printf("%nWhat would you like? %n(Please enter the item's corresponding number once at a time)%n");
    int numberofitem=0;
    int itemnumber=0;
    while(order.hasNextInt()&& numberofitem<23){
      itemnumber=Integer.valueOf(order.nextLine());
      orderarray[numberofitem][0]= itemnumber;

      if(itemnumber==1){
        System.out.println("Would you like your burger to be Animal Style? ");
        String answer = order.nextLine();
        if(answer.contains("y")){itemnumber+=2;}
        else{itemnumber+=0;}
      }

      else if(itemnumber==2){
        System.out.println("Would you like your burger to be Animal Style? ");
        String answer2 = order.nextLine();
        if(answer2.contains("y")){itemnumber+=4;}
        else{itemnumber+=2;}
      }

      else if(itemnumber==3){
        System.out.println("Would you like your burger to be Animal Style? ");
        String answer3 = order.nextLine();
        if(answer3.contains("y")){itemnumber+=6;}
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
    System.out.println();
    System.out.println(".............................................");
    System.out.printf("Here is your order summary!!%n");
    System.out.printf("Quantity          Item%n");
    for(int i=0;i<customer.length;i++){
      System.out.printf("%-18d%s%n", customer[i][1],itemA[customer[i][0]-1]);
    }
    System.out.println(".............................................");


    //method to calculate calories and bill
    calculate(customer, data, itemA, nutriA);

    //method to find the fastest delivery route
    System.out.println();
    TextIO.readStandardInput();
    route();

    thanks();

  }

  //find route
  public static void route(){
    int[][] avai = {{1,1,1,1,1,1,1,1,1,1},
    {1,0,0,0,0,0,1,1,1,1},
    {1,1,1,0,1,1,0,1,0,1},
    {1,1,1,0,1,0,1,0,1,0},
    {1,1,1,0,1,0,1,9,1,0},
    {1,1,1,1,0,1,1,1,1,1},
    {1,1,1,1,1,1,1,1,1,1},
    {1,1,1,1,0,1,1,1,1,1},
    {1,1,1,1,0,1,1,1,1,1},
    {1,1,1,1,0,1,1,1,1,1},};
    String[][] ind = new String[10][10];
    int[][] posi = new int[82][2];
    int k=1;
    for(int i=0;i<10;i++){
      for(int j=0;j<10;j++){
        if(avai[i][j]==1){
          ind[i][j]= k+"";
          posi[k][0]=i;
          posi[k][1]=j;
          k++;
        }
        else{ind[i][j]="[]";
        }
      }
    }
    posi[81][0]=4;
    posi[81][1]=7;
    ind[4][7]="*";
    System.out.println(".............................................");
    System.out.println();
    System.out.println();

    System.out.printf("Below is the map of our town. Please enter your house number.%n* is the location of our store. [] are areas that cannot go through.%n%n");
    //print ind
    for (int i=0;i<10;i++) {
      for (int j=0;j<10;j++) {
        System.out.printf("%2s ",ind[i][j]);
      }
      System.out.println();
    }
    System.out.printf("%nPlease enter your house number (from 1 to 80): ");
    int housenum=TextIO.getlnInt();//User input
    for(;housenum<1||housenum>80;){
      System.out.printf("Sorry, this house is not in our town. Please enter the house number from 1 to 80: ");
      housenum=TextIO.getlnInt();//User input
    }

    System.out.println(".............................................");
    System.out.printf("Thank you. We are preparing your food. Please wait.%n%n");
    //Delay
    for (int i=0;i<2000000; i++) {
      for (int j=0;j<3050; j++) {
        for (int p=0;p<3; p++) {

        }
      }
    }

    System.out.println("█████████████████50%...");
    for (int i=0;i<2000000; i++) {
      for (int j=0;j<3050; j++) {
        for (int p=0;p<3; p++) {

        }
      }
    }

    System.out.println(" ");
    for (int i=0;i<2000000; i++) {
      for (int j=0;j<3050; j++) {
        for (int p=0;p<300; p++) {

        }
      }
    }

    System.out.println("██████████████████████████████████99%...");
    for (int i=0;i<2000000; i++) {
      for (int j=0;j<3100; j++) {
        for (int p=0;p<300; p++) {

        }
      }
    }
    //Delay End
    System.out.printf("%nYour food is ready! %nOur delivery staff is on his fastest path to your house as shown below. Enjoy your meal!%n%n");
    int[] hvalue = new int[81];
    for(int i=1;i<81;i++){
      hvalue[i]= 1000*Math.abs(posi[housenum][0]-posi[i][0])+1000*Math.abs(posi[housenum][1]-posi[i][1]);
    }
    int[] parent = new int[82];
    parent[81]=81;
    int[] openlist = new int[81];
    int olmark=0;
    openlist[olmark]=81;
    olmark++;
    int[] closelist = new int[81];
    int clmark=0;
    int[] fvalue=new int[81];
    int[] gvalue=new int[82];
    gvalue[81]=0;
    int newcenter=81;
    int center=newcenter;
    for (;!testContain(openlist,housenum);) {
      center=newcenter;
      //goAround
      int tempind=999;
      int addk=0;
      int addkr=0;
      int tempg;
      for(int i=-1;i<2;i++){
        for(int j=-1;j<2;j++){
          if((i!=0||j!=0)&&(posi[center][0]!=9||i!=1)&&(posi[center][1]!=9||j!=1)&&(posi[center][0]!=0||i!=-1)&&(posi[center][1]!=0||j!=-1)) {
            if(avai[posi[center][0]+i][posi[center][1]+j]!=0){
              tempind=findInd(posi[center][0]+i,posi[center][1]+j, posi);
              if(testContain(openlist,tempind)) {
                addk=(i*j!=0)?1414:1000;
                tempg=gvalue[center]+addk;
                //                System.out.println("^^ "+tempg);
                if(tempg<gvalue[tempind]){
                  parent[tempind]=center;
                  gvalue[tempind]=tempg;
                  fvalue[tempind]=hvalue[tempind]+gvalue[tempind];
                }
              }
              else if(!testContain(closelist,tempind)) {
                openlist[olmark]=tempind;
                olmark++;
                parent[tempind]=center;
                addk=(i*j!=0)?1414:1000;
                gvalue[tempind]=gvalue[center]+addk;
                fvalue[tempind]=hvalue[tempind]+gvalue[tempind];
              }
            }
          }
        }
      }
      //goAround End
      //add to closelist
      closelist[clmark]=center;
      clmark++;
      //remove from openlist
      for(int i=0;i<81;i++){
        if(openlist[i]==center){
          openlist[i]=0;
        }
      }
      newcenter=leastOpenlist(fvalue,openlist);
    }
    int st=parent[housenum];
    for (int i=0;i<10;i++) {
      for (int j=0;j<10;j++) {
        st=parent[housenum];
        for (;st!=81; ) {
          if(ind[i][j].equals(st+"")){
            ind[i][j]=".";
          }
          st=parent[st];
        }
      }
    }
    for (int i=0;i<10;i++) {
      for (int j=0;j<10;j++) {
        System.out.printf("%2s ",ind[i][j]);
      }
      System.out.println();
    }
    System.out.println();

  }

  public static boolean testContain(int[] arr,int targetValue){
    for(int i=0;i<arr.length;i++){
      if(arr[i]==targetValue){
        return true;
      }
    }
    return false;
  }
  public static int findInd(int row,int col,int[][] posi){
    for(int i=1;i<82;i++){
      if(row==posi[i][0]&&col==posi[i][1]){
        return i;
      }
    }
    return 8888;
  }
  public static int leastOpenlist(int[] fvalue,int[] openlist){
    int tempxxy=99999;
    int leastind=0;
    for(int i=0;i<81;i++){
      if(fvalue[i]!=0&&fvalue[i]<tempxxy&&testContain(openlist,i)) {
        tempxxy=fvalue[i];
        leastind=i;
      }
    }
    return leastind;
  }

  //calculate the calories based on the customer's choice
  public static void calculate(int[][] orderarray, double[][] data, String[] itemA, String[] nutriA){
    double colval;
    double[][] cun = new double[orderarray.length][12];
    for (int i=0; i<orderarray.length; i++){
      for (int j=0; j<12; j++) {
        colval = data[(orderarray[i][0]-1)][j]*orderarray[i][1];
        cun[i][j] = colval;
      }
    }
    double[] total = new double[12];

    for (int i=0;i<12;i++){
      double sum=0;
      for (int k=0;k<cun.length;k++){
        sum=sum+cun[k][i];
        total[i]=sum;
      }
    }

    System.out.println();
    System.out.println();
    System.out.println(".............................................");
    System.out.println("Nutrition Facts:");
    for(int i=0;i<total.length;i++){
      System.out.printf("%30s  %.2f%n",nutriA[i],total[i]);
    }
    System.out.println(".............................................");




   //calculate the bill
    double totalPrice = 0;
    double price;
    for (int i=0; i<orderarray.length; i++){
      price = data[(orderarray[i][0])-1][12]*orderarray[i][1];
      totalPrice = totalPrice+price;
    }
    System.out.printf("The total price is $%.2f%n",totalPrice);
    System.out.println();
    System.out.println();
    System.out.println(".............................................");
    System.out.println("Do you want to split the bill?");
    Scanner order= new Scanner(System.in);
    String answer = order.nextLine();
    if(answer.contains("y")){
      System.out.println("How many people?");
      int people = order.nextInt();
      System.out.printf("Each should pay %.2f dollars. ",totalPrice/people);
    }else{}
  }

  //thank you note
  public static void thanks(){
    System.out.println("Thank you very much for choosing our restaurant. We hope to see you again soon!");
    System.out.println();
    System.out.println();
    System.out.println();
  }

}
