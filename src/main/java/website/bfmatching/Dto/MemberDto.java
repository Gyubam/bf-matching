package website.bfmatching.Dto;

import lombok.Data;
import website.bfmatching.entity.Member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class MemberDto {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
//    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_@.]{6,20}$",
//            message = "아이디는 6 ~ 20자의 영문,숫자,@,-,_,.만 사용 가능합니다.")
    private String loginId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
//            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    //DTO->Entity
    public Member toEntity(){     //DTO -> 엔티티
        return new Member(loginId, password);
    }

    public MemberDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }


}
