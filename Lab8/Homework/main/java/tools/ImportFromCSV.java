package tools;

import exceptions.FileException;

import java.util.ArrayList;
import java.util.List;

public class ImportFromCSV {
    private CSVReader csvReader;

    public ImportFromCSV(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public List<String[]> getAttributes(int... indexes) throws FileException {
        List<String[]> list;
        List<String[]> reqDataList = new ArrayList<>();
        try {
            list = csvReader.getData();

            for (int indexList = 0; indexList < list.size(); indexList++) {
                String[] line = new String[indexes.length];
                for (int indexLine = 0; indexLine < indexes.length; indexLine++) {
                    line[indexLine] = list.get(indexList)[indexes[indexLine]];
                    System.out.println(line[indexLine]);
                }
                reqDataList.add(line);
            }
        } catch (FileException e) {
            System.err.println("Empty data");
        }
        return reqDataList;
    }
}
