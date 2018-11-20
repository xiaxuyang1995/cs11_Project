// 别管这个程序这只是我自己测试我的部分用的
import java.util.Arrays;

public class Ella {
  public static void main(String[] args){

    System.out.println("Hello there!!");
    System.out.printf("Welcome to the Food Heaven simulator!%nAt here, we'll try to satisfy all your hunger!%n");
    System.out.println("Please insert your name");
    String username = TextIO.getln();
    System.out.printf("%s? Nice name!%n",username);

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
}
