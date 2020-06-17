package cn.config;

import cn.entity.Order;
import cn.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "clinic-trade", fallback = TradeFeignFallback.class,configuration = {FeignConfig.class})
public interface TradeFeign {
    @GetMapping("api/wxpay/createqccode/{orderNo}")
    Response createQcCode(@PathVariable String orderNo);
    @GetMapping(value = "api/wxpay/queryorderstatus/{orderNo}")
    Response queryOrderIsSuccess(@PathVariable String orderNo);
    @PostMapping("order/addOrder")
    Response addOrder(@RequestBody Order order);
    @RequestMapping(value = "api/prepay/{orderNo}", method = RequestMethod.GET)
    Response prePay(@PathVariable String orderNo);
}