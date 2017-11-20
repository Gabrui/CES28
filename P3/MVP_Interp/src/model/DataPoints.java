package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

// Objeto imutável
@SuppressWarnings("unchecked") // Por causa do casting do método clone.
public class DataPoints {

    private File _file;
    private Vector<Double> x, y;
    private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
    
    public DataPoints(String arquivo) {
    	buildDataPoints(arquivo);
    }
    
	public Vector<Double> getX() {
    	return (Vector<Double>) x.clone();
    }
    
	public Vector<Double> getY() {
    	return (Vector<Double>) y.clone();
    }
    
    // RESPONSABILITY: LER ARQUIVO DE DADOS
	private void buildDataPoints(String StringFile) {
        _file = new File(StringFile);

        x = new Vector<Double>();
        y = new Vector<Double>();
        try {
            input = new FileReader(_file);
		    /* Filter FileReader through a Buffered read to read a line at a time */
            bufRead = new BufferedReader(input);
            // Read first line
            String line = bufRead.readLine();
            // Read through file one line at time.
            while (line != null){
                xy = new StringTokenizer(line, "\t ");
                while(xy.hasMoreTokens()) {
                    x.addElement(Double.parseDouble(xy.nextToken()));
                    y.addElement(Double.parseDouble(xy.nextToken()));
                }
                line = bufRead.readLine();
            }
            bufRead.close();
        } catch (IOException e) { // If another exception is generated, print a stack trace
            e.printStackTrace();
        }
    }//buildDataPoints
}
