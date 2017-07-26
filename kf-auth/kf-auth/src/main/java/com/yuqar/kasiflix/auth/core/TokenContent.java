package com.yuqar.kasiflix.auth.core;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

public class TokenContent {
	private String username;
	//private List<String> memberOfGroups;
	private Date expires;

	protected TokenContent() {
	}

	public TokenContent(String username,Date expires){// List<String> memberOfGroups, Date expires) {
		Preconditions.checkNotNull(username);//get username and checks if its not null
		//Preconditions.checkNotNull(memberOfGroups);
		Preconditions.checkNotNull(expires);//get token expiry time and check if its not null

		this.username = username;
		//this.memberOfGroups = memberOfGroups;
		this.expires = expires;
	}

	public String getUsername() {
		return username;
	}

	/*public List<String> getMemberOfGroups() {
		return memberOfGroups;
	}*/

	public Date getExpires() {
		return expires;
	}

	public boolean hasExpired(Date now) {
		return Preconditions.checkNotNull(now, "now").compareTo(expires) >= 0;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.expires).append(this.username).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TokenContent)) {
			return false;
		}
		TokenContent other = (TokenContent) obj;
		return new EqualsBuilder().append(this.expires, other.expires)
				.append(this.username, other.username).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
