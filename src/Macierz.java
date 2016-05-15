/**
 * Created by KAMIL BIELSKI on 2016-05-08.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Macierz
{
    static int wysokosc;                                                        //wysokosc i szerokosc macierzy
    static int szerokosc;
    int[][] macierz;                                                     //na macierzy beda ustawiane obiekty bada mialy jakies wspolrzedne , po to wlasnie ta macierz
    /***************************************************************************************************************************************/

    Figura poli_figura = new Kwadrat();

    /*******************************GETTERY I SETTERY***************************************************************************************/

    public static int getWysokosc()
    {
        return wysokosc;
    }

    public static int getSzerokosc()
    {
        return szerokosc;
    }


    /****************************************
     * DO INICJACJI MACIERZY*************************************OPIS_FUNKCJI
     *************************/

    Macierz(int wwysokosc, int sszerokosc)                                                       //konstruktor dla Macierzy
    {

        wysokosc = wwysokosc;
        szerokosc = sszerokosc;
        macierz = new int[wysokosc][szerokosc];

        obrysujMacierz();                                                                     //tu utworzy kontury macierzy
    }

    public void obrysujMacierz()                                                                           //wypelnia wszytkie elementy zerami i obrysuwuje po bokach i od dołu , wstawia tam poprostu jedynki
    {
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j < szerokosc; j++) {
                macierz[i][j] = 0;
                if (j == 0 || j == szerokosc - 1 || i == wysokosc - 1)
                    macierz[i][j] = 1;                                                                //zero oznacza ze nic nie ma na tych wspolrzednych na macierz
            }
        }
    }

    public void wpiszFigureNaMacierz(Figura figura)
    {
        for (int i = 0; i < figura.wspolrzedne.length; i++)
            /*                         K                          W                          KOLOR   */
            macierz[figura.wspolrzedne[i][1]][figura.wspolrzedne[i][0]] = figura.wspolrzedne[i][2];             //uzupelniam odpowiednio macierz wspolrzednymi ze stworzonej figury
    }


    public void pokazMacierzNaEkranie() {
        JFrame ramka = new JFrame();    // tworze ramke(OKNO)
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //ustawiam zeby okienko sie wylaczylo po kliknieciu krzyzyka

        MojPanelRysunkowy panel = new MojPanelRysunkowy();      //tworze panel do rysowania, taka matryca poprostu wewnatrz ramki

        ramka.getContentPane().add(panel);                      //dodaje panel do okienka , teraz bedzie na czym rysowac xD
        ramka.setSize(500, 700);                                 //jaka wielkosc ramki zobaczymy na ekranie
        ramka.setVisible(true);                                 //pokazujemy ramke ramem z panelem


        //*******************************ANIMACJA***********************************************************************************
        for (int i = 0; i < 130; i++) {
            /*for (int k = 0; k < kwadrat.wspolrzedne.length; k++) {

                //kwadrat.wspolrzedne[k][1]++;                    //zwieksz wspolrzedne wierszowe kazdego z malych kwadracikow
            }*/




           poli_figura.ruch();
            wpiszFigureNaMacierz(poli_figura);



            panel.repaint();                                    //przerysowywuje panel, to zeby zachowac efekt animacji (bedzie sie przesuwac ten kwadracik)

            try {
                Thread.sleep(500);
            } catch (Exception ex) {
            }

        }
        //******************************KONIEC ANIMACJI**********************************************************************************

    }




    class MojPanelRysunkowy extends JPanel implements KeyListener
    {
        MojPanelRysunkowy()
        {
            addKeyListener(this);
            setFocusable(true);
        }




        public void paintComponent(Graphics g)
        {

            for (int i = 0; i < wysokosc; i++) {
                for (int j = 0; j < szerokosc; j++) {
                    if (macierz[i][j] == 1)                              // wtedy rysuj czerwony kwadracik
                    {
                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.red);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);
                    }


                    if (macierz[i][j] == 2)                              // wtedy rysuj zolty kwadracik
                    {
                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.yellow);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);

                        /*
                        g.setColor(Color.lightGray);                      //wyczyszczenie ekranu
                        g.fillRect((j) * 20, (i - 2) * 20, 20, 20);*/
                    }


                    if (macierz[i][j] == 3)                              // wtedy rysuj czerwony kwadracik
                    {
                        g.setColor(Color.black);
                        g.fillRect(j * 20, i * 20, 20, 20);
                        g.setColor(Color.WHITE);
                        g.fillRect(j * 20 + 2, i * 20 + 2, 16, 16);
                    }


                }
            }

        }

        /************************************STERWOANIE STRZALKAMI***************************************************************************/

        @Override
        public void keyTyped(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                System.out.println("Right key typed");
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                System.out.println("Left key typed");
            }
        }

        @Override
        public void keyPressed(KeyEvent e)
        {




        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                poli_figura.ruch_od_strzalek(false,true,false,false);
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                poli_figura.ruch_od_strzalek(true,false,false,false);
                repaint();
            }
        }

        /***************************************KONIEC STEROWANIA*******************************************************************************/
    }
}
