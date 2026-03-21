package com.alturion.policyowner.security.user;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alturion.policyowner.domain.PolicyOwner;
import com.alturion.policyowner.enums.UserRoleType;

public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private final Long userID;
	private final String username;
	private final String password;
	private final UserRoleType roleType;
	
	public CustomUserDetails(PolicyOwner policyOwner) {
		this.userID = policyOwner.getUserID();
		this.username = policyOwner.getUsername();
		this.password = policyOwner.getPassword();
		this.roleType = policyOwner.getRoleType();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(roleType.name()));
	}

	public Long getUserID() {
		return userID;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
	    return true;
	}
	@Override
	public String toString() {
		return "CustomUserDetails [userID=" + userID + ", username=" + username + ", roleType=" + roleType + "]";
	}
	
}
