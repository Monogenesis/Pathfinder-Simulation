package de.hhn.it.pp.javafx.controllers;

import de.hhn.it.pp.components.api.src.main.java.api.ApiService;
import de.hhn.it.pp.components.api.src.main.java.api.Api;

import de.hhn.it.pp.javafx.controllers.interaction.InteractionController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ApiServiceController extends Controller implements Initializable {

    @FXML
    ListView<String> interactionListView;
    @FXML
    AnchorPane controlAnchorPane;
    Node actualControlAnchorPaneNode;
    Label functionsLabel;
    ObservableList<String> executableInteractions;
    Api api;
    String currentInteraction;

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(ApiServiceController.class);

    public ApiServiceController() {

        executableInteractions = FXCollections.observableArrayList();
        functionsLabel = new Label("Functions: ");
        api = new ApiService();
        api.addInventory("My inventory", 80, 50);
        api.addInventory("Freddys inventory", 30, 20);
        /*Inventory testInventory = new Inventory(1, "Kevins Inventory", 500, 700, 0);
        api.editInventory(testInventory);*/
        api.removeInventory(2);


//        for(Interaction i: Interaction.values()){
//            executableInteractions.add(i);
//        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        interactionListView.setItems(executableInteractions);
        interactionListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new InteractionCell();
            }
        });

        actualControlAnchorPaneNode = functionsLabel;
        controlAnchorPane.getChildren().add(functionsLabel);
    }

    private class InteractionCell extends ListCell<String>{
        @Override
        protected void updateItem(final String interaction, final boolean empty){
            super.updateItem(interaction, empty);
            Label label = new Label();
            if(interaction != null){
                label.setText(interaction.toString());
            }
            setGraphic(label);
        }
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) {
        logger.debug("clicked on " + interactionListView.getSelectionModel().getSelectedItem());

        currentInteraction = interactionListView.getSelectionModel().getSelectedItem();

        // remove current node from the controlAnchorPane
        if (actualControlAnchorPaneNode != null) {
            controlAnchorPane.getChildren().remove(actualControlAnchorPaneNode);
        }

        if (currentInteraction == null) {
            logger.info("No interaction selected.");
            actualControlAnchorPaneNode = functionsLabel;
            controlAnchorPane.getChildren().add(functionsLabel);
            return;
        }

        InteractionController currentInteractioncontroller = new InteractionController(currentInteraction);
        actualControlAnchorPaneNode = currentInteractioncontroller;
        controlAnchorPane.getChildren().add(currentInteractioncontroller);

    }
}
