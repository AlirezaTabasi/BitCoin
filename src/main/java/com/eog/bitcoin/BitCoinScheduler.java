package com.eog.bitcoin;

import com.google.gson.internal.LinkedTreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Configuration
@EnableScheduling
public class BitCoinScheduler {

    private static HashMap<String, Double> coinBTCPrice;
    private final static Logger logger = LoggerFactory.getLogger(BitCoinScheduler.class);

    static {
        coinBTCPrice = new HashMap<>();
        coinBTCPrice.put("BTC", 0d);
        coinBTCPrice.put("BAT", 0d);
        coinBTCPrice.put("BCC", 0d);
        coinBTCPrice.put("ETH", 0d);
        coinBTCPrice.put("RVN", 0d);
        coinBTCPrice.put("XRP", 0d);
        coinBTCPrice.put("BCC", 0d);
        coinBTCPrice.put("ETH", 0d);
        coinBTCPrice.put("XRP", 0d);
        coinBTCPrice.put("YOYO", 0d);
        coinBTCPrice.put("PAX", 0d);
        coinBTCPrice.put("XLM", 0d);
        coinBTCPrice.put("BNB", 0d);
        coinBTCPrice.put("EOS", 0d);
        coinBTCPrice.put("BNB", 0d);
        coinBTCPrice.put("PHX", 0d);
        coinBTCPrice.put("EOS", 0d);
        coinBTCPrice.put("ADA", 0d);
        coinBTCPrice.put("PAX", 0d);
        coinBTCPrice.put("TUSD", 0d);
        coinBTCPrice.put("TRX", 0d);
        coinBTCPrice.put("TRX", 0d);
        coinBTCPrice.put("BAT", 0d);
        coinBTCPrice.put("QKC", 0d);
        coinBTCPrice.put("ZRX", 0d);
        coinBTCPrice.put("TUSD", 0d);
        coinBTCPrice.put("LTC", 0d);
        coinBTCPrice.put("ARN", 0d);
        coinBTCPrice.put("ZIL", 0d);
        coinBTCPrice.put("XLM", 0d);
        coinBTCPrice.put("NEO", 0d);
        coinBTCPrice.put("IOTA", 0d);
        coinBTCPrice.put("DOCK", 0d);
        coinBTCPrice.put("MFT", 0d);
        coinBTCPrice.put("NPXS", 0d);
        coinBTCPrice.put("NEO", 0d);
        coinBTCPrice.put("ADA", 0d);
        coinBTCPrice.put("LTC", 0d);
        coinBTCPrice.put("BCC", 0d);
        coinBTCPrice.put("ETC", 0d);
        coinBTCPrice.put("GVT", 0d);
        coinBTCPrice.put("VET", 0d);
        coinBTCPrice.put("FUEL", 0d);
        coinBTCPrice.put("ICX", 0d);
        coinBTCPrice.put("SALT", 0d);
        coinBTCPrice.put("KEY", 0d);
        coinBTCPrice.put("LINK", 0d);
        coinBTCPrice.put("XMR", 0d);
        coinBTCPrice.put("ONT", 0d);
        coinBTCPrice.put("GO", 0d);
        coinBTCPrice.put("XRP", 0d);
        coinBTCPrice.put("NANO", 0d);
        coinBTCPrice.put("IOTA", 0d);
        coinBTCPrice.put("ICX", 0d);
        coinBTCPrice.put("IOTX", 0d);
        coinBTCPrice.put("WAN", 0d);
        coinBTCPrice.put("WTC", 0d);
        coinBTCPrice.put("XVG", 0d);
        coinBTCPrice.put("ZEC", 0d);
        coinBTCPrice.put("ONT", 0d);
        coinBTCPrice.put("DNT", 0d);
        coinBTCPrice.put("VET", 0d);
        coinBTCPrice.put("DENT", 0d);
        coinBTCPrice.put("STRAT", 0d);
        coinBTCPrice.put("SNM", 0d);
        coinBTCPrice.put("ETC", 0d);
        coinBTCPrice.put("RLC", 0d);
        coinBTCPrice.put("BLZ", 0d);
        coinBTCPrice.put("XEM", 0d);
        coinBTCPrice.put("AION", 0d);
        coinBTCPrice.put("DASH", 0d);
        coinBTCPrice.put("CVC", 0d);
        coinBTCPrice.put("ADA", 0d);
        coinBTCPrice.put("SC", 0d);
        coinBTCPrice.put("SNGLS", 0d);
        coinBTCPrice.put("CDT", 0d);
        coinBTCPrice.put("APPC", 0d);
        coinBTCPrice.put("POE", 0d);
        coinBTCPrice.put("WPR", 0d);
        coinBTCPrice.put("BCPT", 0d);
        coinBTCPrice.put("NCASH", 0d);
        coinBTCPrice.put("TNT", 0d);
        coinBTCPrice.put("VET", 0d);
        coinBTCPrice.put("POLY", 0d);
        coinBTCPrice.put("STORM", 0d);
        coinBTCPrice.put("IOST", 0d);
        coinBTCPrice.put("ELF", 0d);
        coinBTCPrice.put("EOS", 0d);
        coinBTCPrice.put("MDA", 0d);
        coinBTCPrice.put("VIB", 0d);
        coinBTCPrice.put("TNB", 0d);
        coinBTCPrice.put("OMG", 0d);
        coinBTCPrice.put("ENJ", 0d);
        coinBTCPrice.put("LOOM", 0d);
        coinBTCPrice.put("TRX", 0d);
        coinBTCPrice.put("AST", 0d);
        coinBTCPrice.put("HOT", 0d);
        coinBTCPrice.put("BQX", 0d);
        coinBTCPrice.put("XLM", 0d);
        coinBTCPrice.put("GTO", 0d);
        coinBTCPrice.put("AE", 0d);
        coinBTCPrice.put("MANA", 0d);
        coinBTCPrice.put("STEEM", 0d);
        coinBTCPrice.put("NPXS", 0d);
        coinBTCPrice.put("QTUM", 0d);
        coinBTCPrice.put("DCR", 0d);
        coinBTCPrice.put("HOT", 0d);
        coinBTCPrice.put("DLT", 0d);
        coinBTCPrice.put("BCD", 0d);
        coinBTCPrice.put("MTH", 0d);
        coinBTCPrice.put("POA", 0d);
        coinBTCPrice.put("NAS", 0d);
        coinBTCPrice.put("QTUM", 0d);
        coinBTCPrice.put("LUN", 0d);
        coinBTCPrice.put("THETA", 0d);
        coinBTCPrice.put("ZIL", 0d);
        coinBTCPrice.put("DATA", 0d);
        coinBTCPrice.put("INS", 0d);
        coinBTCPrice.put("BAT", 0d);
        coinBTCPrice.put("BNB", 0d);
        coinBTCPrice.put("LEND", 0d);
        coinBTCPrice.put("ZEN", 0d);
        coinBTCPrice.put("LSK", 0d);
        coinBTCPrice.put("VIBE", 0d);
        coinBTCPrice.put("REP", 0d);
        coinBTCPrice.put("FUN", 0d);
        coinBTCPrice.put("HC", 0d);
        coinBTCPrice.put("YOYO", 0d);
        coinBTCPrice.put("NEBL", 0d);
        coinBTCPrice.put("CMT", 0d);
        coinBTCPrice.put("BTG", 0d);
        coinBTCPrice.put("CND", 0d);
        coinBTCPrice.put("EDO", 0d);
        coinBTCPrice.put("BTS", 0d);
        coinBTCPrice.put("POWR", 0d);
        coinBTCPrice.put("AGI", 0d);
        coinBTCPrice.put("KMD", 0d);
        coinBTCPrice.put("RCN", 0d);
        coinBTCPrice.put("MCO", 0d);
        coinBTCPrice.put("ELF", 0d);
        coinBTCPrice.put("PHX", 0d);
        coinBTCPrice.put("CLOAK", 0d);
        coinBTCPrice.put("RDN", 0d);
        coinBTCPrice.put("NULS", 0d);
        coinBTCPrice.put("SKY", 0d);
        coinBTCPrice.put("REQ", 0d);
        coinBTCPrice.put("DGD", 0d);
        coinBTCPrice.put("PPT", 0d);
        coinBTCPrice.put("SUB", 0d);
        coinBTCPrice.put("LRC", 0d);
        coinBTCPrice.put("ENG", 0d);
        coinBTCPrice.put("MTL", 0d);
        coinBTCPrice.put("PIVX", 0d);
        coinBTCPrice.put("SNT", 0d);
        coinBTCPrice.put("ZRX", 0d);
        coinBTCPrice.put("WAVES", 0d);
        coinBTCPrice.put("PAX", 0d);
        coinBTCPrice.put("QSP", 0d);
        coinBTCPrice.put("NEO", 0d);
        coinBTCPrice.put("IOTA", 0d);
        coinBTCPrice.put("LINK", 0d);
        coinBTCPrice.put("WABI", 0d);
        coinBTCPrice.put("OST", 0d);
        coinBTCPrice.put("TUSD", 0d);
        coinBTCPrice.put("MOD", 0d);
        coinBTCPrice.put("GNT", 0d);
        coinBTCPrice.put("STORJ", 0d);
        coinBTCPrice.put("KNC", 0d);
        coinBTCPrice.put("AMB", 0d);
        coinBTCPrice.put("BCC", 0d);
        coinBTCPrice.put("LOOM", 0d);
        coinBTCPrice.put("WINGS", 0d);
        coinBTCPrice.put("NULS", 0d);
        coinBTCPrice.put("AION", 0d);
        coinBTCPrice.put("ARK", 0d);
        coinBTCPrice.put("NAV", 0d);
        coinBTCPrice.put("VIA", 0d);
        coinBTCPrice.put("GTO", 0d);
        coinBTCPrice.put("ADX", 0d);
        coinBTCPrice.put("RVN", 0d);
        coinBTCPrice.put("KNC", 0d);
        coinBTCPrice.put("GAS", 0d);
        coinBTCPrice.put("MFT", 0d);
        coinBTCPrice.put("XZC", 0d);
        coinBTCPrice.put("XRP", 0d);
        coinBTCPrice.put("PAX", 0d);
        coinBTCPrice.put("NANO", 0d);
        coinBTCPrice.put("QKC", 0d);
        coinBTCPrice.put("BLZ", 0d);
        coinBTCPrice.put("ICX", 0d);
        coinBTCPrice.put("BRD", 0d);
        coinBTCPrice.put("XLM", 0d);
        coinBTCPrice.put("EVX", 0d);
        coinBTCPrice.put("NXS", 0d);
        coinBTCPrice.put("QLC", 0d);
        coinBTCPrice.put("WAN", 0d);
        coinBTCPrice.put("XMR", 0d);
        coinBTCPrice.put("RLC", 0d);
        coinBTCPrice.put("ONT", 0d);
        coinBTCPrice.put("LTC", 0d);
        coinBTCPrice.put("GVT", 0d);
        coinBTCPrice.put("ETC", 0d);
        coinBTCPrice.put("SNM", 0d);
        coinBTCPrice.put("SYS", 0d);
        coinBTCPrice.put("SALT", 0d);
        coinBTCPrice.put("BNT", 0d);
        coinBTCPrice.put("DNT", 0d);
        coinBTCPrice.put("IOTX", 0d);
        coinBTCPrice.put("GXS", 0d);
        coinBTCPrice.put("ARDR", 0d);
        coinBTCPrice.put("ZEC", 0d);
        coinBTCPrice.put("EDO", 0d);
        coinBTCPrice.put("APPC", 0d);
        coinBTCPrice.put("OMG", 0d);
        coinBTCPrice.put("YOYO", 0d);
        coinBTCPrice.put("IOST", 0d);
        coinBTCPrice.put("STRAT", 0d);
        coinBTCPrice.put("LTC", 0d);
        coinBTCPrice.put("ARN", 0d);
        coinBTCPrice.put("FUEL", 0d);
        coinBTCPrice.put("EVX", 0d);
        coinBTCPrice.put("TRX", 0d);
        coinBTCPrice.put("DOCK", 0d);
        coinBTCPrice.put("DENT", 0d);
        coinBTCPrice.put("MANA", 0d);
        coinBTCPrice.put("TUSD", 0d);
        coinBTCPrice.put("SC", 0d);
        coinBTCPrice.put("ADA", 0d);
        coinBTCPrice.put("WTC", 0d);
        coinBTCPrice.put("OAX", 0d);
        coinBTCPrice.put("SNGLS", 0d);
        coinBTCPrice.put("GTO", 0d);
        coinBTCPrice.put("VIB", 0d);
        coinBTCPrice.put("XEM", 0d);
        coinBTCPrice.put("XVG", 0d);
        coinBTCPrice.put("POA", 0d);
        coinBTCPrice.put("GRS", 0d);
        coinBTCPrice.put("DGD", 0d);
        coinBTCPrice.put("NCASH", 0d);
        coinBTCPrice.put("CVC", 0d);
        coinBTCPrice.put("CMT", 0d);
        coinBTCPrice.put("KEY", 0d);
        coinBTCPrice.put("MDA", 0d);
        coinBTCPrice.put("VET", 0d);
        coinBTCPrice.put("WPR", 0d);
        coinBTCPrice.put("NEO", 0d);
        coinBTCPrice.put("CDT", 0d);
        coinBTCPrice.put("AE", 0d);
        coinBTCPrice.put("DLT", 0d);
        coinBTCPrice.put("REQ", 0d);
        coinBTCPrice.put("TNT", 0d);
        coinBTCPrice.put("QTUM", 0d);
        coinBTCPrice.put("THETA", 0d);
        coinBTCPrice.put("BNT", 0d);
        coinBTCPrice.put("TNB", 0d);
        coinBTCPrice.put("POE", 0d);
        coinBTCPrice.put("ENG", 0d);
        coinBTCPrice.put("DASH", 0d);
        coinBTCPrice.put("AST", 0d);
        coinBTCPrice.put("PPT", 0d);
        coinBTCPrice.put("VIBE", 0d);
        coinBTCPrice.put("STORM", 0d);
        coinBTCPrice.put("OST", 0d);
        coinBTCPrice.put("ZEN", 0d);
        coinBTCPrice.put("BCD", 0d);
        coinBTCPrice.put("LRC", 0d);
        coinBTCPrice.put("AGI", 0d);
        coinBTCPrice.put("MCO", 0d);
        coinBTCPrice.put("BQX", 0d);
        coinBTCPrice.put("DATA", 0d);
        coinBTCPrice.put("NEBL", 0d);
        coinBTCPrice.put("STEEM", 0d);
        coinBTCPrice.put("LOOM", 0d);
        coinBTCPrice.put("SNT", 0d);
        coinBTCPrice.put("FUN", 0d);
        coinBTCPrice.put("RCN", 0d);
        coinBTCPrice.put("IOTA", 0d);
        coinBTCPrice.put("GO", 0d);
        coinBTCPrice.put("LEND", 0d);
        coinBTCPrice.put("BTG", 0d);
        coinBTCPrice.put("BCPT", 0d);
        coinBTCPrice.put("NULS", 0d);
        coinBTCPrice.put("EOS", 0d);
        coinBTCPrice.put("CLOAK", 0d);
        coinBTCPrice.put("SUB", 0d);
        coinBTCPrice.put("INS", 0d);
        coinBTCPrice.put("ENJ", 0d);
        coinBTCPrice.put("PIVX", 0d);
        coinBTCPrice.put("BTS", 0d);
        coinBTCPrice.put("XZC", 0d);
        coinBTCPrice.put("RCN", 0d);
        coinBTCPrice.put("QSP", 0d);
        coinBTCPrice.put("MTH", 0d);
        coinBTCPrice.put("LSK", 0d);
        coinBTCPrice.put("GNT", 0d);
        coinBTCPrice.put("CND", 0d);
        coinBTCPrice.put("WAN", 0d);
        coinBTCPrice.put("PHX", 0d);
        coinBTCPrice.put("RDN", 0d);
        coinBTCPrice.put("MFT", 0d);
        coinBTCPrice.put("POLY", 0d);
        coinBTCPrice.put("POWR", 0d);
        coinBTCPrice.put("WABI", 0d);
        coinBTCPrice.put("ARK", 0d);
        coinBTCPrice.put("MTL", 0d);
        coinBTCPrice.put("ADX", 0d);
        coinBTCPrice.put("REP", 0d);
        coinBTCPrice.put("STORJ", 0d);
        coinBTCPrice.put("AMB", 0d);
        coinBTCPrice.put("SKY", 0d);
        coinBTCPrice.put("GXS", 0d);
        coinBTCPrice.put("ONT", 0d);
        coinBTCPrice.put("WTC", 0d);
        coinBTCPrice.put("MOD", 0d);
        coinBTCPrice.put("QLC", 0d);
        coinBTCPrice.put("ARDR", 0d);
        coinBTCPrice.put("NAV", 0d);
        coinBTCPrice.put("WAVES", 0d);
        coinBTCPrice.put("BLZ", 0d);
        coinBTCPrice.put("SC", 0d);
        coinBTCPrice.put("ETC", 0d);
        coinBTCPrice.put("KMD", 0d);
        coinBTCPrice.put("NXS", 0d);
        coinBTCPrice.put("NANO", 0d);
        coinBTCPrice.put("NAS", 0d);
        coinBTCPrice.put("HC", 0d);
        coinBTCPrice.put("VIA", 0d);
        coinBTCPrice.put("WINGS", 0d);
        coinBTCPrice.put("ZIL", 0d);
        coinBTCPrice.put("APPC", 0d);
        coinBTCPrice.put("XEM", 0d);
        coinBTCPrice.put("LUN", 0d);
        coinBTCPrice.put("RLC", 0d);
        coinBTCPrice.put("NEBL", 0d);
        coinBTCPrice.put("ICX", 0d);
        coinBTCPrice.put("PIVX", 0d);
        coinBTCPrice.put("DCR", 0d);
        coinBTCPrice.put("RDN", 0d);
        coinBTCPrice.put("STEEM", 0d);
        coinBTCPrice.put("OAX", 0d);
        coinBTCPrice.put("BRD", 0d);
        coinBTCPrice.put("ZEN", 0d);
        coinBTCPrice.put("AION", 0d);
        coinBTCPrice.put("CVC", 0d);
        coinBTCPrice.put("AGI", 0d);
        coinBTCPrice.put("POWR", 0d);
        coinBTCPrice.put("MCO", 0d);
        coinBTCPrice.put("DLT", 0d);
        coinBTCPrice.put("BCPT", 0d);
        coinBTCPrice.put("NCASH", 0d);
        coinBTCPrice.put("NAV", 0d);
        coinBTCPrice.put("QTUM", 0d);
        coinBTCPrice.put("LSK", 0d);
        coinBTCPrice.put("AMB", 0d);
        coinBTCPrice.put("SYS", 0d);
        coinBTCPrice.put("NULS", 0d);
        coinBTCPrice.put("WABI", 0d);
        coinBTCPrice.put("AE", 0d);
        coinBTCPrice.put("WAVES", 0d);
        coinBTCPrice.put("VIA", 0d);
        coinBTCPrice.put("ENJ", 0d);
        coinBTCPrice.put("STORM", 0d);
        coinBTCPrice.put("CMT", 0d);
        coinBTCPrice.put("THETA", 0d);
        coinBTCPrice.put("ADX", 0d);
        coinBTCPrice.put("GRS", 0d);
        coinBTCPrice.put("REP", 0d);
        coinBTCPrice.put("OST", 0d);
        coinBTCPrice.put("ARDR", 0d);
        coinBTCPrice.put("NXS", 0d);
        coinBTCPrice.put("XZC", 0d);
        coinBTCPrice.put("CND", 0d);
        coinBTCPrice.put("SKY", 0d);
        coinBTCPrice.put("POA", 0d);
        coinBTCPrice.put("QSP", 0d);
        coinBTCPrice.put("BTS", 0d);
        coinBTCPrice.put("GNT", 0d);
        coinBTCPrice.put("BRD", 0d);
        coinBTCPrice.put("NAS", 0d);
        coinBTCPrice.put("ICN", 0d);
        coinBTCPrice.put("SYS", 0d);
        coinBTCPrice.put("QLC", 0d);
        coinBTCPrice.put("ICN", 0d);
        coinBTCPrice.put("CHAT", 0d);
    }
//
//    @Scheduled(fixedRate = 1000 * 60)
//    public void checkCurrencies() throws Exception {
//        logger.info("checkCurrencies started.");
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://api.coinmarketcap.com/v2/ticker/?convert=BTC&limit=10";
//        String out = restTemplate.getForObject(url, String.class);
//        out = out.replaceAll("\\s", "");
//        String data = out.substring(out.indexOf("data") + 7, out.indexOf("metadata") - 3);
//
////        while (true) {
//        if (data.contains("{")) {
//            String currencyStr = data.substring(data.indexOf("{") + 1, data.indexOf("quotes") - 2);
//            data = data.substring(data.indexOf("quotes"), data.length());
//            System.out.println(data);
////            extractCurrency(currencyStr);
//        } else {
////                break;
//        }
////        }
////        logger.info(out);
////        logger.info("checkCurrencies finished.");
//    }


//    private Currency extractCurrency(String data) {
//        Currency currency = new Currency();
//        logger.info(data);
//        String[] list = data.split(",");
//        currency.setId(Integer.parseInt(list[0].split(":")[1]));
//        currency.setName(list[1].split(":")[1]);
//        currency.setSymbol(list[2].split(":")[1]);
//        logger.info(currency.getId()+" " + currency.getName() + " " + currency.getSymbol());
//        return null;
//    }


