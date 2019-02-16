package com.eog.bitcoin;

import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import com.webcerebrium.binance.datatype.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bitcoin")
public class BitCoinController {
    private final static Logger logger = LoggerFactory.getLogger(BitCoinController.class);

    @RequestMapping(method = RequestMethod.POST, value = "test")
    public String getPhones(HttpServletRequest request) {
//        logger.info("Request started");
        String sender = request.getParameter("sender");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body-plain");
        String coin = body.substring(body.indexOf("BINANCE:") + 8, body.length()).split("\n")[0];
        coin = coin.trim();
        logger.info("Coin: " + coin);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://zignaly.com/api/signals.php?key=1f08390c6412a6f49f46bf5cd275e3ae&pair=" + coin + "&type=buy&exchange=binance";
        logger.info("URL: " + url);
        String result = restTemplate.getForObject(url, String.class);
//        logger.info("Result: " + result);
        return body;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllPrices")
    public String getAllPrices() {
        StringBuilder allPrices = new StringBuilder();
        try {
            Map<String, BigDecimal> map = new BinanceApi().pricesMap();
            for (String key : map.keySet()) {
                allPrices.append(key + " : " + map.get(key));
                allPrices.append("\n");
            }
        } catch (BinanceApiException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info(allPrices.toString());
        return allPrices.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "setLimitOrder")
    public String getAllPrices(@RequestParam("symbol") String symbol, @RequestParam("side") String side,
                               @RequestParam("price") String price, @RequestParam("quantity") String quantity) {
        BinanceApi api = new BinanceApi();
        try {
            BinanceSymbol binanceSymbol = new BinanceSymbol(symbol);
            BinanceOrderSide binanceOrderSide = null;
            if (side.equals("buy")) {
                binanceOrderSide = BinanceOrderSide.BUY;
            } else if (side.equals("sell")) {
                binanceOrderSide = BinanceOrderSide.SELL;
            }
            BinanceOrderPlacement placement = new BinanceOrderPlacement(binanceSymbol, binanceOrderSide);
            placement.setType(BinanceOrderType.LIMIT);
            placement.setPrice(new BigDecimal(price));
            placement.setQuantity(new BigDecimal(quantity)); // buy 10000 of asset for 0.00001 BTC
            BinanceOrder order = api.getOrderById(binanceSymbol, api.createOrder(placement).get("orderId").getAsLong());
            logger.info(order.toString());
            return order.toString();
        } catch (BinanceApiException e) {
            logger.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTrades")
    public String getAllPrices(@RequestParam("symbol") String symbol) {
        BinanceApi api = new BinanceApi();
        try {
            BinanceSymbol binanceSymbol = new BinanceSymbol(symbol);
            List<BinanceTrade> trades = api.myTrades(binanceSymbol);
            StringBuilder stringBuilder = new StringBuilder();
            for (BinanceTrade binanceTrade : trades) {
                logger.info("ID: " + binanceTrade.id);
                stringBuilder.append("ID: " + binanceTrade.id);
                logger.info("IsBuyer: " + binanceTrade.isBuyer);
                stringBuilder.append(" IsBuyer: " + binanceTrade.isBuyer);
                logger.info("IsBestMatch: " + binanceTrade.isBestMatch);
                stringBuilder.append(" IsBestMatch: " + binanceTrade.isBestMatch);
                logger.info("CommissionAsset: " + binanceTrade.commissionAsset);
                stringBuilder.append(" CommissionAsset: " + binanceTrade.commissionAsset);
                logger.info("Commission: " + binanceTrade.commission);
                stringBuilder.append(" Commission: " + binanceTrade.commission);
                logger.info("Price: " + binanceTrade.price);
                stringBuilder.append(" Price: " + binanceTrade.price);
                logger.info("QTY: " + binanceTrade.qty);
                stringBuilder.append(" QTY: " + binanceTrade.qty);
                logger.info("Time: " + new Date(binanceTrade.time));
                stringBuilder.append(" Time: " + new Date(binanceTrade.time));
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        } catch (BinanceApiException e) {
            logger.error(e.getMessage(), e);
            return e.getMessage();
        }
    }
}
