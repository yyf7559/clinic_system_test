package cn.response;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

@Data
public class Response {
    private String code;

    private String message;

    private long responseTime = System.currentTimeMillis();

    private Object responseBody;

    public Response(String code, String message, Object responseBody) {
        this.code = code;
        this.message = message;
        this.responseBody = responseBody;
    }

    public static Response success(String message) {
        return createSuccess(message, null);
    }

    public static Response success(String message, Object responseBody) {
        return createSuccess(message, responseBody);
    }

    public static Response success(Object responseBody) {
        return createSuccess(null, responseBody);
    }

    static Response createSuccess(String message, Object responseBody) {
        return new Response("200", message, responseBody);
    }

    public static Response error(String message) {
        return createError(message, null);
    }

    public static Response error() {
        return createError(null, null);
    }

    public static Response error(String message, Object responseBody) {
        return createError(message, responseBody);
    }

    public static Response error(Object responseBody) {
        return createSuccess(null, responseBody);
    }

    static Response createError(String message, Object responseBody) {
        return new Response("400", message, responseBody);
    }

    public Response(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public Response setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
        return this;
    }

    public Object getResponseBody() {
        return responseBody;
    }
}
