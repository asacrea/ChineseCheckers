/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package damas;

/**
 *
 * @author jonathaneidelman
 */

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.applet.Applet;

public class InterfazPrincipal extends JFrame implements ActionListener{
        JButton[][] m1;// SE DECLARA m1 COMO UNA REFERENCIA A UN OBJETO DE LA CLASE MATRIZESTUDIANTES
	JButton b1,b2;
	MyCanvas imagen;//CONTENEDOR PARA PINTAR LA MATRIZ
	JScrollPane panel;// OBJETO UTILIZADO PARA MOSTRAR LA IMAGEN Y ASIGNAR BARRAS SI LO REQUIERE
        ImageIcon fichaBlanca;
        ImageIcon fichaNegra;
 	public InterfazPrincipal()
	{
             fichaBlanca = new ImageIcon ("fichaBlanca.jpg");
             fichaNegra = new ImageIcon ("fichaNegra.jpg");
             setTitle("Damas Chinas");
	     b1 = new JButton("Mayores de edad"); // PARA CREAR EL BOTON
	     getContentPane().add(b1);  // PARA ADICIONAR EL BOTON AL CONTENEDOR
	     b1.reshape(50,430,200,30); // PARA PINTAR EL BOTON
	     b1.addActionListener(this);// PARA QUE EL BOTON NOTIFIQUE CUANDO LO OPRIMEN
	     b2 = new JButton("Notas ganadas"); // PARA CREAR EL BOTON
	     getContentPane().add(b2);  // PARA ADICIONAR EL BOTON AL CONTENEDOR
	     b2.reshape(260,430,200,30); // PARA PINTAR EL BOTON
	     b2.addActionListener(this);// PARA QUE EL BOTON NOTIFIQUE CUANDO LO OPRIMEN
	    //*************************************************
  		// SE CREA LA MATRIZ DE ESTUDIANTE Y SE INSERTA  *
  		// UN ESTUDIANTES EN CADA UNA DE SUS POSICIONES  *
  		//*************************************************
 		m1 = new JButton[8][8];
  		IniciarTablero();
 		//*************************************************
  		// SE CREA UN OBJETO DE LA CLASE MYCANVAS         *
  		// SE ENCARGAR� DE PINTAR LA ESTRUCTURA           *
  		//*************************************************
 	    imagen = new MyCanvas(m1);
 		//*************************************************
  		// SE CREA EL JSCROLPANE Y SE MANDA COMO PARAMETRO*
  		// LA IMAGEN DONDE SE PINTAR� LA ESTRUCTURA       *
  		//*************************************************
	    panel= new JScrollPane(imagen);
		//*************************************************
  		// PARA QUE EL JSCROLLPANE MUESTRE SIEMPRE LAS DOS*
  		// BARRAS DE DESPLAZAMIENTO                       *
  		//*************************************************
   		panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//*************************************************
  		// SE ADICIONA EL PANE Y SE PINTA EN LA POSICION  *
  		// DESEADA                                        *
  		//*************************************************
    	getContentPane().add(panel);
    	getContentPane().setLayout(null);
    	panel.reshape(10,10,1180,400);
    	setResizable(false);
	    resize(1200,600);  // PARA DAR LAS DIMENSIONES A LA VENTANA
	    show(); // PARA QUE LA VENTANA SE MUESTRE
		// PARA CONTROLAR CUANDO EL USUARIO CIERRE LA VENTANA
		// Y SE TERMINE LA APLICACION
	    addWindowListener(
	   	    new WindowAdapter()
	   	    {
  				public void windowClosing(WindowEvent we)
  				{
    				System.exit(0);
  			    }
            }
       );

	}
	public void actionPerformed(ActionEvent e)
	{
		String entrada;
 		//*************************************************
  		// SI OPRIMEN EL BOTON B1                         *
   		//*************************************************
		if(e.getSource()== b1)
		{
			// PARA QUE SE ASIGNE EL COLOR AMARILLO A LOS 
			// ESTUDIANTES MAYORES DE EDAD
			m1.pintarMayoresDeEdad(Color.yellow);
			repaint();// PARA QUE SE PINTE m1 CON LOS COLORES VIGENTES
			String r = m1.mayoresDeEdad();// PARA RECIBIR UNA CADENA CON LOS DATOS DE LOS MAYORES DE EDAD
			// SE MUESTRA LA CADENA EN UN CUADRO DE DIALOGO, ESTE CUADRO ES MODAL,
			// HASTA QUE EL CUADRO NO SE CIERRE NO SE SIGUE CON LAS INSTRUCCIONES
			// SIGUIENTES
			JOptionPane.showMessageDialog(this,r);
			// CUANDO SE CIERRE EL CUADRO SE LIMPIA LA ESTRUCTURA Y SE PINTA NUEVAMENTE
			m1.limpiar();
			repaint();

		}
		if(e.getSource()== b2)
		{
			m1.pintarNotasGanadas(Color.green);
			repaint();
			String r = m1.notasGanadas();
			JOptionPane.showMessageDialog(this,r);
			m1.limpiar();
			repaint();
		}
	}
  	//*************************************************
  	// METODO PRINCIPAL DEL PROGRAMA                  *
  	//*************************************************
	public static void main(String args[])
	{
		InterfazPrincipal x ;
		x = new InterfazPrincipal();
	}