    @Scheduled(fixedRate = 1000 * 60 * 10)
    public void checkCurrencies() throws Exception {
//        logger.info("checkCurrencies started.");
        sendNotification("Scheduler started.");
        List<Currency> currencyList = new ArrayList<>();
        Double oldBTCPrice = 0d;
        Double newBTCPrice = 0d;
        List<String> validCoins = getValidCoins();
        for (int i = 1; i < 2000; i += 100) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.coinmarketcap.com/v1/ticker/?convert=BTC&start=SS&limit=100";
            url = url.replace("SS", i + "");
            String out = restTemplate.getForObject(url, String.class);
            out = out.replaceAll("\\r|\\n", "");
            out = out.replaceAll("\\s", "");
            GsonJsonParser gsonJsonParser = new GsonJsonParser();
            List<Object> currencies = gsonJsonParser.parseList(out);
            for (Object obj : currencies) {
                Currency currency = new Currency();
                currency.setName((String) ((LinkedTreeMap) obj).get("name"));
                currency.setSymbol((String) ((LinkedTreeMap) obj).get("symbol"));
                String price_usd = (String) ((LinkedTreeMap) obj).get("price_usd");
                String price_btc = (String) ((LinkedTreeMap) obj).get("price_btc");
                String percent_change_1h = (String) ((LinkedTreeMap) obj).get("percent_change_1h");
                String percent_change_24h = (String) ((LinkedTreeMap) obj).get("percent_change_24h");
                String percent_change_7d = (String) ((LinkedTreeMap) obj).get("percent_change_7d");
                currency.setPrice_usd(price_usd);
                currency.setPrice_btc(price_btc);
                if (percent_change_1h != null) {
                    currency.setPercent_change_1h(Double.parseDouble(percent_change_1h));
                }
                if (percent_change_24h != null) {
                    currency.setPercent_change_24h(Double.parseDouble(percent_change_24h));
                }
                if (percent_change_7d != null) {
                    currency.setPercent_change_7d(Double.parseDouble(percent_change_7d));
                }
                if (validCoins.contains(currency.getSymbol())) {
                    oldBTCPrice = coinBTCPrice.get(currency.getSymbol()).doubleValue();
                    newBTCPrice = Double.parseDouble(currency.getPrice_btc());
//                    logger.info(String.format("%s currency | oldBTCPrice: %s , newBTCPrice: %s", currency.getSymbol(), oldBTCPrice, newBTCPrice));
                    if (newBTCPrice > oldBTCPrice){
                        currencyList.add(currency);
                    }
                    coinBTCPrice.put(currency.getSymbol(), newBTCPrice);
                }
            }
        }

