import java.io.IOException;
import java.io.File;
import java.lang.ProcessBuilder;
import java.io.InputStream;
import java.text.MessageFormat;

public class github_repo_fetch{


	static void Process( String repo) {
		//  Baixar repositorio no perfil heislerlemos dos github, adicionou-se o argumento repo do metodo Process
		String download_from_github  = MessageFormat.format("wget https://github.com/heislerlemos/{0}/archive/refs/heads/master.zip", repo); 	
		String command = download_from_github;

		// Inicio do processo
		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));

		// Directorio onde será gravado
		processBuilder.directory(new File("home/heisler/Desktop/Formação/Programação/tools/Github_Folders/"));

		// Chamar inicio do processo
		try {
			Process process = processBuilder.start();
			InputStream inputStream = process.getInputStream();
			// Debug do input Stream 
			System.out.println("Id do inputstream : " + inputStream + "Nome do  repositorio:" + command);	
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				System.out.println("Erro no processo volter a tentar");	
			}

			int exitCode = process.exitValue();
		} catch (IOException e) {
			System.out.println("Erro no processo Volte a tentar por favor ");
	   }
	}

	public  static void main (String [] args ){
		String[] list = {"angotrashapi", "flashcards", "dockerfiles_sportsonline"};
		for (int i = 0; i < list.length; i++){
			Process(list[i]);
		}
	}
}
