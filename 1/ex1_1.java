import java.io.*;
import java.lang.System;

import javax.imageio.IIOException;

class ex1_1 {
    public static void main(String[] args) {
		// Count the number of increasing entries
		int count = 0;
		Integer previousReading = -1;

		try {
			File inputFile = new File("1\\input.txt");
			try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
				// Line read from file as string.
				String line;

				// Convert to Integer
				while ((line = br.readLine()) != null) {
					Integer currentReading = Integer.parseInt(line);
					if (previousReading != -1) {
						// Current reading is > previous 
						if (currentReading.compareTo(previousReading) > 0) {
							count++;
						}
					}
					previousReading = currentReading;
				}
				System.out.println("Readings increased: "+count);
			} catch (IIOException e) {
				System.err.println(e);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}