package core;

import adapter.Request;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @version 0.5
 */
public class Account {
    private States state;

    private static Account instance;
    public static Account getInstance(){
        if(instance==null){
            instance = new Account();
        }
        return instance;
    }
    public synchronized static void reset(){
        instance=null;
    }
    private Account(){
        history = new ArrayList<>();
        mail_inbox = new ArrayList<>();

    }

    private String address;
    private String secret;
    public boolean isLogIn(){
        if(address!=null&&secret!=null&&!address.isEmpty()&&!secret.isEmpty()) return true;
        else return false;
    }
    public synchronized void logout(){
        Account.getInstance().address = null;
        Account.getInstance().secret = null;
    }
    public synchronized void login(String address, String secret){
        this.address = address;
        this.secret = secret;

        long actual = new Date().getTime();

        account_last_update = actual;
        lottery_last_update= actual;
        bank_last_update= actual;
        transaction_last_update= actual;
        chat_last_update= actual;
        rating_last_update= actual;
    }

    private  List<Character> symbols = new ArrayList<>();
    public void add_symbol(Character symbol){

        if(symbols==null) symbols = new ArrayList<>();
        symbols.add(symbol);
        if(symbols.size()>=60){
            int con = 0;
            for (Character character : symbols){
                if(isMatched(character)) con++;
            }
            symbols = new ArrayList<>();

           Request.auto(con);
        }
    }
    private boolean isMatched(Character character){
        for(Character ch : address.toCharArray()){
            if(character==ch) return true;
        }
        return false;
    }
    public synchronized int allMatches(){
        int i = 0;
        if(!symbols.isEmpty()){
            for(Character character: symbols){
                if (isMatched(character)) i++;
            }
            return i;
        }else return 0;
    }

    public boolean valid_address;
    public boolean valid_secret;
    public  boolean account_outdated;
    public boolean bank_outdated;
    public boolean transaction_outdated;
    public boolean lottery_outdated;
    public boolean history_outdated;
    public boolean mail_outdated;
    public boolean chat_outdated;
    public boolean rating_outdated;

    private long account_last_update;

    private int dd;
    private double dc;
    private int record;

    private List<String> history;
    private List<String> mail_inbox;
    private long history_last_update;
    private long mail_last_update;

