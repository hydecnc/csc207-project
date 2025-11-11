package org.wavelabs.soundscope.view;

import org.wavelabs.soundscope.style.UIStyle;
import org.wavelabs.soundscope.view.components.WaveformPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Main application window that orchestrates all UI components.
 */
public class MainWindow extends JFrame {
    private final TopToolbar topToolbar;
    private final WaveformPanel waveformPanel;
    private final BottomControlPanel bottomControlPanel;
    
    public MainWindow() {
        initializeWindow();
        
        // Create components
        topToolbar = new TopToolbar();
        waveformPanel = new WaveformPanel();
        bottomControlPanel = new BottomControlPanel();
        
        // Layout components
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(UIStyle.Colors.BACKGROUND_PRIMARY);
        
        contentPane.add(topToolbar, BorderLayout.NORTH);
        contentPane.add(waveformPanel, BorderLayout.CENTER);
        contentPane.add(bottomControlPanel, BorderLayout.SOUTH);
    }
    
    private void initializeWindow() {
        setTitle("Soundscope");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(UIStyle.Dimensions.WINDOW_WIDTH, UIStyle.Dimensions.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
    }
    
    // Getters for component access
    public TopToolbar getTopToolbar() {
        return topToolbar;
    }
    
    public WaveformPanel getWaveformPanel() {
        return waveformPanel;
    }
    
    public BottomControlPanel getBottomControlPanel() {
        return bottomControlPanel;
    }
}

