package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AdminInterfaceController {

    @FXML
    private void handleLogOutButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Hiển thị hộp thoại xác nhận đăng xuất
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(stage);
            alert.setTitle("Đăng xuất");
            alert.setHeaderText("Bạn muốn đăng xuất?");
            alert.setContentText("Bạn có muốn lưu dữ liệu trước khi đăng xuất?");

            // Chờ người dùng phản hồi
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Tải giao diện đăng nhập
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/library/login.fxml"));
                Parent loginRoot = loader.load();

                stage.setScene(new Scene(loginRoot));
                stage.setTitle("Đăng nhập");

                stage.centerOnScreen();
                stage.show();
            }
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Lỗi", "Không thể tải giao diện đăng nhập.");
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



}