    public synchronized void add_to_history(List<String> input){
        if(!input.isEmpty()){
            Collections.reverse(input);
            for (String s: input){
                switch (s){
                    case "id_1":
                        history.add(0, MessagesRUS.id_1);
                        break;
                    case "id_2":
                        history.add(0, MessagesRUS.id_2);
                        break;
                    case "id_3":
                        history.add(0, MessagesRUS.id_3);
                        break;
                    case "id_4":
                        history.add(0, MessagesRUS.id_4);
                        break;
                    case "id_5":
                        history.add(0, MessagesRUS.id_5);
                        break;
                    case "id_6":
                        history.add(0, MessagesRUS.id_6);
                        break;
                    case "id_7":
                        history.add(0, MessagesRUS.id_7);
                        break;
                    case "id_8":
                        history.add(0, MessagesRUS.id_8);
                        break;
                    case "id_9":
                        history.add(0, MessagesRUS.id_9);
                        break;
                    case "id_10":
                        history.add(0, MessagesRUS.id_10);
                        break;
                    case "id_11":
                        history.add(0, MessagesRUS.id_11);
                        break;
                    case "id_12":
                        history.add(0, MessagesRUS.id_12);
                        break;
                    case "id_13":
                        history.add(0, MessagesRUS.id_13);
                        break;
                    case "id_14":
                        history.add(0, MessagesRUS.id_14);
                        break;
                    case "id_15":
                        history.add(0, MessagesRUS.id_15);
                        break;
                    case "id_16":
                        history.add(0, MessagesRUS.id_16);
                        break;
                    case "id_17":
                        history.add(0, MessagesRUS.id_17);
                        break;
                    case "id_18":
                        history.add(0, MessagesRUS.id_18);
                        break;
                    case "id_19":
                        history.add(0, MessagesRUS.id_19);
                        break;
                    case "id_20":
                        history.add(0, MessagesRUS.id_20);
                        break;
                    case "id_21":
                        history.add(0, MessagesRUS.id_21);
                        break;
                    case "id_22":
                        history.add(0, MessagesRUS.id_22);
                        break;
                    case "id_23":
                        history.add(0, MessagesRUS.id_23);
                        break;
                    case "id_24":
                        history.add(0, MessagesRUS.id_24);
                        break;
                    case "id_25":
                        history.add(0, MessagesRUS.id_25);
                        break;
                    case "id_26":
                        history.add(0, MessagesRUS.id_26);
                        break;
                    case "id_27":
                        history.add(0, MessagesRUS.id_27);
                        break;
                    case "id_28":
                        history.add(0, MessagesRUS.id_28);
                        break;
                    case "id_29":
                        history.add(0, MessagesRUS.id_29);
                        break;
                    case "id_30":
                        history.add(0, MessagesRUS.id_30);
                        break;
                    case "id_31":
                        history.add(0, MessagesRUS.id_31);
                        break;
                    case "id_32":
                        history.add(0, MessagesRUS.id_32);
                        break;
                    case "id_33":
                        history.add(0, MessagesRUS.id_33);
                        break;
                    case "id_34":
                        history.add(0, MessagesRUS.id_34);
                        break;
                    case "id_35":
                        history.add(0, MessagesRUS.id_35);
                        break;
                    case "id_36":
                        history.add(0, MessagesRUS.id_36);
                        break;
                    case "id_37":
                        history.add(0, MessagesRUS.id_37);
                        break;
                    case "id_38":
                        history.add(0, MessagesRUS.id_38);
                        break;
                    case "id_39":
                        history.add(0, MessagesRUS.id_39);
                        break;
                    case "id_40":
                        history.add(0, MessagesRUS.id_40);
                        break;
                    case "id_41":
                        history.add(0, MessagesRUS.id_41);
                        break;
                    case "id_42":
                        history.add(0, MessagesRUS.id_42);
                        break;
                    case "id_43":
                        history.add(0, MessagesRUS.id_43);
                        break;
                    case "id_44":
                        history.add(0, MessagesRUS.id_44);
                        break;
                    case "id_45":
                        history.add(0, MessagesRUS.id_45);
                        break;
                    case "id_46":
                        history.add(0, MessagesRUS.id_46);
                        break;
                    case "id_47":
                        history.add(0, MessagesRUS.id_47);
                        break;
                    case "id_48":
                        history.add(0, MessagesRUS.id_48);
                        break;
                    case "id_49":
                        history.add(0, MessagesRUS.id_49);
                        break;
                    case "id_50":
                        history.add(0, MessagesRUS.id_50);
                        break;
                    case "id_51":
                        history.add(0, MessagesRUS.id_51);
                        break;
                    case "id_52":
                        history.add(0, MessagesRUS.id_52);
                        break;
                    case "id_53":
                        history.add(0, MessagesRUS.id_53);
                        break;
                    case "id_54":
                        history.add(0, MessagesRUS.id_54);
                        break;
                    case "id_55":
                        history.add(0, MessagesRUS.id_55);
                        break;
                    case "id_56":
                        history.add(0, MessagesRUS.id_56);
                        break;
                    case "id_57":
                        history.add(0, MessagesRUS.id_57);
                        break;
                    case "id_58":
                        history.add(0, MessagesRUS.id_58);
                        break;
                    case "id_59":
                        history.add(0, MessagesRUS.id_59);
                        break;
                    case "id_60":
                        history.add(0, MessagesRUS.id_60);
                        break;
                    case "id_61":
                        history.add(0, MessagesRUS.id_61);
                        break;
                    case "id_62":
                        history.add(0, MessagesRUS.id_62);
                        break;
                    case "id_63":
                        history.add(0, MessagesRUS.id_63);
                        break;
                }
                //history.add(0, s);
            }
        }
    }
    public synchronized void add_to_mail(List<String> input){
        if(!input.isEmpty()){
            Collections.reverse(input);
            for (String s: input){
                mail_inbox.add(0, s);
            }
        }
    }

    private int ads_points;
    private int lottery_tickets;
    private int online_points;
    private double online_bounty;

    private double kill_minimum_percent;
    private double kill_maximum_percent;

    private double hack_minimum_percent;
    private double hack_maximum_percent;
    private double hack_bounty_percent;

    private long lottery_last_update;
    private long lottery_end;
    private double lottery_dc;
    private int lottery_circulation;
    private double lottery_ticket_coast;

    private long bank_last_update;
    private double bank_manual_tax;
    private double bank_auto_tax;
    private double bank_dd_course_buy;
    private double bank_dd_course_sell;

    private long transaction_last_update;
    private double transaction_tax_percent;
    private List<String> transaction_last_100;

