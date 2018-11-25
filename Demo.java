public class Demo{
  public static void main(String[] args){
    int[][] avai = {{1,1,1,1,1,1,1,1,1,1},
                    {0,0,0,0,0,1,1,1,1,1},
                    {1,1,0,1,1,1,1,1,1,1},
                    {1,1,0,1,0,1,1,1,1,1},
                    {1,1,0,1,1,1,1,9,1,1},
                    {1,1,1,1,0,1,1,1,1,1},
                    {1,1,1,1,0,1,1,1,1,1},
                    {1,1,1,1,0,1,0,1,0,1},
                    {1,1,1,1,1,0,1,0,1,0},
                    {1,1,1,1,1,0,1,1,1,0},};
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
    System.out.println("Please enter your house number. Below is the map of our town. * is the location of our store. [] stand for areas that cannot go through.");
  //print ind
    for (int i=0;i<10;i++) {
      for (int j=0;j<10;j++) {
        System.out.printf("%2s ",ind[i][j]);
      }
      System.out.println();
    }
    System.out.printf("Please enter a number from 1 to 80: ");
    int housenum=TextIO.getlnInt();//User input
    for(;housenum<1||housenum>80;){
      System.out.printf("Sorry, this house number is not in this town. Please enter another house number from 1 to 80: ");
      housenum=TextIO.getlnInt();//User input
    }
    System.out.printf("Thank you. We are preparing your food. Please wait.%n");
//Delay
    for (int i=0;i<2000000; i++) {
      for (int j=0;j<10000; j++) {
        for (int p=0;p<3; p++) {

        }
      }
    }
//Delay End
    System.out.printf("%nYour food is ready! Our delivery staff of genius is already on the fastest path to your house as shown below. Enjoy your meal!%n");
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
///     System.out.println(center);
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
//            System.out.println(tempind+" "+(posi[center][0]+i)+" "+(posi[center][1]+j));

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
//      System.out.println(testContain(openlist,center));
      newcenter=leastOpenlist(fvalue,openlist);
    }
    int st=parent[housenum];
//    System.out.println("** "+parent[housenum]);
    for (int i=0;i<10;i++) {
      for (int j=0;j<10;j++) {
        st=parent[housenum];
        for (;st!=81; ) {
          if(ind[i][j].equals(st+"")){
              ind[i][j]=".";
          }
//          System.out.println(parent[st]);
          st=parent[st];
        }
      }
    }
//  int a=ind[2][1];
  for (int i=0;i<10;i++) {
    for (int j=0;j<10;j++) {
      System.out.printf("%2s ",ind[i][j]);
    }
    System.out.println();
  }


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
}
