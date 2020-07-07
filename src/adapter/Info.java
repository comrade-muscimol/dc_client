package adapter;

import core.Account;
import core.Job;
import core.ToolsManager;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Info {
    static DecimalFormat format_two_zero = new DecimalFormat("0.##");
    static DecimalFormat format_ten_zero = new DecimalFormat("0.##########");

    public static int record_seconds() {
        return Account.getInstance().getRecord();
    }
    public static double manual_tax() {
        return Account.getInstance().getBank_manual_tax();
    }

    public static String symbols_line() {
        String out = "";
        for(Character ch : Account.getInstance().getSymbols()){
            out+=ch;
        }
        return out;

    }
    public static String auto_sum() {
        return "Сумма на отравку: "
                +format_ten_zero.format(Account.getInstance().getBank_auto_tax())
                +"*"
                +Account.getInstance().allMatches()
                +"="
                +format_ten_zero.format(Account.getInstance().getBank_auto_tax()*Account.getInstance().allMatches());
    }
    public static double auto_tax() {
        return Account.getInstance().getBank_auto_tax();
    }

    public static double course_sell_dd() {
        return Account.getInstance().getBank_dd_course_sell();
    }
    public static double course_buy_dd() {
        return Account.getInstance().getBank_dd_course_buy();
    }

    public static String address() {
        return Account.getInstance().getAddress();
    }
    public static String secret() {
        return Account.getInstance().getSecret();
    }
    public static double dc() {
        return Account.getInstance().getDc();
    }
    public static int dd() {
        return Account.getInstance().getDd();
    }

    public static String history() {
        String out = "";
        for(String s : Account.getInstance().getHistory()){
            out+=s+"\n";
        }
        return out;
    }
    public static List<String> rating_top_100() {
        return Account.getInstance().getTop_100_rating();
    }
    public static List<String> chat_messages_list() {
        return Account.getInstance().getChat_last();
    }
    public static List<String> mail_messages_list() {
        return Account.getInstance().getMail_inbox();
    }

    public static double transaction_comission() {
        return Account.getInstance().getTransaction_tax_percent();
    }
    public static List<String> transaction_last_100() {
        return Account.getInstance().getTransaction_last_100();
    }

    public static int ad_points() {
        return Account.getInstance().getAds_points();
    }

    public static int op() {
        return Account.getInstance().getOnline_points();
    }
    public static double op_bounty() {
        return Account.getInstance().getOnline_bounty();
    }

    public static double lottery_dc() {
        return Account.getInstance().getLottery_dc();
    }
    public static int lottery_circulations() {
        return Account.getInstance().getLottery_circulation();
    }
    public static long lottery_end() {
        return Account.getInstance().getLottery_end();
    }
    public static double lottery_ticket_price() {
        return Account.getInstance().getLottery_ticket_coast();
    }
    public static double lottery_my_tickets() {
        return Account.getInstance().getLottery_tickets();
    }

    public static double kill_min_percent() {
        return Account.getInstance().getKill_minimum_percent();
    }
    public static double kill_max_percent() {
        return Account.getInstance().getKill_maximum_percent();
    }

    public static double hack_min_percent() {
        return Account.getInstance().getHack_minimum_percent();
    }
    public static double hack_max_percent() {
        return Account.getInstance().getHack_maximum_percent();
    }
    public static double hack_bounty_percent() {
        return Account.getInstance().getHack_bounty_percent();
    }


}
