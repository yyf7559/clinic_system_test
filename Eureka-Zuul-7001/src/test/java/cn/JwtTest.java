package cn;

import cn.util.JwtHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    @Test
    public void token() throws Exception {
        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        final int keySize = 2048;
        keyPairGenerator.initialize(keySize);
        final KeyPair keyPair = keyPairGenerator.genKeyPair();
        final PrivateKey privateKey = keyPair.getPrivate();
        final PublicKey publicKey = keyPair.getPublic();
        // 获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        final String PUBLIC_KEY = new String(publicKeyBytes);
        System.out.println(PUBLIC_KEY);
        // 获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        final String PRIVATE_KEY = new String(privateKeyBytes);
        System.out.println(PRIVATE_KEY);

        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("id",123);
        userInfo.put("name","admin");
        //生成jwt
        String token = JwtHelper.generateToken(userInfo, JwtHelper.getPrivateKey(PRIVATE_KEY.getBytes()),5);
        System.out.println(token);
        //解析jwt
        Object body = JwtHelper.parseToken(token, JwtHelper.getPublicKey(PUBLIC_KEY.getBytes()));
        System.out.println(body);
    }
}
