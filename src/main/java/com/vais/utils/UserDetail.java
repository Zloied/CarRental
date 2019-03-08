package com.vais.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 * 
 * @author Eduard
 *
 *	This class extends userdetails.User from spring by adding into it user's Id. 
 *
 */
public class UserDetail extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -361731836317250072L;

	// ~ Instance fields
	// ================================================================================================

	private final Long userId;

	public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,
			Long userID) {
		super(username, password, authorities);
		this.userId = userID;
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(": ");
		sb.append("Username: ").append(getUsername()).append("; ");
		sb.append("Password: [PROTECTED]; ");
		sb.append("User ID : ").append(userId).append("; ");
		sb.append("Enabled: ").append(isEnabled()).append("; ");
		sb.append("AccountNonExpired: ").append(isAccountNonExpired()).append("; ");
		sb.append("credentialsNonExpired: ").append(isCredentialsNonExpired()).append("; ");
		sb.append("AccountNonLocked: ").append(isAccountNonLocked()).append("; ");
		if (!getAuthorities().isEmpty()) {
			sb.append("Granted Authorities: ");

			boolean first = true;
			for (GrantedAuthority auth : getAuthorities()) {
				if (!first) {
					sb.append(",");
				}
				first = false;

				sb.append(auth);
			}
		} else {
			sb.append("Not granted any authorities");
		}

		return sb.toString();
	}

}
