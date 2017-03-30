package music;

import org.springframework.stereotype.Component;

@Component
public class Singer implements Player{

	@Override
	public void play() {
		System.out.println("노래 부르기");
	}

}
