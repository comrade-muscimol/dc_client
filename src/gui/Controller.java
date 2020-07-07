package gui;



import adapter.Info;


import adapter.Request;
import adapter.Maintenance;
import core.Prop;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import static core.Prop.*;

public class Controller {

    @FXML
    private Button createNewAccount_button;
    @FXML
    private Button loadKey_button;
    @FXML
    private Label history_label;
    @FXML
    private TextField login_address_textField;
    @FXML
    private TextField login_secret_textField;
    @FXML
    private TextField current_address_textField;
    @FXML
    private TextField current_secret_textField;
    @FXML
    private Button fire_button;
    @FXML
    private Label currentSeconds_label;
    @FXML
    private Label recordSeconds_label;
    @FXML
    private Label manualTax_label;
    @FXML
    private Label symbolsLine_label;
    @FXML
    private Label autoSum_label;
    @FXML
    private Label autoTax_label;
    @FXML
    private Button buy1dd_button;
    @FXML
    private Button buy10dd_button;
    @FXML
    private Button buy100dd_button;
    @FXML
    private Button sell1dd_button;
    @FXML
    private Button sell10dd_button;
    @FXML
    private Button sell100dd_button;
    @FXML
    private Label dd_buy_course;
    @FXML
    private Label dd_sell_course;
    @FXML
    private Label transaction_history_label;
    @FXML
    private TextField addressTo_textField;
    @FXML
    private Slider dc_slider;
    @FXML
    private Button send_transaction_button;
    @FXML
    private Slider dd_slider;
    @FXML
    private Button ap1_button;
    @FXML
    private Button ap10_button;
    @FXML
    private Button ap50_button;
    @FXML
    private Button ap100_button;
    @FXML
    private Label ad_points_label;
    @FXML
    private Button ad_video_button;
    @FXML
    private TextField code_textField;
    @FXML
    private Button send_code_button;
    @FXML
    private Button buy_small_dd_case_button;
    @FXML
    private Button buy_middle_dd_case_button;
    @FXML
    private Button buy_big_dd_case_button;
    @FXML
    private Button buy_small_dc_case_button;
    @FXML
    private Button buy_middle_dc_case_button;
    @FXML
    private Button buy_big_dc_case_button;
    @FXML
    private Label lottery_dc_label;
    @FXML
    private Label lottery_circulation;
    @FXML
    private Button lottery_buy_ticket_button;
    @FXML
    private Label lottery_end_label;
    @FXML
    private Button hipe_90_button;
    @FXML
    private Slider hipe_dc_slider;
    @FXML
    private Button hipe_80_button;
    @FXML
    private Button hipe_70_button;
    @FXML
    private Button hipe_60_button;
    @FXML
    private Button hipe_50_button;
    @FXML
    private Button hipe_40_button;
    @FXML
    private Button hipe_30_button;
    @FXML
    private TextField kill_address_textField;
    @FXML
    private Label kill_min_percent_label;
    @FXML
    private Label kill_max_percent_label;
    @FXML
    private Button kill_min_percent_button;
    @FXML
    private Button kill_max_percent_button;
    @FXML
    private Button kill_send_button;
    @FXML
    private TextField hack_address_textField;
    @FXML
    private Label hack_min_percent_label;
    @FXML
    private Label hack_max_percent_label;
    @FXML
    private Button hack_min_percent_button;
    @FXML
    private Button hack_max_percent_button;
    @FXML
    private Label hack_bounty_percent_label;
    @FXML
    private Button hack_bounty_percent_button;
    @FXML
    private Button hack_send_button;
    @FXML
    private Label online_points_label;
    @FXML
    private Label online_bounty_label;
    @FXML
    private Button bounty_up_button;
    @FXML
    private Button send_online_points_button;
    @FXML
    private Label rating_label;
    @FXML
    private TextField chat_message_textField;
    @FXML
    private Button chat_send_button;
    @FXML
    private Label chat_label;
    @FXML
    private Button mail_send_button;
    @FXML
    private TextField mail_addressTo_textField;
    @FXML
    private TextArea mail_text_textArea;
    @FXML
    private TextField mail_name_textField;
    @FXML
    private Label mail_inbox_label;
    @FXML
    private Label capital_label;
    @FXML
    private Label address_label;
    @FXML
    private Label diamonds_label;

    long startTime;
    double transaction_current_dc;
    int transaction_current_dd;
    double hipe_current_dc;

