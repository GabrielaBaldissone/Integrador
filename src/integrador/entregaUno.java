package integrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class entregaUno {

	public static void main(String[] args) throws IOException {

	
		
		ArrayList<Partido> listaPartidos = new ArrayList<Partido>(); 
		
		//Declaramos 
		Partido unPartido;
		Equipo unEquipo1;
		Equipo unEquipo2;
		
		String archivo = "archivos\\\\Resultados.txt" ;
		for (String linea : Files.readAllLines(Paths.get(archivo))){
			String lineas[] = linea.split(" ");
			
			//Instanciamos o definimos
			unPartido = new Partido();
			unEquipo1 = new Equipo();
			unEquipo2 = new Equipo();
			
			//Guardamos los valores dentro de los atributos de cada uno
			unEquipo1.setNombre(lineas[0]);
			unEquipo2.setNombre(lineas[3]);
			unPartido.setequipo1(unEquipo1);
			unPartido.setequipo2(unEquipo2);
			unPartido.setGol1(Integer.parseInt(lineas[1]));
			unPartido.setGol2(Integer.parseInt(lineas[2]));
			listaPartidos.add(unPartido);
		}
		
		for (int i=0; i<listaPartidos.size();i++) {
			
			
		//JOptionPane.showMessageDialog(null, listaPartidos.get(i).getequipo1().getNombre()  + " " +listaPartidos.get(i).getGol1() 
			//	+ " " + listaPartidos.get(i).getGol2()+ " " + listaPartidos.get(i).getequipo2().getNombre() );
			
	}
		
		ArrayList<Pronostico> listaPronostico = new ArrayList<Pronostico>(); 
		
		//Declaramos 
		Pronostico unPartidoPronostico;
		Equipo unEquipo1Pronostico;
		Equipo unEquipo2Pronostico;
		
		String archivoPronostico = "archivos\\\\Pronostico.txt" ;
		for (String lineaP : Files.readAllLines(Paths.get(archivoPronostico))){
			String lineasP[] = lineaP.split(" ");
			
			//Instanciamos o definimos
			unPartidoPronostico = new Pronostico();
			unEquipo1Pronostico = new Equipo();
			unEquipo2Pronostico = new Equipo();
			
			//Guardamos los valores dentro de los atributos de cada uno
			unEquipo1Pronostico.setNombre(lineasP[0]);
			unEquipo2Pronostico.setNombre(lineasP[4]);
			unPartidoPronostico.setEquipo1(unEquipo1Pronostico); 
			unPartidoPronostico.setEquipo2(unEquipo2Pronostico);
			unPartidoPronostico.setGanaEquipo1(Integer.parseInt(lineasP[1])); 
			unPartidoPronostico.setEmpate(Integer.parseInt(lineasP[2])); 
			unPartidoPronostico.setGanaEquipo2(Integer.parseInt(lineasP[3])); 
			listaPronostico.add(unPartidoPronostico);
		}
		
		for (int i=0; i<listaPronostico.size();i++) {
			
			
		//JOptionPane.showMessageDialog(null, listaPronostico.get(i).getEquipo1().getNombre()  + " " +listaPronostico.get(i).getGanaEquipo1() 
			//	+ " " + listaPronostico.get(i).getGanaEquipo2()+ " " + listaPronostico.get(i).getEmpate() + " "+ listaPronostico.get(i).getEquipo2().getNombre() );
			
	}
		
			
		int puntos = 0 ;
		
		
		for (int i=0; i<4 ;i++) { 
			
		int empate = 0;
			
		if (listaPartidos.get(i).getequipo1().getNombre().equals(listaPronostico.get(i).getEquipo1().getNombre()) && 
				listaPartidos.get(i).getequipo2().getNombre().equals(listaPronostico.get(i).getEquipo2().getNombre())) {
			
		
			// VERIFICAR QUE EQUIPO GANA EN CADA RONDA DE LA LISTA PARTIDOS / RESULTADOS. 
			
			if (listaPartidos.get(i).getGol1() > listaPartidos.get(i).getGol2() && listaPronostico.get(i).getGanaEquipo1() == 1) {
				
				JOptionPane.showMessageDialog(null, "Hay un acierto, el equipo ganador es: " + listaPartidos.get(i).getequipo1().getNombre() );
				
				puntos++; 
			}	
			else if (listaPartidos.get(i).getGol1() < listaPartidos.get(i).getGol2() && listaPronostico.get(i).getGanaEquipo2() == 1) {
			
				JOptionPane.showMessageDialog(null, listaPartidos.get(i).getequipo2().getNombre());
				
				puntos++;
			
			}
			
			else if (listaPartidos.get(i).getGol1() == listaPartidos.get(i).getGol2() && listaPronostico.get(i).getEmpate() == 1) {
				
				JOptionPane.showMessageDialog(null, "Hay un acierto, " + listaPartidos.get(i).getequipo1().getNombre() + " y " + listaPartidos.get(i).getequipo2().getNombre() + " empataron.");
				puntos++;
				
			}
	
		
		}
		

		}
		
			JOptionPane.showMessageDialog(null, "La cantidad de aciertos es: " + puntos);			
			
	}

}
