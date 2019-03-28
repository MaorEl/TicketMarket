package View;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VacationDetailsWindow implements Initializable {

    public Button BackButton;
    public Label event;
    public Label description;
    public Label quantity;
    public Label startTime;
    public Label startDate;
    public Label EndTime;
    public Label EndDate;
    public Label type;
    public Label price;

    private Controller controller = Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String vacationID = controller.vacationID;
        String[] details = controller.readVacation(vacationID);
        event.setText(details[2]);
        startDate.setText(details[3]);
        startTime.setText(details[4]);
        quantity.setText(details[5]);//quantity
        EndDate.setText(details[6]);
        EndTime.setText(details[7]);
        //l_returnDate.setText(details[8]);
        //l_returnTime.setText(details[9]);
        //l_ticketType.setText(details[10]);
        description.setText(details[11]);
        //l_connectionCity.setText(details[12]);
        //l_baggage.setText(details[14]);
        type.setText(details[15]);
        price.setText(details[16] + "$");
    }

    public void go_main(ActionEvent actionEvent) {
        Stage s = (Stage) BackButton.getScene().getWindow();
        s.close();
    }
}
