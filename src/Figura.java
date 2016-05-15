import java.awt.*;

/**
 * Created by KAMIL BIELSKI on 2016-05-08.
 */
abstract public class Figura
{
    int Kolor;
    int[][] wspolrzedne;
    int[] kwadraciki_do_zamazania;

    abstract public void zamaz(int[] ktore_kwadraciki,int jakim_kolorem);                    //zamazuje slad po figurze , to bedzie wywolywane w klasie macierz
    abstract public void ruch_od_strzalek(Boolean lewo,Boolean prawo,Boolean obrot,Boolean obrot_wsteczny);           //pryklad wywolania ruch(1,0,0,0) => ruch w lewo
    abstract public void ruch();

}

