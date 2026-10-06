public class Rotate {
    public static int[][] rotateArray(int[][] square) {
        int[][] newArray = new int[square.length][square.length];

        for(int r = 0; r < square.length; ++r) {
            for(int c = 0; c < square.length; ++c) {
                newArray[r][c] = square[square.length - c - 1][r];
            }
        }

        return newArray;
    }
}
