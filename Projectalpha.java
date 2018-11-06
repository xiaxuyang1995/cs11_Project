public class Projectalpha{
  public static void main(String[] args){
    welcome();
  }


  public static void welcome(){
    System.out.println("Hello there!!");
    System.out.printf("Welcome to the Food Heaven simulator!%nAt here, we'll try to satisfy all your hunger!!%n");
    System.out.println("Please insert your name");
    String username = TextIO.getln();
    System.out.printf("%s ? Nice name",username);
  }
}
