import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.text.html.Option;

public class QuienEsQuienEstructura  extends JFrame implements ListSelectionListener, ActionListener{

	
	private static final long serialVersionUID = 1L;
	
	//Menu
	
	private JMenuBar menu;	
	
	private JMenu menuJuego;
	
	private JMenuItem acercaDe;
	
	private JMenuItem reiniciar;
	
	private JMenuItem salir;
	
	//Persona que hay que adivinar
	Persona personaAdivinar;
	
	//Array de botones 
	final int longitudArray = 18;
	
	//Array de botones 
	JButton [] botones = new JButton [longitudArray];
	
	//Array de personas
	Persona arrayPersonas[];
	
	
	//Persona [] personas = new Personas [longitudArray];
	int personajeAleatorio = generarPersonajeAleatorio();
	
	JSplitPane splitPaneHorizontal;
	
	/* IMAGENES */
	ImageIcon imagenPersonaje;
	
	/* PANELES DE LA APLICACION */
	
	/* Acerca de */
	File informacionPdf;
		
	
	/* PANEL PRINCIPAL */
	//Panel principal 
	JPanel panelPrincipal;
	
	//Panel de las caracteristicas
	JPanel panelAtributos;
	
	//Lista de atributos que se pueden seleccionar 
	JList listaAtributos;
	
	//Lista que almacena el atributo seleccionado
	
	JList guardaAtributo;
	
	//Array JButton
	
	JButton[] arrayBotones = new JButton [18];
	
	
	/*JBUTTONS */
	JButton botonAdam;
	JButton botonBrenda;
	JButton botonCharlie;
	JButton botonDavid;
	JButton botonDenise;
	JButton botonFrank;
	JButton botonGiselle;
	JButton botonHeidi;
	JButton botonKathy;
	JButton botonKevin;
	JButton botonLucas;
	JButton botonMatthew;
	JButton botonPetra;
	JButton botonRaymond;
	JButton botonSophia;
	JButton botonSteven;
	JButton botonTamsin;
	JButton botonYvette;
	
	
	/*COMPONENTES  PANEL ATRIBUTOS  */
	//JButton Atributos
	JButton botonAtributo;

	
	//Campo de texto que contiene el número de preguntas hechas
	JTextField preguntasHechas;
	
	JLabel etiquetaPersonaje;
	
	//Numero de preguntas hechas
	int numPreguntas;
	
	//Atributos
	String[] atributos = {"Hombre", "Mujer", "Tiene gafas", "Tiene sombrero",
						  "Tiene Barba","Tiene Bigote", 
						   "Pelo Moreno", "Pelo Negro", "Pelo Rubio", "Calvo", 
						   "Ojos Marrones", "Ojos Verdes", "Ojos Azules","Piel Clara"};
	
	
	String[] nombres = {"Adam", "Brenda", "Charlie", "David", "Denise", "Frank", 
								  "Giselle", "Heidi", "Kathy", "Kevin", "Lucas", "Matthew", 
								  "Petra", "Raymond", "Sophia", "Steven", "Tamsin", "Yvette"};
	
	//Variables caracteristicas
	
	int numColumna=0;
	String caracteristica="";
	
	
	
	/*RANKING JUGADORES*/
	int longitudNombreJugador;
	JTextField nombreJugador;

	
	
