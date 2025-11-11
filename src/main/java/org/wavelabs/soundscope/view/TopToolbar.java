package org.wavelabs.soundscope.view;

import org.wavelabs.soundscope.style.UIStyle;
import org.wavelabs.soundscope.view.components.StyledButton;

import javax.swing.*;
import java.awt.*;

/**
 * Top toolbar component containing file and action buttons.
 */
public class TopToolbar extends JPanel {
    private final StyledButton openButton;
    private final StyledButton saveButton;
    private final StyledButton fingerprintButton;
    private final StyledButton identifyButton;
    
    public TopToolbar() {
        setLayout(new FlowLayout(FlowLayout.LEFT, UIStyle.Spacing.TOOLBAR_GAP, UIStyle.Spacing.TOOLBAR_PADDING));
        setBackground(UIStyle.Colors.BACKGROUND_TOOLBAR);
        setBorder(BorderFactory.createEmptyBorder(
            UIStyle.Spacing.TOOLBAR_PADDING,
            UIStyle.Spacing.TOOLBAR_PADDING,
            UIStyle.Spacing.TOOLBAR_PADDING,
            UIStyle.Spacing.TOOLBAR_PADDING
        ));
        
        // Create buttons
        openButton = new StyledButton("Open");
        saveButton = new StyledButton("Save As");
        fingerprintButton = new StyledButton("Fingerprint");
        identifyButton = new StyledButton("Identify");
        
        // Add buttons to toolbar
        add(openButton);
        add(saveButton);
        add(fingerprintButton);
        add(identifyButton);
    }
    
    // Getters for button access
    public StyledButton getOpenButton() {
        return openButton;
    }
    
    public StyledButton getSaveButton() {
        return saveButton;
    }
    
    public StyledButton getFingerprintButton() {
        return fingerprintButton;
    }
    
    public StyledButton getIdentifyButton() {
        return identifyButton;
    }
}

