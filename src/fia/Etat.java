package fia;

import java.util.Vector;

public class Etat 
{

    public int chou;
    public int loup;
    public int chevre;
    public int h;
    public int d;
    public int berger;
    public int nbrFils;
    public Etat[] fils;
    public int i;
    public Etat parent ;
    public int f;
    public char symbole;
    
    public Etat(char s,int chou, int loup, int chevre, int berger, int h,int nbrFils,int d) 
    {
        this.chou = chou;
        this.loup = loup;
        this.chevre = chevre;
        this.berger = berger;
        this.h = h;
        this.nbrFils = nbrFils;
        this.fils=new Etat[nbrFils];
        i=0;
        this.d=d;
        this.f=h+d;
        this.parent = this;
    }

    public void setD(int d){this.d=d;this.f=h+d;}
    public int getD(int d) {return d;}  
    
    public boolean estValide()
    {
    if(chou==chevre && chou!=berger) return false;
        if (loup == chevre && loup != berger) {
            return false;
        }
        return true;
    }
   
    public static boolean verifFinal(Vector tab)
    {
        for(int i=0;i<tab.size();i++)
        { Etat a=(Etat)tab.elementAt(i);
          if(a.h==0)return true;
        }
        return false;
    }

    public void addFils(Etat a) 
    {
        if(i<nbrFils){fils[i] =a;i++;}
    }

    
    public void afficher() {
        System.out.println("chevre :" + chevre);
        System.out.println("chou :" + chou);
        System.out.println("loup :" + loup);
        System.out.println("berger :" + berger);
        System.out.println("distance :" + d);
        System.out.println("fonction :" + f);
        System.out.println("***************************************");
    }

   
}
