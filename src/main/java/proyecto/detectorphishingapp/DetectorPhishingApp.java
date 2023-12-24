package proyecto.detectorphishingapp;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Aplicación de detección de phishing.
 * Esta aplicación permite seleccionar un archivo de texto (.txt), analizar
 * las ocurrencias de palabras clave de phishing y mostrar los resultados.
 *
 * @author CRIZ
 */
public class DetectorPhishingApp {

    private JTextArea outputTextArea;

    public static void main(String[] args) {
        // Iniciar la aplicación en el hilo de eventos de la interfaz gráfica.
        SwingUtilities.invokeLater(() -> {
            DetectorPhishingApp app = new DetectorPhishingApp();
            app.createAndShowGUI();
        });
    }

    /**
     * Crea y muestra la interfaz gráfica de la aplicación su título será Phising Detector.
     */
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Phishing Detector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Área de texto para mostrar los resultados.
        outputTextArea = new JTextArea(20, 50);
        outputTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Botón para seleccionar un archivo.
        JButton openFileButton = new JButton("Seleccionar Archivo");
        openFileButton.addActionListener(e -> processFile());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openFileButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Procesa el archivo seleccionado, analizando las ocurrencias de palabras clave de phishing.
     */
    private void processFile() {
        File selectedFile = selectTextFile();
        if (selectedFile == null) {
            showError("Por favor, selecciona un archivo de texto (.txt).");
            return;
        }

        // Limpiar el área de texto antes de procesar un nuevo archivo.
        outputTextArea.setText("");

        try (FileReader fileReader = new FileReader(selectedFile);
             Scanner scanner = new Scanner(fileReader)) {

            // Contar las ocurrencias de palabras clave de phishing.
            Map<String, Integer> keywordOccurrences = countPhishingKeywords(scanner);

            // Mostrar los resultados en el área de texto.
            printKeywordOccurrences(keywordOccurrences);

        } catch (IOException e) {
            showError("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Permite al usuario seleccionar un archivo de texto.
     *
     * @return El archivo seleccionado o null si la selección fue cancelada.
     */
    private File selectTextFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    /**
     * Cuenta las ocurrencias de palabras clave de phishing en el scanner proporcionado.
     *
     * @param scanner El scanner que proporciona el contenido del archivo.
     * @return Un mapa que contiene las ocurrencias de palabras clave y los puntos totales.
     */
    private Map<String, Integer> countPhishingKeywords(Scanner scanner) {
        Map<String, Integer> keywordOccurrences = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();

            if (PhishingKeywords.KEYWORDS_MAP.containsKey(word)) {
                int points = PhishingKeywords.KEYWORDS_MAP.get(word);
                keywordOccurrences.put(word, keywordOccurrences.getOrDefault(word, 0) + 1);
                keywordOccurrences.put("Total de puntos", keywordOccurrences.getOrDefault("Total de puntos", 0) + points);
            }
        }

        return keywordOccurrences;
    }

    /**
     * Muestra las ocurrencias de palabras clave y los puntos totales en el área de texto.
     *
     * @param keywordOccurrences Mapa que contiene las ocurrencias de palabras clave y los puntos totales.
     */
    private void printKeywordOccurrences(Map<String, Integer> keywordOccurrences) {
        appendToOutput("Resultados del Análisis");
        appendToOutput("------------------------\n");

        for (Map.Entry<String, Integer> entry : keywordOccurrences.entrySet()) {
            if (!entry.getKey().equals("Total de puntos")) {
                String line = entry.getKey() + ": " + entry.getValue() + " ocurrencias, " +
                        "Total de puntos: " + entry.getValue() + "\n";
                appendToOutput(line);
            }
        }

        int totalPoints = keywordOccurrences.getOrDefault("Total de puntos", 0);
        appendToOutput("------------------------\n");
        String totalLine = "Total de puntos: " + totalPoints + " ocurrencias, " +
                "Total de puntos: " + totalPoints + "\n";
        appendToOutput(totalLine);
    }

    /**
     * Agrega texto al área de texto de salida.
     *
     * @param text El texto que se agregará.
     */
    
    private void appendToOutput(String text) {
        outputTextArea.append(text);
    }

    /**
     * Muestra un cuadro de diálogo de error con el mensaje proporcionado.
     *
     * @param message El mensaje de error a mostrar.
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
