package website.bfmatching.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import website.bfmatching.Dto.MemberDto;
import website.bfmatching.entity.Member;
import website.bfmatching.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void registerDB(MemberDto memberDto){
        Member member = memberDto.toEntity();    //memberDto -> member로 변환.
        memberRepository.save(member);
    }

    public Member findByLoginId(String loginId){
        Member member = memberRepository.findByLoginId(loginId);

        if (member != null) {
            return member;
        }
        else {
            return null;
        }
    }
}
