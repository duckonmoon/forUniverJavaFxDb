package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.JDBCUtil;

import java.sql.SQLException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Parent root = FXMLLoader.load(getClass().getResource("/controller/main.fxml"));
        primaryStage.setTitle("University");
        primaryStage.setScene(new Scene(root, 750, 600));
        primaryStage.setResizable(false);
        primaryStage.show();


        primaryStage.setOnCloseRequest(event -> {
                    //HibernateUtil.shutdown();
                    try {
                        JDBCUtil.shutDown();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        );

    }
}