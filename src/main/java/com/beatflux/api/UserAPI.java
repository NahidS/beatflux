package com.beatflux.api;

import java.util.ArrayList;
import java.util.List;

import com.beatflux.db.dal.UserDAL;
import com.beatflux.db.to.UserTO;
import com.beatflux.rest.objects.User;

public class UserAPI {
	/*
	 * @return list of Users
	 */
	public List<User> getUserList(){
		UserDAL dal = new UserDAL();
		List<UserTO> uts = dal.listUsers();
		List<User> users = (List<User>) new ArrayList<User>();
		for (UserTO ut : uts) {
			User user = new User();
			user.setUserID(ut.getUserID());
			user.setUserName(ut.getUserName());
			user.setFirstName(ut.getFirstName());
			user.setLastName(ut.getLastName());
			user.setCountryCode(ut.getCountryCode());
			user.setBirthDate(ut.getBirthDate());
			user.setEmail(ut.getEmail());
			user.setMobileNumber(ut.getMobileNumber());
			user.setSignupTimstamp(ut.getSignupTimstamp());
			user.setLastOnline(ut.getLastOnline());
			user.setLatitude(ut.getLatitude());
			user.setLongitude(ut.getLongitude());
			users.add(user);
		}
		return users;
	}
	/*
	 * @param user_id int
	 */
	public User searchUser(int id){
		UserDAL dal = new UserDAL();
		User user = new User();
		UserTO s = dal.searchRecord(id); 
		if (s != null){
			user.setUserID(s.getUserID());
			user.setUserName(s.getUserName());
			user.setFirstName(s.getFirstName());
			user.setLastName(s.getLastName());
			user.setCountryCode(s.getCountryCode());
			user.setBirthDate(s.getBirthDate());
			user.setEmail(s.getEmail());
			user.setMobileNumber(s.getMobileNumber());
			user.setSignupTimstamp(s.getSignupTimstamp());
			user.setLastOnline(s.getLastOnline());
			user.setLatitude(s.getLatitude());
			user.setLongitude(s.getLongitude());
			return user;
		} else
			return null;
	}
	/*
	 * @param user_id int
	 */
	public void deleteUser(int id){
		UserDAL dal = new UserDAL();
		dal.deleteUser(id);
	}
	/*
	 * @param User object
	 */
	public void addUser(User user){
		UserDAL dal = new UserDAL();
		UserTO ut = new UserTO();
		ut.setUserName(user.getUserName());
		ut.setFirstName(user.getFirstName());
		ut.setLastName(user.getLastName());
		ut.setCountryCode(user.getCountryCode());
		ut.setBirthDate(user.getBirthDate());
		ut.setEmail(user.getEmail());
		ut.setMobileNumber(user.getMobileNumber());
		ut.setSignupTimstamp(user.getSignupTimstamp());
		ut.setLastOnline(user.getLastOnline());
		ut.setLatitude(user.getLatitude());
		ut.setLongitude(user.getLongitude());
		ut.setPassword("default");
		ut.setPasswordSalt("default");
		dal.addUser(ut);
	}
	/*
	 * @param user_id int
	 */
	public boolean checkUser(int id){
		UserDAL dal = new UserDAL();
		if (dal.checkRecord(id))
			return true;
		else
			return false;
	}
	/*
	 * @param User object
	 */
	public void updateUser(User user){
		UserDAL dal = new UserDAL();
		UserTO s = new UserTO();
		s.setUserID(user.getUserID());
		s.setUserName(user.getUserName());
		s.setFirstName(user.getFirstName());
		s.setLastName(user.getLastName());
		s.setCountryCode(user.getCountryCode());
		s.setBirthDate(user.getBirthDate());
		s.setEmail(user.getEmail());
		s.setMobileNumber(user.getMobileNumber());
		s.setSignupTimstamp(user.getSignupTimstamp());
		s.setLastOnline(user.getLastOnline());
		s.setLatitude(user.getLatitude());
		s.setLongitude(user.getLongitude());
		s.setPassword("default");
		s.setPasswordSalt("default");
		dal.updateUser(s);      
	}
}
