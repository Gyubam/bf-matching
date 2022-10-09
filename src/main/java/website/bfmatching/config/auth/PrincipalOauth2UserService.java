package website.bfmatching.config.auth;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import website.bfmatching.config.auth.PrincipalDetails;
import website.bfmatching.config.oauth.provider.FacebookUserInfo;
import website.bfmatching.config.oauth.provider.GoogleUserInfo;
import website.bfmatching.config.oauth.provider.NaverUserInfo;
import website.bfmatching.config.oauth.provider.OAuth2UserInfo;
import website.bfmatching.entity.Member;
import website.bfmatching.repository.MemberRepository;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 회원가입 진행
        OAuth2UserInfo oAuth2UserInfo = null;

        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());

        }else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));

        }else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            System.out.println("페이스북 로그인 요청");
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());

        }else {
            log.info("구글, 네이버, 페이스북만 지원");
        }


        String provider = oAuth2UserInfo.getProvider(); // google
        String provideId = oAuth2UserInfo.getProviderId(); //
        String username = provider + "_" + provideId; // google_10128412491824
        String email = oAuth2UserInfo.getEmail();
        String password = bCryptPasswordEncoder.encode("겟인데어"); // 크게 의미없음, 패스워드는 필요 x
        String role = "ROLE_USER";

        Member member = memberRepository.findByUsername(username);

        if (member == null) {
            member = Member.builder()
                    .username(username)
                    .loginId(username)
                    .password(password)
                    .role(role)
                    .provider(provider)
                    .providerId(provideId)
                    .build();
            memberRepository.save(member);
        }

        return new PrincipalDetails(member, oAuth2User.getAttributes());
    }
}
