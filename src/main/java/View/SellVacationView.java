package View;

import Controller.Controller;
import Model.Excpetions.V4UException;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class SellVacationView implements Initializable {

    public Button publish_for_sale_button;
    public Button BackButton;
    public TextField Event;
    public DatePicker startDate;
    public TextField startTime;
    public TextField quantity;
    public DatePicker returnDate;
    public TextField returnTime;
    public DatePicker EndDate;
    public TextField EndTime;
    public TextField classType;
    public TextField ticketType;
    public TextField connectionCity;
    public TextField baggageInfo;
    public CheckBox baggage;
    public TextField Price;
    public TextField description;

//    public void publish(ActionEvent actionEvent) {
//        String _from, _departureTime, _destination, _returnTime, _arrivalTime,
//                _classType, _ticketType, _connectionCity, _baggageInfo, _price, _company;
//        boolean _baggage;
//        _from = from.getText();
//        _departureTime = departureTime.getText();
//        _destination = destination.getText();
//        _returnTime = returnTime.getText();
//        _arrivalTime = arrivalTime.getText();
//        _classType = classType.getText();
//        _ticketType = ticketType.getText();
//        _connectionCity = connectionCity.getText();
//        _baggageInfo = baggageInfo.getText();
//        _baggage = baggage.isSelected();
//        _price = Price.getText();
//        _company = company.getText();
//
//        Object[] vacation_details = new Object[]{_from,departureDate, _departureTime,_destination,arrivalDate,_arrivalTime,returnDate,_returnTime,_ticketType,_company,_connectionCity,baggage,_baggageInfo,_classType,_price};
//        try {
//            controller.insertNewVacation("Vacations", vacation_details);
//            Stage s = (Stage) BackButton.getScene().getWindow();
//            s.close();
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//
//        }
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Security Alert");
//        alert.setHeaderText("Your vacation was published!");
//        alert.showAndWait();
//
//    }

    public void publish(ActionEvent actionEvent) {
        String _from, _departureTime, _destination, _returnTime, _arrivalTime,
                _classType, _ticketType, _connectionCity, _baggageInfo, _price, _company;
        boolean _baggage;
        _from = Event.getText();
        _departureTime = startTime.getText();
        _destination = quantity.getText();
        //_returnTime = returnTime.getText();
        _returnTime = "00:00";
        _arrivalTime = EndTime.getText();
        _classType = classType.getText();
        //_ticketType = ticketType.getText();
        _ticketType ="0";
        //_connectionCity = connectionCity.getText();
        _connectionCity="0";
        _baggageInfo = "0";
        _baggage = false;
        _price = Price.getText();
        _company = description.getText();

        Object[] vacation_details = new Object[]{_from,startDate, _departureTime,_destination,EndDate,_arrivalTime,EndDate,_returnTime,_ticketType,_company,_connectionCity,baggage,_baggageInfo,_classType,_price,"Available"};
        boolean flag = false;
        try {
            flag = controller.insertNewVacation("Vacations", vacation_details);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Your Request Failed!");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
        if(flag) {
            Stage s = (Stage) BackButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ticket Published");
            alert.setHeaderText("Your Ticket was published!");
            alert.showAndWait();
            s.close();

        }

    }

    private Controller controller = Controller.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

//    public void update_info(ActionEvent actionEvent) {
//        /*
//        show current connected_user's details by default
//         */
//
//        String user, city, ln, fn, password;
//        Date date = new Date();
//
////        updatedDetails[2] = bd.getValue();
//        boolean flag = false;
//        try {
//            flag = controller.update("Users", updatedDetails, (String) updatedDetails[0]);
//        } catch (V4UException e) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Error");
//            alert.setHeaderText(e.getMessage());
//            alert.showAndWait();
//
//        }
//        if (flag) {
//            Stage s = (Stage) BackButton.getScene().getWindow();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Update Confirm");
//            alert.setHeaderText("Your details have been updated!");
//            alert.showAndWait();
//            s.close();
//        }

    public void go_main(ActionEvent actionEvent) {
        Stage s = (Stage) BackButton.getScene().getWindow();
        s.close();
    }
}