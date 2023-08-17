package di.anno04;

import org.springframework.stereotype.Component;

@Component("k1")
public class KumhoTire implements Tire {

	public String getTireBrand() {
		// TODO Auto-generated method stub
		return "금호타이어";
	}

}
