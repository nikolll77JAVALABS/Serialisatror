package nikolll77.com;


public class ClassForSave {
    @Save
    public int a;
    public String b;
    @Save
    public String c;

    public ClassForSave(){}

    public ClassForSave(int a,String b,String c){
    this.a=a;
    this.b=b;
    this.c=c;
    }

  @Override
   public String toString(){
      return a+","+b+","+c;
  }


}
