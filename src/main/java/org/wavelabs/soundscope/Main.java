package org.wavelabs.soundscope;

import org.wavelabs.soundscope.view.MainWindow;
import org.wavelabs.soundscope.view.components.StyledButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main application entry point and controller.
 * Handles application initialization and event handling.
 */
public class Main {
    private MainWindow mainWindow;
    private boolean isRecording = false;
    
    public Main() {
        initializeUI();
        setupEventHandlers();
    }
    
    private void initializeUI() {
        mainWindow = new MainWindow();
    }
    
    private void setupEventHandlers() {
        // Top toolbar buttons
        mainWindow.getTopToolbar().getOpenButton()
            .addActionListener(e -> onOpenFile());
        mainWindow.getTopToolbar().getSaveButton()
            .addActionListener(e -> onSaveFile());
        mainWindow.getTopToolbar().getFingerprintButton()
            .addActionListener(e -> onGenerateFingerprint());
        mainWindow.getTopToolbar().getIdentifyButton()
            .addActionListener(e -> onIdentifySong());
        
        // Bottom control buttons
        mainWindow.getBottomControlPanel().getPlayButton()
            .addActionListener(e -> onPlayAudio());
        mainWindow.getBottomControlPanel().getRecordButton()
            .addActionListener(e -> onRecordAudio());
    }
    
    // Event handler methods
    private void onOpenFile() {
        mainWindow.getBottomControlPanel().setOutputText("File opened successfully.");
        // TODO: Implement file opening logic
    }
    
    private void onSaveFile() {
        mainWindow.getBottomControlPanel().setOutputText("File saved successfully.");
        // TODO: Implement file saving logic
    }
    
    private void onGenerateFingerprint() {
        mainWindow.getBottomControlPanel().setOutputText("Fingerprint: abE671deF");
        // TODO: Implement fingerprint generation logic
    }
    
    private void onIdentifySong() {
        mainWindow.getBottomControlPanel().setOutputText("Most similar to \"Viva La Vida\"");
        // TODO: Implement song identification logic
    }
    
    private void onPlayAudio() {
        mainWindow.getBottomControlPanel().setOutputText("Playing audio...");
        // TODO: Implement audio playback logic
    }
    
    private void onRecordAudio() {
        StyledButton recordButton = mainWindow.getBottomControlPanel().getRecordButton();
        
        if (!isRecording) {
            isRecording = true;
            recordButton.setText("⏹ Stop");
            mainWindow.getBottomControlPanel().setOutputText("Recording...");
            // TODO: Implement recording start logic
        } else {
            isRecording = false;
            recordButton.setText("● Record");
            mainWindow.getBottomControlPanel().setOutputText("Recording stopped.");
            // TODO: Implement recording stop logic
        }
    }
    
    public void show() {
        mainWindow.setVisible(true);
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default for better appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Failed to set system look and feel: " + e.getMessage());
        }
        
        // Create and show the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.show();
        });
    }
}
