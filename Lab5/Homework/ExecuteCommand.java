package com.company;

import java.io.IOException;

public class ExecuteCommand extends Command {

    public ExecuteCommand() {
    }

    @Override
    public void execute(String... parameters) throws IOException, InvalidCommandException {
        // Verificăm dacă avem suficiente argumente pentru a executa comanda "view"
        if (parameters.length < 2) {
            throw new IllegalArgumentException("View command requires a file path as parameter");
        }
        
        for (int i = 0; i <= parameters.length-1; i++) {
            String filePath = parameters[i];
            String comanda = parameters[i+1];

            // Implementare opțională, depinde de caz
            switch (comanda) {
                case "view" -> {/*opens a document using the native operating system application (see the Desktop class);*/
                    var view = new ViewDocument();
                    view.execute(filePath);
                }
                case "report" -> {
                    var report = new ReportDocument();
                    report.execute(filePath);
                }
                case "export" -> {
                    if (parameters.length < 3){
                        var export = new ExportRepository();
                        export.execute(parameters[1],parameters[2]);
                    }
                }
                default ->
                    throw new InvalidCommandException("Comanda invalida");
            }
        }

    }
}
