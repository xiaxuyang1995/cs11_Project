import java.util.Scanner;

public class zkx {
  public static void main(String[] args){

    int[][] orderarray={{1,2},{2,3},{12,3}};

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

    zkx1(orderarray,data,itemA,nutriA);

  }

  //System.out.println(Arrays.toString(nutriA));

  public static void zkx1(int[][] orderarray, double[][] data, String[] itemA, String[] nutriA){
    //in this method we calculate the calories based on the customer's choice
    double totalCalories = 0;
    double calories;
    for (int i=0; i<orderarray.length; i++){
      calories = data[(orderarray[i][0]-1)][0]*orderarray[i][1];
      totalCalories = totalCalories+calories;
      System.out.printf("The calories for %s is %.2f ", itemA[orderarray[i][0]-1], calories);
      System.out.println();
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
    }else{

    }
  }
}
