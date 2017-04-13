package store.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.logic.BaseballTeamStoreLogic;

public class BaseballTeanTest {
	BaseballTeamStoreLogic test = new BaseballTeamStoreLogic();
	@Test
	public void test() {
		BaseballTeam team = test.retrieve(String.valueOf(1));
		assertEquals("1", team.getTeamId());
	}
	
//	@Test
//	public void test() {
//		List<BaseballTeam> list = test.retrieveAll();
//		assertEquals(10, list.size());
//	}

}
