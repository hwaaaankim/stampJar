package com.dev.OnlineStamp.model.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "TB_MEMBER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member implements UserDetails {

	private static final long serialVersionUID = 2023L;

	@JsonIgnore
    @Id 
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "MEMBER_USERNAME", length = 50, unique = true)
    private String username;
    
    @Column(name = "MEMBER_PASSWORD", length = 50, unique = true)
    private String password;
    
    @Column(name="MEMBER_JOIN_DATE")
    private Date memberJoinDate;
    
    @Column(name="MEMBER_EMAIL", unique = true)
    private String memberEmail;

    @Column(name = "MEMBER_NICKNAME", length = 50)
    private String memberNickname;

    @JsonIgnore
    @Column(name = "MEMBER_ACTIVATED")
    private boolean memberActivated;

    @Column(name="MEMBER_ROLE", length = 50)
	private String memberRole;
    
    // Default value is false
    // about Dao or not
    @Column(name="MEMBER_SIGN")
    private boolean memberSign;
    
    @OneToMany(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "accessLogMemberId"
			)
	private List<MemberAccessLog> memberAccessLogs;
	
    
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(memberRole));
        return auth;
	}

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isEnabled() {
		return true;
	}

}
