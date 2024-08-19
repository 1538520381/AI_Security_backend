package com.AI_Security.AI_Security_server.utils;

import com.google.protobuf.ByteString;
import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/05/19 21:36
 */
public class ByteStringUtil {
    public static String bytesToString(ByteString src, String charSet) {
        if (StringUtils.isEmpty(charSet)) {
            charSet = "GB2312";
        }
        return bytesToString(src.toByteArray(), charSet);
    }

    public static String bytesToString(byte[] input, String charSet) {
//        if(ArrayUtils.isEmpty(input)) {
//            return StringUtils.EMPTY;
//        }

        ByteBuffer buffer = ByteBuffer.allocate(input.length);
        buffer.put(input);
        buffer.flip();

        Charset charset = null;
        CharsetDecoder decoder = null;
        CharBuffer charBuffer = null;

        try {
            charset = Charset.forName(charSet);
            decoder = charset.newDecoder();
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());

            return charBuffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
