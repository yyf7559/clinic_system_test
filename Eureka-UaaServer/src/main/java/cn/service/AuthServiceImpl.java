package cn.service;


import cn.exception.CustomException;
import cn.pojo.po.User;
import cn.pojo.vo.TokenVO;
import cn.response.ResultCode;
import cn.response.ResultJson;
import cn.util.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    /**
     * jwt签名私钥，实际项目应该妥善保管，不要直接写在代码中
     */
    private static final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDHyXK909rEvzLO87p8qC0BsTZXg/ws2Bn3ZIVlO6SPmsVWRIgIl4K5wRoNBUhKfufBUaqgWs9Wo4U55mFjy/BCjSZTQK3o89DUVJ9CboJwvo10cjVS93wpdziCSi//fUM1PSlNvDthcTEvzUDkDITyGCl1XMxyaV04ZojzPPblevdppfmZga0hvIdEN0WvlfnucgGUCY4pnA6sZtVQKNWnM8qs4LldqU7GGWY8JckpOXY8qx44dX5vrQD7W47HFUmMDDVXKMezSiHf6ZpvC7ozfpl0BC8gECJ6X6uS/PUe/Zbqb0qh/k/mVRYQda0aVsroLbG5Qmqeonw5nAde0DLbAgMBAAECggEAQVNQTluYW968yUiOgLYoyTXds+33Jd6fVvIqX/iJjV8pCVUtOcn4t645S2qfwaQPOXnvlbE7vHOJW25GB/CmJcyrbGtoshQPA26MCJfD1QOpkxrI7tD3a0ONWaTSXvLhZ+YQvFdA/1KYp62weyDQ06ws2jA2tW5YSdnVC9uyS0Q++7yrRxpiijtavnDi18zetizskMHc/1qD5S5AdFvbwC5leKYWaLJRuQUvBUPXuC0Nq6G+MTaE5Q7IpmjxKK2jrpWMu0CuUDbTnjUaCNgHxq0n7/wt3k0AO56m3/hLwm6SthSY4C2oKlOjE9baP8U3x7oR3eUNhyS0GO2X43/MMQKBgQDk+S0uk2f54IQFsVtGQp+WsdsqcOFDFWUU0MBFwRPpsMKfyXlspZ+pBl0Xi3Q+kSJ6NrkjHNpr0pFxeAsH2JmJlhX1MfBt87e2PVwRMG44GZ2gdKwgDeOCuSq1RNtcPHmvrCTpkbFBnJ1QNJKzvLBNyNW+7x1n5VfuT/bG7rqU8wKBgQDfXlpv4BQ1iP8CHqMR065ngEIVZNuNZycVk82VCPem1AXMFLYxdbDC0pBzmWxrZtltJdA47l46b6rTXcikQK1e+h3TR6svUNzcU0F+hHD9CIiMv8mflMlCXLDmgS0g9TgpRn56YX6X8mRPcLRAJBY9sxMqbLBJ+105RtHEK4QEeQKBgBPhNnUGw05EmfHMljohaq2wv3CN4GDsqJwIC8mCm/H8MMmiunIeZyBLtyVmLC+Kdk3aFnTf+m7GF26cl4iU26/AYiOptFA3ism9xhKP++HPB4p41sDps8kTvouCcPEvJvmDnqjQx20E5fuitOH6DeyS9UvggtMUbG/6bViUPYrVAoGBAMoKH0VYaw8tdnPlYFzMmtE1uxB85PZXGowy395xeQhmeUPqbA36xULDkTNu0Bmpsvs+G8STH5o9zUdYahbgBbGGDRpBlj67JrsHd5NHmqfVYyXkiCwXOaAUFVK5/ybzh7QV9msd6pLoBgGxEOl/erqeUrSqER8qBV28iBqnvccJAoGBAMqQT9cSLXxJ0+iCULck5ezk874jKfjvcTozLs0uJPqsDCLvee3OjY15ZieGu3BX4LCdInXYpespmbrMgN4fntDpxE4slsySB+yN5wsyNATJpiErwUGOw0kyvf0RofkQHpCdOvU6+TzTppJevOVYrOGZfRcWLwC2qFuq8HYiIKnO";

    @Value("${jwt.publicKey}")
    private String publicKey;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.expiration}")
    private int expiration;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public TokenVO login(String username, String password) {
        //用户验证
        final Authentication authentication = authenticate(username, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        UserDetails user = (UserDetails) authentication.getPrincipal();
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", user.getUsername());
        userInfo.put("msg","这是一条测试消息");
        // 获取私钥
        PrivateKey privateKey = null;
        try {
            privateKey = JwtHelper.getPrivateKey(PRIVATE_KEY.getBytes());
        } catch (Exception e) {
            throw new CustomException(ResultJson.failure(ResultCode.SERVER_ERROR, e));
        }
        String token = JwtHelper.generateToken(userInfo, privateKey, expiration);
        return new TokenVO().setToken(token);
    }

    @Override
    public void register(User user) {

    }

    @Override
    public void logout(String token) {

    }

    @Override
    public TokenVO refresh(String oldToken) {
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) throws Exception {
        token = token.substring(tokenHead.length());
        PublicKey pubKey = JwtHelper.getPublicKey(publicKey.getBytes());
        Map<String, Object> claims = JwtHelper.parseToken(token, pubKey);
        log.debug("parse info from token, method:getUserInfo:{}", claims);
        return claims;
    }

    private Authentication authenticate(String username, String password) {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new CustomException(ResultJson.failure(ResultCode.LOGIN_ERROR, e.getMessage()));
        }
    }
}
