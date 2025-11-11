package org.wavelabs.soundscope.view.components;

import org.wavelabs.soundscope.style.UIStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Custom panel for visualizing audio waveforms.
 */
public class WaveformPanel extends JPanel {
    private double[] waveformData;
    
    public WaveformPanel() {
        setBackground(UIStyle.Colors.WAVEFORM_BACKGROUND);
        setPreferredSize(new Dimension(
            UIStyle.Dimensions.WAVEFORM_WIDTH,
            UIStyle.Dimensions.WAVEFORM_HEIGHT
        ));
        // Initialize with placeholder data
        generatePlaceholderWaveform();
    }
    
    /**
     * Updates the waveform with new audio data.
     * @param data Array of amplitude values (normalized to -1.0 to 1.0)
     */
    public void updateWaveform(double[] data) {
        this.waveformData = data;
        repaint();
    }
    
    /**
     * Generates placeholder waveform data for demonstration.
     */
    private void generatePlaceholderWaveform() {
        int numSamples = 200;
        waveformData = new double[numSamples];
        for (int i = 0; i < numSamples; i++) {
            waveformData[i] = Math.sin(i * 0.1) * 0.5 + Math.sin(i * 0.3) * 0.3;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Clear background
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        if (waveformData == null || waveformData.length == 0) {
            return;
        }
        
        // Draw waveform
        g2d.setColor(UIStyle.Colors.WAVEFORM_STROKE);
        g2d.setStroke(new BasicStroke(UIStyle.Borders.WAVEFORM_STROKE_WIDTH));
        
        double mid = getHeight() / 2.0;
        double width = getWidth();
        double sampleWidth = width / waveformData.length;
        
        // Draw waveform lines
        for (int i = 0; i < waveformData.length - 1; i++) {
            double x1 = i * sampleWidth;
            double y1 = mid - waveformData[i] * (mid - 10);
            
            double x2 = (i + 1) * sampleWidth;
            double y2 = mid - waveformData[i + 1] * (mid - 10);
            
            g2d.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }
}