	public void jMenuBar(){
		
		menu = new JMenuBar();
		
		menuJuego = new JMenu("Juego");
		
		menuJuego.addActionListener(this);
		
		acercaDe = new JMenuItem("Acerca de...");
		
		acercaDe.addActionListener(this);
		
		reiniciar = new JMenuItem("Reiniciar");
		
		reiniciar.addActionListener(this);
		
		salir = new JMenuItem("Salir");
		
		salir.addActionListener(this);
		
		//Añadimos el menu a JMenuBar
		
		setJMenuBar(menu);	
		
		//Añadimos los submenus al JMenuBar
		
		menu.add(menuJuego);
		
		menuJuego.add(acercaDe);
		
		menuJuego.add(reiniciar);
		
		menuJuego.add(salir);
		
		
	}
	
	
	public void crearPanelPrincipal(){
		
		
		panelPrincipal = new JPanel();
		
		setLayout(new BorderLayout());
		panelPrincipal.setLayout(new GridLayout(3,6));
		
		
		/* BOTONES E IMAGENES */
		//Creamos los botones y las imagenes que van a contener estos 
		ImageIcon adam = new ImageIcon("img/Adam.jpg");
		botonAdam = new JButton();
		botonAdam.addActionListener(this);
		arrayBotones[0] = botonAdam;
		botonAdam.setIcon(adam);
		
		ImageIcon brenda = new ImageIcon("img/Brenda.jpg");
		botonBrenda = new JButton();
		botonBrenda.addActionListener(this);
		arrayBotones[1] = botonBrenda;
		botonBrenda.setIcon(brenda);
		
		
		ImageIcon charlie = new ImageIcon("img/Charlie.jpg");
		botonCharlie = new JButton();
		botonCharlie.addActionListener(this);
		arrayBotones[2] = botonCharlie;
		botonCharlie.setIcon(charlie);
		
		
		ImageIcon david = new ImageIcon("img/David.jpg");
		botonDavid = new JButton();
		botonDavid.addActionListener(this);
		arrayBotones[3] = botonDavid;
		botonDavid.setIcon(david);
		
		
		ImageIcon denise = new ImageIcon("img/Denise.jpg");
		botonDenise = new JButton();
		botonDenise.addActionListener(this);
		arrayBotones[4] = botonDenise;
		botonDenise.setIcon(denise);
		
		ImageIcon frank = new ImageIcon("img/Frank.jpg");
		botonFrank = new JButton();
		botonFrank.addActionListener(this);
		arrayBotones[5] = botonFrank;
		botonFrank.setIcon(frank);
		
		ImageIcon giselle = new ImageIcon("img/Giselle.jpg");
		botonGiselle = new JButton();
		botonGiselle.addActionListener(this);
		arrayBotones[6] = botonGiselle;
		botonGiselle.setIcon(giselle);
		
		ImageIcon heidi = new ImageIcon("img/Heidi.jpg");
		botonHeidi = new JButton();
		botonHeidi.addActionListener(this);
		arrayBotones[7] = botonHeidi;
		botonHeidi.setIcon(heidi);
		
		ImageIcon kathy = new ImageIcon("img/Kathy.jpg");
		botonKathy = new JButton();
		botonKathy.addActionListener(this);
		arrayBotones[8] = botonKathy;
		botonKathy.setIcon(kathy);
		
		ImageIcon kevin = new ImageIcon("img/Kevin.jpg");
		botonKevin = new JButton();
		botonKevin.addActionListener(this);
		arrayBotones[9] = botonKevin;
		botonKevin.setIcon(kevin);
		
		ImageIcon lucas = new ImageIcon("img/Lucas.jpg");
		botonLucas = new JButton();
		botonLucas.addActionListener(this);
		arrayBotones[10] = botonLucas;
		botonLucas.setIcon(lucas);
		
		ImageIcon matthew = new ImageIcon("img/Matthew.jpg");
		botonMatthew = new JButton();
		botonMatthew.addActionListener(this);
		arrayBotones[11] = botonMatthew;
		botonMatthew.setIcon(matthew);
		
		ImageIcon petra = new ImageIcon("img/Petra.jpg");
		botonPetra = new JButton();
		botonPetra.addActionListener(this);
		arrayBotones[12] = botonPetra;
		botonPetra.setIcon(petra);
		
		ImageIcon raymond = new ImageIcon("img/Raymond.jpg");
		botonRaymond = new JButton();
		botonRaymond.addActionListener(this);
		arrayBotones[13] = botonRaymond;
		botonRaymond.setIcon(raymond);
		
		ImageIcon sophia = new ImageIcon("img/Sophia.jpg");
		botonSophia = new JButton();
		botonSophia.addActionListener(this);
		arrayBotones[14] = botonSophia;
		botonSophia.setIcon(sophia);
		
		ImageIcon steven = new ImageIcon("img/Steven.jpg");
		botonSteven = new JButton();
		botonSteven.addActionListener(this);
		arrayBotones[15] = botonSteven;
		botonSteven.setIcon(steven);
		
		ImageIcon tamsin = new ImageIcon("img/Tamsin.jpg");
		botonTamsin = new JButton();
		botonTamsin.addActionListener(this);
		arrayBotones[16] = botonTamsin;
		botonTamsin.setIcon(tamsin);
		
		ImageIcon yvette = new ImageIcon("img/Yvette.jpg");
		botonYvette = new JButton();
		botonYvette.addActionListener(this);
		arrayBotones[17] = botonYvette;
		botonYvette.setIcon(yvette);
		
		/*AÑADIMOS LOS BOTONES AL JPANEL PRINCIPAL*/
		panelPrincipal.add(botonAdam);
		panelPrincipal.add(botonBrenda);
		panelPrincipal.add(botonCharlie);
		panelPrincipal.add(botonDavid);
		panelPrincipal.add(botonDenise);
		panelPrincipal.add(botonFrank);
		panelPrincipal.add(botonGiselle);
		panelPrincipal.add(botonHeidi);
		panelPrincipal.add(botonKathy);
		panelPrincipal.add(botonKevin);
		panelPrincipal.add(botonLucas);
		panelPrincipal.add(botonMatthew);
		panelPrincipal.add(botonPetra);
		panelPrincipal.add(botonRaymond);
		panelPrincipal.add(botonSteven);
		panelPrincipal.add(botonSophia);
		panelPrincipal.add(botonTamsin);
		panelPrincipal.add(botonYvette);
		
		add(panelPrincipal);
		
		}
	
	
	public void crearPanelAtributos(){
		
		
		panelAtributos = new JPanel();
		
		imagenPersonaje = new ImageIcon("img/guessWho.jpg");
		
		etiquetaPersonaje =  new JLabel();
		
		etiquetaPersonaje.setIcon(imagenPersonaje);

		panelAtributos.add(etiquetaPersonaje);
		
		//instanciamos la lista
		listaAtributos = new JList(atributos);
		//Tipo de  seleccion que podemos realizar en este caso solo podemos elegir un atributo 
		listaAtributos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		
		botonAtributo = new JButton("Seleccionar Atributo");
		
		botonAtributo.addActionListener(this);
		
	
		
		
		//Centrar los componentes 
		panelAtributos.setLayout(new BoxLayout(panelAtributos,BoxLayout.PAGE_AXIS));
		etiquetaPersonaje.setAlignmentX(Component.CENTER_ALIGNMENT);
		listaAtributos.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonAtributo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	
		
		//Puntuacion 
		
		
		//Añadimos los componentes al JPanel Atributos
		panelAtributos.add(listaAtributos);
		panelAtributos.add(botonAtributo);
	

		
		add(panelAtributos);
		
		
	}
	
