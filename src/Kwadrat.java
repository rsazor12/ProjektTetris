import java.awt.*;

public class Kwadrat extends Figura {
    Kwadrat() {
        Kolor = 2;
        wspolrzedne = new int[12][3];     // 10 kwadracikow , 2 wsp x i y w podtablicy i kolor
        kwadraciki_do_zamazania = new int[8];


        /*         NR  X                                Y                         KOLOR   */                           //startowe wspolrzedne obiektu na maciery glownej

        wspolrzedne[0][0] = 8;          wspolrzedne[0][1] = 0;       wspolrzedne[0][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[1][0] = 9;          wspolrzedne[1][1] = 0;       wspolrzedne[1][2] = 3;  //kwadracik1 CZYSTY
        wspolrzedne[2][0] = 10;         wspolrzedne[2][1] = 0;       wspolrzedne[2][2] = 3;  //kwadracik2 CZYSTY
        wspolrzedne[3][0] = 11;         wspolrzedne[3][1] = 0;       wspolrzedne[3][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[4][0] = 8;          wspolrzedne[4][1] = 1;       wspolrzedne[4][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[5][0] = 9;          wspolrzedne[5][1] = 1;       wspolrzedne[5][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[6][0] = 10;         wspolrzedne[6][1] = 1;       wspolrzedne[6][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[7][0] = 11;         wspolrzedne[7][1] = 1;       wspolrzedne[7][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[8][0] = 8;          wspolrzedne[8][1] = 2;       wspolrzedne[8][2] = 3;  //kwadracik0 CZYSTY
        wspolrzedne[9][0] = 9;          wspolrzedne[9][1] = 2;       wspolrzedne[9][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[10][0] = 10;        wspolrzedne[10][1] =2;      wspolrzedne[10][2] = 2;  //kwadracik0 CZYSTY
        wspolrzedne[11][0] = 11;        wspolrzedne[11][1] =2;      wspolrzedne[11][2] = 3;  //kwadracik0 CZYSTY


    }

    @Override
    public void zamaz(int[] ktore_kwadraciki,int jakim_Kolorem)              // podaje ktore kwadraciki wyczyscic w tablicy
    {
        for(int i=0;i<ktore_kwadraciki.length;i++)
        {
            wspolrzedne[ktore_kwadraciki[i]][2] = jakim_Kolorem;

            if(wspolrzedne[ktore_kwadraciki[i]][0]==0)                             //zeby nie zamzywalo czerwonej ramki macierzy przy kolizji obiektu ze sciana z lewej strony
            {
                wspolrzedne[ktore_kwadraciki[i]][2] = 1;
            }

            if(wspolrzedne[ktore_kwadraciki[i]][0]==Macierz.getSzerokosc()-1)      //tu równiez ale ze strony prawej
            {
                wspolrzedne[ktore_kwadraciki[i]][2] = 1;
            }
        }

    }


    public void ruch()
    {
        wspolrzedne[0][1]++;       wspolrzedne[0][2] = Kolor;
        wspolrzedne[1][1]++;       wspolrzedne[1][2] = Kolor;
        wspolrzedne[2][1]++;       wspolrzedne[2][2] = Kolor;
        wspolrzedne[3][1]++;       wspolrzedne[3][2] = Kolor;
        wspolrzedne[4][1]++;       wspolrzedne[4][2] = Kolor;
        wspolrzedne[5][1]++;       wspolrzedne[5][2] = Kolor;
        wspolrzedne[6][1]++;       wspolrzedne[6][2] = Kolor;
        wspolrzedne[7][1]++;       wspolrzedne[7][2] = Kolor;
        wspolrzedne[8][1]++;       wspolrzedne[8][2] = Kolor;
        wspolrzedne[9][1]++;       wspolrzedne[9][2] = Kolor;
        wspolrzedne[10][1]++;      wspolrzedne[10][2] = Kolor;
        wspolrzedne[11][1]++;      wspolrzedne[11][2] = Kolor;


        kwadraciki_do_zamazania[0]=0;
        kwadraciki_do_zamazania[1]=1;
        kwadraciki_do_zamazania[2]=2;
        kwadraciki_do_zamazania[3]=3;
        kwadraciki_do_zamazania[4]=4;
        kwadraciki_do_zamazania[5]=7;
        kwadraciki_do_zamazania[6]=8;
        kwadraciki_do_zamazania[7]=11;


        zamaz(kwadraciki_do_zamazania,3);
    }




    public void ruch_od_strzalek(Boolean lewo,Boolean prawo,Boolean obrot,Boolean obrot_wsteczny)
    {
        if(lewo == true)
        {


           //1) przesun    lewo
            wspolrzedne[0][0]--;          wspolrzedne[0][2] = Kolor;
            wspolrzedne[1][0]--;          wspolrzedne[1][2] = Kolor;
            wspolrzedne[2][0]--;          wspolrzedne[2][2] = Kolor;
            wspolrzedne[3][0]--;          wspolrzedne[3][2] = Kolor;
            wspolrzedne[4][0]--;          wspolrzedne[4][2] = Kolor;
            wspolrzedne[5][0]--;          wspolrzedne[5][2] = Kolor;
            wspolrzedne[6][0]--;          wspolrzedne[6][2] = Kolor;
            wspolrzedne[7][0]--;          wspolrzedne[7][2] = Kolor;
            wspolrzedne[8][0]--;          wspolrzedne[8][2] = Kolor;
            wspolrzedne[9][0]--;          wspolrzedne[9][2] = Kolor;
            wspolrzedne[10][0]--;         wspolrzedne[10][2] = Kolor;
            wspolrzedne[11][0]--;         wspolrzedne[11][2] = Kolor;

            //2 zamaz

            kwadraciki_do_zamazania[0]=0;
            kwadraciki_do_zamazania[1]=1;
            kwadraciki_do_zamazania[2]=2;
            kwadraciki_do_zamazania[3]=3;
            kwadraciki_do_zamazania[4]=4;
            kwadraciki_do_zamazania[5]=7;
            kwadraciki_do_zamazania[6]=8;
            kwadraciki_do_zamazania[7]=11;


            zamaz(kwadraciki_do_zamazania,3);

        }

        if(prawo == true)
        {
           //1) przesun  prawo            dol
            wspolrzedne[0][0]++;          wspolrzedne[0][2] = Kolor;
            wspolrzedne[1][0]++;          wspolrzedne[1][2] = Kolor;
            wspolrzedne[2][0]++;          wspolrzedne[2][2] = Kolor;
            wspolrzedne[3][0]++;          wspolrzedne[3][2] = Kolor;
            wspolrzedne[4][0]++;          wspolrzedne[4][2] = Kolor;
            wspolrzedne[5][0]++;          wspolrzedne[5][2] = Kolor;
            wspolrzedne[6][0]++;          wspolrzedne[6][2] = Kolor;
            wspolrzedne[7][0]++;          wspolrzedne[7][2] = Kolor;
            wspolrzedne[8][0]++;          wspolrzedne[8][2] = Kolor;
            wspolrzedne[9][0]++;          wspolrzedne[9][2] = Kolor;
            wspolrzedne[10][0]++;         wspolrzedne[10][2] = Kolor;
            wspolrzedne[11][0]++;         wspolrzedne[11][2] = Kolor;

            //2 zamaz

            kwadraciki_do_zamazania[0]=0;
            kwadraciki_do_zamazania[1]=1;
            kwadraciki_do_zamazania[2]=2;
            kwadraciki_do_zamazania[3]=3;
            kwadraciki_do_zamazania[4]=4;
            kwadraciki_do_zamazania[5]=7;
            kwadraciki_do_zamazania[6]=8;
            kwadraciki_do_zamazania[7]=11;


            zamaz(kwadraciki_do_zamazania,3);
        }

        if(obrot==true)   //kwadrat sie nie obraca xd
        {

        }

        if(obrot_wsteczny==true)
        {

        }

    }
}
