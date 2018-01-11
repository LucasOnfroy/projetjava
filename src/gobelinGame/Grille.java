package gobelinGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grille {

    public static void main(String[] args) {

        JFrame win=new JFrame(); // Cr�e la fenetre principale
        JPanel jp=(JPanel) win.getContentPane(); // R�cup�re le conteneur de la fen�tre
        final AffGrille jp2=new AffGrille(); // Cr�e une instance de la classe priv�e AffGrille
        jp2.addMouseMotionListener(new MouseMotionListener(){
            Polygon p;
            @Override
            public void mouseDragged(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseMoved(MouseEvent arg0) {
                p=jp2.pol;
                if(!p.contains(arg0.getPoint())){
                    jp2.repaint();
                }
            }

        });// Repeind jp2 lorsque la souris se déplace
        jp2.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent arg0) {
                super.mouseClicked(arg0);
                JOptionPane.showMessageDialog(null,"Hexagone n�:"+jp2.numero + " " + jp2.x + jp2.y + jp2.z);
            }

        });// Evenement qui survient au clicque
        jp.add(jp2);// Ajoute le composant à la fenêtre
        //win.setSize(640, 480); Ancienne dimension la fenetre
        win.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH); // Redimensionner la fenetre
        win.setVisible(true);// Affiche la fenetre

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Permet de quiter l'application à la fermeture de la fen�tre
    }

}
