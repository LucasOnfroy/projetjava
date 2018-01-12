package gobelinGame;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class AffGrille extends JPanel { // Classe personnelle qui cr�e une grile hexagonale.
  final static int cote=30; // Ceci d�finit la taille du c�t� d'un polygone
  int numero=0; // Retien le n� du polygone sur lequel est la souris
  int x=0;
  int y=0;
  int z=0;
  Polygon pol;

  private Image img;

  @Override
  public void paint(Graphics arg0) {
    Polygon p2=getPolygon(0, 0, cote); // Crée un hexagone
    Rectangle r=p2.getBounds(); // Récupère le plus petit rectangle // aux bord de la fen�tre dans lequel l'hexagone peut s'inscrire
    Point hovered=null;
    arg0.setColor(Color.black);
    super.paint(arg0);
    Graphics2D g2d;

    ImageIcon i= new ImageIcon(getClass().getResource("img/map.png"));
    img = i.getImage();

    g2d=(Graphics2D) arg0;
    //g2d.drawImage(img, x, 0, null);
    g2d.drawImage(img,0,0,1300,1000,null);
    BasicStroke bs1=new BasicStroke(1);// Permet de fixer l'�paisseur du trait dans la suite
    BasicStroke bs2=new BasicStroke(2);// Idem
    BasicStroke bs3=new BasicStroke(3);// Idem
    BasicStroke bs4=new BasicStroke(4);// Idem
    BasicStroke bs5=new BasicStroke(5);// Idem

    g2d.setStroke(bs1);


    for(int l=0;l<30;l=l+2){// Remarquer le "+2" car la grille est constituée de 2 sous grilles (les lignes impaires sont d��call�es)
      for(int c=0;c<30;c++){
        Point p;
        p=getMousePosition();
        Polygon poly=getPolygon(c*r.width, (int)(l*cote*1.5),cote);
        if(p!=null && poly.contains(p)){
          hovered=new Point(c*r.width, (int)(l*cote*1.5));
          numero=l*10+c;
          x=c;
          y=-c;
          z=l;
          pol=poly;
        }
        g2d.draw(poly);
      }
    }
    for(int l=1;l<30;l=l+2){
      for(int c=0;c<30;c++)
      {
        Point p;
        p=getMousePosition();
        Polygon poly=getPolygon(c*r.width+r.width/2,  (int)(l*cote*1.5+0.5),cote);
        //arg0.setColor(Color.black);
        if(p!=null && poly.contains(p)){
          hovered=new Point(c*r.width+r.width/2,  (int)(l*cote*1.5+0.5));
          numero=l*10+c;
          x = c;
          y = -c;
          z = l;
          pol=poly;
        }
        g2d.draw(poly);
      }
    }
    if(hovered!=null){
      Polygon p=getPolygon(hovered.x, hovered.y,cote);

      g2d.setStroke(bs3);
      arg0.setColor(Color.orange);

      Polygon v1=getPolygon(hovered.x+(2*cote-8), hovered.y,cote);
      g2d.draw(v1);
      Polygon v2=getPolygon(hovered.x-(2*cote-8), hovered.y,cote);
      g2d.draw(v2);
      Polygon v3=getPolygon(hovered.x+cote-4, hovered.y+(cote+14),cote);
      g2d.draw(v3);
      Polygon v4=getPolygon(hovered.x-cote+4, hovered.y-(cote+14),cote);
      g2d.draw(v4);
      Polygon v5=getPolygon(hovered.x+cote-4, hovered.y-(cote+12),cote);
      g2d.draw(v5);
      Polygon v6=getPolygon(hovered.x-cote+4, hovered.y+(cote+12),cote);
      g2d.draw(v6);

      arg0.setColor(Color.red);
      g2d.setStroke(bs4);
      g2d.fill(p);
      //g2d.draw(p);

    }
  }

  public Polygon getPolHover(){
    return pol;
  }


  public static Polygon getPolygon(int x,int y,int cote){// Forme le polygone
    int haut=cote/2;
    int larg=(int)(cote*(Math.sqrt(3)/2));
    Polygon p=new Polygon();
    p.addPoint(x,y+haut);
    p.addPoint(x+larg,y);
    p.addPoint(x+2*larg,y+haut);
    p.addPoint(x+2*larg,y+(int)(1.5*cote));
    p.addPoint(x+larg,y+2*cote);
    p.addPoint(x,y+(int)(1.5*cote));
    return p;
  }
}

