// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class RotateTest {
   private static Boolean failed = false;
   private static Rotate rotate;

   public RotateTest() {
   }

   public static void main(String[] args) {
      test();
      if (failed) {
         System.out.println("\nSorry, try again.");
      } else {
         System.out.println("\nCongratulations!  You have completed the Rotate assignment");
      }

   }

   private static void test() {
      try {
         rotate = new Rotate();
      } catch (NoClassDefFoundError var8) {
         failure("Epic Failure: missing Rotate class");
         return;
      }

      int size = (int)(Math.random() * (double)5.0F + (double)3.0F);
      System.out.println("Now attempting to rotate the following " + size + "x" + size + " array\n");
      int[][] array = new int[size][size];

      for(int r = 0; r < size; ++r) {
         for(int c = 0; c < size; ++c) {
            array[r][c] = (int)(Math.random() * (double)10.0F);
         }
      }

      displayArray(array);
      int[][] testArray = rotateArray(array);

      int[][] newArray;
      try {
         Rotate var10000 = rotate;
         newArray = Rotate.rotateArray(array);
      } catch (NoSuchMethodError var6) {
         failure("Missing or improper rotateArray method");
         return;
      } catch (IncompatibleClassChangeError var7) {
         failure("rotateArray method must be static");
         return;
      }

      if (newArray == null) {
         failure("your rotateArray method is not returning a valid array");
      } else {
         if (testArray.length != newArray.length || testArray[0].length != newArray[0].length) {
            failure("Your array does not have the proper dimensions");
         }

         if (!failed) {
            for(int r = 0; r < newArray.length; ++r) {
               for(int c = 0; c < newArray[r].length; ++c) {
                  if (newArray[r][c] != testArray[r][c]) {
                     failure("Your array is not properly rotated 90 degrees clockwise\n");
                     displayArray(newArray);
                     return;
                  }
               }
            }
         }

         if (!failed) {
            System.out.println("Good.  Here is your properly rotated array\n");
         }

         displayArray(newArray);
      }
   }

   private static void displayArray(int[][] array) {
      for(int r = 0; r < array.length; ++r) {
         for(int c = 0; c < array[r].length; ++c) {
            System.out.print("\t" + array[r][c]);
         }

         System.out.println();
      }

      System.out.println();
   }

   private static int[][] rotateArray(int[][] square) {
      int[][] newArray = new int[square.length][square.length];

      for(int r = 0; r < square.length; ++r) {
         for(int c = 0; c < square.length; ++c) {
            newArray[r][c] = square[square.length - c - 1][r];
         }
      }

      return newArray;
   }

   private static void failure(String str) {
      System.out.println("*** " + str);
      failed = true;
   }
}