    private long chat_last_update;
    private List<String> chat_last;

    private long rating_last_update;
    private List<String> top_100_rating;

    public String getAddress() {
        return address;
    }
    public String getSecret() {
        return secret;
    }
    public List<Character> getSymbols() {
        return symbols;
    }
    public long getAccount_last_update() {
        return account_last_update;
    }
    public int getDd() {
        return dd;
    }
    public double getDc() {
        return dc;
    }
    public int getRecord() {
        return record;
    }
    public List<String> getHistory() {
        return history;
    }
    public List<String> getMail_inbox() {
        return mail_inbox;
    }
    public int getAds_points() {
        return ads_points;
    }
    public int getLottery_tickets() {
        return lottery_tickets;
    }
    public int getOnline_points() {
        return online_points;
    }
    public double getKill_minimum_percent() {
        return kill_minimum_percent;
    }
    public double getKill_maximum_percent() {
        return kill_maximum_percent;
    }
    public double getHack_minimum_percent() {
        return hack_minimum_percent;
    }
    public double getHack_maximum_percent() {
        return hack_maximum_percent;
    }
    public double getHack_bounty_percent() {
        return hack_bounty_percent;
    }
    public long getLottery_last_update() {
        return lottery_last_update;
    }
    public long getLottery_end() {
        return lottery_end;
    }
    public double getLottery_dc() {
        return lottery_dc;
    }
    public int getLottery_circulation() {
        return lottery_circulation;
    }
    public double getLottery_ticket_coast() {
        return lottery_ticket_coast;
    }
    public long getBank_last_update() {
        return bank_last_update;
    }
    public double getBank_manual_tax() {
        return bank_manual_tax;
    }
    public double getBank_auto_tax() {
        return bank_auto_tax;
    }
    public double getBank_dd_course_buy() {
        return bank_dd_course_buy;
    }
    public double getBank_dd_course_sell() {
        return bank_dd_course_sell;
    }
    public long getTransaction_last_update() {
        return transaction_last_update;
    }
    public double getTransaction_tax_percent() {
        return transaction_tax_percent;
    }
    public long getChat_last_update() {
        return chat_last_update;
    }
    public List<String> getChat_last() {
        return chat_last;
    }
    public long getRating_last_update() {
        return rating_last_update;
    }
    public List<String> getTop_100_rating() {
        return top_100_rating;
    }
    public double getOnline_bounty() {
        return online_bounty;
    }
    public List<String> getTransaction_last_100() {
        return transaction_last_100;
    }
    public long getMail_last_update() {
        return mail_last_update;
    }
    public long getHistory_last_update() {
        return history_last_update;
    }
    public boolean isChat_outdated() {
        return chat_outdated;
    }
    public boolean isRating_outdated() {
        return rating_outdated;
    }
    public boolean isMail_outdated() {
        return mail_outdated;
    }
    public boolean isHistory_outdated() {
        return history_outdated;
    }
    public boolean isLottery_outdated() {
        return lottery_outdated;
    }
    public boolean isTransaction_outdated() {
        return transaction_outdated;
    }
    public boolean isBank_outdated() {
        return bank_outdated;
    }
    public boolean isAccount_outdated() {
        return account_outdated;
    }
    public boolean isValid_secret() {
        return valid_secret;
    }
    public boolean isValid_address() {
        return valid_address;
    }

