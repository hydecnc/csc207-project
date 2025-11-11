package org.wavelabs.soundscope.view;

import org.wavelabs.soundscope.style.UIStyle;
import org.wavelabs.soundscope.view.components.StyledButton;

import javax.swing.*;
import java.awt.*;

/**
 * Bottom control panel containing output label and playback/recording controls.
 */
public class BottomControlPanel extends JPanel {
    private final JLabel outputLabel;
    private final StyledButton playButton;
    private final StyledButton recordButton;
    
    public BottomControlPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(UIStyle.Colors.BACKGROUND_PRIMARY);
        setBorder(BorderFactory.createEmptyBorder(
            UIStyle.Spacing.BOTTOM_PADDING,
            UIStyle.Spacing.BOTTOM_PADDING,
            UIStyle.Spacing.BOTTOM_PADDING,
            UIStyle.Spacing.BOTTOM_PADDING
        ));
        
        // Output label
        outputLabel = new JLabel();
        outputLabel.setFont(UIStyle.Fonts.DEFAULT);
        outputLabel.setForeground(UIStyle.Colors.TEXT_PRIMARY);
        outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, UIStyle.Spacing.MD, 0));
        setOutputText("Most similar to \"Viva La Vida\"<br>Fingerprint: abE671deF");
        
        // Control buttons panel
        JPanel controlButtons = new JPanel(new FlowLayout(
            FlowLayout.CENTER,
            UIStyle.Spacing.CONTROL_BUTTONS_GAP,
            0
        ));
        controlButtons.setBackground(UIStyle.Colors.BACKGROUND_PRIMARY);
        
        playButton = new StyledButton("▶ Play");
        recordButton = new StyledButton("● Record");
        
        controlButtons.add(playButton);
        controlButtons.add(recordButton);
        
        // Add components
        add(outputLabel);
        add(controlButtons);
    }
    
    /**
     * Sets the output text with HTML formatting for center alignment.
     */
    public void setOutputText(String text) {
        outputLabel.setText("<html><center>" + text + "</center></html>");
    }
    
    // Getters for component access
    public JLabel getOutputLabel() {
        return outputLabel;
    }
    
    public StyledButton getPlayButton() {
        return playButton;
    }
    
    public StyledButton getRecordButton() {
        return recordButton;
    }
}

