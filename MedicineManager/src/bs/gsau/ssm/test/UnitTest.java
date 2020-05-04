package bs.gsau.ssm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bs.gsau.ssm.mapper.MedicineMapper;
import bs.gsau.ssm.pojo.Medicine;

public class UnitTest {

	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
	}

	@Test
	public void test() throws Exception {
		MedicineMapper mapper = (MedicineMapper)applicationContext.getBean("medicineMapper");
		
		List<Medicine> list = mapper.findAllMedicine();
		
		Medicine medicine = list.get(1);
		
		Float factoryadd = medicine.getPrice();
		
		System.out.println(factoryadd);
	}

}
