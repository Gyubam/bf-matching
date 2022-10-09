package website.bfmatching.config.auth;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import website.bfmatching.entity.Member;
import website.bfmatching.login.SessionConst;
import website.bfmatching.repository.MemberRepository;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@AllArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member memberEntity = memberRepository.findByLoginId(username);

        if (memberEntity != null) {

            log.info("로컬 로그인 진행, 아이디 {}", memberEntity.getLoginId());

            return new PrincipalDetails(memberEntity);
        }
        return null;
    }
}
