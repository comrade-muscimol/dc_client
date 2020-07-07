package adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.Account;
import core.Job;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import packages.InRequestPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Request {
    static String address = "http://localhost:9307/dark/";
    static String servlet = "/in";
    static String param_name = "encrypted_string";
    static String mainKey = "fgdb53t4bvw3112efrv544tv342cr31234uk0lk776b4wcrxqxfgvht6thy6554xfgyb7buy";

    public static void manual(int seconds) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();

        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "manual";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());
        output_package.integer_params.put("record", seconds);
        out =serial(output_package);


        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void auto(int matches){
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "auto";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());
        output_package.integer_params.put("matches", matches);
        out = serial(output_package);


        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("encrypted_string", out));

        new Job(address+servlet, urlParameters);
    }

    public static void buy1dd() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "buy1dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);


        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void buy10dd() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "buy10dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out =serial(output_package);


        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void buy100dd() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "buy100dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);


        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void sell1dd() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "sell1dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);


        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void sell10dd() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "sell10dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);


        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void sell100dd() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "sell100dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void send_transaction(String address_to, double dc, int dd) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "transaction";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());
        output_package.string_params.put("address_to",address_to);
        output_package.double_params.put("dc", dc);
        output_package.integer_params.put("dd", dd);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void send_code(String code) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "code";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());
        output_package.string_params.put("code",code);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void ap1() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "ap1";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void ap10() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "ap10";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void ap50() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "ap50";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void ap100() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "ap100";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void ad_video() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "ad";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void op_bounty_upgrade() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "online_upgrade";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);

    }
    public static void op_send_offer() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "online";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void small_dd_case() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "small_dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void middle_dd_case() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "middle_dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void big_dd_case() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "big_dd";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void small_dc_case() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "small_dc";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void middle_dc_case() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "middle_dc";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void big_dc_case() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "big_dc";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void buy_ticket() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "buy_lottery_ticket";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);

    }

    public static void hipe_90(double dc) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hipe_90";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.double_params.put("dc", dc);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hipe_80(double dc) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hipe_80";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.double_params.put("dc", dc);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hipe_70(double dc) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hipe_70";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.double_params.put("dc", dc);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hipe_60(double dc) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hipe_60";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.double_params.put("dc", dc);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hipe_50(double dc) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hipe_50";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.double_params.put("dc", dc);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hipe_40(double dc) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hipe_40";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.double_params.put("dc", dc);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hipe_30(double dc) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hipe_30";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.double_params.put("dc", dc);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void kill(String addressTo) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "kill";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.string_params.put("address_to", Account.getInstance().getAddress());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void kill_max_upgrade() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "kill_upgrade_max";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void kill_min_upgrade() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "kill_upgrade_min";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void hack_min_upgrade() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hack_upgrade_min";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hack_max_upgrade() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hack_upgrade_max";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hack_bounty_upgrade() {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hack_upgrade_bounty";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void hack(String addressTo) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "hack";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());

        output_package.string_params.put("address_to", Account.getInstance().getAddress());

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }

    public static void chat_send_message(String message) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "world_chat_message";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());
        output_package.string_params.put("message", message);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
    }
    public static void mail_send_message(String addressTo, String topic, String message) {
        String out = "";
        InRequestPackage output_package = new InRequestPackage();
        output_package.string_params = new HashMap<>();
        output_package.integer_params = new HashMap<>();
        output_package.double_params = new HashMap<>();
        output_package.long_params = new HashMap<>();

        output_package.type = "mail_message";
        output_package.string_params.put("address", Account.getInstance().getAddress());
        output_package.string_params.put("secret", Account.getInstance().getSecret());
        output_package.string_params.put("address_to", addressTo);
        output_package.string_params.put("topic", topic);
        output_package.string_params.put("message", message);

        out = serial(output_package);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair(param_name, out));

        new Job(address+servlet, urlParameters);
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
    private static String serial(InRequestPackage pack){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSON  = gson.toJson(pack);
        return JSON;
    }
}
