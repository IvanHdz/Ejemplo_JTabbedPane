import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class JTabbedPaneGUI extends JFrame{
    JTabbedPane pVista;   // Panel con vistas
    JPanel []   paneles;  // Paneles para vistas
    Container   c;        // Contenedor
    JButton       b1;       // Un botón
    JToggleButton b2;       // Un botón de palanca o interruptor 
    JSlider       s1;       // Barra deslizable
    JSlider       s2;
    JList         lista1;   // Lista de objetos
    JTable        tabla1;   // Una tabla

    public JTabbedPaneGUI(){
        super("Viruz Blog: Primer JTabbedPane");
        setSize(450,450);
        setBackground(Color.cyan);
        c = getContentPane();
        construirPaneles();
        construirPanelConBotones();
        construirPanelConBarras();
        construirPanelConListas();
        construirPanelConTablas();
    }

    private void construirPaneles(){
        pVista  = new JTabbedPane();
        paneles = new  JPanel[4];
        String [] etiqueta = {"Botones","Barras","Listas","Tabla"};
        String [] mensajes = {"Panel con Botones","Barras de control",
                              "Lista de Iconos","Una tabla"};
        Border bordes[] = {BorderFactory.createMatteBorder(2, 3, 2, 3, Color.orange),
        BorderFactory.createEmptyBorder(4, 3, 4, 3),
        BorderFactory.createBevelBorder(6),
        BorderFactory.createCompoundBorder(new TitledBorder (mensajes[3]),
        BorderFactory.createRaisedBevelBorder())};
        
        for(int i=0;i<4;i++){
           paneles[i] = new JPanel();
           paneles[i].setBackground(Color.lightGray);
           paneles[i].setBorder(bordes[i]);
           //paneles[i].setBorder(new TitledBorder(mensajes[i]));
            //agrega El Panel con vistas (etiquetas,iconos,Panel,mensaje en cada pestaña)
           pVista.addTab(etiqueta[i], null, paneles[i], mensajes[i]);
        }
        
        for(int i=1;i<4;i++){
           paneles[i].setBackground(Color.ORANGE);
           paneles[i].setBorder(bordes[i]);
           paneles[i].setBorder(new TitledBorder(mensajes[i]));
           pVista.addTab(etiqueta[i],null,paneles[i],mensajes[i]);
        }
        
        for(int i=2;i<4;i++){
           paneles[i].setBackground(Color.red);
           paneles[i].setBorder(bordes[i]);
           paneles[i].setBorder(new TitledBorder (mensajes[i]));
           pVista.addTab(etiqueta[i],null,paneles[i],mensajes[i]);
        }
        
        for(int i=3;i<4;i++){
           paneles[i].setBackground(Color.GREEN);
           paneles[i].setBorder(bordes[i]);
           paneles[i].setBorder(new TitledBorder(mensajes[i]));
           pVista.addTab(etiqueta[i],null,paneles[i],mensajes[i]);
        }
        
        c.add(pVista,"Center");
    }
    
    private void construirPanelConBotones(){
         b1 = new JButton("Imprimir",new ImageIcon("24.gif"));
         b2 = new JToggleButton("Otro botón");
         paneles[0].setLayout(new BorderLayout());
         paneles[0].add(b1,BorderLayout.NORTH);
         paneles[0].add(b2,BorderLayout.SOUTH);   
    }
    
    private void construirPanelConBarras(){
        s1 = new JSlider(JSlider.VERTICAL, 0,100,50);
        s1.setMajorTickSpacing(10);
        s1.setMinorTickSpacing(5);
        s1.setPaintTicks(true);

        s2 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        s2.setMajorTickSpacing(10);
        s2.setMinorTickSpacing(5);
        s2.setPaintTicks(true);
        
        paneles[1].setLayout(new GridLayout(3,3,5,5));
        paneles[1].add(new JLabel("Barra deslizante vertical"));
        paneles[1].add(s1);
        paneles[1].add(new JLabel("Barra deslizante horizontal"));
        paneles[1].add(s2);
     }
    
     private void construirPanelConListas(){
        ImageIcon [] imagenes = {new ImageIcon("leaf1.gif"),
                                 new ImageIcon("24.gif"),
                                 new ImageIcon("leaf3.gif")};
        lista1 = new JList(imagenes);
        paneles[2].add(lista1);
     }
       
     private void construirPanelConTablas(){
        String titulos[] = {"Num. de Control","Nombre","Carrera"};
        Object celdas[][] = { titulos,
                              {"3456","Pedro Perez", "Sistemas"},
                              {"1243","Luisa López", "Industrial"},
                              {"2312","Carlos Cruz", "Mecanica"},
                            };
        
        tabla1 = new JTable(celdas,titulos);
        paneles[3].add(tabla1);
     }
}