package com.pakin.crm.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 后台往前台的时间格式转换（注解方式）
 * 未成功
 * @author Pakin
 *
 */
public class CustomDateFormat extends JsonSerializer<Date> {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		System.out.println("*****************");
		System.out.println("*****************");
		System.out.println("*****************");
		System.out.println("*****************");
		System.out.println("*****************");
		jsonGenerator.writeString("1111");
	}

}
