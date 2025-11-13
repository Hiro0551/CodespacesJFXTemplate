package edu.sdccd.cisc;

//TODO: import javafx libraries
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // TODO: title
        stage.setTitle("Message Board");

        // TODO: header
        Label header = new Label("Message Board");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // TODO: status label
        Label status = new Label("Ready");

        // TODO: Input row: TextField + Add button
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a message...");
        Button addBtn = new Button("Add Message");
        HBox inputRow = new HBox(10, inputField, addBtn);
        inputRow.setPadding(new Insets(5, 0, 5, 0));

        // TODO: prompt for message
        // (Handled via inputField.setPromptText above)

        // TODO: add button
        // (Created above as addBtn)

        // TODO: reset button
        Button resetBtn = new Button("Reset");

        // TODO: message history area
        TextArea historyArea = new TextArea();
        historyArea.setEditable(false);
        historyArea.setWrapText(true);
        VBox.setVgrow(historyArea, Priority.ALWAYS);

        // TODO: Wire up the Add button.
        // - If input text is empty or blank: set status to "Nothing to add" and return.
        // - Otherwise: append text to history (one line per message),
        //              clear the input field,
        //              set status to "Last action: added message".
        addBtn.setOnAction(e -> {
            String text = inputField.getText().trim();
            if (text.isEmpty()) {
                status.setText("Nothing to add");
                return;
            }
            historyArea.appendText(text + "\n");
            inputField.clear();
            status.setText("Last action: added message");
        });

        // TODO: Wire up the Reset button.
        // - Clear history and input.
        // - Set status to "Cleared".
        resetBtn.setOnAction(e -> {
            inputField.clear();
            historyArea.clear();
            status.setText("Cleared");
        });

        // TODO: add content to root
        VBox root = new VBox(10, header, status, inputRow, resetBtn, historyArea);
        root.setPadding(new Insets(15));

        // TODO: set scene and show stage
        Scene scene = new Scene(root, 420, 320);
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(300);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
