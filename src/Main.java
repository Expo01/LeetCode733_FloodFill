public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

//class Solution {
//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        int storedColor = image[sr][sc];
//        // sr = x axis. sc = y axis
//        image[sr][sc] = color;
//
//        if (sr - 1 >= 0 && image[sr - 1][sc] == storedColor) { //explore left
//            floodFill(image, sr - 1, sc, color);
//        }
//
//        if (sr + 1 <= image.length && image[sr + 1][sc] == storedColor) { //explore right
//            floodFill(image, sr + 1, sc, color);
//        }
//
//        if (sc - 1 >= 0 && image[sr][sc - 1] == storedColor) {
//            floodFill(image, sr, sc - 1, color);
//        }
//
//        if (sc + 1 <= image.length && image[sr][sc + 1] == storedColor) {
//            floodFill(image, sr, sc + 1, color);
//        }
//
//        return image;
//    }
//}

class Solution {

    public int[][] floodFill(int[][] image, int x, int y, int fillColor) {
        if( image[x][y] == fillColor ) return image; // if coordinate has value of fill color already, return
        move( image , x , y , fillColor , image[x][y] ); // same parameters as flood fill except passing the coordinate point too
        return image;
    }

    static void move( int[][] i , int h , int  v , int fc , int pc ){

        if( h == -1 || h == i.length || v == -1 || v == i[0].length ) return; // if horizonal or vertical values are outside of bounds
        // of the image, then return
        // return statment with void just terminates but doesn't actually return anything
        // i.length refers to the number of rows so this is actually the height/y axis? i may have my variable names flopped.
        // i assumed x,y ordering...
        // it seems the first bracket [] indiactes # of rows and second indicates # of columns, so effectievly to coordinates
        // are y,x. for which row, then which column

        if( i[h][v] != pc ) return;  // pc is stored pixel color. if coordinate isn't same , then return
        i[h][v] = fc; // change color of coordinate to fill color

        move( i , h , v + 1 , fc , pc ); // moves down
        move( i , h - 1 , v , fc , pc ); // moves left
        move( i , h + 1 , v , fc , pc ); // moves right
        move( i , h , v - 1 , fc , pc ); // moves up
    }
}