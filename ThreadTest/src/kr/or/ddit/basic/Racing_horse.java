package kr.or.ddit.basic;
/*
10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간중간에 각 말들의 위치를 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

경기가 끝나면 등수 순으로 출력한다.
 */
public class Racing_horse {
   static String strRank = "";
   static String[] str = new String[10];
   static int rank = 0;
   
   public static void main(String[] args) {
      Horse[] h = new Horse[] {
            new Horse(" 1번말"),
            new Horse(" 2번말"),
            new Horse(" 3번말"),
            new Horse(" 4번말"),
            new Horse(" 5번말"),
            new Horse(" 6번말"),
            new Horse(" 7번말"),
            new Horse(" 8번말"),
            new Horse(" 9번말"),
            new Horse("10번말")      
      };
      
      for(int i = 1; i <= h.length; i++) {
         h[i-1].start();
      }
      
      for(Horse hs : h) {
         try {
            hs.join();
         }catch(InterruptedException e) {
            e.printStackTrace();
         }
      }
      
      System.out.println("-----------------------------------");
      System.err.println("경기 끝...");
      System.out.println("-----------------------------------");
      System.out.println();
      System.out.println("경기 결과");
      System.out.println("순위 : \n" + strRank);
      
   }
}

class Horse extends Thread{
   private String name;
   private int rank;
   
   public Horse(String name) {
      this.name = name;
   }
   
   @Override
   public void run() {
      String show = ">-------------------------------------------------";
      for(int i = 1; i <= 50; i++) {
         try {
            Thread.sleep((int)(Math.random()*301 + 200));
         }catch(InterruptedException e) {
            e.printStackTrace();
         }
         show =show.substring(0, show.length()-1);
         show = "-" + show;      
         Racing_horse.str[Integer.parseInt(name.substring(0,2).trim())-1] = show;
         clear();
         display();
      
      }
      Racing_horse.rank++;
      System.err.println(name + "도착...");
      Racing_horse.strRank += Racing_horse.rank +"등" + "\t" +name + "\n";
   }
   
   public void display() {
      int i = 0;
      System.out.println("1번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("2번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("3번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("4번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("5번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("6번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("7번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("8번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("9번말" + "\t" + Racing_horse.str[i++]);
      System.out.println("10번말" + "\t" + Racing_horse.str[i++]);
   }

   public void clear() {
      for(int i = 0; i <= 100; i++) {
         System.out.println();
      }
   }
   
   
   //등수를 오름차순으로 처리하는 메서드
}