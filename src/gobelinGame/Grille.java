package gobelinGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grille {

    public static void main(String[] args) {

        GameMenu gamemenu = new GameMenu();

        JFrame win=new JFrame(); // Crée la fenetre principale
        JPanel jp=(JPanel) win.getContentPane(); // Récupère le conteneur de la fenêtre
        final AffGrille jp2=new AffGrille(); // Crée une instance de la classe privée AffGrille
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
                    jp2.repaint(); // Repeins jp2 lorsque la souris se déplace
                }
            }
        });
        jp2.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent arg0) {
                super.mouseClicked(arg0);
                JOptionPane.showMessageDialog(null,"Hexagone n°:"+jp2.numero + "\n" +  " x=" + jp2.x + "\n" + " y=" + jp2.y +  "\n" + " z=" + jp2.z);
            }

        });// Evenement qui survient au clic
        jp.add(jp2);// Ajoute le composant à la fenêtres
        //win.setSize(640, 480); Ancienne dimension la fenetre
        win.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH); // Redimensionner la fenetre
        win.setVisible(true);// Affiche la fenetre

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Permet de quiter l'application à la fermeture de la fenêtre
    }

}
