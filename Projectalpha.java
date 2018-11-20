public class Projectalpha{

  public static void main(String[] args){

    welcome();
    menuData();
    printMenu();

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

  public static void ordering(){
    //in this method we let the customers choose their meal
  }

  public static void calories(){
    //in this method we calculate the calories based on the customer's choice
  }

  public static void check(){
    //in this method we calculate the bill
  }

  public static void thanks(){
    System.out.println("Thank you very much for visiting  our restaurant. We will be happy to return to serve you with our best service. We hope to see you again soon!");
  }

}
