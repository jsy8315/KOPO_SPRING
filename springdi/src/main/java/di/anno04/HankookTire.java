package di.anno04;

import org.springframework.stereotype.Component;

@Component("h1") //내맘대로 이름 짓기
public class HankookTire implements Tire {

	public String getTireBrand() {
		// TODO Auto-generated method stub
		return "한국타이어";
	}

}
