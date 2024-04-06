package com.company.command;

import com.company.exception.InvalidCommandException;
import java.io.IOException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReportDocument extends Command {

    @Override
    public void execute(String... parameters) throws IOException, InvalidCommandException {
        String filePath = parameters[0];

        // Initializam configurarea FreeMarker
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");

        // Facem un Map pentru a transmite date catre sablonul FreeMarker
        Map<String, Object> model = new HashMap<>();

        // Adăugăm datele necesare pentru raport (exemplu)
        model.put("title", "Sablon HTML");
        model.put("content", "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<title>Document</title></head><body></body></html>");

        try {
            // Incarcam sablonul
            Template template = configuration.getTemplate("report_template.ftl");

            // Creăm un scriitor pentru a scrie conținutul raportului în fișierul HTML
            try (Writer fileWriter = new FileWriter(new File(filePath))) {
                template.process(model, fileWriter);
            }

            // Deschidem fișierul 
            var view = new ViewDocument();
            view.execute(filePath);
        } catch (IOException | TemplateException e) {
            throw new InvalidCommandException("Comanda invalida");
        }
    }
}
