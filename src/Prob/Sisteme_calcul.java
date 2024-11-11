package Prob;

public class Sisteme_calcul extends ehipamente_electronice
{
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private sistem sistem;

    enum sistem
    {
        windows,linux
    }

    protected Sisteme_calcul(String denumire, int nr_inventar, float pret, String zona_magazie,situatie situatie,tip tip,String tip_mon,float vit_proc,int c_hdd,sistem sistem)
    {
        super(denumire,nr_inventar,pret,zona_magazie,situatie,tip);
        this.tip_mon=tip_mon;
        this.vit_proc=vit_proc;
        this.c_hdd=c_hdd;
        this.sistem=sistem;
    }

    public String getTip_mon()
    {
        return tip_mon;
    }
    public float getVit_proc()
    {
        return vit_proc;
    }
    public int getC_hdd()
    {
        return c_hdd;
    }
    public sistem getSistem()
    {
        return sistem;
    }

    void setTip_mon(String tip_mon)
    {
        this.tip_mon=tip_mon;
    }
    void setVit_proc(float vit_proc)
    {
        this.vit_proc=vit_proc;
    }
    void setC_hdd(int c_hdd)
    {
        this.c_hdd=c_hdd;
    }
    void setSistem(sistem sistem)
    {
        this.sistem=sistem;
    }

    @Override
    public String toString()
    {
        return super.toString()+",\n"+"Tip monitor:"+tip_mon+",\n"+"Viteza procesor:"+vit_proc+",\n"+"Cap.HDD:"+c_hdd+",\n"+"Sistem:"+sistem;
    }
}
