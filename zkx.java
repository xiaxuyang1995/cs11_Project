public static void zkx(int[][] orderarray, double[][] data, String[] itemA, String[] nutriA){
  //in this method we calculate the calories based on the customer's choice
  double totalCalories = 0;
  double calories;
  for (int i=0; i<orderarray.length; i++){
    calories = data[(orderarray[i][0])-1][0]*orderarray[i][1];
    totalCalories = totalCalories+calories;
    System.out.printf("The calories for %s is %.2f ", itemA[itemnumber-1], calories);
  }
  System.out.println("The total amount of calorie is"+totalCalories);

/** 是否satisfy，这个不要了，太麻烦了

  System.out.println("Are you satisfied with the calories? (Enter yes or no)");
  Scanner order= new Scanner(System.in);
  String answer = order.nextLine();
  if (answer.equals("yes")){
      System.out.println("Preceeding to checkout");
  }
  else{
    order();
  }
*/

  //we calculate the bill
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
