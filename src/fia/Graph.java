
package fia;

import java.util.Collections;
import java.util.Vector;

public class Graph 
{
   Etat[] etat;
    public Graph() 
    {
        etat=new Etat[15];
        Etat a=new Etat('A',0, 0, 0, 0, 30,  4,0);
        a.parent=null;
        
        
        Etat b = new Etat('B',1, 0, 0, 1, 30,  1,100);
        Etat c = new Etat('C',0, 1, 0, 1, 30, 1, 100);
        Etat d = new Etat('D',0, 0, 1, 1, 10,  1, 100);
        Etat e = new Etat('E',0, 0, 0, 1, 30, 0, 100);
        
        Etat f = new Etat('F',1, 0, 0, 0, 7, 2, 100);
        Etat g = new Etat('G',0, 1, 0, 0, 7,  2, 100);
        Etat h = new Etat('H',0, 0, 1, 0, 7,  2, 100);
        
        Etat i = new Etat('I',0, 1, 1, 1, 11, 2, 100);
        Etat j = new Etat('J',1, 1, 0, 1, 2,  1, 100);
        Etat k = new Etat('K',1, 0, 1, 1, 5, 2, 100);
        
        Etat l = new Etat('L',0, 1, 1, 0, 20,  1, 100);
        Etat m = new Etat('M',1, 1, 0, 0, 1,  1, 100);
        Etat n = new Etat('N',1, 0, 1, 0, 20, 1, 100); 
        
        Etat o = new Etat('O',1, 1, 1, 1, 0,  0, 100);
        
        a.addFils(b);
        a.addFils(c);
        a.addFils(d);
        a.addFils(e);
        
        b.addFils(f);
        c.addFils(g);
        d.addFils(h);
        
        f.addFils(j);
        f.addFils(k);
        
        g.addFils(j);
        g.addFils(i);
        
        h.addFils(k);
        h.addFils(i);
        
        k.addFils(n);
        k.addFils(f);
        
        j.addFils(m);
        
        i.addFils(l);
        i.addFils(g);
        
        n.addFils(o);
        m.addFils(o);
        l.addFils(o);
        
        etat[0]=a;
        etat[1] = b;
        etat[2] = c;
        etat[3] = d;
        etat[4] = e;
        etat[5] = f;
        etat[6] = g;
        etat[7] = h;
        etat[8] = i;
        etat[9] = j;
        etat[10] = k;
        etat[11] = l;
        etat[12] = m;
        etat[13] = n;
        etat[14] = o;
        
    }  
 //******************************************************************   
    public static Etat minimum (Vector<Etat> v)
    {int min=0;
      if(v.size()>=1)
      {
            
            for(int i=1;i<v.size();i++)
            {
              if(v.elementAt(min).f>v.elementAt(i).f)
                  min=i;
            }    

      }
        return v.elementAt(min); 
    }
    //******************************************************************
    public static void explorer(Etat z,Vector ouvert,Vector fermet) 
    {
      
       if(z.nbrFils>0)
       {
                    for(int i=0;i<z.nbrFils;i++)
                   {
                                Etat y= z.fils[i]; 
                                //y.afficher();
                          if(y.estValide())
                          {
                               if(fermet.contains(y))
                               {
                                            if(z.d+1<y.d)
                                            {
                                            y.parent=z;
                                            y.setD(z.d+1);
                                            ouvert.addElement(y);
                                            fermet.removeElement(y);
                                            }
                               }   
                               else   
                               {
                                    if(ouvert.contains(y))         
                                    {
                                             if (z.d + 1 < y.d) 
                                            {
                                                y.parent = z;
                                                y.setD(z.d + 1);
                                            }
                                    }
                                 
                                    else
                                    {
                                            ouvert.addElement(y);
                                            y.parent=z;
                                            y.setD(z.d + 1);
                                     }

                               }
              }
                   }
    }
    }
   
    //****************************************************************** 
    public static Vector aStar() 
    {

        Graph g = new Graph();
        Vector fermet = new Vector();
        Vector ouvert = new Vector();
        Etat pos = g.etat[0];
        ouvert.addElement(pos);

        do {
            Etat e;
            e = minimum(ouvert);

            //e.afficher();
            fermet.addElement(e);
            explorer(e, ouvert, fermet);
            ouvert.removeElement(e);
        } 
        while (!Etat.verifFinal(fermet));
        System.out.print("***************************************");
        return fermet;

    }
 //****************************************************************** 
  public static void afficher(Vector v)
  {
  for(int i=0;i<v.size();i++)
  {
      Etat a= (Etat) v.elementAt(i);
      a.afficher();
  
  }
  
  }
    
    
    
}
