import java.io.IOException;
import java.io.File;
import java.lang.ProcessBuilder;
import java.io.InputStream;
import java.text.MessageFormat;


public class github_repo_fetch { 

	static void Process (String repo){
		String string  = MessageFormat.format("wget https://github.com/heislerlemos/{0}/archive/refs/heads/master.zip", repo); 	
		String command = string;

		// Inicio do processo

		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
		// Directorio onde será gravado
		processBuilder.directory(new File("/home/heisler/Desktop/Formação/Programação/tools/Github_Folders/"));

		// Chamar inicio do processo
		try {
			Process process = processBuilder.start();
			InputStream inputStream = process.getInputStream();
			System.out.println("Id do inputstream : " + inputStream + "Nome do  repositorio:" + command);	
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				System.out.println("Erro no processo volter a tentar local");	
			}

			int exitCode = process.exitValue();
		} catch (IOException e) {
			System.out.println("no processo Volte a tentar por favor rede");
		}
	}


		public static void main (String[] args){
			String[] lista = {"hlemos", "angotrashapi"};
			for (String i : lista){
			Process(i);
			}
		}
	}
