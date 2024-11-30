package com.example.demo.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Collection;
import java.util.List;

@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String id;

    private String nickname;
    private String phone_number;
    private String department;
    private String student_id;
    private int height;
    private String mbti;
    private List<String> interests;
    private String created_at;
    private String updated_at;

    // 기본 생성자
    public User() {}

    // 생성자
    public User(String nickname, String phone_number, String department, String student_id, int height,
                String mbti, List<String> interests, String created_at, String updated_at) {
        this.nickname = nickname;
        this.phone_number = phone_number;
        this.department = department;
        this.student_id = student_id;
        this.height = height;
        this.mbti = mbti;
        this.interests = interests;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // UserDetails 구현

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 예시로 ROLE_USER 권한을 부여
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return null; // 비밀번호 필드가 없으면 null 반환 (필요하면 추가)
    }

    @Override
    public String getUsername() {
        return this.nickname; // nickname을 username으로 반환
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

    // Getter 및 Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    
    public int getHeight() {
    	return height;
    }
    
    public void setHeight(int height) {
    	this.height = height;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", department='" + department + '\'' +
                ", student_id='" + student_id + '\'' +
                ", mbti='" + mbti + '\'' +
                ", interests=" + interests +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
