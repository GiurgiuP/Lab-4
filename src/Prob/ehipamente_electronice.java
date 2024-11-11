package Prob;

public class ehipamente_electronice
{
    private String denumire;
    private int nr_inventar;
    private float pret;
    private String zona_magazie;
    private situatie situatie;
    private tip tip;

    enum situatie
    {
        achizitionat,expus,vandut
    }
    enum tip
    {
        imprimanta,copiator,sistem_de_calcul
    }


    protected ehipamente_electronice(String denumire, int nr_inventar, float pret, String zona_magazie,situatie situatie,tip tip)
    {
        this.denumire = denumire;
        this.nr_inventar = nr_inventar;
        this.pret = pret;
        this.zona_magazie = zona_magazie;
        this.situatie = situatie;
        this.tip=tip;
    }

    public String getDenumire()
    {
        return denumire;
    }
    public int getNr_inventar()
    {
        return nr_inventar;
    }
    public float getPret()
    {
        return pret;
    }
    public String getZona_magazie()
    {
        return zona_magazie;
    }
    public tip getTip()
    {
        return tip;
    }
    public situatie getSituatie()
    {
        return situatie;
    }


    public void setDenumire(String denumire)
    {
        this.denumire = denumire;
    }
    public  void setNr_inventar(int nr_inventar)
    {
        this.nr_inventar = nr_inventar;
    }
    public void setPret(float pret)
    {
        this.pret = pret;
    }
    public void setZona_magazie(String zona_magazie)
    {
        this.zona_magazie = zona_magazie;
    }
    public void setSituatie(situatie situatie)
    {
        this.situatie = situatie;
    }
    public void setTip(tip tip)
    {
        this.tip = tip;
    }


    @Override
    public String toString()
    {
        return "Denumire: "+denumire+",\n"+"Nr.Inventar:"+nr_inventar+"\n"+"Pret:"+pret+"\n"+"Zona mag:"+zona_magazie+"\n"+"Situatie:"+situatie+"\n"+"Tip:"+tip;
    }

}



