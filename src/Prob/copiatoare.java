package Prob;

public class copiatoare extends ehipamente_electronice
{
    private int p_ton;
    private format format;

    enum format
    {
        A3,A4
    }

    protected copiatoare(String denumire, int nr_inventar, float pret, String zona_magazie,situatie situatie,tip tip,int p_ton,format format)
    {
        super(denumire,nr_inventar,pret,zona_magazie,situatie,tip);
        this.p_ton = p_ton;
        this.format = format;
    }

    public int getP_ton()
    {
        return p_ton;
    }
    public format getFormat()
    {
        return format;
    }

    void setP_ton(int p_ton)
    {
        this.p_ton = p_ton;
    }
    void setFormat(format format)
    {
        this.format = format;
    }

    @Override
    public String toString()
    {
        return super.toString()+",\n"+"P_ton:"+p_ton+",\n"+"Format:"+format;
    }


}