    private void IniciarTablero() {
        //hay que poner background cafe y otro color.
        
        m1[7][0].setIcon(fichaBlanca);
        m1[7][2].setIcon(fichaBlanca);
        m1[7][4].setIcon(fichaBlanca);
        m1[7][6].setIcon(fichaBlanca);
        m1[6][1].setIcon(fichaBlanca);
        m1[6][3].setIcon(fichaBlanca);
        m1[6][5].setIcon(fichaBlanca);
        m1[6][7].setIcon(fichaBlanca);
        m1[5][0].setIcon(fichaBlanca);
        m1[5][2].setIcon(fichaBlanca);
        m1[5][4].setIcon(fichaBlanca);
        m1[5][6].setIcon(fichaBlanca);
        
        m1[0][0].setIcon(fichaNegra);
        m1[0][2].setIcon(fichaNegra);
        m1[0][4].setIcon(fichaNegra);
        m1[0][6].setIcon(fichaNegra);
        m1[1][1].setIcon(fichaNegra);
        m1[1][3].setIcon(fichaNegra);
        m1[1][5].setIcon(fichaNegra);
        m1[1][7].setIcon(fichaNegra);
        m1[2][0].setIcon(fichaNegra);
        m1[2][2].setIcon(fichaNegra);
        m1[2][4].setIcon(fichaNegra);
        m1[2][6].setIcon(fichaNegra);
    }
  	//*************************************************
  	// CLASE ENCARGADA DE PINTAR LA  MATRIZ           *
  	//*************************************************
 	class MyCanvas extends JComponent
	 {
		 MatrizEstudiantes L;
  		//*************************************************
  		// CONSTRUCTOR QUE RECIBE LA REFERENCIA A UN OBJETO*
  		// DE LA CLASE MATRIZESTUDIANTE Y LO ASIGNA A L, 
  		// DE ESTA MANERA TODOS LOS METODOS
  		// DE LA CLASE PUEDEN MANIPULAR ESTE OBJETO
  	    //*************************************************
 		 public MyCanvas( MatrizEstudiantes L)
		 {
			 this.L= L;
			 resize(800,1500);// SE LE DA TAMA�O A LA IMAGEN
		 }
 		//*************************************************
  		// METODO QUE SE LLAMA AUTOMATICAMENTE CADA VEZ   *
  		// EL USUARIO CAMBIE LAS DIMENSIONES DEL MARCO    *
  		// O EL MARCO SEA TAPADO POR OTRO OBJETO          *
   		//*************************************************
		 public void paint(Graphics g)
		 {
		 	super.paint(g);
			g.setColor(Color.white);
			g.fillRect(0,0,this.getSize().width,this.getSize().height);
			if( L != null)
			{
				L.pintar(g,20,30  );
			}
		}
 		//*************************************************
  		// METODO QUE REGRESA LAS DIMENSIONES NECESARIAS  *
  		// PARA QUE EL SCROLLPANE PUEDA DESLIZAR LA IMAGEN*
   		//*************************************************
	    public Dimension getPreferredSize()
		{
			return new Dimension(this.getSize().width,this.getSize().height);
		}
    }
}
