package website.bfmatching.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import website.bfmatching.file.UploadFile;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AddFormDto {

    @NotBlank(message = "값을 입력해주세요.")
    private String projectName;

    @NotBlank(message = "값을 입력해주세요.")
    private String projectIntro;

    @NotBlank(message = "값을 입력해주세요.")
    private String writerName;

    @NotBlank(message = "값을 입력해주세요.")
    private String r_title1;

    @NotBlank(message = "값을 입력해주세요.")
    private String r_title2;

    @NotBlank(message = "값을 입력해주세요.")
    private String r_title3;

    @NotBlank(message = "값을 입력해주세요.")
    private String r_content1;

    @NotBlank(message = "값을 입력해주세요.")
    private String r_content2;

    @NotBlank(message = "값을 입력해주세요.")
    private String r_content3;

    private MultipartFile attachFile;
    private String needPosition;

    public AddFormDto(String projectName, String projectIntro, String writerName,
                      String r_title1, String r_title2, String r_title3,
                      String r_content1, String r_content2, String r_content3,
                      String needPosition) {
        this.projectName = projectName;
        this.projectIntro = projectIntro;
        this.writerName = writerName;
        this.r_title1 = r_title1;
        this.r_title2 = r_title2;
        this.r_title3 = r_title3;
        this.r_content1 = r_content1;
        this.r_content2 = r_content2;
        this.r_content3 = r_content3;
        this.needPosition = needPosition;
    }


    //    private MultipartFile attachFile;
}
