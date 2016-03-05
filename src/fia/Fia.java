
package fia;

import java.util.Vector;
import javax.swing.JLabel;

public class Fia extends javax.swing.JFrame implements Runnable 
{
//**************************************************************************
    // Variables declaration - do not modify                     

    private javax.swing.JLabel bateau;
    private javax.swing.JLabel chevreA;
    private javax.swing.JLabel chevreB;
    private javax.swing.JLabel chouA;
    private javax.swing.JLabel chouB;
    private javax.swing.JButton demarrer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel loupA;
    private javax.swing.JLabel loupB;                   
    private Thread t1;
    
    // End of variables declaration
    public Fia() 
    {
        initComponents();
     }

                          
    private void initComponents() 
    {

        chevreA = new javax.swing.JLabel();
        chouA = new javax.swing.JLabel();
        loupA = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chevreB = new javax.swing.JLabel();
        chouB = new javax.swing.JLabel();
        loupB = new javax.swing.JLabel();
        bateau = new javax.swing.JLabel();
        demarrer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        t1 = new Thread(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(100, 100, 1000, 700));
        getContentPane().setLayout(null);
        setBounds(50, 100, 1210, 530);
        setVisible(true);
        setResizable(false);
        
        chevreA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevreA.png"))); // NOI18N
        chevreA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(chevreA);
        chevreA.setBounds(1020, 340, 70, 90);

        chouA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chouA.png"))); // NOI18N
        chouA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(chouA);
        chouA.setBounds(920, 340, 90, 70);

        loupA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loupA.png"))); // NOI18N
        loupA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(loupA);
        loupA.setBounds(1100, 340, 95, 80);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 190, 0, 0);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 220, 0, 0);

        chevreB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chevreB.png"))); // NOI18N
        chevreB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(chevreB);
        chevreB.setBounds(90, 340, 80, 80);
        chevreB.setVisible(false);
        
        chouB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chouB.png"))); // NOI18N
        chouB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(chouB);
        chouB.setBounds(180, 350, 80, 80);
        chouB.setVisible(false);
        
        loupB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loupB.png"))); // NOI18N
        loupB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(loupB);
        loupB.setBounds(10, 350, 69, 70);
        loupB.setVisible(false);
        
        bateau.setBackground(new java.awt.Color(51, 51, 51));
        bateau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bergerVersB.png"))); // NOI18N
        bateau.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(bateau);
        bateau.setBounds(610, 340, 290, 150);

        demarrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dmarrer.png"))); // NOI18N
        demarrer.setBorder(null);
        demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Graph.afficher(Graph.aStar());
                demarrer.setVisible(false);
                t1.start();
            }
        });
        getContentPane().add(demarrer);
        demarrer.setBounds(500, 20, 220, 160);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plant.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1210, 500);

       
    }                       
   //**************************************************************************

    public void pause(int i) 
    {
        try 
        {
            t1.sleep(i);
        } catch (Exception e) {
            System.out.print("probleme:pause");
        }
    }
  //**************************************************************************

    public void translation(Etat e1, Etat e2) 
    {
        char pos = 'A';
        if (e1.loup != e2.loup) {
            loupA.setVisible(false);
            loupB.setVisible(false);
            if (e1.loup == 1) {
                bateau = modifierIcone(bateau, "loupVersA");
                pos = 'B';
            } else {
                bateau = modifierIcone(bateau, "loupVersB");
                pos = 'A';
            }
        } else if (e1.chevre != e2.chevre) {
            chevreA.setVisible(false);
            chevreB.setVisible(false);
            if (e1.chevre == 1) {
                bateau = modifierIcone(bateau, "chevreVersA");
                pos = 'B';
            } else {
                bateau = modifierIcone(bateau, "chevreVersB");
                pos = 'A';
            }
        } else if (e1.chou != e2.chou) {
            chouA.setVisible(false);
            chouB.setVisible(false);
            if (e1.chou == 1) {
                bateau = modifierIcone(bateau, "chouVersA");
                pos = 'B';
            } else {
                bateau = modifierIcone(bateau, "chouVersB");
                pos = 'A';
            }
        } else {
            if (e1.berger == 1) {
                bateau = modifierIcone(bateau, "bergerVersA");
                pos = 'B';
            } else {
                bateau = modifierIcone(bateau, "bergerVersB");
                pos = 'A';
            }

        }
        try {
            if (pos == 'B') {
                for (int i = 290; i <= 610; i++) {
                    bateau.setBounds(i, 340, 290, 150);
                    pause(30);
                }
            } else {
                for (int i = 610; i >= 290; i--) {
                    bateau.setBounds(i, 340, 290, 150);
                    pause(30);
                }
            }
        } catch (Exception e) {

        }
    }
    //**************************************************************************
   public void jouer(Vector v) 
    {
        pause(500);
        for (int i = 0; i < v.size() - 1; i++) 
        {
            Etat e1 = (Etat) v.elementAt(i);
            Etat e2 = (Etat) v.elementAt(i + 1);
            presentationEtat(e1);
            pause(1000);
            translation(e1, e2);
            pause(1000);
            presentationEtat(e2);
        }
    }
    //**************************************************************************
    public JLabel modifierIcone(JLabel l, String ch) 
    {
        l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/" + ch + ".png")));
        return l;
    }
   //**************************************************************************
    public void presentationEtat(Etat e) 
    {
        int loup = e.loup;
        int chevre = e.chevre;
        int chou = e.chou;
        int berger = e.berger;

        if (loup == 0) {
            loupA.setVisible(true);
            loupB.setVisible(false);
        } else {
            loupA.setVisible(false);
            loupB.setVisible(true);
        }
        if (chevre == 0) {
            chevreA.setVisible(true);
            chevreB.setVisible(false);
        } else {
            chevreA.setVisible(false);
            chevreB.setVisible(true);
        }
        if (chou == 0) {
            chouA.setVisible(true);
            chouB.setVisible(false);
        } else {
            chouA.setVisible(false);
            chouB.setVisible(true);
        }
        if (berger == 0) {
            bateau = modifierIcone(bateau, "bergerVersB");
        } else {
            bateau = modifierIcone(bateau, "bergerVersA");
        }

    }
    //**************************************************************************
    public void run() 
    {    
          jouer(Graph.aStar());
    }
   //**************************************************************************
    public static void main(String args[]) {

        Fia f = new Fia();
       

    }

}