    DecimalFormat format_two_zero = new DecimalFormat("0.##");
    DecimalFormat format_ten_zero = new DecimalFormat("0.##########");

    Calendar calendar = Calendar.getInstance();

    @FXML
    void initialize() {
        createNewAccount_button.setOnAction(event -> { Maintenance.create_new_account();});

        buy1dd_button.setOnAction(event -> { Request.buy1dd();});
        buy10dd_button.setOnAction(event -> { Request.buy10dd();});
        buy100dd_button.setOnAction(event -> { Request.buy100dd();});
        sell1dd_button.setOnAction(event -> { Request.sell1dd();});
        sell10dd_button.setOnAction(event -> { Request.sell10dd();});
        sell100dd_button.setOnAction(event -> { Request.sell100dd();});

        send_transaction_button.setOnAction(event -> {
            Request.send_transaction(addressTo_textField.getText(), dc_slider.getValue(), (int)dd_slider.getValue());
            addressTo_textField.setText("");
            transaction_current_dc=0;
            transaction_current_dd=0;

        });
        dc_slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> obsVal,
                                Number oldVal, Number newVal) {
                transaction_current_dc = newVal.doubleValue();
            }
        });
        dd_slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> obsVal,
                                Number oldVal, Number newVal) {
                transaction_current_dd = newVal.intValue();
            }
        });

        ap1_button.setOnAction(event -> {Request.ap1();});
        ap10_button.setOnAction(event -> {Request.ap10();});
        ap50_button.setOnAction(event -> {Request.ap50();});
        ap100_button.setOnAction(event -> {Request.ap100();});
        send_code_button.setOnAction(event -> {
            Request.send_code(code_textField.getText());
            code_textField.setText("");
        });
        ad_video_button.setOnAction(event -> {Request.ad_video();});

        buy_small_dd_case_button.setOnAction(event -> {Request.small_dd_case();});
        buy_middle_dd_case_button.setOnAction(event -> {Request.middle_dd_case();});
        buy_big_dd_case_button.setOnAction(event -> {Request.big_dd_case();});
        buy_small_dc_case_button.setOnAction(event -> {Request.small_dc_case();});
        buy_middle_dc_case_button.setOnAction(event -> {Request.middle_dc_case();});
        buy_big_dc_case_button.setOnAction(event -> {Request.big_dc_case();});

        lottery_buy_ticket_button.setOnAction(event -> {Request.buy_ticket();});

        hipe_dc_slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> obsVal,
                                Number oldVal, Number newVal) {
                hipe_current_dc = newVal.doubleValue();
            }
        });
        hipe_90_button.setOnAction(event -> {
            Request.hipe_90(hipe_current_dc);
            hipe_current_dc = 0;

        });
        hipe_80_button.setOnAction(event -> {
            Request.hipe_80(hipe_current_dc);
            hipe_current_dc = 0;});
        hipe_70_button.setOnAction(event -> { Request.hipe_70(hipe_current_dc);
            hipe_current_dc = 0;});
        hipe_60_button.setOnAction(event -> { Request.hipe_60(hipe_current_dc);
            hipe_current_dc = 0;});
        hipe_50_button.setOnAction(event -> { Request.hipe_50(hipe_current_dc);
            hipe_current_dc = 0;});
        hipe_40_button.setOnAction(event -> { Request.hipe_40(hipe_current_dc);
            hipe_current_dc = 0;});
        hipe_30_button.setOnAction(event -> { Request.hipe_30(hipe_current_dc);
            hipe_current_dc = 0;});

        kill_min_percent_button.setOnAction(event -> {
            Request.kill_min_upgrade();
        });
        kill_max_percent_button.setOnAction(event -> {
            Request.kill_max_upgrade();
        });
        kill_send_button.setOnAction(event -> {
            Request.kill(kill_address_textField.getText());
            kill_address_textField.setText("");
        });

       hack_min_percent_button.setOnAction(event -> {Request.hack_min_upgrade();});
         hack_max_percent_button.setOnAction(event -> {Request.hack_max_upgrade();});
        hack_bounty_percent_button.setOnAction(event -> {Request.hack_bounty_upgrade();});

     hack_send_button.setOnAction(event -> {
         Request.hack(hack_address_textField.getText());
         hack_address_textField.setText("");
     });


       bounty_up_button.setOnAction(event -> {
           Request.op_bounty_upgrade();
       });
      send_online_points_button.setOnAction(event -> {
          Request.op_send_offer();
      });


      chat_send_button.setOnAction(event -> {
          Request.chat_send_message(chat_message_textField.getText());
          chat_message_textField.setText("");
      });

       mail_send_button.setOnAction(event -> {
           Request.mail_send_message(mail_addressTo_textField.getText(), mail_name_textField.getText(), mail_text_textArea.getText());
           mail_addressTo_textField.setText("");
           mail_text_textArea.setText("");
           mail_name_textField.setText("");
       });

        loadKey_button.setOnAction(event -> {

            Maintenance.login(login_address_textField.getText(), login_secret_textField.getText());

        });


        fire_button.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                    startTime = System.currentTimeMillis();
                }
                else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {

                    long time = System.currentTimeMillis()-startTime;
                    if(time/1000>=1){
                        Request.manual((int)time/1000);
                        startTime = 0;
                    }else{
                    }
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(SYMBOL_CHANGE_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //////////////////////
                            Maintenance.refresh_index();
                            Maintenance.refresh_main();
                            //////////////////////
                        }
                    });
                }
            }
        }).start();//поток обновления индекса и данных с сервера
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //////////////////////
                            refresh();
                            //////////////////////
                        }
                    });
                }
            }
        }).start();//поток обновления надписей на экране
    }
    public void refresh(){
        try {
            if(Info.address()!=null&&Info.secret()!=null) {


                if (startTime != 0) {
                    currentSeconds_label.setText(String.valueOf((System.currentTimeMillis() - startTime) / 1000));
                }

                if (
                        !current_secret_textField.getText().equals(Info.secret())
                                ||
                                !current_address_textField.getText().equals(Info.address())) {
                    current_address_textField.setText(Info.address());
                    current_secret_textField.setText(Info.secret());
                }

                manualTax_label.setText("Текущий курс: " + format_ten_zero.format(Info.manual_tax()) + " dc за 1 секунду");
                autoTax_label.setText("Текущий курс: " + format_ten_zero.format(Info.auto_tax()) + " dc за 1 совпадение");

                buy1dd_button.setText("Купить 1dd за " + Info.course_buy_dd() * 1 + "dc");
                buy10dd_button.setText("Купить 10dd за " + Info.course_buy_dd() * 10 + "dc");
                buy100dd_button.setText("Купить 100dd за " + Info.course_buy_dd() * 100 + "dc");
                sell1dd_button.setText("Продать 1dd за " + Info.course_sell_dd() * 1 + "dc");
                sell10dd_button.setText("Продать 10dd за " + Info.course_sell_dd() * 10 + "dc");
                sell100dd_button.setText("Продать 100dd за " + Info.course_sell_dd() * 100 + "dc");

                send_transaction_button.setText("Transaction : " + format_ten_zero.format(dc_slider.getValue()) + "dc & " + (int) dd_slider.getValue() + "dd --- Comission : " + format_ten_zero.format(dc_slider.getValue() * Info.transaction_comission()) + "dc (" + format_two_zero.format(Info.transaction_comission() * 100) + "%) + 1dd");

                hipe_90_button.setText("Вложить " + format_ten_zero.format(hipe_dc_slider.getValue()) + "dc --- "+HIPE_90_CHANCE*100+" --- Вернется " + format_ten_zero.format(hipe_dc_slider.getValue() * HIPE_90_MULTIPLIER) + "dc");
                hipe_80_button.setText("Вложить " + format_ten_zero.format(hipe_dc_slider.getValue()) + "dc --- "+HIPE_80_CHANCE*100+" --- Вернется " + format_ten_zero.format(hipe_dc_slider.getValue() * HIPE_80_MULTIPLIER) + "dc");
                hipe_70_button.setText("Вложить " + format_ten_zero.format(hipe_dc_slider.getValue()) + "dc --- "+HIPE_70_CHANCE*100+" --- Вернется " + format_ten_zero.format(hipe_dc_slider.getValue() * HIPE_70_MULTIPLIER) + "dc");
                hipe_60_button.setText("Вложить " + format_ten_zero.format(hipe_dc_slider.getValue()) + "dc --- "+HIPE_60_CHANCE*100+" --- Вернется " + format_ten_zero.format(hipe_dc_slider.getValue() * HIPE_60_MULTIPLIER) + "dc");
                hipe_50_button.setText("Вложить " + format_ten_zero.format(hipe_dc_slider.getValue()) + "dc --- "+HIPE_50_CHANCE*100+" --- Вернется " + format_ten_zero.format(hipe_dc_slider.getValue() * HIPE_50_MULTIPLIER) + "dc");
                hipe_40_button.setText("Вложить " + format_ten_zero.format(hipe_dc_slider.getValue()) + "dc --- "+HIPE_40_CHANCE*100+" --- Вернется " + format_ten_zero.format(hipe_dc_slider.getValue() * HIPE_40_MULTIPLIER) + "dc");
                hipe_30_button.setText("Вложить " + format_ten_zero.format(hipe_dc_slider.getValue()) + "dc --- "+HIPE_30_CHANCE*100+" --- Вернется " + format_ten_zero.format(hipe_dc_slider.getValue() * HIPE_30_MULTIPLIER) + "dc");

                String transaction_history = "";
                List<String> input_list = Info.transaction_last_100();
                for (String s : input_list) {
                    transaction_history += s + "\n";
                }
                transaction_history_label.setText(transaction_history);

                ad_points_label.setText(Info.ad_points() + "ap");

                recordSeconds_label.setText(String.valueOf(Info.record_seconds()));
                symbolsLine_label.setText(String.valueOf(Info.symbols_line()));
                autoSum_label.setText(String.valueOf(Info.auto_sum()));

                history_label.setText(String.valueOf(Info.history()));
                capital_label.setText(String.valueOf(format_ten_zero.format(Info.dc())));
                address_label.setText(String.valueOf(Info.address()));
                diamonds_label.setText(String.valueOf(Info.dd()));

                dd_buy_course.setText(String.valueOf("Текуший курс покупки 1 dd ---> " + format_ten_zero.format(Info.course_buy_dd()) + "dc"));
                dd_sell_course.setText(String.valueOf("Текуший курс продажи 1 dd ---> " + format_ten_zero.format(Info.course_sell_dd()) + "dc"));

                dc_slider.setMin(0);
                dc_slider.setMax(Info.dc());
                dd_slider.setMin(0);
                dd_slider.setMax(Info.dd());


                calendar.setTimeInMillis(Info.lottery_end());
                lottery_end_label.setText(calendar.getTime().toString());

                lottery_dc_label.setText("Призовой фонд: " + format_ten_zero.format(Info.lottery_dc()));
                lottery_circulation.setText("Тираж: " + Info.lottery_circulations());

                lottery_buy_ticket_button.setText(
                        "Купить билет (" +
                                format_ten_zero.format(Info.lottery_ticket_price()) +
                                "dc) " + "Уже куплено билетов: " + Info.lottery_my_tickets() +
                                ". Текущий шанс: " +
                                format_two_zero.format((Info.lottery_my_tickets() / Info.lottery_circulations()) * 100) +
                                "%");

                hipe_dc_slider.setMin(0);
                hipe_dc_slider.setMax(Info.dc());

                online_points_label.setText(Info.op() + "op");
                online_bounty_label.setText(format_ten_zero.format(Info.op_bounty()) + "dc за 60 op (минут онлайна)");


                kill_min_percent_label.setText("Минимальный шанс: " + format_two_zero.format(Info.kill_min_percent() * 100) + "%");
                kill_max_percent_label.setText("Максимальный шанс: " + format_two_zero.format(Info.kill_max_percent() * 100) + "%");

                hack_min_percent_label.setText("Минимальный шанс: " + format_two_zero.format(Info.hack_min_percent() * 100) + "%");
                hack_max_percent_label.setText("Максимальный шанс: " + format_two_zero.format(Info.hack_max_percent() * 100) + "%");
                hack_bounty_percent_label.setText("Награда : " + format_two_zero.format(Info.hack_bounty_percent() * 100) + "% от dc жертвы");

                String rating = "";
                for (String s : Info.rating_top_100()) {
                    rating += s + "\n";
                }
                rating_label.setText(rating);
                String chat = "";
                for (String s : Info.chat_messages_list()) {
                    chat += s + "\n";
                }
                chat_label.setText(chat);

                String mail = "";
                for (String s : Info.mail_messages_list()) {
                    mail += s + "\n";
                }
                mail_inbox_label.setText(mail);
            }
        }catch (Exception e){

        }
    }
}
