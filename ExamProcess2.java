package AlejrandroExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ExamProcess {

	public static void main(String[] args) {

		try {
			
			Process process1 = new ProcessBuilder("cmd","/C","date").start();
			Process process4 = new ProcessBuilder("cmd","/C","time").start();
			//Process process2 = new ProcessBuilder("cmd","/C","java -jar ./Ascii.jar").start();
			Process process3 = new ProcessBuilder("cmd","/C","mspaint.exe").start(); 
			Scanner kb = new Scanner(System.in);
			BufferedReader br= new BufferedReader( new InputStreamReader(process1.getInputStream())); 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process1.getOutputStream()));
			String[] fecha;
			String[] div;
			String line = br.readLine();
						
			fecha = line.split(":"); //dividimos la string para coger la fecha
			div = fecha[1].split("/"); //dividimos la string de tal manera que quede dia,mes,año
			int dia = Integer.parseInt(div[0].trim());
			String date = (dia-1 + "-" + div[1] + "-" + div[2]); //le restamos un dia

			bw.write(date + "\n");
			bw.flush();
			
			System.out.println(line); 
			System.out.println(br.readLine());
			
			
			//Process 4
			BufferedReader br2= new BufferedReader( new InputStreamReader(process4.getInputStream())); 
			BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(process4.getOutputStream()));
			String[] hora;
			String[] div2;
			String line2 = br2.readLine();
			
			hora = line2.split(":");
			div2 = hora[1].split(":");
			int nuevahora = Integer.parseInt(div2[0].trim());
			String hora2 = (nuevahora-1 + ":" +div2[1] + ":" +div2[2]);
			bw2.write(hora2 + "\n");
			bw2.flush();
			System.out.println(line2); 
			System.out.println(br2.readLine());
			
			//

			System.out.print("Dime un numero: ");
			String num = kb.nextLine();
			int num2 = Integer.parseInt(num.trim());
			
			System.out.println("El caracter ASCII es: " +(char)num2);
			
			
			/* br= new BufferedReader( new InputStreamReader(process2.getInputStream())); 
			 bw = new BufferedWriter(new OutputStreamWriter(process2.getOutputStream()));
			
			bw.write(num + "\n");
			bw.flush();
			
			
			System.out.println("El caracter ASCII es: " + br.readLine());
			*/
		
			process3.waitFor(); //Esperamos a que termine con el pain para terminar

			kb.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
