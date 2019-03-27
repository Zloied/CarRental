package com.vais.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vais.entities.User;
import com.vais.repositories.UserRepository;
import com.vais.utils.UserDetail;
/**
 * 
 * @author Eduard
 *	
 * This class implements spring's UserDatailService ,
 *  which retrieves user from the database and returns required for spring security informations about user. 
 *  Such as encrypted password, user's name, GrantedAuthority and user's ID
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User" + username + "was not found");
		}

		System.out.println("Found USer:" + user);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (user.getRole() != null) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().toUpperCase());
			grantList.add(authority);
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserDetails userDetails = (UserDetails) new UserDetail(username, encoder.encode(user.getPassword()), grantList,
				user.getId());
		System.out.println(userDetails.toString());
		return userDetails;
	}

}