        for (Currency currency : currencyList) {
            if (currency.getPercent_change_1h() > 2) {
                sendNotification("Name: " + currency.getName() + "   " + "Symbol: " + currency.getSymbol() +
                        "    " + "1H: " + currency.getPercent_change_1h() +
                        "    " + "24H: " + currency.getPercent_change_24h() +
                        "    " + "1W: " + currency.getPercent_change_7d() +
                        "Price BTC: " + "   " + currency.getPrice_btc());
            }
        }
    }

    private void sendNotification(String message) {
        String url = "http://138.197.218.88:8081/telegram/bot780483507:AAG14qZiZe-id-FDl37VSnw797sMKHslw3I/sendMessage?chat_id=@mamadalireza2&text=";
        url += message;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, String.class);
    }

    private List<String> getValidCoins() {
        List<String> validCoins;
        validCoins = Arrays.asList(new String[]{
                "BTC", "BAT", "BCC", "ETH", "RVN", "XRP", "BCC", "ETH", "XRP", "YOYO",
                "PAX", "XLM", "BNB", "EOS", "BNB", "PHX", "EOS", "ADA", "PAX", "TUSD",
                "TRX", "TRX", "BAT", "QKC", "ZRX", "TUSD", "LTC", "ARN", "ZIL", "XLM",
                "NEO", "IOTA", "DOCK", "MFT", "NPXS", "NEO", "ADA", "LTC", "BCC", "ETC",
                "GVT", "VET", "FUEL", "ICX", "SALT", "KEY", "LINK", "XMR", "ONT", "GO",
                "XRP", "NANO", "IOTA", "ICX", "IOTX", "WAN", "WTC", "XVG", "ZEC", "ONT",
                "DNT", "VET", "DENT", "STRAT", "SNM", "ETC", "RLC", "BLZ", "XEM", "AION",
                "DASH", "CVC", "ADA", "SC", "SNGLS", "CDT", "APPC", "POE", "WPR", "BCPT",
                "NCASH", "TNT", "VET", "POLY", "STORM", "IOST", "ELF", "EOS", "MDA", "VIB",
                "TNB", "OMG", "ENJ", "LOOM", "TRX", "AST", "HOT", "BQX", "XLM", "GTO",
                "AE", "MANA", "STEEM", "NPXS", "QTUM", "DCR", "HOT", "DLT", "BCD", "MTH",
                "POA", "NAS", "QTUM", "LUN", "THETA", "ZIL", "DATA", "INS", "BAT", "BNB",
                "LEND", "ZEN", "LSK", "VIBE", "REP", "FUN", "HC", "YOYO", "NEBL", "CMT",
                "BTG", "CND", "EDO", "BTS", "POWR", "AGI", "KMD", "RCN", "MCO", "ELF",
                "PHX", "CLOAK", "RDN", "NULS", "SKY", "REQ", "DGD", "PPT", "SUB", "LRC",
                "ENG", "MTL", "PIVX", "SNT", "ZRX", "WAVES", "PAX", "QSP", "NEO", "IOTA",
                "LINK", "WABI", "OST", "TUSD", "MOD", "GNT", "STORJ", "KNC", "AMB", "BCC",
                "LOOM", "WINGS", "NULS", "AION", "ARK", "NAV", "VIA", "GTO", "ADX", "RVN",
                "KNC", "GAS", "MFT", "XZC", "XRP", "PAX", "NANO", "QKC", "BLZ", "ICX",
                "BRD", "XLM", "EVX", "NXS", "QLC", "WAN", "XMR", "RLC", "ONT", "LTC",
                "GVT", "ETC", "SNM", "SYS", "SALT", "BNT", "DNT", "IOTX", "GXS", "ARDR",
                "ZEC", "EDO", "APPC", "OMG", "YOYO", "IOST", "STRAT", "LTC", "ARN", "FUEL",
                "EVX", "TRX", "DOCK", "DENT", "MANA", "TUSD", "SC", "ADA", "WTC", "OAX",
                "SNGLS", "GTO", "VIB", "XEM", "XVG", "POA", "GRS", "DGD", "NCASH", "CVC",
                "CMT", "KEY", "MDA", "VET", "WPR", "NEO", "CDT", "AE", "DLT", "REQ",
                "TNT", "QTUM", "THETA", "BNT", "TNB", "POE", "ENG", "DASH", "AST", "PPT",
                "VIBE", "STORM", "OST", "ZEN", "BCD", "LRC", "AGI", "MCO", "BQX", "DATA",
                "NEBL", "STEEM", "LOOM", "SNT", "FUN", "RCN", "IOTA", "GO", "LEND", "BTG",
                "BCPT", "NULS", "EOS", "CLOAK", "SUB", "INS", "ENJ", "PIVX", "BTS", "XZC",
                "RCN", "QSP", "MTH", "LSK", "GNT", "CND", "WAN", "PHX", "RDN", "MFT",
                "POLY", "POWR", "WABI", "ARK", "MTL", "ADX", "REP", "STORJ", "AMB", "SKY",
                "GXS", "ONT", "WTC", "MOD", "QLC", "ARDR", "NAV", "WAVES", "BLZ", "SC",
                "ETC", "KMD", "NXS", "NANO", "NAS", "HC", "VIA", "WINGS", "ZIL", "APPC",
                "XEM", "LUN", "RLC", "NEBL", "ICX", "PIVX", "DCR", "RDN", "STEEM", "OAX",
                "BRD", "ZEN", "AION", "CVC", "AGI", "POWR", "MCO", "DLT", "BCPT", "NCASH",
                "NAV", "QTUM", "LSK", "AMB", "SYS", "NULS", "WABI", "AE", "WAVES", "VIA",
                "ENJ", "STORM", "CMT", "THETA", "ADX", "GRS", "REP", "OST", "ARDR", "NXS",
                "XZC", "CND", "SKY", "POA", "QSP", "BTS", "GNT", "BRD", "NAS", "ICN",
                "SYS", "QLC", "ICN", "CHAT"
        });
        return validCoins;
    }

}


