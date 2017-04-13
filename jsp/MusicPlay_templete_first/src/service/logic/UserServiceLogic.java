package service.logic;

import domain.User;
import service.UserService;
import store.UserStore;
import store.logic.UserStoreLogic;

public class UserServiceLogic implements UserService{
	
	private UserStore store;
	
	public UserServiceLogic() {
		store = new UserStoreLogic();
	}

	@Override
	public User login(User user) {
		User temp = find(user.getLoginId());
		if(temp != null){
			if((user.getPassword()).equals(temp.getPassword())){
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		return store.create(user);
	}

	@Override
	public User find(String loginId) {
		return store.read(loginId);
	}

}
