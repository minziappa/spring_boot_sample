package io.sample.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.sample.bean.ExtendUser;
import io.sample.bean.model.UserModel;
import io.sample.configure.PasswordEncoding;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private PasswordEncoding passwordEncoder;

	@Override
	// @Transaction(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		ExtendUser user = null;
		UserModel userModel = null;

		try {
			logger.info("UserDetailsService >> userId >> " + userName);

			// Get a user information form DB.
			Map<String, Object> mapSelect = new HashMap<String, Object>();
			mapSelect.put("userName", userName);

			try {
				// Select DB like the following code
				// userModel = slaveDao.getMapper(SlaveDao.class).selectSampleByName(mapSelect);
				userModel = new UserModel();
				userModel.setUserStatus("1");
				userModel.setUserId("admin");
				userModel.setUserName("name");
			} catch (Exception e) {
				logger.error("Exception error", e);
			}

			if(userModel == null) {
				throw new UsernameNotFoundException( userName + " is not found." );
			}

	        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        // For java1.6
	        switch(Integer.valueOf(userModel.getUserStatus())) {
	            case 1:
	                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	            break;
	            default:
	                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	            break;
	        }

	        boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;

	        user = new ExtendUser(userModel.getUserName(), passwordEncoder.encode("test"), enabled, 
	        		accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, userModel);

		} catch (Exception e) {
			logger.error("Select error, userName={}, userStatus={}", userModel.getUserName(), userModel.getUserStatus());
			logger.error("Exception >> ", e);
		}

		return user;
	}

}
