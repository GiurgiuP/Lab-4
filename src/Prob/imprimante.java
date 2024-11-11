package Prob;

public class imprimante extends ehipamente_electronice
{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private modul modul;

    enum modul
    {
        color,alb_negru
    }

    protected imprimante(String denumire, int nr_inventar, float pret, String zona_magazie,situatie situatie,tip tip,int ppm, String rezolutie, int p_car, modul modul)
    {
        super(denumire,nr_inventar,pret,zona_magazie,situatie,tip);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.modul = modul;
    }

    public int getPpm()
    {
        return ppm;
    }
    public String getRezolutie()
    {
        return rezolutie;
    }
    public int getP_car()
    {
        return p_car;
    }
    public modul getModul()
    {
        return modul;
    }

    void setPpm(int ppm)
    {
        this.ppm = ppm;
    }
    void setRezolutie(String rezolutie)
    {
        this.rezolutie = rezolutie;
    }
    void setP_car(int p_car)
    {
        this.p_car = p_car;
    }
    void setModul(modul modul)
    {
        this.modul = modul;
    }


    @Override
    public String toString()
    {
        return super.toString()+",\n"+"PMM:"+ppm+",\n"+"Rezolutie:"+rezolutie+",\n"+"P_car:"+p_car+",\n"+"Modul:"+modul;
    }

}
