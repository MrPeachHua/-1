package com.boxiang.weixin.utils.json;

import java.io.IOException;
import java.util.Date;

import com.boxiang.weixin.utils.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 日期时间Json序列化器，此列化器适用yyyy-MM-dd HH:mm:ss格式
 */
public class DateTimeJsonSerializer extends JsonSerializer<Date> {
	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		generator.writeString(DateUtil.date2str(date, DateUtil.DATETIME_FORMAT));
	}
}