	public void crearSplitPane (JPanel panel1, JPanel panel2){
		
		splitPaneHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1,panel2);
		add(splitPaneHorizontal);
		
	}	
	
	/* CONSTRUCTOR PRINCIPAL DEL JUEGO Y CARACTERISTICAS DEL JFRAME  */
	public QuienEsQuienEstructura() throws IOException{

			jMenuBar();
			crearPanelPrincipal();
			crearPanelAtributos();
			crearSplitPane(panelPrincipal, panelAtributos);
			
			//Propiedades del JFrame
			setTitle("¿Quien es Quien?");
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension dim=super.getToolkit().getScreenSize();
	        super.setSize(dim);
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		guardaAtributo = (JList)e.getSource();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		arrayPersonas=crearArray();
		
		int numBoton=0;
		boolean resultado=false;
		
		if ((e.getSource()==botonAdam)){
			
			numBoton = 0;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonBrenda)){
			
			numBoton = 1;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonCharlie)){
				
			numBoton = 2;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonDavid)){
			
			numBoton = 3;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonDenise)){
			
			numBoton = 4;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonFrank)){
			
			numBoton =5;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonGiselle)){
			
			numBoton = 6;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonHeidi)){
			
			numBoton = 7;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);			
			
		}
		
		else if ((e.getSource()==botonKathy)){
			
			numBoton = 8;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonKevin)){
			
			numBoton = 9;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonLucas)){
			
			numBoton = 10;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonMatthew)){
			
			numBoton = 11;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonPetra)){
			
			numBoton = 12;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonRaymond)){
			
			numBoton = 13;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonSophia)){
			
			numBoton = 14;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonSteven)){
			
			numBoton = 15;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonTamsin)){
			
			numBoton = 16;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		else if ((e.getSource()==botonYvette)){
			
			numBoton = 17;
			resultado = arrayPersonas[numBoton].compruebaPersona(numBoton, personajeAleatorio);
			comprobarBoton(resultado,numBoton,arrayPersonas);
			
		}
		
		
		else if(e.getSource()==reiniciar){
			
			reiniciarPartida(arrayBotones);
		}
		
		else if(e.getSource()==salir){
			
			System.exit(0);
			
		}
		
		else if(e.getSource()==botonAtributo){
			
			int num = listaAtributos.getSelectedIndex();
			conversor(num);
			System.out.println("numComuna: "+numColumna);
			System.out.println("caracteristica: "+caracteristica);
			caracteristicasFisicas(numColumna, caracteristica, arrayPersonas, personajeAleatorio);
			
		}
		
		else if (e.getSource()==acercaDe) {
			
			try {
			     Runtime.getRuntime().exec("hh.exe C:/Users/dam2/Desktop/Nueva carpeta (2)/Guess Who/acercaDe.chm");
			}
			catch (Exception ex) {
			     ex.printStackTrace();
			}
		}
		
		else{
			
			
			
		}
		
		

	}
	
	
	public int generarPersonajeAleatorio() {
		
		int numAleatorio = (int)(Math.random()*18);
		
		return numAleatorio;
			
	}	
	
	//Método botones
	
	public static void boton(int numBoton, Persona array[], int personajeRandom){
				
		array[numBoton].compruebaPersona(personajeRandom, numBoton);
					
	}
	
	
	public Persona [] crearArray (){
		
		Persona arrayPersonas[]= new Persona[18];
		
		//numPersona,nombre,pelo, ojos,gafas,bigote,barba,genero,sombrero
		
		arrayPersonas[0] = new Persona(1,"Adam", "Marron", "Azules", false, false,false,true,true,true);
		arrayPersonas[1] = new Persona(2,"Brenda", "Negro", "Verdes", true, false,false,false,false,true);
		arrayPersonas[2] = new Persona(3,"Charlie", "Rubio", "Azules", true, false,true,true,false,true);
		arrayPersonas[3] = new Persona(4,"David", "Negro", "Marrones", false, true,false,true,false,false);
		arrayPersonas[4] = new Persona(5,"Denise", "Marron", "Azules", true, false,false,false,false,true);
		arrayPersonas[5] = new Persona(6,"Frank", "Calvo", "Marrones", false, false,false,true,false,false);
		arrayPersonas[6] = new Persona(7,"Giselle", "Rubio", "Azules", true, false,false,false,false,true);
		arrayPersonas[7] = new Persona(8,"Heidi", "Marron", "Marrones", true, false,false,false,true,true);
		arrayPersonas[8] = new Persona(9,"Kathy", "Marron", "Marrones", false, false,false,false,false,true);
		arrayPersonas[9] = new Persona(10,"Kevin", "Calvo", "Marrones", true, false,false,true,false,true);
		arrayPersonas[10] = new Persona(11,"Lucas", "Negro", "Marrones", false, false,false,true,true,true);
		arrayPersonas[11] = new Persona(12,"Matthew", "Negro", "Verdes", false, false,false,true,false,false);
		arrayPersonas[12] = new Persona(13,"Petra", "Negro", "Azules", false, false,false,false,true,true);
		arrayPersonas[13] = new Persona(14,"Raymond", "Calvo", "Verdes", true, true,false,true,false,true);
		arrayPersonas[14] = new Persona(15,"Sophia", "Rubio", "Azules", false, false,false,false,true,true);
		arrayPersonas[15] = new Persona(16,"Steven", "Rubio", "Verdes", false, false,false,true,true,true);
		arrayPersonas[16] = new Persona(17,"Tamsin", "Rubio", "Verdes", false, false,false,false,false,true);
		arrayPersonas[17] = new Persona(18,"Yvette", "Marron", "Marrones", false, false,false,false,false,false);
		
		
		return arrayPersonas;
		
	}
	
	
	public void comprobarBoton(boolean resultado, int numBoton, Persona array[]){
		
		ImageIcon logo = new ImageIcon("img/logo.jpg");
		
		if (resultado==true){
			
			String nombreGanador = array[numBoton].nombre;
			
			JPanel panelDatos = new JPanel();
			
			panelDatos.setLayout(new BorderLayout());
			
			ImageIcon iconoEnhorabuena = new ImageIcon("img/enhorabuena.png");
			JLabel enhorabuena = new JLabel(iconoEnhorabuena);
			
			ImageIcon iconoGanador = new ImageIcon("img/"+nombreGanador+".jpg");
			JLabel ganador = new JLabel(iconoGanador);
			
			JLabel texto = new JLabel("Enhorabuena, has ganado la partida. ¿Quieres volver a jugar? ",JLabel.CENTER);
			
			panelDatos.add(enhorabuena,BorderLayout.PAGE_START);
			panelDatos.add(ganador,BorderLayout.CENTER);
			panelDatos.add(texto,BorderLayout.PAGE_END);
		
			if(JOptionPane.showConfirmDialog(this,panelDatos,"Enhorabuena!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE)==JOptionPane.YES_OPTION){
				
				reiniciarPartida(arrayBotones);
				
				
			}
			
			else {
				
				System.exit(0);
				
			}
			
		}
		
		else {
			
			JOptionPane.showMessageDialog(this, " Te has equivocado !!! "," Mensaje ",JOptionPane.INFORMATION_MESSAGE,logo);
			
			if(resultado==false){
				
				arrayBotones[numBoton].setEnabled(false);
				
			}
			
			
		}
		
		
	}
	
	//Método seleccion de características físicas
	
			public void caracteristicasFisicas(int numColumna, String caracteristica, Persona array[], int numSeleccionado){
				
				Persona personaSeleccionada = array[numSeleccionado];
				
					if((numColumna==1)||(numColumna==2)){
						
						if(numColumna==1){
											
								if(caracteristica.equals(personaSeleccionada.pelo)){
									
									for(int i=0;i<array.length;i++){
									
										if(!array[i].pelo.equals(caracteristica)){
											
											arrayBotones[i].setEnabled(false);
											
										}
									
									}
									
								}
								
								else{
									
									for(int i=0;i<array.length;i++){
										
										if(array[i].pelo.equals(caracteristica)){
											
											arrayBotones[i].setEnabled(false);
											
										}
									
									}
												
								}
									
						}
							
						else{
		
							if(caracteristica.equals(personaSeleccionada.ojos)){
								
								for(int i=0;i<array.length;i++){
								
									if(!array[i].ojos.equals(caracteristica)){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
								
							}
							
							else{
								
								for(int i=0;i<array.length;i++){
									
									if(array[i].ojos.equals(caracteristica)){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
											
							}
								
						}
								
					}
					
					else{
						
						boolean resultadoCaracteristica = Boolean.valueOf(caracteristica);
						
						if(numColumna==3){
							
							if(resultadoCaracteristica==personaSeleccionada.gafas){
								
								for(int i=0;i<array.length;i++){
								
									if(!array[i].gafas==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
								
							}
							
							else{
								
								for(int i=0;i<array.length;i++){
									
									if(array[i].gafas==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
											
							}
								
						}
						
						else if(numColumna==4){
							
							if(resultadoCaracteristica==personaSeleccionada.bigote){
								
								for(int i=0;i<array.length;i++){
								
									if(!array[i].bigote==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
								
							}
							
							else{
								
								for(int i=0;i<array.length;i++){
									
									if(array[i].bigote==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
											
							}
								
						}
						
						else if(numColumna==5){
							
							if(resultadoCaracteristica==personaSeleccionada.barba){
								
								for(int i=0;i<array.length;i++){
								
									if(!array[i].barba==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
								
							}
							
							else{
								
								for(int i=0;i<array.length;i++){
									
									if(array[i].barba==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
											
							}
								
						}
						
						else if(numColumna==6){
							
							if(resultadoCaracteristica==personaSeleccionada.genero){
								
								for(int i=0;i<array.length;i++){
								
									if(!array[i].genero==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
								
							}
							
							else{
								
								for(int i=0;i<array.length;i++){
									
									if(array[i].genero==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
											
							}
								
						}
						
						else if(numColumna==7){
							
							if(resultadoCaracteristica==personaSeleccionada.sombrero){
								
								for(int i=0;i<array.length;i++){
								
									if(!array[i].sombrero==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
								
							}
							
							else{
								
								for(int i=0;i<array.length;i++){
									
									if(array[i].sombrero==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
											
							}
								
						}
						
						else if(numColumna==8){
							
							if(resultadoCaracteristica==personaSeleccionada.piel){
								
								for(int i=0;i<array.length;i++){
								
									if(!array[i].piel==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
								
							}
							
							else{
								
								for(int i=0;i<array.length;i++){
									
									if(array[i].piel==resultadoCaracteristica){
										
										arrayBotones[i].setEnabled(false);
										
									}
								
								}
											
							}
								
						}
						
					}		
			}
							
			
			
			//Metodo que convierte los atributos seleccionados para utilizar el método caracteristicas Fisicas
			
				public void conversor(int numCaracteristica){
					
					switch(numCaracteristica){
					
						case 0: numColumna=6; caracteristica="true";break;
						
						case 1: numColumna=6; caracteristica="false";break;
						
						case 2: numColumna=3; caracteristica="true";break;
						
						case 3: numColumna=7; caracteristica="true";break;
						
						case 4: numColumna=5; caracteristica="true";break;
						
						case 5: numColumna=4; caracteristica="true";break;
						
						case 6: numColumna=1; caracteristica="Marron";break;
						
						case 7: numColumna=1; caracteristica="Negro";break;
						
						case 8: numColumna=1; caracteristica="Rubio";break;
						
						case 9: numColumna=1; caracteristica="Calvo";break;
						
						case 10: numColumna=2; caracteristica="Marrones";break;
						
						case 11: numColumna=2; caracteristica="Verdes";break;
						
						case 12: numColumna=2; caracteristica="Azules";break;
						
						case 13: numColumna=8; caracteristica="true";break;
						
						default: break;
					
					}
					
					
				}
				
				//Metodo que reinicia la partida 
				
				public void reiniciarPartida (JButton[] arrayBotones){
					
					for(int i=0;i<arrayBotones.length;i++){
						
						arrayBotones[i].setEnabled(true);	
							
					}
					
					personajeAleatorio = generarPersonajeAleatorio();	
					
				}
		}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

