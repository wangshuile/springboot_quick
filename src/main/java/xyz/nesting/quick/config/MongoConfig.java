package xyz.nesting.quick.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.bson.types.Decimal128;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

@Configuration
public class MongoConfig {

	/**
     * spring-data-mongodb 默认将java Bigdecimal类型 映射成 bson string类型, 不利于数值计算
     * 此配置将java Bigdecimal 映射成 bson decimal123
     * 
     * 注意: mongodb v3.4 以上版本，才支持decimal123类型
     * 
     * @return a new instance of CustomConversons
     */
    @Bean
    CustomConversions customConverions() {
        Converter<Decimal128, BigDecimal> decimal128ToBigDecimal = new Converter<Decimal128, BigDecimal>() {
            @Override
            public BigDecimal convert(Decimal128 s) {
                return s==null ? null : s.bigDecimalValue();
            }
        };
        
        Converter<BigDecimal, Decimal128> bigDecimalToDecimal128 = new Converter<BigDecimal, Decimal128>() {
            @Override
            public Decimal128 convert(BigDecimal s) {
                return s==null ? null : new Decimal128(s);
            }
        };
        
        return new CustomConversions(Arrays.asList(decimal128ToBigDecimal, bigDecimalToDecimal128));
    }
}
