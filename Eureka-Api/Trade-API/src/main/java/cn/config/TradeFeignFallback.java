package cn.config;

import cn.entity.Order;
import cn.response.Response;
import cn.response.ResponseEnum;
import org.springframework.stereotype.Component;

@Component
public class TradeFeignFallback implements TradeFeign {

    @Override
    public Response createQcCode(String orderNo) {
        return new Response(ResponseEnum.SUCCESS).setResponseBody("服务未能正常响应");
    }

    @Override
    public Response queryOrderIsSuccess(String orderNo) {
        return new Response(ResponseEnum.SUCCESS).setResponseBody("服务未能正常响应");
    }


    @Override
    public Response addOrder(Order order) {
        return new Response(ResponseEnum.SUCCESS).setResponseBody("服务未能正常响应");
    }

    @Override
    public Response prePay(String orderNo) {
        return new Response(ResponseEnum.SUCCESS).setResponseBody("服务未能正常响应");
    }
}
