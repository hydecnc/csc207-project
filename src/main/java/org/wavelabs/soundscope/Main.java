package org.wavelabs.soundscope;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Canvas waveformCanvas;
    private GraphicsContext gc;
    private Label outputLabel;
    private Button recordBtn;
    private boolean isRecording = false;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Soundscope");

        // Create root layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #E6F2FF;"); // Light blue background

        // Top toolbar with buttons
        HBox topBar = createTopBar();
        root.setTop(topBar);

        // Center waveform visualization
        waveformCanvas = new Canvas(800, 200);
        gc = waveformCanvas.getGraphicsContext2D();
        drawPlaceholderWaveform();
        root.setCenter(waveformCanvas);

        // Bottom section with output label and control buttons
        VBox bottomSection = createBottomSection();
        root.setBottom(bottomSection);

        // Create scene
        Scene scene = new Scene(root, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createTopBar() {
        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(15));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: #B8D4F0;");

        Button openBtn = createStyledButton("Open");
        Button saveBtn = createStyledButton("Save As");
        Button fingerprintBtn = createStyledButton("Fingerprint");
        Button identifyBtn = createStyledButton("Identify");

        // Placeholder event handlers
        openBtn.setOnAction(e -> onOpenFile());
        saveBtn.setOnAction(e -> onSaveFile());
        fingerprintBtn.setOnAction(e -> onGenerateFingerprint());
        identifyBtn.setOnAction(e -> onIdentifySong());

        topBar.getChildren().addAll(openBtn, saveBtn, fingerprintBtn, identifyBtn);
        return topBar;
    }

    private VBox createBottomSection() {
        VBox bottomSection = new VBox(15);
        bottomSection.setPadding(new Insets(20));
        bottomSection.setAlignment(Pos.CENTER);

        // Output label
        outputLabel = new Label("Most similar to \"Viva La Vida\"\nFingerprint: abE671deF");
        outputLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333;");
        outputLabel.setAlignment(Pos.CENTER);
        outputLabel.setWrapText(true);

        // Control buttons
        HBox controlButtons = new HBox(40);
        controlButtons.setAlignment(Pos.CENTER);

        Button playBtn = createStyledButton("▶ Play");
        recordBtn = createStyledButton("● Record");

        playBtn.setOnAction(e -> onPlayAudio());
        recordBtn.setOnAction(e -> onRecordAudio());

        controlButtons.getChildren().addAll(playBtn, recordBtn);

        bottomSection.getChildren().addAll(outputLabel, controlButtons);
        return bottomSection;
    }

    private Button createStyledButton(String text) {
        Button btn = new Button(text);
        btn.setStyle(
            "-fx-background-color: #4A90E2; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 8 16 8 16; " +
            "-fx-background-radius: 5; " +
            "-fx-cursor: hand;"
        );
        btn.setOnMouseEntered(e -> btn.setStyle(
            "-fx-background-color: #a0c4ff; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 8 16 8 16; " +
            "-fx-background-radius: 5; " +
            "-fx-cursor: hand;"
        ));
        btn.setOnMouseExited(e -> btn.setStyle(
            "-fx-background-color: #4A90E2; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 8 16 8 16; " +
            "-fx-background-radius: 5; " +
            "-fx-cursor: hand;"
        ));
        return btn;
    }

    private void drawPlaceholderWaveform() {
        gc.clearRect(0, 0, waveformCanvas.getWidth(), waveformCanvas.getHeight());
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);

        double mid = waveformCanvas.getHeight() / 2;
        double width = waveformCanvas.getWidth();
        int numSamples = 200;

        // Draw a sample waveform
        for (int i = 0; i < numSamples - 1; i++) {
            double x1 = i * (width / numSamples);
            double amplitude1 = Math.sin(i * 0.1) * 0.5 + Math.sin(i * 0.3) * 0.3;
            double y1 = mid - amplitude1 * (mid - 10);

            double x2 = (i + 1) * (width / numSamples);
            double amplitude2 = Math.sin((i + 1) * 0.1) * 0.5 + Math.sin((i + 1) * 0.3) * 0.3;
            double y2 = mid - amplitude2 * (mid - 10);

            gc.strokeLine(x1, y1, x2, y2);
        }
    }

    // Placeholder event handler methods
    private void onOpenFile() {
        outputLabel.setText("File opened successfully.");
        // TODO: Implement file opening logic
    }

    private void onSaveFile() {
        outputLabel.setText("File saved successfully.");
        // TODO: Implement file saving logic
    }

    private void onGenerateFingerprint() {
        outputLabel.setText("Fingerprint: abE671deF");
        // TODO: Implement fingerprint generation logic
    }

    private void onIdentifySong() {
        outputLabel.setText("Most similar to \"Viva La Vida\"");
        // TODO: Implement song identification logic
    }

    private void onPlayAudio() {
        outputLabel.setText("Playing audio...");
        // TODO: Implement audio playback logic
    }

    private void onRecordAudio() {
        if (!isRecording) {
            isRecording = true;
            recordBtn.setText("⏹ Stop");
            outputLabel.setText("Recording...");
            // TODO: Implement recording start logic
        } else {
            isRecording = false;
            recordBtn.setText("● Record");
            outputLabel.setText("Recording stopped.");
            // TODO: Implement recording stop logic
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
