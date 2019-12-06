package game.frontend;

import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level3;
import javafx.scene.control.*;

import java.util.Optional;

public class AppMenu extends MenuBar {

    public AppMenu() {
        Menu file = new Menu("Archivo");
        MenuItem exitMenuItem = new MenuItem("Salir");
        exitMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText("Salir de la aplicación");
            alert.setContentText("¿Está seguro que desea salir de la aplicación?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    System.exit(0);
                }
            }
        });
        file.getItems().add(exitMenuItem);

        Menu help = new Menu("Ayuda");
        MenuItem aboutMenuItem = new MenuItem("Acerca De");
        aboutMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca De");
            alert.setHeaderText("Candy TPE");
            alert.setContentText("Cátedra POO 2018.\n" +
                    "Implementación Original: Laura Zabaleta (POO 2013).\n" +
                    "Modificaciones Realizadas Por: Arca, Revich, Rodriguez (POO 2019).");
            alert.showAndWait();
        });
        help.getItems().add(aboutMenuItem);

        Menu menuLevels = new Menu("Levels");
        MenuItem[] levels = new MenuItem[3];
        for(int i=0;i < 3;i++) {
            levels[i] = new MenuItem("Level " + ( i + 1 ));
        }

        levels[0].setOnAction(event -> GameApp.startLevel(Level1.class, new L1ScorePanel(), this));
        levels[1].setOnAction(event -> GameApp.startLevel(Level2.class,new L2ScorePanel(), this));
        levels[2].setOnAction(event -> GameApp.startLevel(Level3.class,new L3ScorePanel(), this));

        menuLevels.getItems().addAll(levels);
        getMenus().addAll(file, menuLevels, help);
    }

}
