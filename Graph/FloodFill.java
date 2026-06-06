public class FloodFill {
    private void helper(int image[][], int x, int y, int newColor, int oldColor){
        if(x < 0 || y < 0 || x>= image.length || y >= image[0].length || image[x][y] != oldColor){
            return;
        }
        image[x][y] = newColor;
        helper(image, x+1,y, newColor, oldColor);
         helper(image, x-1,y, newColor, oldColor);
          helper(image, x,y+1, newColor, oldColor);
           helper(image, x,y-1, newColor, oldColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        helper(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}
