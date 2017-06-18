package pesquisa_ordenacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
	
	public static void write(String filename, String content) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(filename);
			bw = new BufferedWriter(fw);
			bw.write(content);
			
			System.out.println(filename);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
}
