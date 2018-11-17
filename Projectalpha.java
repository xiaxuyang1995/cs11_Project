public class Projectalpha{
  public static void main(String[] args){
    welcome();
  }


  public static void welcome(){
    System.out.println("Hello there!!");
    System.out.printf("Welcome to the Food Heaven simulator!%nAt here, we'll try to satisfy all your hunger!%n");
    System.out.println("Please insert your name");
    String username = TextIO.getln();
    System.out.printf("%s ? Nice name",username);
  }


  public static void menu(){
    //in this method we show customers our menu
  }

  public static void ordering(){
    //in this method we let the customers choose their meal
  }

  public static void calories(){
    //in this method we calculate the calories based on the customer's choice

  public static void check(){
    //in this method we calculate the bill
  }

  public static void thanks(){
    System.out.println("Thank you very much for visiting  our restaurant. We will be happy to return to serve you with our best service. We hope to see you again soon!")
  }

}
