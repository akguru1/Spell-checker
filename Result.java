public class Result{
    private int count;
    private boolean found;

    public Result(int c, boolean f){
        count = c;
        found = f;
    }
    boolean isFound(){
        return found;
    }
    int Count(){
        return count;
    }
}
