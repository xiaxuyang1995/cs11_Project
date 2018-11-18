public class Projectalpha{
  public static void main(String[] args){
    if (args.length==0) {
      // if not when print an error message and return to the shell
      System.out.println("You must supply a file name:  java Averages FILENAME.txt");
      return;
    }

    TextIO.readFile(args[0]);

    double[][] items = new double[23][13];
        for (int i=0;i<23;i++) {
            for(int j=0; j<13; j++){
              items[i][j]=TextIO.getDouble();
            }
        }

    }
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
    //这一段想用scanner的但是还没写好所以先放着吧：））
    /* String item = "Hamburger w/Onion,with mustard & ketchup instead of spread,ProteinÂ® Style (Bun replaced with Lettuce),Cheeseburger w/Onion,with mustard & ketchup instead of spread,ProteinÂ® Style (Bun replaced with Lettuce),Double-Double w/Onion with mustard & ketchup instead of spread,ProteinÂ® Style (Bun replaced with Lettuce),French Fries,Chocolate Shake,Vanilla Shake,Strawberry Shake,Coca-Cola Classic,Diet Coke,Seven Up,Dr Pepper,Root Beer,Lemonade,Minute Maid Light Lemonade,Iced Tea,Coffee,Milk";
    String item[] = item.split(",");

    String nutri = "Calories,Total Fat % Daily Values*,Cholesterol % Daily Values*,Sodium % Daily Values*,Carbohydrates % Daily Values*,Dietary Fiber % Daily Values*,Sugars (g),Protein (g),% Vitamin A,% Vitamin C,% Calcium,% Iron";
    String nutri[] = nutri.split(",");

    TextIO.readFile(dataA.txt);
    String data[][] = new String[23][13];
    data.split(" ");


    public static final String FILENAME="dataA.xlsx";
    public static final int ROWS = 23;

    public static String[] date = new String[ROWS];
    public static String[] time = new String[ROWS];
    public static int[] transaction = new int[ROWS];
    public static String[] item = new String[ROWS];

    public static void readStaticData(){
      //Date,Time,Transaction,Item
      try {
          File file = new File(FILENAME);

          Scanner fileScanner = new Scanner(file);//use a scanner to read from the file

          // now read the entire file and print it with line numbers:
          int row=0;
          while (fileScanner.hasNextLine()) {
              String line = fileScanner.nextLine();
              // create a new Scanner just for this row!
              Scanner lineScanner = new Scanner(line);
              lineScanner.useDelimiter(",");
              // we read each of the four columns in this row
              date[row]=lineScanner.next();
              time[row] = lineScanner.next();
              transaction[row] = lineScanner.nextInt();
              item[row] = lineScanner.next();
              row++;
          }
          fileScanner.close();

      } catch (Exception ex) {
          ex.printStackTrace();
      }
    }
  }
  */



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
