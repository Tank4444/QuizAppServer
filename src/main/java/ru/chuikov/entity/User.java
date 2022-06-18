package ru.chuikov.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column
        private String email;
        @Column
        private String password;
        @Column
        private String first_name;
        @Column
        private String last_name;
        @Column
        private String org_name;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
        private List<Game> games;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
        private List<File> files;

        public User(Long id, String email, String password, String first_name, String last_name, String org_name, List<Game> games, List<File> files) {
                this.id = id;
                this.email = email;
                this.password = password;
                this.first_name = first_name;
                this.last_name = last_name;
                this.org_name = org_name;
                this.games = games;
                this.files = files;
        }

        public User() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFirst_name() {
                return first_name;
        }

        public void setFirst_name(String first_name) {
                this.first_name = first_name;
        }

        public String getLast_name() {
                return last_name;
        }

        public void setLast_name(String last_name) {
                this.last_name = last_name;
        }

        public String getOrg_name() {
                return org_name;
        }

        public void setOrg_name(String org_name) {
                this.org_name = org_name;
        }

        public List<Game> getGames() {
                return games;
        }

        public void setGames(List<Game> games) {
                this.games = games;
        }

        public List<File> getFiles() {
                return files;
        }

        public void setFiles(List<File> files) {
                this.files = files;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
        }

        @Override
        public String getPassword() {
                return password;
        }

        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return false;
        }

        @Override
        public boolean isAccountNonLocked() {
                return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return false;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}