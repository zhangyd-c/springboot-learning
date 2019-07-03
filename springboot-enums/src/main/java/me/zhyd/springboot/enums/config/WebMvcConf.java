package me.zhyd.springboot.enums.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class WebMvcConf implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(System.out::println);
    }

    private boolean isJson(String str) {
        return !StringUtils.isEmpty(str) && (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}');
    }

    /**
     * 自定义FastJsonHttpMessageConverter处理api中的枚举
     * 参考资料：
     * https://blog.csdn.net/mickjoust/article/details/51671060
     * https://ask.csdn.net/questions/358742?sort=id
     * https://www.cnblogs.com/china-baizhuangli/p/8630787.html
     * https://blog.csdn.net/u010246789/article/details/52539576
     * https://blog.csdn.net/yiifaa/article/details/73610334
     */

    /*@Configuration
    @ConditionalOnClass({FastJsonHttpMessageConverter.class})
    @ConditionalOnProperty(
            name = {"spring.http.converters.preferred-json-mapper"},
            havingValue = "fastjson",
            matchIfMissing = true
    )
    public class FastJsonHttpMessageConvertersConfiguration {

        @Bean
        @ConditionalOnMissingBean({FastJsonHttpMessageConverter.class})
        public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
            FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

            FastJsonConfig fastJsonConfig = new FastJsonConfig();
            // https://blog.csdn.net/u010246789/article/details/52539576
            fastJsonConfig.setSerializerFeatures(
                    SerializerFeature.PrettyFormat,
                    SerializerFeature.WriteEnumUsingToString
            );
            // 中文乱码解决方案 https://www.cnblogs.com/china-baizhuangli/p/8630787.html
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
            converter.setSupportedMediaTypes(mediaTypes);

            ValueFilter valueFilter = (o, s, o1) -> {
                if (o1 instanceof Enum) {
                    // 枚举类的序列化结果转成map
                    String str = String.valueOf(o1);
                    if (isJson(str)) {
                        o1 = JSONObject.parseObject(String.valueOf(o1), Map.class);
                    }
                }
                return o1;
            };
            fastJsonConfig.setSerializeFilters(valueFilter);

            converter.setFastJsonConfig(fastJsonConfig);

            return converter;
        }

    }*/

}
