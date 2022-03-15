package com.restaurant;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Restaurant_Website extends Application {


    public static void main(String[] args) {
        launch();
    }

    public ArrayList<HBox> getNavigationBarList(int pages, double navSpace){

        // initialize ArrayList of horizontal boxes that will contain page navigating buttons
        ArrayList<HBox> navigationList = new ArrayList<>();

        // for each page that needs a navigation bar
        for (int i = 0; i < pages; i++){

            //declare page navigating buttons
            Button goHome = new Button("Home");
            Button goLogin = new Button("Login");
            Button goMenu = new Button("Order/Menu");

            //setup horizontal box with spacing defined in the parameter
            HBox navigation = new HBox();
            navigation.setAlignment(Pos.TOP_CENTER);
            navigation.getChildren().addAll(goHome, goLogin, goMenu);
            navigation.setSpacing(navSpace);

            //add HBox to the front of the list
            navigationList.add(navigation);
        }

        //after populating navigation bars, return list
        return navigationList;

    }

    @Override
    public void start(Stage primaryStage) {
        try {

            //init constants and declare scene variables
            double width = 1000, height = 750, navSpace = 50;
            int pageCount = 3;
            int home = 0, login = 1, menu = 2;
            String website_title = "www.fivenights@fortnite.com";

            ArrayList<HBox> nav = getNavigationBarList(pageCount, navSpace);

            //declare home page UI with nav buttons at top
            HomePage home_gui = new HomePage();

            VBox home_layout = new VBox();
            home_layout.getChildren().addAll(nav.get(home), home_gui);

            // "" for menu page
            MenuPage menu_gui = new MenuPage();

            VBox menu_layout = new VBox();
            menu_layout.getChildren().addAll(nav.get(menu), menu_gui);

            // "" for login page
            LoginPage login_gui = new LoginPage();

            VBox login_layout = new VBox();
            login_layout.getChildren().addAll(nav.get(login), login_gui);

            //init each scene with same constants but different layouts
            ArrayList<Scene> sceneList = new ArrayList<>();

            Scene homeScene = new Scene(home_layout, width, height);
            Scene loginScene = new Scene(login_layout, width, height);
            Scene menuScene = new Scene(menu_layout, width, height);

            sceneList.add(homeScene);
            sceneList.add(loginScene);
            sceneList.add(menuScene);

            //setup button event handlers to navigate to the respective page
            for (int page = 0; page < pageCount; page++){
                ((Button) nav.get(page).getChildren().get(home)).setOnAction(e -> primaryStage.setScene(homeScene));
                ((Button) nav.get(page).getChildren().get(menu)).setOnAction(e -> primaryStage.setScene(menuScene));
                ((Button) nav.get(page).getChildren().get(login)).setOnAction(e -> primaryStage.setScene(loginScene));
            }

            //display home page on startup
            primaryStage.setTitle(website_title);
            primaryStage.setScene(homeScene);
            primaryStage.show();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}