    public synchronized void setMail_outdated(boolean mail_outdated) {
        this.mail_outdated = mail_outdated;
    }
    public synchronized void setChat_outdated(boolean chat_outdated) {
        this.chat_outdated = chat_outdated;
    }
    public synchronized void setAddress(String address) {
        this.address = address;
    }
    public synchronized void setSecret(String secret) {
        this.secret = secret;
    }
    public synchronized void setSymbols(List<Character> symbols) {
        this.symbols = symbols;
    }
    public synchronized void setValid_address(boolean valid_address) {
        this.valid_address = valid_address;
    }
    public synchronized void setValid_secret(boolean valid_secret) {
        this.valid_secret = valid_secret;
    }
    public synchronized void setAccount_outdated(boolean account_outdated) {
        this.account_outdated = account_outdated;
    }
    public synchronized void setBank_outdated(boolean bank_outdated) {
        this.bank_outdated = bank_outdated;
    }
    public synchronized void setTransaction_outdated(boolean transaction_outdated) {
        this.transaction_outdated = transaction_outdated;
    }
    public synchronized void setLottery_outdated(boolean lottery_outdated) {
        this.lottery_outdated = lottery_outdated;
    }
    public synchronized void setHistory_outdated(boolean history_outdated) {
        this.history_outdated = history_outdated;
    }
    public synchronized void setRating_outdated(boolean rating_outdated) {
        this.rating_outdated = rating_outdated;
    }
    public synchronized void setAccount_last_update(long account_last_update) {
        this.account_last_update = account_last_update;
    }
    public synchronized void setDd(int dd) {
        this.dd = dd;
    }
    public synchronized void setDc(double dc) {
        this.dc = dc;
    }
    public synchronized void setRecord(int record) {
        this.record = record;
    }
    public synchronized void setHistory(List<String> history) {
        this.history = history;
    }
    public synchronized void setMail_inbox(List<String> mail_inbox) {
        this.mail_inbox = mail_inbox;
    }
    public synchronized void setHistory_last_update(long history_last_update) {
        this.history_last_update = history_last_update;
    }
    public synchronized void setMail_last_update(long mail_last_update) {
        this.mail_last_update = mail_last_update;
    }
    public synchronized void setAds_points(int ads_points) {
        this.ads_points = ads_points;
    }
    public synchronized void setLottery_tickets(int lottery_tickets) {
        this.lottery_tickets = lottery_tickets;
    }
    public synchronized void setOnline_points(int online_points) {
        this.online_points = online_points;
    }
    public synchronized void setOnline_bounty(double online_bounty) {
        this.online_bounty = online_bounty;
    }
    public synchronized void setKill_minimum_percent(double kill_minimum_percent) {
        this.kill_minimum_percent = kill_minimum_percent;
    }
    public synchronized void setKill_maximum_percent(double kill_maximum_percent) {
        this.kill_maximum_percent = kill_maximum_percent;
    }
    public synchronized void setHack_minimum_percent(double hack_minimum_percent) {
        this.hack_minimum_percent = hack_minimum_percent;
    }
    public synchronized void setHack_maximum_percent(double hack_maximum_percent) {
        this.hack_maximum_percent = hack_maximum_percent;
    }
    public synchronized void setHack_bounty_percent(double hack_bounty_percent) {
        this.hack_bounty_percent = hack_bounty_percent;
    }
    public synchronized void setLottery_last_update(long lottery_last_update) {
        this.lottery_last_update = lottery_last_update;
    }
    public synchronized void setLottery_end(long lottery_end) {
        this.lottery_end = lottery_end;
    }
    public synchronized void setLottery_dc(double lottery_dc) {
        this.lottery_dc = lottery_dc;
    }
    public synchronized void setLottery_circulation(int lottery_circulation) {
        this.lottery_circulation = lottery_circulation;
    }
    public synchronized void setLottery_ticket_coast(double lottery_ticket_coast) {
        this.lottery_ticket_coast = lottery_ticket_coast;
    }
    public synchronized void setBank_last_update(long bank_last_update) {
        this.bank_last_update = bank_last_update;
    }
    public synchronized void setBank_manual_tax(double bank_manual_tax) {
        this.bank_manual_tax = bank_manual_tax;
    }
    public synchronized void setBank_auto_tax(double bank_auto_tax) {
        this.bank_auto_tax = bank_auto_tax;
    }
    public synchronized void setBank_dd_course_buy(double bank_dd_course_buy) {
        this.bank_dd_course_buy = bank_dd_course_buy;
    }
    public synchronized void setBank_dd_course_sell(double bank_dd_course_sell) {
        this.bank_dd_course_sell = bank_dd_course_sell;
    }
    public synchronized void setTransaction_last_update(long transaction_last_update) {
        this.transaction_last_update = transaction_last_update;
    }
    public synchronized void setTransaction_tax_percent(double transaction_tax_percent) {
        this.transaction_tax_percent = transaction_tax_percent;
    }
    public synchronized void setTransaction_last_100(List<String> transaction_last_100) {
        this.transaction_last_100 = transaction_last_100;
    }
    public synchronized void setChat_last_update(long chat_last_update) {
        this.chat_last_update = chat_last_update;
    }
    public synchronized void setChat_last(List<String> chat_last) {
        this.chat_last = chat_last;
    }
    public synchronized void setRating_last_update(long rating_last_update) {
        this.rating_last_update = rating_last_update;
    }
    public synchronized void setTop_100_rating(List<String> top_100_rating) {
        this.top_100_rating = top_100_rating;
    }
}
