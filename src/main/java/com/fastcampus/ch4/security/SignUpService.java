package com.fastcampus.ch4.security;


import com.fastcampus.ch4.dao.Dao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("signUpService")
@Slf4j
public class SignUpService {

    @Autowired //can not autowired 에러 발생
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private SqlSessionTemplate sqlSession;

    public boolean insertUserInfo(String username, String password) {
        Dao dao = sqlSession.getMapper(Dao.class);
        UserDetailsDto user = dao.selectUser(username);

        if(user != null) return false;
        else {
            dao.userSignUp(username, passwordEncoder.encode(password), '1');
            dao.giveAuth(username, "ROLE_USER");
            return true;
        }
    }

}
