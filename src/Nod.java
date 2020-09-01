public class Nod {
    public int x,y;
    public Nod parinte=null;
   public Nod(int x, int y,Nod parinte){
        this.x=x;
        this.y=y;
        this.parinte=parinte;
   }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof Nod))
            return false;
        Nod nod=(Nod) obj;
        return (nod.x==x && nod.y==y);
    }
    @Override
    public int hashCode(){
       return x-y;
    }
    public void SetParinte(Nod parinte)
    {
        this.parinte=parinte;
    }
}
