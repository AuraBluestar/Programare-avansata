package com.company;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ViewDocument extends Command{
    private String filePath;

    @Override
    public void execute(String... parameters) throws IOException, InvalidCommandException {
        
        String filePath = parameters[0];
        
        // Verificăm dacă sistemul acceptă operații pe fișiere
        if (!Desktop.isDesktopSupported()) {
            throw new UnsupportedOperationException("Desktop operations not supported");
        }
        // Deschidem fișierul cu aplicația nativă a sistemului
        Desktop.getDesktop().open(new File(filePath));
    }
    
    
}
