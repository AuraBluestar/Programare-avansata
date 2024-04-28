package tools;

import exceptions.FileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private String separator;
    private BufferedReader source = null;

    public CSVReader() {
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setSource(String source) {
        try {
            this.source = new BufferedReader(new FileReader(source));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find the specified file");
            ;
        }
    }

    public List<String[]> getData() throws FileException {
        if (this.source == null) {
            throw new FileException("Empty source");
        }
        if(this.separator == null){
            throw new FileException("Separator is not set");
        }
        List<String[]> data = new ArrayList<>();
        String valuesLine = "";
        try {
            while ((valuesLine = this.source.readLine()) != null) {
                String[] line = valuesLine.split(separator);
                data.add(line);
            }
        } catch (IOException exception) {
            System.err.println("Couldn't read from file.");
        }
        return data;
    }
}
