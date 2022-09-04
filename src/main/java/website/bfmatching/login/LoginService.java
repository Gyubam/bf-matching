package website.bfmatching.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import website.bfmatching.entity.Member;
import website.bfmatching.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){

        try{
            Member findMember = memberRepository.findByloginId(loginId);
            if(findMember.getPassword().equals(password)){
                return findMember;
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }

    }
}
