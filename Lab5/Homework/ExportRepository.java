package com.company;

import java.io.IOException;
import java.io.File;

public class ExportRepository extends Command{

    @Override
    public void execute(String... parameters) throws IOException, InvalidCommandException {
        String filePath = parameters[0];
        String destinationPath = parameters[1];

        File file = new File(filePath);
        if(file.renameTo(new File(destinationPath))){
            file.delete();
            System.out.println("File moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }
    
}
