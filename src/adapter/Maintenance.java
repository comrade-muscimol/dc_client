package adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.Account;
import core.Job;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import packages.*;

import java.util.ArrayList;
import java.util.List;

public class Maintenance {

    static String server_address = "http://localhost:9307/dark/";

    static String servlet_create = "/create";
    static String servlet_refresh_index = "/refresh_index";
    static String servlet_refresh_main = "/refresh_main";
    static String servlet_check = "/check";

    static String param_name = "encrypted_string";
    static String mainKey = "fgdb53t4bvw3112efrv544tv342cr31234uk0lk776b4wcrxqxfgvht6thy6554xfgyb7buy";

    public static void refresh_index() {
        if(Account.getInstance().getAddress()==null||Account.getInstance().getSecret()==null){
            return;
        }

        String out = "";
        IndexRequestPackage output_package = new IndexRequestPackage();

        output_package.address = Account.getInstance().getAddress();
        output_package.secret = Account.getInstance().getSecret();

        output_package.account_last_update = Account.getInstance().getAccount_last_update();

        output_package.bank_last_update = Account.getInstance().getBank_last_update();
        output_package.transaction_last_update = Account.getInstance().getTransaction_last_update();
        output_package.lottery_last_update = Account.getInstance().getLottery_last_update();

        output_package.history_last_update = Account.getInstance().getHistory_last_update();
        output_package.mail_last_update= Account.getInstance().getMail_last_update();
        output_package.chat_last_update= Account.getInstance().getChat_last_update();
        output_package.rating_last_update= Account.getInstance().getRating_last_update();

        out = serial_index_package(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        try{
            String encrypted_string = Job.send_and_get(server_address +servlet_refresh_index, urlParameters);
            String decoded_string = encrypted_string;
            IndexResponsePackage input_response = de_serial_index_package(decoded_string);

            if(!input_response.valid_address||!input_response.valid_secret){
                Account.getInstance().setAddress(null);
                Account.getInstance().setSecret(null);
                return;
            }else{
                Account.getInstance().add_symbol(input_response.symbol);
                Account.getInstance().setAccount_outdated(input_response.account_outdated);

                Account.getInstance().setBank_outdated(input_response.bank_outdated);
                Account.getInstance().setTransaction_outdated(input_response.transaction_outdated);
                Account.getInstance().setLottery_outdated(input_response.lottery_outdated);

                Account.getInstance().setHistory_outdated(input_response.history_outdated);
                Account.getInstance().setMail_outdated(input_response.mail_outdated);
                Account.getInstance().setChat_outdated(input_response.chat_outdated);
                Account.getInstance().setRating_outdated(input_response.rating_outdated);

                //new Thread(() -> refresh_main()).start();
            }

        }catch (Exception e){

        }
    }
    public static void refresh_main() {

        if(Account.getInstance().getAddress()==null||Account.getInstance().getSecret()==null){
            return;
        }
        String request = "";

        MainRequestPackage output_package = new MainRequestPackage();

        output_package.address = Account.getInstance().getAddress();
        output_package.secret = Account.getInstance().getSecret();


        if(Account.getInstance().isAccount_outdated()) {
            output_package.type = "account";
            request = serial_main_package(output_package);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));
            try {
                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;

                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setAccount_last_update(input_response.long_params.get("account_last_update"));
                Account.getInstance().setDd(input_response.integer_params.get("dd"));
                Account.getInstance().setDc(input_response.double_params.get("dc"));
                Account.getInstance().setRecord(input_response.integer_params.get("record"));
                Account.getInstance().setAds_points(input_response.integer_params.get("ads_points"));
                Account.getInstance().setLottery_tickets(input_response.integer_params.get("lottery_tickets"));
                Account.getInstance().setKill_minimum_percent(input_response.double_params.get("kill_minimum_percent"));
                Account.getInstance().setKill_maximum_percent(input_response.double_params.get("kill_maximum_percent"));
                Account.getInstance().setHack_minimum_percent(input_response.double_params.get("hack_minimum_percent"));
                Account.getInstance().setHack_maximum_percent(input_response.double_params.get("hack_maximum_percent"));
                Account.getInstance().setHack_bounty_percent(input_response.double_params.get("hack_bounty_percent"));
                Account.getInstance().setOnline_points(input_response.integer_params.get("online_points"));
                Account.getInstance().setOnline_bounty(input_response.double_params.get("online_bounty"));

                Account.getInstance().setAccount_outdated(false);

            } catch (Exception e) {
                java.lang.System.out.println("Что то случилось при десериализации");
                e.printStackTrace();
            }

        }
        if(Account.getInstance().isBank_outdated()) {
            output_package.type = "bank";

            request = serial_main_package(output_package);


            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));

            try {

                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;

                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setBank_last_update(input_response.long_params.get("bank_last_update"));
                Account.getInstance().setBank_manual_tax(input_response.double_params.get("bank_manual_tax"));
                Account.getInstance().setBank_auto_tax(input_response.double_params.get("bank_auto_tax"));
                Account.getInstance().setBank_dd_course_buy(input_response.double_params.get("bank_dd_course_buy"));
                Account.getInstance().setBank_dd_course_sell(input_response.double_params.get("bank_dd_course_sell"));


                Account.getInstance().setBank_outdated(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(Account.getInstance().isTransaction_outdated()) {
            output_package.type = "transaction";

            request = serial_main_package(output_package);


            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));

            try {

                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;

                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setTransaction_last_update(input_response.long_params.get("transaction_last_update"));
                Account.getInstance().setTransaction_last_100(input_response.universal_list);
                Account.getInstance().setTransaction_tax_percent(input_response.double_params.get("transaction_tax_percent"));

                Account.getInstance().setTransaction_outdated(false);

            } catch (Exception e) {}

        }
        if(Account.getInstance().isLottery_outdated()) {
            output_package.type = "lottery";

            request = serial_main_package(output_package);


            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));

            try {

                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;

                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setLottery_last_update(input_response.long_params.get("lottery_last_update"));
                Account.getInstance().setLottery_end(input_response.long_params.get("lottery_end"));
                Account.getInstance().setLottery_dc(input_response.double_params.get("lottery_dc"));
                Account.getInstance().setLottery_circulation(input_response.integer_params.get("lottery_circulation"));
                Account.getInstance().setLottery_ticket_coast(input_response.double_params.get("lottery_ticket_coast"));

                Account.getInstance().setLottery_outdated(false);

            } catch (Exception e) {}


        }
        if(Account.getInstance().isHistory_outdated()) {
            output_package.type = "history";

            request = serial_main_package(output_package);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));

            try {
                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;

                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setHistory_last_update(Long.valueOf(input_response.long_params.get("history_last_update")));
                Account.getInstance().add_to_history(input_response.universal_list);

                Account.getInstance().setHistory_outdated(false);

            } catch (Exception e) {}

        }
        if(Account.getInstance().isMail_outdated()) {
            output_package.type = "mail";

            request = serial_main_package(output_package);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));

            try {

                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;

                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setMail_last_update(Long.valueOf(input_response.long_params.get("mail_last_update")));
                Account.getInstance().add_to_mail(input_response.universal_list);

                Account.getInstance().setMail_outdated(false);

            } catch (Exception e) {}

        }
        if(Account.getInstance().isChat_outdated()) {
            output_package.type = "chat";

            request = serial_main_package(output_package);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));

            try {

                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;


                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setChat_last_update(Long.valueOf(input_response.long_params.get("chat_last_update")));
                Account.getInstance().setChat_last(input_response.universal_list);

                Account.getInstance().setChat_outdated(false);

            } catch (Exception e) {}

        }
        if(Account.getInstance().isRating_outdated()) {
            output_package.type = "rating";

            request = serial_main_package(output_package);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(param_name, request));

            try {

                String response = Job.send_and_get(server_address + servlet_refresh_main, urlParameters);

                String decoded_response = response;

                MainResponsePackage input_response = de_serial_main_package(decoded_response);

                Account.getInstance().setRating_last_update(Long.valueOf(input_response.long_params.get("rating_last_update")));
                Account.getInstance().setTop_100_rating(input_response.universal_list);

                Account.getInstance().setRating_outdated(false);

            } catch (Exception e) {

            }

        }


    }

    public static void create_new_account() {
        String out = "";

        CreateRequestPackage output_request = new CreateRequestPackage();
        output_request.id = "id";

        out = serial_create_package(output_request);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));
        String response = "";
        try{
            response = Job.send_and_get(server_address+servlet_create, urlParameters);

            CreateResponsePackage input_response = de_serial_create_package(response);


            Account.getInstance().setAddress(input_response.address);
            Account.getInstance().setSecret(input_response.secret);

            Account.getInstance().setAccount_outdated(true);

            Account.getInstance().setBank_outdated(true);
            Account.getInstance().setTransaction_outdated(true);
            Account.getInstance().setLottery_outdated(true);

            Account.getInstance().setHistory_outdated(true);
            Account.getInstance().setMail_outdated(true);
            Account.getInstance().setChat_outdated(true);
            Account.getInstance().setRating_outdated(true);



        }catch (Exception e){
            java.lang.System.out.println("Ошибка при чтении адреса и секрета");
        }

    }

    public static void login(String address, String secret){
        Account.getInstance().setAddress(address);
        Account.getInstance().setSecret(secret);
    }

    private static String encode(String address) {

        byte[] adr = address.getBytes();
        byte[] key = mainKey.getBytes();
        byte[] res = new byte[address.length()];
        for (int i = 0; i < adr.length; i++) {
            res[i] = (byte) (adr[i] ^ key[i % key.length]);
        }

        return res.toString();
    }
    private static String decode(String secret) {

        byte[] sec = secret.getBytes();
        byte[] res = new byte[sec.length];
        byte[] key = mainKey.getBytes();
        for (int i = 0; i < secret.toCharArray().length; i++) {
            res[i] = (byte) (sec[i] ^ key[i % key.length]);
        }
        return new String(res);
    }
    private static String serial_index_package(IndexRequestPackage pack){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSON  = gson.toJson(pack);
        return JSON;
    }
    private static String serial_main_package(MainRequestPackage pack){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSON  = gson.toJson(pack);
        return JSON;
    }
    private static String serial_create_package(CreateRequestPackage pack){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSON  = gson.toJson(pack);
        return JSON;
    }
    public static IndexResponsePackage de_serial_index_package(String json){
        try {
            Gson gson = new Gson();
            IndexResponsePackage input = gson.fromJson(json, IndexResponsePackage.class);
            return input;
        } catch (Exception e) {
            java.lang.System.out.println("Ошибка при парсинге json");
            java.lang.System.out.println(json);
            return null;
        }
    }
    public static MainResponsePackage de_serial_main_package(String json){
        try {
            Gson gson = new Gson();
            MainResponsePackage input = gson.fromJson(json, MainResponsePackage.class);
            return input;
        } catch (Exception e) {
            java.lang.System.out.println("Ошибка при парсинге json");
            java.lang.System.out.println(json);
            return null;
        }
    }
    public static CreateResponsePackage de_serial_create_package(String json){
        try {
            Gson gson = new Gson();
            CreateResponsePackage input = gson.fromJson(json, CreateResponsePackage.class);
            return input;
        } catch (Exception e) {
            java.lang.System.out.println("Ошибка при парсинге json");
            java.lang.System.out.println(json);
            return null;
        }
    }

}
