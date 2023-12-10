package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwingWorkerExample extends JFrame {

    private JButton startButton;
    private JTextArea resultTextArea;

    public SwingWorkerExample() {
        setTitle("SwingWorker Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout
        setLayout(new BorderLayout());

        // Create GUI components
        startButton = new JButton("Start Task");
        resultTextArea = new JTextArea();

        // Add components to the frame
        add(startButton, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        // Attach ActionListener to the startButton
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, start the background task
                performBackgroundTask();
            }
        });
    }

    private void performBackgroundTask() {
        // Create and execute SwingWorker
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulate a time-consuming task (e.g., fetching data from a remote server)
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(500); // Simulating a delay of 500 milliseconds
                    publish("Task in progress... Step " + i);
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                // Update the UI with intermediate results
                for (String message : chunks) {
                    resultTextArea.append(message + "\n");
                }
            }

            @Override
            protected void done() {
                // This method is called when the background task is complete
                resultTextArea.append("Task completed!\n");
                startButton.setEnabled(true); // Re-enable the button
            }
        };

        // Disable the button to prevent multiple executions of the task
        startButton.setEnabled(false);

        // Execute the SwingWorker
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingWorkerExample example = new SwingWorkerExample();
            example.setVisible(true);
        });
    }
}
