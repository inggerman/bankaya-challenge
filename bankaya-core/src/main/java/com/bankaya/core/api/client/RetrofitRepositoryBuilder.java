package com.bankaya.core.api.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.net.ssl.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
@Component
public class RetrofitRepositoryBuilder {

    public static ObjectMapper objectMapper;

    public static final String CONTEXT_INSTANCE_NAME = "SSL";

    public static final String KEY_STORE_TYPE = "PKCS12";

    static {
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, Boolean.FALSE)
                .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, Boolean.FALSE)
                .registerModule(new JavaTimeModule())
                .findAndRegisterModules() //needed to support instantiation by jackson
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public <T> T build(String baseURL, Class<T> repositoryClass, Long timeout) throws NoSuchAlgorithmException, KeyManagementException {

        final Interceptor interceptor = chain -> {
            final Request.Builder requestBuilder = chain.request().newBuilder()
                    .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            return chain.proceed(requestBuilder.build());
        };

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(getUnsafeHttpsClient(timeout != null ? timeout : 1000L,interceptor))
                .build()
                .create(repositoryClass);
    }


    public static OkHttpClient getHttpClient(long timeout) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.readTimeout(timeout, TimeUnit.MILLISECONDS);

        return builder.build();
    }

    public static OkHttpClient getUnsafeHttpsClient(long readTimeOutMillis,Interceptor... interceptors) throws KeyManagementException, NoSuchAlgorithmException {
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {

                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };
        final SSLContext sslContext = SSLContext.getInstance(CONTEXT_INSTANCE_NAME);
        sslContext.init(null, trustAllCerts, new SecureRandom());
        final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Stream.of(interceptors).forEach(builder::addInterceptor);

        builder
                .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                .hostnameVerifier((hostname, session) -> true)
                .readTimeout(readTimeOutMillis, TimeUnit.MILLISECONDS);

        return builder.build();
    }

}
