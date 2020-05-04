package bs.gsau.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//日期转换器
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		//实现将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		try {
			//成功直接返回
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//失败返回空
		return null;
		
	}

}
