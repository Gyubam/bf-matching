package website.bfmatching.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import website.bfmatching.file.UploadFile;

@Data
public class AddFormDto {

    private String projectName;
    private String projectIntro;

    private String writerName;

    private String r_title1;
    private String r_title2;
    private String r_title3;

    private String r_content1;
    private String r_content2;
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
