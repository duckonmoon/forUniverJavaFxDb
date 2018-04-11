package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.JPAUtil;

import javax.persistence.EntityManagerFactory;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        Parent root = FXMLLoader.load(getClass().getResource("/controller/main.fxml"));
        primaryStage.setTitle("University");
        primaryStage.getIcons().add(new Image("/drawable/spring-framework-project-logo.png"));
        primaryStage.setScene(new Scene(root, 750, 600));
        primaryStage.setResizable(false);
        primaryStage.show();


        primaryStage.setOnCloseRequest(event -> {
                    JPAUtil.shutdown();
                }
        );

    }
}
