/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc4;

/**
 *
 * @author ahmed mamdouh
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField messageTextField;
    public TextField KeyTextField;
    public Button encryptButton;
    public Button decryptButton;
    public Label headerLabel;
    public Label encryptedLabel;

    RC4Cipher rc4Cipher;

    @FXML
    private void initialize() {

        rc4Cipher = new RC4Cipher();

        encryptButton.setOnMouseClicked(mouseEvent -> handleEncryptButton());
        decryptButton.setOnMouseClicked(mouseEvent -> handleDecryptedButton());
    }

    private void handleEncryptButton() {
        String message = messageTextField.getText();
        String key = KeyTextField.getText();

        rc4Cipher.setKey(key);
        String encryptedMessage = rc4Cipher.encrypt(message);

        showEncryptedMessage(encryptedMessage);
    }

    private void handleDecryptedButton() {
        String encryptedMessage = encryptedLabel.getText();
        String decryptedMessage = rc4Cipher.decrypt(encryptedMessage);
        showDecryptedMessage(decryptedMessage);
    }

    private void showEncryptedMessage(String encryptedMessage) {
        headerLabel.setVisible(true);
        encryptedLabel.setText(encryptedMessage);
        messageTextField.clear();
    }

    private void showDecryptedMessage(String decryptedMessage) {
        headerLabel.setVisible(false);
        messageTextField.setText(decryptedMessage);
        encryptedLabel.setText("");
    }

}

