import  java.util.Scannar;

public class Projectalpha{

  public static void main(String[] args){

    welcome();
    menuData();
    printMenu();
    order();
    calories();
    check();
    thanks();
  }

  public static void welcome(){
    System.out.println("Hello there!!");
    System.out.printf("Welcome to the Food Heaven simulator!%nAt here, we'll try to satisfy all your hunger!%n");
    System.out.println("Please insert your name");
    public static final String username = TextIO.getln();
    System.out.printf("%s? Nice name!%n",username);
  }


  public static void menuData(){
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
  }


    /**
    这个就是之后调用data array里面数据的时候可以用的格式
        switch (price){
          case "Hamburger w/Onion": price=data[0][12]; break;
          case "Hamburger with mustard & ketchup instead of spread": days=28; break;
          case "mar": days=31; break;
          case "apr": days=30; break;
          case "may": days=31; break;
          case "jun": days=30; break;
          case "jul": days=31; break;
          case "aug": days=31; break;
          case "sep": days=30; break;
          case "oct": days=31; break;
          case "nov": days=30; break;
          case "dec": days=31; break;
          default: days=0;
    */

  public static void printMenu(){
    System.out.printf("Hey %s, here is the Menu!%n",username);

    System.out.println("                                       MENU");
    System.out.printf("%30s                          %s%n"," ","Price");
    int k=1;
    for(int i=0;i<itemA.length; i++){
      if(i!=1 && i!=2 && i!=4 && i!=5 && i!=7 && i!=8){
          System.out.printf("%2d  %28s........................%.2f$%n",k,itemA[i],data[i][12]);
          k++;
      }
    }
  }

  public static int[][] order(){
    //in this method we let the customers choose their meal
    Scanner order= new Scanner(System.in);
    int [][] orderarray = new int[23][2];
    System.out.printf("What would you like ? %nPlease enter the item's corresponding number once at a time%n");
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

        System.out.printf("How many of #%d would you want? ", menuData.itemA[itemnumber-1]);
        int itemquantity= order.nextInt();
        orderarray[numberofitem][1]= itemquantity;
        System.out.printf("%d of #%d%n",itemquantity,menuData.itemA[itemnumber-1]);
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

    return customer;
  }

  public static void calories(){
    //in this method we calculate the calories based on the customer's choice
    double totalCalories = 0;
    for (int i=0; i<orderarray.length; i++){
      double calories = data[(orderarray[i][0])-1][0]*orderarray[i][1];
      totalCalories = totalCalories+calories;
      System.out.printf("The calories for %s is %.2f ", menuData.itemA[itemnumber-1],calories);
    }
    System.out.println("The total amount of calorie is"+totalCalories);
    System.out.println("Are you satisfied with the calories? (Enter yes or no)");
    Scanner order= new Scanner(System.in);
    String answer = order.nextLine();
    if (answer.equals("yes")){
        System.out.println("Preceeding to checkout");
    }
    else{
      order();
    }
  }

  public static void check(){
    //in this method we calculate the bill
    double totalPrice = 0;
    for (int i=0; i<orderarray.length; i++){
      double price = data[(orderarray[i][0])-1][12]*orderarray[i][1];
      totalPrice = totalPrice+price;
    }
    System.out.println("The total price is "+totalPrice);
    System.out.println("Do you want to split the bill?");
    Scanner order= new Scanner(System.in);
    String answer = order.nextLine();
    if(answer.equals("yes")){
      System.out.println("How many people?");
      int people = TextIO.getlnInt();
      System.out.println("Each should pay "+(totalPrice/people));
    }else{

    }
  }

  public static void thanks(){
    System.out.println("Thank you very much for visiting  our restaurant. We will be happy to return to serve you with our best service. We hope to see you again soon!");
  }

}
